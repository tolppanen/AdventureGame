package adventureGame.GUI

import java.awt.Graphics2D
import adventureGame.MODEL.Level
import scala.swing.GridPanel
import java.awt.Dimension
import java.awt.Color
import adventureGame.MODEL.Game

class GamePanel(var game: Game) extends GridPanel(rows0 = 15, cols0 = 20) {

  private val tileSize = 50
  var animationPhase = 0
  this.preferredSize = new Dimension(tileSize * game.currentLevel.width, tileSize * game.currentLevel.height)

  override def paintComponent(g: Graphics2D): Unit = {

    val level = game.currentLevel
    val positions = level.characterGrid

    if (animationPhase < 6) animationPhase += 1
    else {
      animationPhase = 0
      game.player.hasFinishedMoving = true
    }

    for (x <- 0 until level.width) {
      for (y <- 0 until level.height) {
        val tile = level.levelGrid(x)(y)
        g.setColor(tile.getColor())
        g.fillRect(x * tileSize, y * tileSize, tileSize, tileSize)
      }
    }

    for (x <- 0 until level.width) {
      for (y <- 0 until level.height) {
        if (positions(x)(y) != null) {

          val character = positions(x)(y)

          if (character.moving) {
            character.direction match {
              case "RIGHT" => g.drawImage(character.getImage, x * tileSize + 7 * animationPhase -50, y * tileSize, null)
              case "LEFT" => g.drawImage(character.getImage, x * tileSize - 7 * animationPhase + 25, y * tileSize, null)
              case "UP" => g.drawImage(character.getImage, x * tileSize, y * tileSize - 7 * animationPhase + 25, null)
              case "DOWN" => g.drawImage(character.getImage, x * tileSize, y * tileSize + 7 * animationPhase + 25, null)
            }
            println(x * tileSize + 5 * animationPhase - 50)
          } else g.drawImage(character.getImage, x * tileSize, y * tileSize, null)
        }
      }
    }
  }
}