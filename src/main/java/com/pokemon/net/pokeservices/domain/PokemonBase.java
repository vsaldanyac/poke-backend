package com.pokemon.net.pokeservices.domain;

import lombok.Data;

import javax.persistence.Id;

@Data
public class PokemonBase {

  @Id
  int id;
  String name;
  String url;
}
