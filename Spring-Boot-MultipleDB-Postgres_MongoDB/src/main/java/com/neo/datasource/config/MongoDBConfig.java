package com.neo.datasource.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "com.neo.mongodb.repo", mongoTemplateRef = "mongoTemplate")
public class MongoDBConfig {	
	
	@Value("${spring.mongodb.uri}")
	private String mongoUrl;
	
	@Value("${spring.mongodb.database}")
	private String database;
	
	// Create a MongoTemplate bean with the MongoClient
	@Bean
	public MongoTemplate mongoTemplate(MongoClient mongoClient) {
		 // Set default collation
		MongoTemplate template = new MongoTemplate(mongoClient, database);
		
		  // Set default collation globally for all queries if necessary
        template.setWriteConcern(WriteConcern.ACKNOWLEDGED);
        
		return template;
	}

	// Create MongoClient with connection URL
	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create(mongoUrl);  // Mongo URI to connect with the MongoDB server
	}
}
