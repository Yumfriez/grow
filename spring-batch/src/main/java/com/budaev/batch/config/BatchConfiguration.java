package com.budaev.batch.config;

import com.budaev.batch.encoder.BasicPasswordEncoder;
import com.budaev.batch.encoder.PasswordEncoder;
import com.budaev.batch.entity.user.CsvUser;
import com.budaev.batch.entity.user.User;
import com.budaev.batch.listener.JobCompletionListener;
import com.budaev.batch.processor.UserProcessor;
import com.budaev.batch.writer.InMemoryWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;

	@Autowired
	public BatchConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
	}

	@Bean
	public BeanWrapperFieldSetMapper<CsvUser> csvUserBeanWrapperFieldSetMapper() {
		final BeanWrapperFieldSetMapper<CsvUser> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
		beanWrapperFieldSetMapper.setTargetType(CsvUser.class);
		return beanWrapperFieldSetMapper;
	}

	@Bean
	public FlatFileItemReader<CsvUser> csvUserReader() {
		return new FlatFileItemReaderBuilder<CsvUser>().name("csvUserReader")
				.resource(new ClassPathResource("users.csv"))
				.delimited()
				.names("login", "password")
				.fieldSetMapper(csvUserBeanWrapperFieldSetMapper())
				.build();
	}

	@Bean
	public PasswordEncoder basicPasswordEncoder() {
		return new BasicPasswordEncoder();
	}

	@Bean
	public ItemProcessor<CsvUser, User> convertUserProcessor() {
		return new UserProcessor(basicPasswordEncoder());
	}

	@Bean
	public Map<Long, User> userMapping() {
		return new HashMap<>();
	}

	@Bean
	public ItemWriter<User> userItemWriter() {
		return new InMemoryWriter(userMapping());
	}

	@Bean
	public Job loadUsersJob(JobCompletionListener jobCompletionListener, Step loadUsersStep) {
		return jobBuilderFactory.get("importUserJob")
				.incrementer(new RunIdIncrementer())
				.listener(jobCompletionListener)
				.flow(loadUsersStep)
				.end()
				.build();
	}

	@Bean
	public Step loadUsersStep() {
		return stepBuilderFactory.get("loadUsersStep").<CsvUser, User>chunk(2).reader(csvUserReader())
				.processor(convertUserProcessor())
				.writer(userItemWriter())
				.build();
	}

	@PostConstruct
	public void monitorMapping() {
		new Thread(() -> IntStream.range(0, 3).forEach(i -> {
			System.out.println(userMapping());
			try {
				TimeUnit.MILLISECONDS.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		})).start();
	}
}
