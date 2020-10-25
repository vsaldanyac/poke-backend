package com.pokemon.net.pokeservices.repository.mapper;

import com.pokemon.net.pokeservices.domain.PokemonData;
import com.pokemon.net.pokeservices.repository.model.PokemonDataDAO;

import java.util.ArrayList;
import java.util.List;


public abstract class PokemonDecorator implements PokemonMapper {

  private final PokemonMapper delegate;

  public PokemonDecorator(PokemonMapper delegate) {
    this.delegate = delegate;
  }

  @Override
  public PokemonDataDAO map(PokemonData pokemonData) {
    PokemonDataDAO pokemon = delegate.map(pokemonData);
    List<String> colorList = new ArrayList();
    if (pokemon != null) {
      for (PokemonData.ColorVersion pokeColor : pokemonData.getGame_indices()) {
        colorList.add(pokeColor.getVersion().getName());
      }
      pokemon.setColor(colorList);
    }

    return pokemon;
  }
}
