package adventureGame.MODEL

import java.awt.Color

abstract class Type {
  
}

object Grass extends Type {
  val color = Color.GREEN
}

object Wall extends Type {
  val color = Color.BLACK
}

object NPC extends Type {
  val color = Color.RED
}
