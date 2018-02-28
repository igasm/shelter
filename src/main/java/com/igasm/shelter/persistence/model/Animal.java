package com.igasm.shelter.persistence.model;

import javafx.scene.layout.AnchorPane;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animal {

  @Id
  @Column(name="id")
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private int id;

  private String name;

  private String species;

  //for hibernate
  private Animal(){
  }

  public Animal(String name, String species){
    this.name = name;
    this.species = species;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }
}
