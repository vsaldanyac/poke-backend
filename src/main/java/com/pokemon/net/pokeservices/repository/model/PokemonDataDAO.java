package com.pokemon.net.pokeservices.repository.model;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity(name="PokemonData")
public class PokemonDataDAO {

  @Id
  int id;
  int height;
  int weight;
  int base_experience;
  @ElementCollection
  List<String> color;
}
