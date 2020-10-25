package com.pokemon.net.pokeservices.repository;

import com.pokemon.net.pokeservices.repository.model.PokemonDataDAO;
import org.springframework.data.repository.CrudRepository;

public interface PokemonDataRepository extends CrudRepository<PokemonDataDAO, Integer> {

}
