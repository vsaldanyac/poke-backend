package com.pokemon.net.pokeservices.controller;

import com.pokemon.net.pokeservices.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokeController {

  @Autowired
  PokemonService pokemonService;

  public final int LIMIT = 5;

  @GetMapping("/start")
  public ResponseEntity<?> getPokemons() {

    return ResponseEntity.ok(pokemonService.getAndSavePokemons());
  }

  @GetMapping("/heaviest")
  public ResponseEntity<?> getHeaviest() {

    return ResponseEntity.ok(pokemonService.getHeaviestPokemons(LIMIT));
  }

  @GetMapping("/highest")
  public ResponseEntity<?> getHighest() {

    return ResponseEntity.ok(pokemonService.getHighestPokemons(LIMIT));
  }

  @GetMapping("/experience")
  public ResponseEntity<?> getMoreBaseExperiencePokemons() {

    return ResponseEntity.ok(pokemonService.getMoreBaseExperiencePokemons(LIMIT));
  }

}

