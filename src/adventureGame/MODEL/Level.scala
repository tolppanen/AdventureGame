package adventureGame.MODEL

import scala.collection.mutable.ArrayBuffer
import java.awt.Color

class Level(val width: Int, val height: Int) {

  var levelGrid = ArrayBuffer.fill[Entity](width, height)(null)
  var characterGrid = ArrayBuffer.fill[Character](width, height)(null)
  var neighbourLevels: ArrayBuffer[Level] = ArrayBuffer()

  //characterGrid(10)(10) = new Entity(10,10,this,"NPC")

  def clearCharacters: Unit = {
    characterGrid = ArrayBuffer.fill[Character](width, height)(null)
  }

  for (x <- 0 until width) {
    for (y <- 0 until height) {
      val r = scala.util.Random
      val next = r.nextInt(2)
      val colors = ArrayBuffer("grass", "wall")
      levelGrid(x)(y) = new Entity(x, y, this, "grass")
    }
  }

  def printThis() = {
    characterGrid.foreach { x => println(x) }
  }

}