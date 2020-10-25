package com.pokemon.net.pokeservices.repository;

import com.pokemon.net.pokeservices.repository.model.PokemonBaseDAO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonBaseRepository extends CrudRepository<PokemonBaseDAO, Integer> {

  @Query("SELECT b FROM PokemonBase b JOIN FETCH PokemonData p ON p.id = b.id JOIN p.color c WHERE c = 'red' ORDER BY p.height DESC")
  List<PokemonBaseDAO> findByColorRedOrderByHeight(Pageable pageable);

  @Query("SELECT b FROM PokemonBase b JOIN FETCH PokemonData p ON p.id = b.id JOIN p.color c WHERE c = 'red' ORDER BY p.weight DESC")
  List<PokemonBaseDAO> findByColorRedOrderByWeight(Pageable pageable);

  @Query("SELECT b FROM PokemonBase b JOIN FETCH PokemonData p ON p.id = b.id JOIN p.color c WHERE c = 'red' ORDER BY p.base_experience DESC")
  List<PokemonBaseDAO> findByColorRedOrderByBase_experience(Pageable pageable);
}
