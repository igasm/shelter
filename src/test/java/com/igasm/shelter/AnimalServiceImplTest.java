package com.igasm.shelter;


import com.igasm.shelter.persistence.model.Animal;
import com.igasm.shelter.persistence.model.Species;
import com.igasm.shelter.persistence.service.AnimalService;
import com.igasm.shelter.springConfig.PersistenceConfig;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class, loader = AnnotationConfigContextLoader.class)
public class AnimalServiceImplTest {

  @Autowired
  private AnimalService animalService;

  @Test
  public void testAddingAnimal(){
    String name = "Burek";
    Species species = Species.DOG;
    LocalDate date = LocalDate.now();
    String registrationNumber = "SP/1/03/2018";
    Animal animal = new Animal(name, species, date);
    animalService.addAnimal(animal);
    List<Animal> animals = animalService.listAnimals();

    assertThat(animals).contains(animal);
  }

  @Test
  public void testUpdatingAnimal(){
    //given
    String name = "Trik";
    LocalDate date = LocalDate.now();
    String registrationNumber = "SP/2/03/2018";
    Animal animal = new Animal(name, Species.DOG, date);
    int id = (int) animalService.addAnimal(animal);
    //when
    animal.setSpecies(Species.CAT);
    animalService.updateAnimal(animal);
    //then
    List<Animal> animals
        = animalService.listAnimals().stream()
                      .filter(a -> a.getId()==id)
                      .collect(Collectors.toList());

    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(animals.size()).isEqualTo(1);
    softAssertions.assertThat(animals.get(0).getName()).isEqualTo(name);
    softAssertions.assertThat(animals.get(0).getSpecies()).isEqualTo(Species.CAT);
    softAssertions.assertThat(animals.get(0).getRegistrationDate()).isEqualTo(date);
    softAssertions.assertThat(animals.get(0).getId()).isEqualTo(id);
    softAssertions.assertAll();
  }

  @Test
  public void deleteAnimal(){
    //given
    String registrationNumber = "SP/3/03/2018";
    Animal animal = new Animal("Tymon", Species.CAT, LocalDate.now());
    int id = (int) animalService.addAnimal(animal);
    //when
    animalService.deleteAnimal(animal);
    //then
    List<Animal> animals
        = animalService.listAnimals().stream()
        .filter(a -> a.getId() == id)
        .collect(Collectors.toList());
    assertThat(animals.size()).isEqualTo(0);
  }

  @Test
  public void testGettingAnimalById(){
    //given
    Animal newAnimal = new Animal("Trick", Species.HORSE, LocalDate.now());
    //when
    long id = animalService.addAnimal(newAnimal);
    //then
    Animal animal = animalService.getAnimalById((int) id);
    assertThat(animal).isEqualTo(newAnimal);
  }

}