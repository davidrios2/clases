package co.s4n.clases

import scala.::
import scala.annotation.tailrec

object UsingOption extends App {
  //lista de prueba
  val numbers = List(1,2,3,4,5,6)
  //suma la lista usando fold
  val a =  numbers.fold(0) { (z, i) =>
  {
    println("fold val1 " + z +" val2 " + i)
    z + i
  }
  }
  println(a)
  //lista de strings
  val nombre = List("s","a","n","t","i")
  //concatena la lista de srtings con el fold
  val d =  nombre.fold("") { (z, i) =>
  {
    println("fold val1 " + z +" val2 " + i)
    z + i
  }
  }
  println(a)
  //Diferencia entre fold y fold left
  /*
  val listad = nombre.fold(Nil:List[String]){
    (z, i) =>
    {
      println("fold val1 " + z +" val2 " + i)
      z :+ i
    }
  }
  */
  //funcion copy de una lista de Strings con foldLeft
  val copiarlista = nombre.foldLeft(Nil:List[String]){
    (z, i) =>
    {
      println("fold val1 " + z +" val2 " + i)
      z :+ i
    }
  }
  val b =  numbers.foldLeft(0) { (z, i) =>
    println("foldleft val1 " + z +" val2 " + i)
    z + i
  }
  println(b)
  val c =  numbers.foldRight(0) { (z, i) =>
    println("fold right val1 " + z +" val2 " + i)
    z + i
  }
  println(c)
}