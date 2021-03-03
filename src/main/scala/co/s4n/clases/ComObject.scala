package co.s4n.clases

class Counter(val init: Int, val step:Int){

  //inmutable objects a spacial method called copy that calls new
  def copy(init:Int = this.init, step:Int = this.step) = new Counter(init, step)

  // normal way def doStep(): Counter = new Counter(init + step, step)
  //we use copy to copy the initial value
  def doStep():Counter = copy(init + step)

  //def doStep(step:Int):Counter = new Counter(init + step, step)
  def doStep(step:Int):Counter = copy (init + step, step)

  override def toString():String =s"Value: $init, step: $step"

}
//companion object has the same name of the class
object Counter {
  def apply(init:Int, step:Int) = new Counter(init,step)
  //when it calls Counter calls the object not the class
  def main(args:Array[String]):Unit = {
    val c:Counter = Counter(1,1)
    val c2:Counter = Counter(2,2)
    println(c.doStep(1).doStep(2).doStep(3))
    println(c2.doStep(1).doStep(2).doStep(3))
  }
}