package com.pokemon.net.pokeservices.repository.mapper;

import com.pokemon.net.pokeservices.domain.PokemonBase;
import com.pokemon.net.pokeservices.domain.PokemonData;
import com.pokemon.net.pokeservices.repository.model.PokemonBaseDAO;
import com.pokemon.net.pokeservices.repository.model.PokemonDataDAO;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
@DecoratedWith(PokemonDecorator.class)
public interface PokemonMapper {

  PokemonMapper INSTANCE = Mappers.getMapper(PokemonMapper.class);

  List<PokemonBaseDAO> map(List<PokemonBase> pokemonBase);

  List<PokemonBase> mapDAO(List<PokemonBaseDAO> pokemon);

  PokemonDataDAO map(PokemonData pokemonData);

}






