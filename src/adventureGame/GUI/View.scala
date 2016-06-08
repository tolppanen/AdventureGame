package adventureGame.GUI

import java.awt.Dimension

import scala.swing.BoxPanel
import scala.swing.MainFrame
import scala.swing.Orientation
import scala.swing.SimpleSwingApplication
import scala.swing.event.ActionEvent

import adventureGame.MODEL.Game
import adventureGame.MODEL.Level

object View extends SimpleSwingApplication {
  val frame = new MainFrame() {
    title = "Adventure"
    preferredSize = new Dimension(1000,770)
  }
  
  def top = frame
  
  
  val firstLevel = new Level(20,15)
  val gamePanel = new GamePanel(firstLevel)
  
  this.frame.contents = getUI()
  
  

  

  
  
  def getUI() : BoxPanel = {
    val container = new BoxPanel(Orientation.Horizontal)
    val game = new Game
    container.contents += gamePanel
    container
  }
  
}