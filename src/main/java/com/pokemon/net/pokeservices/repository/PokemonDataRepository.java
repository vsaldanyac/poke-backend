package com.pokemon.net.pokeservices.repository;

import com.pokemon.net.pokeservices.domain.PokemonData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PokemonDataRepository extends CrudRepository<PokemonData, Integer> {

  @Query("SELECT p FROM PokemonData p ORDER BY p.height DESC")
  List<PokemonData> findOrderByHeight(Pageable pageable);

  @Query("SELECT p FROM PokemonData p ORDER BY p.weight DESC")
  List<PokemonData> findOrderByWeight(Pageable pageable);

  @Query("SELECT p FROM PokemonData p ORDER BY p.base_experience DESC")
  List<PokemonData> findOrderByBase_experience(Pageable pageable);
}
