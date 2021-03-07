package co.s4n.clases

object test extends App{

  //def subs[A](lst:List[A]):List[List[A]] = lst.toSet[A].subsets().map(_.toList).toList

 def subs[A](lst: List[A]): List[List[A]] = {
    val list = lst match {
      case Nil => List(Nil)
      case head :: tail => subs(tail).map(head :: _) ::: subs(tail)
    }
   list.sortBy(_.length)
  }

  /*def permutaciones[A](lst:List[A]):List[List[A]] = lst match {
    case Nil => List(Nil)
    case List(value) => List(List(value))
    case _=>
  }*/

  def predAtPos[A](lst:List[A], preds:List[(Int, (A)=>Boolean)]) : List[List[Boolean]] = ???

  //*--study this--*
  def myLast[A](lst:List[A]):A = lst match {
    case head :: Nil => head
    case _ :: tail => myLast(tail)
  }

  def myButLast[A](lst: List[A]): A = lst match {
    case head :: tail :: Nil =>  head
    case head :: tail => myButLast(tail)
  }

  def myLast2[A](lst:List[A]):List[A] = lst match {
    case head :: tail :: Nil => List(head,tail)
    case _ :: tail => myLast2(tail)
  }

  def elementAt[A](lst:List[A], n:Int): A = (lst, n) match{
    case (head :: Nil, n) => head
    case (head :: tail, n) => elementAt(tail, n-1)
  }

  def myLength[A](lst:List[A]):Int = lst match {
    case _:: Nil => 1
    case _:: tail => 1 + myLength(tail)
  }

  /*
  //valor acumulador , despues elemento
  def lenghRight(lst: List[A]): Int = lst.foldLeft(0) { (_, tail) => tail + 1 }
  //valor acumulador , despues elemento
  def lenghtLeft(lst: List[A]): Int = lst.foldLeft(0) { (count, _) => count + 1 }
 */

  //Programación no funcional

 /*def myReverse[A](lst:List[A]):List[A] = {
   def myReverserRec(lst:List[A], count:Int):List[A] = count match {
     case -1 => Nil
     case n => lst(n) :: myReverserRec(lst,n-1)
   }
   myReverserRec(lst,lst.length-1)
 }*/

  //functional programming NO index --> TABLA

  def myReverse[A](lst: List[A]): List[A] = lst match {
    case head :: tail => myReverse(tail) ::: List(head)
    case Nil => Nil
  }

  def isPalindrome[A](lst:List[A]): Boolean = lst == myReverse(lst)

  def isPalindrome2[A](lst:List[A]): Boolean = lst match {
    case Nil => true
    case head :: Nil => true
    case head :: tail => (head == tail.last && isPalindrome(tail.init))
  }

  sealed trait NestedList [+A]
  case class Elem[A](elem:A) extends NestedList[A]
  case class Nested[A](lst: List[NestedList[A]]) extends NestedList[A]

  val lst = Nested(List(Elem(1),Nested(List(Elem(2),Nested(List(Elem(3),Elem(4))),Elem(5)))))
 //Función de alquimia
  def myFlatten[A] (lst: NestedList[A]): List[A] = lst match {
    //Convers an elem to a list
    case Elem(value) => List(value)
    case Nested(list) => list.flatMap(myFlatten)
  }

  def myCompress[A](lst: List[A]): List[A] = lst match {
    case Nil => Nil
    case head :: tail => head :: myCompress(tail.dropWhile(_ == head))
  }

  def myPack[A](lst:List[A]): List[List[A]] = lst match {
    case Nil => List(List())
    case head :: tail => ???
  }

}
