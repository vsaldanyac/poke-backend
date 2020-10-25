package com.pokemon.net.pokeservices.domain;

import lombok.Data;

public class PokemonResources {

  @Data
  public class ColorVersion {
    PokeColor version;
  }

  @Data
  public class PokeColor {
    String name;
    String url;
  }
}
