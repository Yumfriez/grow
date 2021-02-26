package com.budaev.core.reflection.entity;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Smartphone extends Phone {

	private WirelessAdapter wirelessAdapter;

	@Override
	public void receiveCall() {
		encryptChannel();
		super.receiveCall();
	}

	protected void encryptChannel() {
		System.out.println("Channel encrypted.");
	}

	public void enableSimInternet() {
		createInternetConnection(getSimCard());
		System.out.println("Sim internet enabled");
	}

	public void enableWifi() {
		createInternetConnection(wirelessAdapter);
		System.out.println("Wifi enabled");
	}

	private void createInternetConnection(InternetProvider internetProvider) {
		System.out.println("Internet connection created using sim: " + internetProvider.getClass().getSimpleName());
	}

	public WirelessAdapter getWirelessAdapter() {
		return wirelessAdapter;
	}

	public void setWirelessAdapter(WirelessAdapter wirelessAdapter) {
		this.wirelessAdapter = wirelessAdapter;
	}
}
