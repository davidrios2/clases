package co.s4n.contador

class Contador (val counter:Int){
  def incr(): Contador = new Contador(counter + 1)
  def decr(): Contador = new Contador(counter - 1)
  def incrVa(value:Int = 1) = new Contador(counter + value)
  def decrVa(value:Int = 1) = new Contador(counter - value)
  def ajuste(sumador: Sumador) = new Contador(sumador.adicionar(counter))
}
class Sumador(monto:Int){
  def adicionar(valor:Int) = valor + monto
}