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

import static org.junit.Assert.*;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoConfig.class)
public class AnimalRepositoryTest {

  @Autowired
  AnimalRepository animalRepository;

  @Test
  public void testSaveAnimal(){
    String name = "Burek";
    Species species = Species.DOG;
    LocalDate date = LocalDate.now();
    String registrationNumber = "SP/1/03/2018";
    Animal animal = new Animal(name, species, date, registrationNumber);
    animalRepository.save(animal);

    List<Animal> animalList = animalRepository.findAll();
    assertEquals(animalList.size(), 1);
    assertEquals(animalList.get(0).getName(), name);
    animalRepository.deleteAll();
  }

  @Test
  public void testUpdateAnimal(){
    String name = "Burek";
    Species species = Species.DOG;
    LocalDate date = LocalDate.now();
    String registrationNumber = "SP/1/03/2018";
    Animal new_animal = new Animal(name, species, date, registrationNumber);
    animalRepository.save(new_animal);

    Animal animal = animalRepository.findAll().get(0);
    animal.setName("Burek_new_name");
    animalRepository.save(animal);

    List<Animal> animalList = animalRepository.findAll();
    assertEquals(animalList.size(), 1);
    assertEquals(animalList.get(0).getName(), "Burek_new_name");
    animalRepository.deleteAll();
  }


}