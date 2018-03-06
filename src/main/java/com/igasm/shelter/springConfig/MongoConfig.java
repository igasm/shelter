package com.igasm.shelter.springConfig;

import com.igasm.shelter.persistence.repository.AnimalService;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.igasm.shelter")
@ComponentScan({"com.igasm.shelter.persistence"})
public class MongoConfig extends AbstractMongoConfiguration {
  @Override
  protected String getDatabaseName() {
    return "test";
  }

  @Override
  public MongoClient mongoClient() {
    return new MongoClient("127.0.0.1", 27017);
  }

  @Bean
  public AnimalService animalService(){
    AnimalService animalRepository = new AnimalService();
    return animalRepository;
  }

}
