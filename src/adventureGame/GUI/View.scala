package adventureGame.GUI

import java.awt.Dimension
import scala.swing.BoxPanel
import scala.swing.MainFrame
import scala.swing.Orientation
import scala.swing.SimpleSwingApplication
import scala.swing.event.ActionEvent
import adventureGame.MODEL.Game
import adventureGame.MODEL.Level
import adventureGame.MODEL.Entity
import scala.swing.event.KeyPressed
import scala.swing.event.KeyReleased
import scala.swing.event.Key

object View extends SimpleSwingApplication {
  val frame = new MainFrame() {
    title = "Adventure"
    preferredSize = new Dimension(1000, 770)
  }

  def top = frame

  var newGame = new Game
  var gamePanel = new GamePanel(newGame)

  this.frame.contents = getUI()

  val player = gamePanel.game.player
  var rightKey = false
  var leftKey = false
  var upKey = false
  var downKey = false

  def getUI(): BoxPanel = {

    val container = new BoxPanel(Orientation.Horizontal) {

      listenTo(keys)
      reactions += {
        case KeyPressed(_, Key.Right, _, _) => {
          rightKey = true
          //          player.direction = "RIGHT"
          //          player.moving = true
        }
        case KeyPressed(_, Key.Left, _, _) => {
          leftKey = true
        }
        case KeyPressed(_, Key.Down, _, _) => {
          downKey = true
        }
        case KeyPressed(_, Key.Up, _, _) => {
          upKey = true
        }
        case KeyReleased(_, Key.Right, _, _) => {
          rightKey = false
          gamePanel.animationPhase = 0
        }
        case KeyReleased(_, Key.Left, _, _) => {
          leftKey = false
          gamePanel.animationPhase = 0
        }
        case KeyReleased(_, Key.Down, _, _) => {
          downKey = false
          gamePanel.animationPhase = 0
        }
        case KeyReleased(_, Key.Up, _, _) => {
          upKey = false
          gamePanel.animationPhase = 0
        }

      }
      focusable = true
      requestFocus
    }

    container.contents += gamePanel
    var tick = 1

    Timer(100) {
      if (rightKey) {
        player.moving = true
        player.direction = "RIGHT"
      } else if (leftKey) {
        player.moving = true
        player.direction = "LEFT"
      } else if (upKey) {
        player.moving = true
        player.direction = "UP"
      } else if (downKey) {
        player.moving = true
        player.direction = "DOWN"
      } else {
        player.moving = false
        player.hasFinishedMoving = true
      }
      if (gamePanel.animationPhase >= 6) player.moveToDirection(player.direction)
      newGame.updateGame()
      gamePanel.repaint()
    }
    container
  }

  object Timer {
    def apply(interval: Int, repeats: Boolean = true)(op: => Unit) {
      val timeOut = new javax.swing.AbstractAction() {
        def actionPerformed(e: java.awt.event.ActionEvent) = op
      }
      val t = new javax.swing.Timer(interval, timeOut)
      t.setRepeats(repeats)
      t.start()
    }
  }

}