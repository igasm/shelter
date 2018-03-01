package com.igasm.shelter.persistence.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.igasm.shelter.springConfig.CustomLocalDateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Animal {

  @Id
  @Column(name="id")
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private int id;

  private String name;

  private Species species;

  @JsonSerialize(using = CustomLocalDateSerializer.class)
  private LocalDate registrationDate;

  private String registrationNumber;

  //for hibernate
  private Animal(){
  }

  public Animal(String name, Species species, LocalDate registrationDate, String registrationNumber){
    this.name = name;
    this.species = species;
    this.registrationDate = registrationDate;
    this.registrationNumber = registrationNumber;
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
