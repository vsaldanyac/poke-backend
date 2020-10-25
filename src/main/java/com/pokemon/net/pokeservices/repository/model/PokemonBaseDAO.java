package com.pokemon.net.pokeservices.repository.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity(name = "PokemonBase")
public class PokemonBaseDAO {
  public void PokemonBaseDAO(String name) {
    this.name = name;
  }
  @Id
  int id;
  String name;
  String url;
  @OneToOne
  PokemonDataDAO data;

}
