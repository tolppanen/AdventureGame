package adventureGame.GUI

import java.awt.Graphics2D

import adventureGame.MODEL.Level
import scala.swing.GridPanel
import java.awt.Dimension
import java.awt.Color

class GamePanel(val grid: Level) extends GridPanel(rows0 = 15, cols0 = 30) {
  
    private val tileSize = 50
    
    this.preferredSize = new Dimension(tileSize*grid.width, tileSize*grid.height)
  
    override def paintComponent(g:Graphics2D) : Unit = {
    for (x <- 0 until grid.width) {
      for (y <- 0 until grid.height) {
        val tile = grid.levelGrid(x)(y)
        g.setColor(tile.getColor())
        g.fillRect(x*tileSize, y*tileSize, tileSize, tileSize)
        
        if(grid.characterGrid(x)(y) != null) g.drawImage(grid.characterGrid(x)(y).getImage(), x*tileSize,y*tileSize, null)
      }
    }
    //g.drawImage(grid.characterGrid(10)(10).getImage(), 10*tileSize,10*tileSize,null)
  }
  
}