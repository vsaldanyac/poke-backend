package com.pokemon.net.pokeservices.controller;

import com.pokemon.net.pokeservices.services.PokemonService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PokemonControllerShould {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PokemonService pokemonService;

  @Before(value = "")
  public void setup() {
    initMocks(this);
  }

  @Test
  public void shouldExistGetPokemonData() throws Exception {
    this.mockMvc.perform(get("/pokemon/start")
        .contentType(MediaType.APPLICATION_JSON)
    ).andExpect(status().is2xxSuccessful()
    );
  }

  @Test
  public void shouldExistGetHeaviest() throws Exception {
    this.mockMvc.perform(get("/pokemon/heaviest")
        .contentType(MediaType.APPLICATION_JSON)
    ).andExpect(status().is2xxSuccessful()
    );
  }

  @Test
  public void shouldExistGetMoreExperience() throws Exception {
    this.mockMvc.perform(get("/pokemon/experience")
        .contentType(MediaType.APPLICATION_JSON)
    ).andExpect(status().is2xxSuccessful()
    );
  }

  @Test
  public void shouldExistGetHighest() throws Exception {
    this.mockMvc.perform(get("/pokemon/highest")
        .contentType(MediaType.APPLICATION_JSON)
    ).andExpect(status().is2xxSuccessful()
    );
  }

  @Test
  public void shouldProcessSubscriptionUpdateSuccessfully() throws Exception {
    this.mockMvc.perform(get("/pokemon/start")
        .contentType(MediaType.APPLICATION_JSON)
        .content(readBody("pokemonSample.json"))
    ).andExpect(status().is2xxSuccessful());
  }

  private String readBody(final String resourceFile) throws IOException {
    File file = new File(getClass().getClassLoader().getResource(resourceFile).getFile());
    byte[] contents = Files.readAllBytes(file.toPath());
    return new String(contents, StandardCharsets.UTF_8);
  }
}
