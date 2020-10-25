package com.pokemon.net.pokeservices.domain;

import lombok.Data;

import javax.persistence.Id;
import java.util.List;

@Data
public class PokemonData {

  @Id
  int id;
  int height;
  int weight;
  int base_experience;
  List<ColorVersion> game_indices;

  @Data
  public static class ColorVersion {
    PokeColor version;
  }

  @Data
  public static class PokeColor {
    String name;
  }
}


