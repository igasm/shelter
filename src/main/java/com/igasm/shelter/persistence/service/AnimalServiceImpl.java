package com.igasm.shelter.persistence.service;

import com.igasm.shelter.persistence.dao.AnimalDAO;
import com.igasm.shelter.persistence.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AnimalServiceImpl implements AnimalService {

  private AnimalDAO animalDAO;

  @Autowired
  @Qualifier(value = "animalDAO")
  public void setAnimalDAO(AnimalDAO animalDAO) {
    this.animalDAO = animalDAO;
  }

  @Override
  public long addAnimal(Animal animal) {
    return animalDAO.addAnimal(animal);
  }

  @Override
  public void updateAnimal(Animal animal) {
    animalDAO.updateAnimal(animal);
  }

  @Override
  public void deleteAnimal(Animal animal) {
    animalDAO.deleteAnimal(animal);
  }

  @Override
  public void deleteAnimalById(int id) {
    animalDAO.deleteAnimalById(id);
  }

  @Override
  public List<Animal> listAnimals() {
    return animalDAO.listAnimals();
  }

  @Override
  public Animal getAnimalById(int id) {
    return animalDAO.getAnimalById(id);
  }

}
