package repository.schema

import sangria.schema._

import scala.util.Random

object DataTypes {
  case class Pokemon(id: Int, name: String, height: Int, weight: Int, description: List[String], img_url: String)

  val PokemonType = ObjectType(
    "Pokemon",
    fields[Unit, Pokemon](
      Field("id", IntType, resolve = ctx => ctx.value.id),
      Field("name", StringType, resolve = ctx => ctx.value.name),
      Field("height", IntType, resolve = ctx => ctx.value.height),
      Field("weight", IntType, resolve = ctx => ctx.value.weight),
      Field("description", StringType, resolve = ctx =>
        ctx.value.description(new Random().nextInt(ctx.value.description.length))),
      Field("img_url", StringType, resolve = ctx => ctx.value.img_url)
    )
  )
}
