package clases

import co.s4n.clases.Execption.{compress2, myLast4}
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
    subs(listString)
  }

  "The last" should "be 2" in {
    val list = List(1,3,5,6,2)
    myLast(list)
  }

  "The myLast4" should "be 2" in {
    val list = List(2,2,2,2,2)
    myLast4(list) shouldEqual List(2)
  }
  "The compress2" should "be 2" in {
    val list = List(2,2,1,3,5)
    compress2(list) shouldEqual List(2,1,3,5)
  }



}
