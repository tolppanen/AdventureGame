package adventureGame.MODEL

import java.awt.Color
import javax.imageio.ImageIO
import java.awt.image.BufferedImage
import java.io.File

class Entity (var x: Int, var y: Int, val map: Level, val content: String) extends Type {
  
  val npcImage: BufferedImage = ImageIO.read(new File("npc.png"))
  
  var direction = "down"         //Default direction should be down, this is for the sprites
  
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
     }
   }

}