package com.pokemon.net.pokeservices.services.impl;

import com.pokemon.net.pokeservices.config.HttpClientConfig;
import com.pokemon.net.pokeservices.config.RestTemplateConfig;
import com.pokemon.net.pokeservices.domain.PokemonBase;
import com.pokemon.net.pokeservices.domain.PokemonConfig;
import com.pokemon.net.pokeservices.domain.PokemonData;
import com.pokemon.net.pokeservices.repository.PokemonBaseRepository;
import com.pokemon.net.pokeservices.repository.PokemonDataRepository;
import com.pokemon.net.pokeservices.repository.mapper.PokemonMapper;
import com.pokemon.net.pokeservices.services.PokemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
@ContextConfiguration(classes = {RestTemplateConfig.class, HttpClientConfig.class})
public class PokemonServiceImpl implements PokemonService {

  private static final Logger LOGGER = LoggerFactory.getLogger(PokemonServiceImpl.class);

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  PokemonBaseRepository pokemonBaseRepository;

  @Autowired
  PokemonDataRepository pokemonDataRepository;

  @Value("${pokemon.url}")
  private String uri;

  PokemonMapper pokemonMapper = PokemonMapper.INSTANCE;

  @Override
  public PokemonConfig getAndSavePokemons() {
    PokemonConfig pokemonConfig = restTemplate.getForObject(uri, PokemonConfig.class);
    LOGGER.info(String.format("GET pokemon base information for %d results", pokemonConfig.getCount()));
    String uriForNext = pokemonConfig.getNext();
    getNextPokemonPages(pokemonConfig, uriForNext);
    getPokemonDataInfo(pokemonConfig);
    pokemonBaseRepository.saveAll(pokemonMapper.map(pokemonConfig.getResults()));
    return pokemonConfig;
  }

  private void getPokemonDataInfo(PokemonConfig pokemonConfig) {
    int count = 0;
    for (PokemonBase poke : pokemonConfig.getResults()) {
      LOGGER.info(String.format("GET data information for pokemon number %d", count));
      PokemonData pokeData = restTemplate.getForObject(poke.getUrl(), PokemonData.class);

      pokemonDataRepository.save(pokemonMapper.map(pokeData));
      poke.setId(pokeData.getId());
      count++;
    }
  }

  private void getNextPokemonPages(PokemonConfig pokemonConfig, String uriForNext) {
    int page = 0;
    while (uriForNext != null) {
      page++;
      LOGGER.info(String.format("GET pokemon base information for page %d ", page));
      PokemonConfig pokemonTemp = restTemplate.getForObject(uriForNext, PokemonConfig.class);
      pokemonConfig.getResults().addAll(pokemonTemp.getResults());
      uriForNext = pokemonTemp.getNext();
    }
  }

  @Override
  public List<PokemonBase> getHeaviestPokemons(int top) {
    Pageable topLimit = PageRequest.of(0, top);
    return pokemonMapper.mapDAO(pokemonBaseRepository.findByColorRedOrderByWeight(topLimit));

  }

  @Override
  public List<PokemonBase> getHighestPokemons(int top) {
    Pageable topLimit = PageRequest.of(0, top);
    return pokemonMapper.mapDAO(pokemonBaseRepository.findByColorRedOrderByHeight(topLimit));
  }

  @Override
  public List<PokemonBase> getMoreBaseExperiencePokemons(int top) {
    Pageable topLimit = PageRequest.of(0, top);
    return pokemonMapper.mapDAO(pokemonBaseRepository.findByColorRedOrderByBase_experience(topLimit));
  }
}
