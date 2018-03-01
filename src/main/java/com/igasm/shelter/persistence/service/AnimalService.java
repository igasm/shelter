package com.igasm.shelter.persistence.service;

import com.igasm.shelter.persistence.model.Animal;

import java.util.List;

public interface AnimalService {
  long addAnimal(Animal animal);
  void updateAnimal(Animal animal);
  void deleteAnimal(Animal animal);
  void deleteAnimalById(int id);
  List<Animal> listAnimals();
  Animal getAnimalById(int id);
}
