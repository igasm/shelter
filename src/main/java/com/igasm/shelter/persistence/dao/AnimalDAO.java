package com.igasm.shelter.persistence.dao;

import com.igasm.shelter.persistence.model.Animal;
import com.igasm.shelter.persistence.model.Species;

import java.util.List;

public interface AnimalDAO {
  long addAnimal(Animal animal);
  void updateAnimal(Animal animal);
  void deleteAnimal(Animal animal);
  void deleteAnimalById(int id);
  List<Animal> listAnimals();
  Animal getAnimalById(int id);
  List<Animal> listAnimalsBySpecies(Species species);
}
