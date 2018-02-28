package com.igasm.shelter.persistence.dao;

import com.igasm.shelter.persistence.model.Animal;

public interface AnimalDAO {

  void addAnimal(Animal animal);
  void updateAnimal(Animal animal);
  void deleteAnimal(Animal animal);

}
