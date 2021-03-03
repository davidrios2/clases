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
}
class Pelicula (val nombre: String, val presentacion:Int, val rangoIMBD: Double, val director: Director){

  def copy(nombre: String = this.nombre, presentacion:Int = this.presentacion, rangoIMBD: Double = this.rangoIMBD, director: Director = this.director)
    = new Pelicula(nombre, presentacion, rangoIMBD, director)

  def directorOld = copy().presentacion - copy().director.nacimiento

  def isDirecterBy(director: Director) = copy().director == director

}

object Director {

  def apply (nombre: String, apellido: String, nacimiento: Int) = new Director(nombre,apellido,nacimiento)

  def oldest (director: Director, director2:Director):Director= if (director.copy().nacimiento > director2.copy().nacimiento) director else director2
}

 object  Pelicula {
   def apply (nombre: String,presentacion:Int,rangoIMBD: Double, director: Director) = new Pelicula(nombre, presentacion, rangoIMBD, director)
   def bestIMDB(pelicula: Pelicula, pelicula2: Pelicula):Pelicula = if (pelicula.rangoIMBD > pelicula2.rangoIMBD) pelicula else pelicula2
   def oldesDireTime(pelicula: Pelicula, pelicula2: Pelicula):Director = {
     if (pelicula.copy().directorOld > pelicula2.copy().directorOld) pelicula.copy().director else pelicula2.copy().director
   }
 }

