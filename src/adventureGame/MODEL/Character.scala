package adventureGame.MODEL

import javax.imageio.ImageIO
import java.awt.image.BufferedImage
import java.io.File

class Character(private var xPos: Int, private var yPos: Int, val characterType: String, var map: Level) {

  var playerImage: BufferedImage = ImageIO.read(new File("assets/player_RIGHT.png"))
  var npcImage: BufferedImage = ImageIO.read(new File("assets/npc.png"))
  var direction: String = "DOWN"
  var moving: Boolean = false
  var hasFinishedMoving = true
  var movingPhase = 0

  def moveTo(x: Int, y: Int): Boolean = {
    playerImage = ImageIO.read(new File("assets/player_" + this.direction + ".png"))
    if (canMoveTo(x, y)) {     
      this.xPos = x
      this.yPos = y
      hasFinishedMoving = false
      true
    } else false
  }

  def moveToDirection(direction: String): Boolean = {
    if (moving)
      direction match {
        case "RIGHT" => moveTo(xPos + 1, yPos)
        case "LEFT" => moveTo(xPos - 1, yPos)
        case "UP" => moveTo(xPos, yPos - 1)
        case "DOWN" => moveTo(xPos, yPos + 1)
      }
    else false
  }

  def canMoveTo(x: Int, y: Int): Boolean = {
    //this goes out of bounds TODO!
    if (x >= 0 && x < map.width && y >= 0 && y < map.height) !map.characterGrid(x)(y).isInstanceOf[Character] && !map.levelGrid(x)(y).content.equals("wall")
    else false
  }

  def getX() = {
    this.xPos
  }

  def getY() = {
    this.yPos
  }

  def moveToLevel(newLevel: Level): Boolean = {
    this.map = newLevel
    true
  }

  def getImage: BufferedImage = {
    this.characterType match {
      case "player" => playerImage
      case "NPC" => npcImage
    }
  }

}