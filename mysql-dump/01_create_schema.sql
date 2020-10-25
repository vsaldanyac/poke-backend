-- CREATE PokemonBase TABLE
	CREATE TABLE PokemonBase (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
PRIMARY KEY (`id`)
);

-- CREATE PokemonData TABLE
	CREATE TABLE PokemonData (
  `id` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  `weight` int(11) NOT NULL,
  `base_experience` int(11) NOT NULL,
PRIMARY KEY (`id`)
);