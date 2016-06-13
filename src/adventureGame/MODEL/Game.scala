package adventureGame.MODEL

import scala.collection.mutable.ArrayBuffer

class Game {

  var currentLevel = new Level(20, 15)
  private var levels: ArrayBuffer[Level] = ArrayBuffer()

  val player = new Character(10, 10, "player", currentLevel)
  val npc1 = new Character(8,8, "NPC", currentLevel)

  def updateGame() = {
    currentLevel.clearCharacters
    currentLevel.characterGrid(player.getX())(player.getY()) = player
    currentLevel.characterGrid(npc1.getX())(npc1.getY()) = npc1
  }

}