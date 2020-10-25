package com.pokemon.net.pokeservices.domain;

import lombok.Data;

@Data
public class RequestBase {

  int count;
  String next;
  String previous;
}
