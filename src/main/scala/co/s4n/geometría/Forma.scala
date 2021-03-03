package co.s4n.geometría

class Forma {
  def area: Double = 0.0
}

class Rectangulo(val ancho:Double, val altura:Double) extends Forma {
  override def area: Double = ancho * altura
}

class Círculo(val radio:Double) extends Forma{
  override def area: Double = math.Pi * radio * radio
}
