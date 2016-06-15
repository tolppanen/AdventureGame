package adventureGame.MODEL

import java.awt.Color
import javax.imageio.ImageIO
import java.awt.image.BufferedImage
import java.io.File

class Entity(var x: Int, var y: Int, val map: Level, var content: String) extends Type {

  val npcImage: BufferedImage = ImageIO.read(new File("assets/npc.png"))
  val grassImage: BufferedImage = ImageIO.read(new File("assets/grass.jpg"))
  val wallImage: BufferedImage = ImageIO.read(new File("assets/wall.png"))

  var direction = "down" //Default direction should be down, this is for the sprites

  def getName(): String = {
    content match {
      case "wall" => "This is a wall"
      case "NPC" => "Character"
      case "grass" => "This is grass, you can walk on it"
    }
  }

  def getColor(): Color = {
    content match {
      case "wall" => Color.BLACK
      case "NPC" => Color.ORANGE
      case "grass" => Color.GREEN
    }
  }

  def getImage(): BufferedImage = {
    content match {
      case "NPC" => npcImage
      case "grass" => grassImage
      case "wall" => wallImage
    }
  }

}