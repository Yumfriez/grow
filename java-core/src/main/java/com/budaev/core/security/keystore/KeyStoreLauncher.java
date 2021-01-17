package com.budaev.core.security.keystore;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Base64;
import java.util.Properties;

import static java.util.Optional.ofNullable;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class KeyStoreLauncher {

	public static void main(String[] args) {
		final Properties properties = new Properties();
		try {
			properties.load(KeyStoreLauncher.class.getResourceAsStream("/keystore.properties"));

			ofNullable(properties.getProperty("password")).map(String::toCharArray).ifPresent(password -> {

				try {
					//JKS/JCEKS/PKCS12
					KeyStore keyStore = KeyStore.getInstance("JCEKS");
					try {
						keyStore.load(null, password);
						try (FileOutputStream fileOutputStream = new FileOutputStream("ksFile.jceks")) {
							keyStore.store(fileOutputStream, password);
						}

						try (FileInputStream fileInputStream = new FileInputStream("ksFile.jceks")) {
							keyStore.load(fileInputStream, password);
						}

						useSymmetricKey(keyStore, password, properties);

					} catch (IOException | NoSuchAlgorithmException | CertificateException e) {
						e.printStackTrace();
					}
				} catch (KeyStoreException e) {
					e.printStackTrace();
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void useSymmetricKey(KeyStore keyStore, char[] password, Properties properties) {
		ofNullable(properties.getProperty("secret")).ifPresent(secret -> {

			//AES/DES/DESede/HmacSHA1/HmacSHA256
			try {
				final KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
				SecureRandom secureRandom = new SecureRandom();
				keyGenerator.init(secureRandom);
				final SecretKey secretKey = keyGenerator.generateKey();
				KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(secretKey);
				System.out.println(Base64.getEncoder().encodeToString(secretKey.getEncoded()));
				KeyStore.PasswordProtection passwordProtection = new KeyStore.PasswordProtection(password);
				try {
					keyStore.setEntry(secret, secretKeyEntry, passwordProtection);
					try {
						keyStore.store(new FileOutputStream("ksFile.jceks"), password);
					} catch (IOException | CertificateException e) {
						e.printStackTrace();
					}
				} catch (KeyStoreException e) {
					e.printStackTrace();
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}

			try {
				keyStore.load(new FileInputStream("ksFile.jceks"), password);
				final KeyStore.SecretKeyEntry entry = (KeyStore.SecretKeyEntry) keyStore.getEntry(secret,
						new KeyStore.PasswordProtection(password)
				);
				System.out.println(Base64.getEncoder().encodeToString(entry.getSecretKey().getEncoded()));

				final Key key = keyStore.getKey(secret, password);
				System.out.println(Base64.getEncoder().encodeToString(key.getEncoded()));
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

	}
}
