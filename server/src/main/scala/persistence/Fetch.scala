package persistence

import repository.schema.DataTypes.Pokemon
import resource._
import io.circe.parser._
import io.circe.Decoder
import io.circe.generic.semiauto._

import scala.io.Source
import scala.util.Try

object Fetch {
  implicit val pokeDecoder: Decoder[Pokemon] = deriveDecoder[Pokemon]
  val pokemonData: Try[Vector[Pokemon]] = {
    managed(Source.fromResource("pokedata.json")).map(data => {
      decode[Vector[Pokemon]](data.mkString).toTry
    }).tried.flatten
  }
}
