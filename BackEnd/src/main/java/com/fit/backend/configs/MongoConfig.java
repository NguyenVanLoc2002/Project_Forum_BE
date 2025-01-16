package com.fit.backend.configs;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {
    @Value("${mongodb.user}")
    private String mongoUser;
    @Value("${mongodb.password}")
    private String mongoPassword;
    @Value("${mongodb.dbname}")
    private String mongoDBName;
    @Value("${mongodb.cluster-url}")
    private String mongoClusterUrl;

    @Bean
    public MongoClient mongoClient() {
        String connectionString = String.format("mongodb+srv://%s:%s@%s/%s?retryWrites=true&w=majority",
                mongoUser, mongoPassword, mongoClusterUrl, mongoDBName);
        return MongoClients.create(
                MongoClientSettings.builder()
                        .applyConnectionString(new ConnectionString(connectionString))
                        .build()
        );
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), mongoDBName);
    }
}
