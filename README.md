# poke-backend

## How to run

### Start with docker

~~~~
docker-compose up -d --build
~~~~

### Load Data

- First of all, you must load data from API service `https://pokeapi.co/api/v2/pokemon/`

To do that, you must call the method from the API

· `localhost:8081/pokemon/start`

### Extract info

· To extract the heaviest 5 pokemons

`localhost:8081/pokemon/heaviest`

· To extract the highest 5 pokemons

`localhost:8081/pokemon/highest`

· To extract the 5 most experienced pokemons

`localhost:8081/pokemon/experience`

### Optional parameter

All the request has an optional parameter called count that allows to request for another number of pokemons.

· *Sample to extract the 10 most experienced pokemons*

`localhost:8081/pokemon/experience?count=10`
