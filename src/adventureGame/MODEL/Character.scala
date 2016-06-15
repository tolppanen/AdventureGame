package adventureGame.MODEL

import javax.imageio.ImageIO
import java.awt.image.BufferedImage
import java.io.File

class Character(private var xPos: Int, private var yPos: Int, val characterType: String, var map: Level) {

  var playerImage: BufferedImage = ImageIO.read(new File("assets/playerImages/player_RIGHT.png"))
  val playerLeft1 = ImageIO.read(new File("assets/playerImages/player_left1.png"))
  val playerLeft2 = ImageIO.read(new File("assets/playerImages/player_left2.png"))
  val playerLeft3 = ImageIO.read(new File("assets/playerImages/player_left3.png"))
  val playerLeft4 = ImageIO.read(new File("assets/playerImages/player_left4.png"))
  val playerRight1 = ImageIO.read(new File("assets/playerImages/player_right1.png"))
  val playerRight2 = ImageIO.read(new File("assets/playerImages/player_right2.png"))
  val playerRight3 = ImageIO.read(new File("assets/playerImages/player_right3.png"))
  val playerRight4 = ImageIO.read(new File("assets/playerImages/player_right4.png"))
  val playerUp1 = ImageIO.read(new File("assets/playerImages/player_up1.png"))
  val playerUp2 = ImageIO.read(new File("assets/playerImages/player_up2.png"))
  val playerUp3 = ImageIO.read(new File("assets/playerImages/player_up3.png"))
  val playerUp4 = ImageIO.read(new File("assets/playerImages/player_up4.png"))
  val playerDown1 = ImageIO.read(new File("assets/playerImages/player_down1.png"))
  val playerDown2 = ImageIO.read(new File("assets/playerImages/player_down2.png"))
  val playerDown3 = ImageIO.read(new File("assets/playerImages/player_down3.png"))
  val playerDown4 = ImageIO.read(new File("assets/playerImages/player_down4.png"))
  var npcImage: BufferedImage = ImageIO.read(new File("assets/npc.png"))
  var direction: String = "DOWN"
  var moving: Boolean = false
  var hasFinishedMoving = true
  var movingPhase = 0

  def moveTo(x: Int, y: Int): Boolean = {
    //playerImage = ImageIO.read(new File("assets/playerImages/player_" + this.direction + ".png"))
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
      case "player" => {
        direction match {
          case "LEFT" => movingPhase match {
            case 0 => playerLeft1
            case 1 => playerLeft2
            case 2 => playerLeft3
            case 3 => playerLeft4
            case 4 => playerLeft1
            case 5 => playerLeft2
            case 6 => playerLeft3
          }
          case "RIGHT" => movingPhase match {
            case 0 => playerRight1
            case 1 => playerRight2
            case 2 => playerRight3
            case 3 => playerRight4
            case 4 => playerRight1
            case 5 => playerRight2
            case 6 => playerRight3
          }
          case "UP" => movingPhase match {
            case 0 => playerUp1
            case 1 => playerUp2
            case 2 => playerUp3
            case 3 => playerUp4
            case 4 => playerUp1
            case 5 => playerUp2
            case 6 => playerUp3
          }
          case "DOWN" => movingPhase match {
            case 0 => playerDown1
            case 1 => playerDown2
            case 2 => playerDown3
            case 3 => playerDown4
            case 4 => playerDown1
            case 5 => playerDown2
            case 6 => playerDown3
          }
        }

      }
      case "NPC" => npcImage
    }
  }

}