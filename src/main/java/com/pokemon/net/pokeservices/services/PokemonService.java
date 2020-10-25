package com.pokemon.net.pokeservices.services;

import com.pokemon.net.pokeservices.domain.PokemonConfig;
import com.pokemon.net.pokeservices.domain.PokemonData;

import java.util.List;

public interface PokemonService {

  PokemonConfig getAndSavePokemons();

  List<PokemonData> getHeaviestPokemons(int top);

  List<PokemonData> getHighestPokemons(int top);

  List<PokemonData> getMoreBaseExperiencePokemons(int top);
}
