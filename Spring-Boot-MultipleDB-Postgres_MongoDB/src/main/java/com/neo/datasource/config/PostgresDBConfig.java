package com.neo.datasource.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.Data;


@Data
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.neo.postgresdb.repo", 
					   entityManagerFactoryRef = "postgresEntityManagerFactory",
					   transactionManagerRef = "postgresTransactionManager")
public class PostgresDBConfig {

	@Value("${spring.datasource.postgres.url}")
	private String url;
	
	@Value("${spring.datasource.postgres.username}")
	private String username;
	
	@Value("${spring.datasource.postgres.password}")
	private String pwd;
	


	@Bean(name = "postgresDataSource")
	public DataSource postgresDataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.url(url);
		dataSourceBuilder.username(username);
		dataSourceBuilder.password(pwd);
		return dataSourceBuilder.build();
	}



	@Bean(name = "postgresEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("postgresDataSource") DataSource dataSource) {
		HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		return builder.dataSource(dataSource).properties(properties).packages("com.neo.postgresdb.entity")
				.persistenceUnit("postgres").build();
	}


	@Bean(name = "postgresTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("postgresEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}

//properties.put("hibernate.globally_quoted_identifiers", true);	
//properties.put("hibernate.show_sql", true);  // Use Hibernate property here
//properties.put("hibernate.format_sql", true);  // Format SQL for readability
//properties.put("hibernate.use_sql_comments", true);  // Use SQL comments
