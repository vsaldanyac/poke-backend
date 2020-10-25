package com.pokemon.net.pokeservices.services;

import com.pokemon.net.pokeservices.domain.PokemonBase;
import com.pokemon.net.pokeservices.domain.PokemonConfig;

import java.util.List;

public interface PokemonService {

  PokemonConfig getAndSavePokemons();

  List<PokemonBase> getHeaviestPokemons(int top);

  List<PokemonBase> getHighestPokemons(int top);

  List<PokemonBase> getMoreBaseExperiencePokemons(int top);
}
