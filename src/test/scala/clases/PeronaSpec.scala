package clases

import co.s4n.clases.Persona
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PeronaSpec extends AnyFlatSpec with Matchers {
  "The name" should "be Pepito" in {
    val persona1 = Persona("Pepito Pérez")
    persona1.nombre shouldEqual "Pepito"
  }
}
