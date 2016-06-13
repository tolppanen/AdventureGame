package adventureGame.MODEL

import scala.collection.mutable.ArrayBuffer

class Game {

  var currentLevel = new Level(20, 15)
  private var levels: ArrayBuffer[Level] = ArrayBuffer()

  val player = new Character(10, 10, "player", currentLevel)
  val npc1 = new Character(8,8, "NPC", currentLevel)
  val lines = scala.io.Source.fromFile("assets/level1.txt").getLines.map(_.split(",")).toArray
  
  println(lines.size)
  
  for(x <- 0 until currentLevel.width) {
    for(y <- 0 until currentLevel.height) {
      if (lines(y)(x) == "o") currentLevel.levelGrid(x)(y) = new Entity(x,y,currentLevel,"grass")
      else if (lines(y)(x) == "#") currentLevel.levelGrid(x)(y) = new Entity(x,y,currentLevel,"wall")     
    }
  }
  

  def updateGame() = {
    currentLevel.clearCharacters
    currentLevel.characterGrid(player.getX())(player.getY()) = player
    currentLevel.characterGrid(npc1.getX())(npc1.getY()) = npc1
  }

}