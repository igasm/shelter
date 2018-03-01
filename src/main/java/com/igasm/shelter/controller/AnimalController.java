package com.igasm.shelter.controller;

import com.igasm.shelter.persistence.model.Animal;
import com.igasm.shelter.persistence.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalController {

  @Autowired
  private AnimalService animalService;

  @GetMapping("/animal")
  public ResponseEntity<List<Animal>> getAll(){
    List<Animal> animals = animalService.listAnimals();
    return ResponseEntity.ok().body(animals);
  }

  @PostMapping("/animal")
  public ResponseEntity<?> save(@RequestBody Animal animal){
    long id = animalService.addAnimal(animal);
    return ResponseEntity.ok().body("New animal has bee saved with id:" + id);
  }

  @GetMapping("/animal/{id}")
  public ResponseEntity<Animal> get(@PathVariable("id") int id){
    Animal animal = animalService.getAnimalById(id);
    return ResponseEntity.ok().body(animal);
  }
}
