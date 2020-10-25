package com.pokemon.net.pokeservices.domain;

import lombok.Data;

import java.util.List;

@Data
public class PokemonConfig extends RequestBase {

  List<PokemonBase> results;
}
