package com.pokemon.net.pokeservices.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class PokemonBase {

  @Id
  int id;
  String name;
  String url;
}
