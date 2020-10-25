package com.pokemon.net.pokeservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class PokeServicesApplication {

  public static void main(String[] args) {
    SpringApplication.run(PokeServicesApplication.class, args);
  }

}
