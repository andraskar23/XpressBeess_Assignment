package com.neo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.neo.entity.Customer;
import com.neo.repo.CustomerRepository;
import lombok.AllArgsConstructor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	

	//1) Create ItemReader
	
	@Bean
	public FlatFileItemReader<Customer> customerReader() {
		FlatFileItemReader<Customer> itemReader = new FlatFileItemReader<>();
		itemReader.setResource(new FileSystemResource("src/main/resources/customers.csv"));
		itemReader.setName("csv-reader");//any name
		itemReader.setLinesToSkip(1);//It will skip from .csv file, Because Data is start from row no. 2
		itemReader.setLineMapper(lineMapper());
		return itemReader;
	}
	
//	Line Mapper is used to tell that, Read one line, and represent that line as a customer object
// and that customer object is one record for the DB.
	private LineMapper<Customer> lineMapper() {

		DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();

		//My data is seperated by ','
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");//seperate my data whenever there is ','.
		lineTokenizer.setStrict(false);//for every column there might be a no records(i.e. empty or null), so, whenever there is no value, then considered as false.
		lineTokenizer.setNames("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob");

		
		//Take data from lineMapper and convert into Bean Object
		// To convert the data into Bean Object We are using BeanWrapperFieldSetMapper
		BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Customer.class);

		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);

		return lineMapper;
	}// This is very very Important

	
	//2) Create ItemProcessor
	@Bean
	public CustomerProcessor customerProcessor() {
		return new CustomerProcessor();
	}
	
	
	//3) Create ItemWriter
	@Bean
	public RepositoryItemWriter<Customer> customerWriter() {

		RepositoryItemWriter<Customer> writer = new RepositoryItemWriter<>();
		writer.setRepository(customerRepository);//Respository Name
		writer.setMethodName("save"); // Method name

		return writer;
	}
	
	//2) Create Step
	@Bean
	public Step step() {             // any name "step-2"
		return stepBuilderFactory.get("step-1").<Customer, Customer>chunk(10)
						  .reader(customerReader())
						  .processor(customerProcessor())
						  .writer(customerWriter())
						  .taskExecutor(taskExecutor())
						  .build();
	}
	
// For multiple Steps	
	
//	@Bean
//	public Step step2() {             // any name "step-1"
//		return stepBuilderFactory.get("step-2").<Customer, Customer>chunk(10)
//						  .reader(customerReader())
//						  .processor(customerProcessor())
//						  .writer(customerWriter())
//						  .taskExecutor(taskExecutor())
//						  .build();
//	}
//	
	
	
	//2) Create Job
	@Bean
	public Job job() {
		return jobBuilderFactory.get("customers-import")// Any Name "customers-import"
								.flow(step())
								.end()
								.build();
	}
	
	@Bean
	public TaskExecutor taskExecutor() {
		SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
		taskExecutor.setConcurrencyLimit(10);
		return taskExecutor;
	}
	
	
}







