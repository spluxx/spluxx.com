package repository

import engine.Search
import repository.schema.DataTypes.Pokemon

object Resolvers {
  // delegates calculations to the search engine
  class PokemonResolver(data: Vector[Pokemon]) {
    def pokemonWithHeight(height: Int): Pokemon = Search.pokemonWithHeight(height, data)
    def pokemonsWithHeight(height: Int): List[Pokemon] = Search.pokemonsWithHeight(height, data).toList
    def pokemonWithWeight(weight: Int): Pokemon = Search.pokemonWithWeight(weight, data)
    def pokemonsWithWeight(weight: Int): List[Pokemon] = Search.pokemonsWithWeight(weight, data).toList
    def pokemons: List[Pokemon] = data.toList
  }

  class Resolvers(pokemonData: Vector[Pokemon]) extends PokemonResolver(pokemonData)
}
