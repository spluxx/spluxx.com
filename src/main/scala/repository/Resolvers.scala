package repository

import engine.Search
import repository.schema.DataTypes.Pokemon

object Resolvers {
  // delegates calculations to the search engine
  class PokemonResolver(data: Vector[Pokemon]) {
    def pokemonWithHeight(height: Double): Pokemon = Search.pokemonWithHeight(height, data)
    def pokemonsWithHeight(height: Double): List[Pokemon] = Search.pokemonsWithHeight(height, data).toList
    def pokemonWithWeight(weight: Double): Pokemon = Search.pokemonWithWeight(weight, data)
    def pokemonsWithWeight(weight: Double): List[Pokemon] = Search.pokemonsWithWeight(weight, data).toList
    def pokemons: List[Pokemon] = data.toList
  }

  class Resolvers(pokemonData: Vector[Pokemon]) extends PokemonResolver(pokemonData)
}
