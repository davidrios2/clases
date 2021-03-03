package co.s4n.editorial

class Libro (val titulo: String, val autor: String, val ref: String ){
  //s means substitution and '$' to reference any val
  def presentar = s"$titulo de $autor, categoría: $ref"
}

object run extends Libro("El coronel no tiene quien le escriba","Gabo","Realismo Mágico") with App {

  //if you specify the parameter in the constructor you could change the order of them
  val libro = new Libro(ref = "yolo", titulo = "yoo", autor = "woo" )
  println(libro.presentar)

}

