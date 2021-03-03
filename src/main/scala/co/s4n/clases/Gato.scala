package co.s4n.clases

class Gato (val nombre:String, val comida:String, val color:String)

object VentaDeChurrus {
  def despachar (gato:Gato): Boolean = gato.comida == "Churrus"
}

