package com.igasm.shelter.persistence.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.igasm.shelter.springConfig.CustomLocalDateDeserializer;
import com.igasm.shelter.springConfig.CustomLocalDateSerializer;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Document(collection = "animals")
public class Animal {

  @Id
  private String id;

  private String name;

  private Species species;

  @JsonSerialize(using = CustomLocalDateSerializer.class)
  @JsonDeserialize(using = CustomLocalDateDeserializer.class)
  private LocalDate registrationDate;

  private String registrationNumber;

  //for hibernate, need to be public to make session.load method work
  public Animal(){
  }

  public Animal(String name, Species species, LocalDate registrationDate, String registrationNumber){
    this.name = name;
    this.species = species;
    this.registrationDate = registrationDate;
    this.registrationNumber = registrationNumber;
  }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
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

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  @Override
  public boolean equals(Object o){
    if(this == o) return true;
    if(!(o instanceof Animal)) return false;
    Animal animal = (Animal) o;
    return animal.name.equals(this.name)
        && animal.registrationDate.equals(this.registrationDate)
        && animal.species.equals(this.species)
        && animal.registrationNumber.equals(this.registrationNumber);
  }
}
