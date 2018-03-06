package com.igasm.shelter.persistence.repository;

import com.igasm.shelter.persistence.model.Animal;
import com.igasm.shelter.persistence.model.Species;
import com.igasm.shelter.springConfig.MongoConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;
import java.util.List;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoConfig.class)
public class AnimalServiceTest {

  @Autowired
  private AnimalService animalService;

  @Test
  public void testAddingAnimal(){
    String name = "Burek";
    Species species = Species.DOG;
    LocalDate date = LocalDate.now();
    String registrationNumber = "SP/1/03/2018";
    Animal animal = new Animal(name, species, date, registrationNumber);
    animalService.insertAnimal(animal);
    List<Animal> animals = animalService.listAllAnimals();

  }

  @Test
  public void listAllAnimal(){
    List<Animal> animals = animalService.listAllAnimals();
    System.out.println(animals);
  }

}