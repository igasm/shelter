package com.igasm.shelter.persistence.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.igasm.shelter.springConfig.CustomLocalDateDeserializer;
import com.igasm.shelter.springConfig.CustomLocalDateSerializer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Animal {

  @Id
  @Column(name="id")
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private int id;

  private String name;

  private Species species;

  @JsonSerialize(using = CustomLocalDateSerializer.class)
  @JsonDeserialize(using = CustomLocalDateDeserializer.class)
  private LocalDate registrationDate;

  //for hibernate, need to be public to make session.load method work
  public Animal(){
  }

  public Animal(String name, Species species, LocalDate registrationDate){
    this.name = name;
    this.species = species;
    this.registrationDate = registrationDate;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Species getSpecies() {
    return species;
  }

  public void setSpecies(Species species) {
    this.species = species;
  }

  public LocalDate getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(LocalDate registrationDate) {
    this.registrationDate = registrationDate;
  }

  @Override
  public boolean equals(Object o){
    if(this == o) return true;
    if(!(o instanceof Animal)) return false;
    Animal animal = (Animal) o;
    return animal.name.equals(this.name)
        && animal.registrationDate.equals(this.registrationDate)
        && animal.species.equals(this.species);
  }
}
