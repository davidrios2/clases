package co.s4n.clases

class Persona (val nombre:String, val apellido:String){
  def name = s"$nombre $apellido"
}
 object Persona {

   def apply (nombre:String) = {
     val separator = nombre.split(" ")
     new Persona(separator(0),separator(1))
   }

 }
class Director (val nombre: String, val apellido: String, val nacimiento: Int) {

  def copy (nombre: String =  this.nombre, apellido: String =
    this.apellido, nacimiento: Int = this.nacimiento) = new Director(nombre, apellido, nacimiento)

  def name: String = s"$nombre $apellido"

  //override def toString: String
}
class Pelicula (val nombre: String, val presentacion:Int, val rangoIMBD: Double, val director: Director){

  def copy(nombre: String = this.nombre, presentacion:Int = this.presentacion, rangoIMBD: Double =
    this.rangoIMBD, director: Director = this.director)
    = new Pelicula(nombre, presentacion, rangoIMBD, director)

  //def directorOld = copy().presentacion - copy().director.nacimiento
  def directorOld = presentacion - director.nacimiento

  //def isDirecterBy(director: Director) = copy().director == director
  def isDirecterBy(director: Director) = this.director == director

}

object Director {

  def apply (nombre: String, apellido: String, nacimiento: Int) =
    new Director(nombre,apellido,nacimiento)

  def oldest (director: Director, director2:Director):Director =
    if (director.nacimiento > director2.nacimiento) director else director2

}

 object  Pelicula {

   def apply (nombre: String,presentacion:Int,rangoIMBD: Double, director: Director) =
     new Pelicula(nombre, presentacion, rangoIMBD, director)

   def bestIMDB(pelicula: Pelicula, pelicula2: Pelicula):Pelicula =
     if (pelicula.rangoIMBD > pelicula2.rangoIMBD) pelicula else pelicula2

   def oldesDirectorTime(pelicula: Pelicula, pelicula2: Pelicula):Director = {
     if (pelicula.directorOld > pelicula2.directorOld) pelicula.director else pelicula2.director
   }
 }

object main extends App {

  val director = Director("Tarantino","Pérez", 1915 )
  val director2 = Director("Sergio","Muñoz", 1922 )
  val myMovie = Pelicula("Titulo 1", 1956, 8.2, director)
  val myMovie2 = Pelicula("Titulo 2", 1945, 9.6, director2)

  val best = Pelicula.bestIMDB(myMovie, myMovie2).toString
  val old = Pelicula.oldesDirectorTime(myMovie, myMovie2).toString

  println(best)
  println(old)

  println(director.name)
  println(director2.name)
  println(myMovie.directorOld)
  println(myMovie2.directorOld)
  println(myMovie.isDirecterBy(director))
  println(myMovie2.isDirecterBy(director))

}

