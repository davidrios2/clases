package co.s4n.gato

class Gato (val nombre:String, val comida:String, val color:String)

object VentaDeChurrus {
  def despachar (gato:Gato): Boolean = gato.comida == "Churrus"
}

