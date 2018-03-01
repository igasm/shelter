package com.igasm.shelter.controller;

import com.igasm.shelter.MvcConfiguration;
import com.igasm.shelter.persistence.model.Animal;
import com.igasm.shelter.persistence.model.Species;
import com.igasm.shelter.persistence.service.AnimalService;
import com.igasm.shelter.springConfig.PersistanceConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.*;
//import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistanceConfig.class, MvcConfiguration.class})
@WebAppConfiguration
public class AnimalControllerTest {

  @Autowired
  private WebApplicationContext wac;

  @Autowired
  MockHttpSession session;

  @Autowired
  private AnimalService animalService;

  private MockMvc mockMvc;

  @Before
  public void setup() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }


  @Test
  public void testGetAnimals() throws Exception {

    Animal dog = new Animal("Burek",
        Species.DOG,
        LocalDateTime.now(),
        "SP/1/2018");

    this.mockMvc.perform(get("/animal"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].name", is("Burek")));

    animalService.deleteAnimal(dog);

  }

}