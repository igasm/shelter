package com.igasm.shelter.persistence.repository;

import com.igasm.shelter.persistence.model.Animal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AnimalRepository extends MongoRepository<Animal, String> {

  public List<Animal> findByName(String name);

}
