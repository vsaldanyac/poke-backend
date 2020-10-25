package com.pokemon.net.pokeservices.domain;

import lombok.Data;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class PokemonData {

  @Id
  int id;
  int height;
  int weight;
  int base_experience;
  /*
  transient List<PokemonResources.ColorVersion> game_indices;

  public boolean hasRedColor() {
    for (PokemonResources.ColorVersion color : game_indices) {
      if (color.getVersion().getName().equals("red")) {
        return true;
      }
    }
    return false;
  }*/
}


