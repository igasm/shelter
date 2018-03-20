package com.igasm.shelter.controller;

import com.igasm.shelter.MvcConfiguration;
import com.igasm.shelter.persistence.model.Animal;
import com.igasm.shelter.persistence.model.Species;
import com.igasm.shelter.persistence.service.AnimalService;
import com.igasm.shelter.springConfig.PersistenceConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, MvcConfiguration.class})
@WebAppConfiguration
public class AnimalControllerTest {

  @Autowired
  private WebApplicationContext wac;

  @Autowired
  MockHttpSession session;

  @Autowired
  private AnimalService animalService;

  private MockMvc mockMvc;
  private LocalDate date;
  private Animal dog;
  private long animalId;

  @Before
  public void setup() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    this.date = LocalDate.now();
    this.dog = new Animal("Burek", Species.DOG, date);
    this.animalId = animalService.addAnimal(dog);
  }

  @After
  public void cleanUp(){
    animalService.deleteAnimal(dog);
  }


  @Test
  public void testGetAnimals() throws Exception {
    this.mockMvc.perform(get("/animal"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].name", is("Burek")))
        .andExpect(jsonPath("$[0].species", is(Species.DOG.toString())))
        .andExpect(jsonPath("$[0].registrationDate", is(date.toString())));
  }

  @Test
  public void testGetAnimalById() throws Exception {
    this.mockMvc.perform(get("/animal/" + animalId))
        .andExpect(status().isOk())
        .andExpect(jsonPath("name", is("Burek")))
        .andExpect(jsonPath("species", is(Species.DOG.toString())))
        .andExpect(jsonPath("registrationDate", is(date.toString())));
  }

}