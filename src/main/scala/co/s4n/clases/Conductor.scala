package co.s4n.clases

class Conductor (val nombre:String, val apellido:String, val totalCarreras:Int, val carrerasTerminadas:Int) {
  def carrerasNoTerminadas = totalCarreras - carrerasTerminadas
  //val conductor = new Conductor ("Alex", "Montoya", 15, 5)
}
class Escuderia (val nombre:String, val consuctor:Conductor)
