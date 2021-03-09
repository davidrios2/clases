package clases

import co.s4n.clases.Execption.{compress2, media, myHead, myKthElem, myLast4, prime}
import co.s4n.clases.Persona
import co.s4n.clases.test._
//import co.s4n.clases.test.subs
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class PeronaSpec extends AnyFlatSpec with Matchers {

  "The name" should "be Pepito" in {
    val persona1 = Persona("Pepito Pérez")
    persona1.nombre shouldEqual "Pepito"
  }

  "The list" should "be List(List(), List(Ruby), List(cactus), List(Café), List(Ruby, cactus), List(Ruby, Café), List(cactus, Café), List(Ruby, cactus, Café))" in {
    val listString= List("Ruby","cactus","Café")
    val result =List(List(), List("Ruby"), List("cactus"), List("Café"), List("Ruby", "cactus"), List("Ruby", "Café"), List("cactus", "Café"), List("Ruby", "cactus", "Café"))
    subs(listString) shouldEqual result
  }

  "The last" should "be 2" in {
    val list = List(1,3,5,6,2)
    myLast(list) shouldEqual 2
  }

  "the media" should "be 3" in {
    val list = List(2.0,3.0,5.0,2.0)
    media(list).getOrElse(0) shouldEqual 3
  }

  "the number 101" should "be prime (true)" in {
    prime(101) shouldEqual (true)
  }

  "The myLast4" should "be 2" in {
    val list = List(2,2,2,2,2)
    myLast4(list) shouldEqual List(2)
  }

  //check compress with for comprehension
  "The compress2" should "be 2" in {
    val list = List(2,2,1,3,5)
    compress2(list) shouldEqual List(2,1,3,5)
  }

  "The head" should "be 1" in {
    val list = List(1,3,5,6,2)
    myHead(list) shouldEqual 1
  }

  "The kth element" should "be 2" in {
    val list = List(2,1,2,3,5,4)
    myKthElem(5,list) shouldEqual 4
  }


}
