package com.igasm.shelter;


import com.igasm.shelter.persistence.model.Animal;
import com.igasm.shelter.persistence.service.AnimalService;
import com.igasm.shelter.springConfig.PersistanceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistanceConfig.class, loader = AnnotationConfigContextLoader.class)
public class AnimalServiceImplTest {

  @Autowired
  private AnimalService animalService;

  @Test
  public void testAddingAnimal(){
    Animal animal = new Animal("Burek", "pies");
    animalService.addAnimal(animal);
    List<Animal> animals = animalService.listAnimals();
    assertEquals(1, animals.size());
  }

}