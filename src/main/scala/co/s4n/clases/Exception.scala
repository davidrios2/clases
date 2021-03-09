package co.s4n.clases

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

  def myKthElem[A](k:Int,lst:List[A]) = (for {
    xi <- lst
  }yield ((t:(Int, Option[A])) => (t._2) match {
    case None => if (t._1 == k) (t._1,Some(xi)) else (t._1+1,None)
    case Some(x) => (t._1, Some(x))})).foldLeft((0,None:Option[A]))((e,f) => f(e))._2.getOrElse(-1)

}
