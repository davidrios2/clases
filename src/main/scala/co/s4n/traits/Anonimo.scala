package co.s4n.traits
//case class Anonimo extends Visitante

//case class Usuario extends Visitante

//sealed = sellado no se pued ecrear un trait más abajo
//manejo de efectos mónada --> práctica
//manejo de listas y opciones
//lista por convcención
//funciuón generadora ->
//yield
//estudiar funciones de listas map, flat map,

sealed trait Felino {
  def color():String = "amarillo"
  def sonido(): String
}

final class Lion(val melena:Int = 0) extends Felino {

  color():String
  def sonido(): String = "Chsrrz"

}
final class Tiger extends Felino {

  override def color():String = "C"
  def sonido(): String = "plop"

}

final class Jaguar extends Felino {

  override def color():String = "B"
  def sonido(): String = "blblblbl"

}
final class Cat(val comida:String = "Lasagna") extends Felino {

  override def color():String = "A"
  def sonido(): String = "Miua"

}
object main extends App{

  val tiger = new Tiger
  println(tiger.color())
  print(tiger.sonido())

}

trait Forma {
  def tamaño():Int
  def perímetro():Double
  def área():Double
}

trait Rectangular extends Forma {
  override def tamaño():Int = 4
}

case class Círculo (val radio:Double = 1) extends Forma {

  def tamaño() = 0

  def perímetro(): Double = math.Pi*2*radio

  def área(): Double = math.Pi*radio*radio

  override def toString: String = s"Un círculo de radio $radio cm"

}

case class Rectángulo (val lado1: Double, val lado2 : Double) extends Rectangular {

  def perímetro():Double = lado1*2 + lado2*2

  def área(): Double = lado1 * lado2

  override def toString: String = s"Un Rectángulo de ancho $lado1 cm y ancho $lado2 cm"

}

case class Cuadrado (val lado:Int = 1) extends Rectangular {

  def perímetro():Double = lado * 4

  def área(): Double = lado * lado

  override def toString: String = s"Un cuadrado de radio $lado cm"
}
object Draw{
  def apply2(forma:Forma):String = forma.toString

  def apply(forma: Forma):String = forma match{
    case Círculo(radio) => s"Un círculo de radio $radio cm"
    case Rectángulo(lado1,lado2) => s"Un Rectángulo de ancho $lado1 cm y ancho $lado2 cm"
    case Cuadrado(lado) => s"Un cuadrado de radio $lado cm"
  }
}

class Color(val red:Int,val green:Int, val blue:Int)

object Red extends Color(255,0,0)
object Yellow extends Color(255,255,0)
object Pink extends Color(255,0,255)

object Color {

  def apply(red: Int, green:Int, blue:Int) = new Color (red, green, blue)

}



