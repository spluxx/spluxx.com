package repository.schema

import repository.Resolvers.Resolvers
import repository.schema.DataTypes._
import sangria.schema._

object QueryTypes {
  val Weight = Argument("weight", IntType)
  val Height = Argument("height", IntType)

  val QueryType = ObjectType("Query", fields[Resolvers, Unit](
    Field(
      "pokemonWithWeight",
      PokemonType,
      arguments = Weight :: Nil,
      resolve = c => c.ctx.pokemonWithWeight(c.args.arg("weight"))
    ),
    Field(
      "pokemonsWithWeight",
      ListType(PokemonType),
      arguments = Weight :: Nil,
      resolve = c => c.ctx.pokemonsWithWeight(c.args.arg("weight"))
    ),
    Field(
      "pokemonWithHeight",
      PokemonType,
      arguments = Height :: Nil,
      resolve = c => c.ctx.pokemonWithHeight(c.args.arg("height"))
    ),
    Field(
      "pokemonsWithHeight",
      ListType(PokemonType),
      arguments = Height :: Nil,
      resolve = c => c.ctx.pokemonsWithHeight(c.args.arg("height"))
    ),
    Field(
      "pokemons",
      ListType(PokemonType),
      arguments = Nil,
      resolve = c => c.ctx.pokemons
    )
  ))

  val schema: Schema[Resolvers, Unit] = Schema(QueryType)
}
