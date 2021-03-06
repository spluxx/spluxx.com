package engine

import repository.schema.DataTypes.Pokemon

import scala.util.Random

object Search {
  def pokemonsWithWeight(weight: Double, data: Vector[Pokemon]): Vector[Pokemon] = {
    val closestWeight = data.map(_.weight).minBy(w => Math.abs(w - weight))
    data.filter(p => p.weight == closestWeight)
  }
  def pokemonWithWeight(weight: Double, data: Vector[Pokemon]): Pokemon = {
    val candidates = pokemonsWithWeight(weight, data)
    candidates(new Random().nextInt(candidates.length))
  }
  def pokemonsWithHeight(height: Double, data: Vector[Pokemon]): Vector[Pokemon] = {
    val closestHeight = data.map(_.height).minBy(h => Math.abs(h - height))
    data.filter(p => p.height == closestHeight)
  }
  def pokemonWithHeight(height: Double, data: Vector[Pokemon]): Pokemon = {
    val candidates = pokemonsWithHeight(height, data)
    candidates(new Random().nextInt(candidates.length))
  }
}
