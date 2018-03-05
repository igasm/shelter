package com.igasm.shelter.persistence.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class AnimalTest {

  @Test
  public void whenUsingCustomLocalDateSerializer() throws JsonProcessingException {
    LocalDate date = LocalDate.of(2018, 03, 01);
    Animal animal = new Animal("Burek", Species.DOG, date, "SP/5/03/2018");
    ObjectMapper mapper = new ObjectMapper();
    String result = mapper.writeValueAsString(animal);
    assertThat(result).contains("2018-03-01");
  }

  //{"id":0,"name":"Burek","species":"DOG","registrationDate":"2018-03-01","registrationNumber":"SP/5/03/2018"}
  @Test
  public void whenUsingCustomLocalDateDeserializer() throws IOException {
    LocalDate date = LocalDate.of(2018, 03, 01);
    ObjectMapper mapper = new ObjectMapper();
    String stringBody = "{\"id\":0,\"name\":\"Burek\",\"species\":\"DOG\",\"registrationDate\":\"2018-03-01\",\"registrationNumber\":\"SP/5/03/2018\"}";
    Animal animal = mapper.readValue(stringBody, Animal.class);
    assertThat(animal.getRegistrationDate()).isEqualTo(date);
  }

}