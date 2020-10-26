package com.pokemon.net.pokeservices.controller;

import com.pokemon.net.pokeservices.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokeController {

  @Autowired
  PokemonService pokemonService;

  public final String LIMIT = "5";

  @GetMapping("/start")
  public ResponseEntity<?> getPokemons() {

    return ResponseEntity.ok(pokemonService.getAndSavePokemons());
  }

  @GetMapping("/heaviest")
  public ResponseEntity<?> getHeaviest(@RequestParam(name = "count", required = false, defaultValue = LIMIT) int count) {

    return ResponseEntity.ok(pokemonService.getHeaviestPokemons(count));
  }

  @GetMapping("/highest")
  public ResponseEntity<?> getHighest(@RequestParam(name = "count", required = false, defaultValue = LIMIT) int count) {

    return ResponseEntity.ok(pokemonService.getHighestPokemons(count));
  }

  @GetMapping("/experience")
  public ResponseEntity<?> getMoreBaseExperiencePokemons(@RequestParam(name = "count", required = false, defaultValue = LIMIT) int count) {

    return ResponseEntity.ok(pokemonService.getMoreBaseExperiencePokemons(count));
  }

}

