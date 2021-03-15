package co.s4n.clases
import scala.::
import scala.annotation.tailrec
/*Exceptions produce side effects so functional paradigm
so we have Options, either and try to manage exceptions
Option not always has answers so it's type is None or Some
Some encapsulates the value in a "box" so we can use them later
map converts a A => B so it's our best friend
getOrElse is used to take the values of the "box"*/

object Execption {


  def media(lst:List[Double]): Option[Double] = {
    if (lst.isEmpty) None
    else Some(lst.sum / lst.length)
  }

  /*Listas por comprensión
  un generador que saca el valor( <- ) de una lista
  una guarda (cualificadior): una expresión (if ...) para ver que elemtos quiera filtrar
  definiciones locales: un valor x que puede tener una expresión
      for {
        e <- lst
        if (e % 2 == 0)
      }yield e*/

  def mapa[A,B](lst:List[A])( f: (A) => B): List[B] = {
    for {
      x <- lst
    }yield (f(x))
  }

  def filter[A](lst:List[A])(p: (A) => Boolean): List[A] = for {
    x <- lst
    if p(x)
  }yield x

  def divideA(d:Int, n:Int): Boolean = n % d == 0

  def divisoresDe(n:Int): List[Int] = for {
    x <- List.range(1, n + 1)
    if divideA(x, n)
  } yield (x)

  def prime(n: Int): Boolean = divisoresDe(n) == List(1,n)

  //:( no
  def myLast4[A](lst: List[A]): List[A] = for {
    x <- (List.range(1,lst.length))
    y = lst(x)
    if (x == lst.length-1)
  } yield y

  /*def myLast5[A](lst: List[A]):A = (for = {
    x <- lst
    i <- lst
  }yield ((a:A) => x)).foldLeft(lst.head)((e,f) => f(e))*/

  def myLength [A](lst:List[A]):Int = (for {
    _ <- lst
  }yield ((a: Int) => a+1)).foldLeft(0)((e,f) => f(e))

  def myButLast2[A](lst: List[A]): List[A] = for {
    x <- (List.range(1,lst.length))
    y = lst(x)
    if (x == lst.length-2)
  } yield y

  def myKth[A](elem: Int, lst: List[A]): List[A] = for {
    x <- (List.range(1,lst.length))
    y = lst(x)
    if (x == (elem-1))
  } yield y

  def Both[A](lst: List[A]): List[A] = for {
    x <- lst.drop(lst.length-2)
  } yield x

  def elementAt[A](elem: Int, lst: List[A]): List[A] = for {
    x <- (List.range(1,lst.length).reverse)
    y = lst(x)
    if (x == (lst.length - elem))
  } yield y

  def compress2[A](lst:List[A]):List[A] = for {
    x <- lst
    y <- lst.tail
    if (x != y)
  } yield x

  def myHead[A](lst:List[A]) = (for {
    xi <- lst
  }yield ((a:A) => xi)).foldRight(lst.head)((f,e) => f(e))
  /*función generadora de funciones*/

  def myKthElem[A](k:Int,lst:List[A]) = (
    for {
      xi <- lst
    }yield ((touple:(Int, Option[A])) => (touple._2) match {
      case None => if (touple._1 == k) (touple._1,Some(xi)) else (touple._1+1,None)
      case Some(x) => (touple._1, Some(x))})).foldLeft((0,None:Option[A]))((e,f) => f(e))._2.getOrElse(-1)

  //Repaso funciones anonimas --> proceso dentro de otras funciones
  val func= (x:Int) => x % 3  == 0
  val mayor3 = (x:Int, y:Int, z:Int) => if(x >= y && x >= z) x else if (y > z) y else z
  val par = (x:Integer) => if (x % 2 == 0) "es par" else "es impar"

  //funciones parciales --> no para todos los casos se definbe que hacer, se deja expresado y se puede volver total despues
  def derechoMuerteDigna(edad:Int): Boolean = edad match {
    case x if (x > 14) => true
    case x if( x < 12 && x > 8) => false
    case x if( x < 8) => ???
  }
  //no
  def dividir(dividiendo:Int, divisor:Int): Double = {
    dividiendo/divisor
  }

  //repaso tail recursion
  def factorial(n: Int): Int = {
    @tailrec
    def factorialAux(x:Int, result: Int): Int = {
      if (x == 1) result
      else factorialAux (x - 1, result * x)
    }
    factorialAux(n,1)
  }

  // higher-order functions
  def apply(f: (Int, Int) => Int, a:Int, b:Int) = f(a,b)

  def filtro(f:(Int,Int)=>Int,a:Int,b:Int) =f(a,b)
  filtro((a, b) => if (a > b) a else b, 10,2)

  def filtro2(f:(Int,Int)=>Int,a:Int,b:Int):Int = f(a,b)

  val biger = filtro2((a:Int, b:Int)=>{a >= b match {
    case true =>a
    case false => b
  }},2,10)

  //pattern matching
  /*Desconposición estructural*/

  def recorrerTuplas[A](lst: List[A]): List[_] = lst match {
    case Nil => Nil
    case list => list.head match {
      case (x:Int, y) => y :: recorrerTuplas(list.tail)
      case x => List(x) ::: recorrerTuplas(list.tail)
    }
  }

  /*currying --> separar parametros por funciones
  * No se necesita tener todos los parámetros
  * pero en caso de no tenerlos no retorna valor
  *
  * Se está recibiendo dos parámetros uno apara la funcion externa add
  * y otro pára la anónima
  * facilita la creación de funciones de alto orden y aplicaciones parciales
  * */
  def add(a:Int)= (b:Int) => a + b

  /*ADT's

  *Usar para emun
  *Son conjuntos
  * No está basado en la memoria del computador sino en nombnes
  *
  *Todo lo que hay adentro son val (INMUTABLES)
  * case objcet producto cartesiano
  * case class or operator
  *
  * Tipos de datos recursivos
  *
  *
  *
  * */
  /*Case datos inmutable, decirle al compilador que le genere
    los constructores y geters sin crearlos
    Los getters permiten cxrear factories de manera sencilla
   */
  sealed trait Temperaturte
  case object Cold extends Temperaturte
  case object Hot extends Temperaturte

  sealed trait Season
  case object Spring extends Season
  case object Summer extends Season
  case object Autumn extends Season
  case object Winter extends Season

  def tipoTemperatura(season:Season): Temp = season match{
    case Summer => Hot
    case _ => Cold
  }

  sealed trait Colors
  case object Red extends Colors
  case object Green extends Colors
  case object Blue extends Colors

  sealed trait Months
  case object Jan extends Months
  case object Feb extends Months
  case object March extends Months
  case object Apr extends Months
  case object May extends Months
  case object Jun extends Months
  case object Jul extends Months
  case object Aug extends Months
  case object Sep extends Months
  case object Oct extends Months
  case object Nov extends Months
  case object Dec extends Months

  sealed trait Shape
  case class Circle(radio:Float) extends Shape
  case class Rectangle(width:Float, height: Float) extends Shape
  case class Triangle (lado:Float) extends Shape


  /*Fold
    Es una función que analiza una estructura de datos
    particularmente lo hace pasando un caso base y una función extra.
    Se va llamando a la función interna de manera recursiva "creando" el valor a retornar
    Es una currificada y de alto orden
  */
  def makeInt(s: String): Option[Int] = {
    try {
      Some(s.trim.toInt)
    }catch {
      case e:Exception => None
    }
  }



}
