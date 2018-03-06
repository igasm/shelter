package com.igasm.shelter.persistence.repository;

import com.igasm.shelter.persistence.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

  @Autowired
  MongoTemplate mongoTemplate;

  public void insertAnimal(Animal animal){
    mongoTemplate.insert(animal);
  }

  public List<Animal> listAllAnimals(){
    List<Animal> results = mongoTemplate.findAll(Animal.class);
    return results;
  }

}
