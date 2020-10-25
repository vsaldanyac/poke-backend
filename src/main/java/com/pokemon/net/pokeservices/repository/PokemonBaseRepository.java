package com.pokemon.net.pokeservices.repository;

import com.pokemon.net.pokeservices.domain.PokemonBase;
import org.springframework.data.repository.CrudRepository;

public interface PokemonBaseRepository extends CrudRepository<PokemonBase, Integer> {

}
