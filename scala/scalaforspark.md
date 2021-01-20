# Scala for spark

```
val i = 2
var i = 2
val s = "Hello World"
s.toUpperCase
for (i <- (1 to 100)) {
  println(i)
}
var total = 0
for (element <- (1 to 100))
  total += element
for (element <- (1 to 100))
  if(element % 2 ==0)
    total += element
while(lb <= ub) {

def sum(lb: Int, up:Int): Int = {
  var total = 0
  for(element <- lb to up){
    total += element
  }
  total
} 
sum(1,10)

def sum(func: Int => Int, lb:Int, ub:Int)= {
  var total = 0
  for(element <- lb to ub)
  {
    total += func(element)
  }
  total
}
def sqr(i: Int)= i * i
--Anonymous function
sum(i => i, 1, 10) 

class Order(orderId:Int, orderDate: String, orderCustomerId: Int, orderStatus:String){
      println("I am inside Order Constructor")
      override def toString = "Order(" + orderId + "," + orderDate + "," + orderCustomerId + "," + orderStatus + ")"
}  

--Use the javap command to disassemble a .class file to look at its signature.  
:javap -p className

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello World")
  }
}  

--Companion Objects: A companion object is an object with the same name as a class and is defined in the same source file as the associated file.

object Order{
    def apply(orderId:Int, orderDate: String, orderCustomerId: Int, orderStatus:String) : Order = {
       new Order(orderId, orderDate, orderCustomerId, orderStatus)
    }
    def apply(orderId:String, orderDate: String, orderCustomerId: String, orderStatus:String) : Order = {
       new Order(orderId.toInt, orderDate, orderCustomerId.toInt, orderStatus)
    }
}
val order = Order.apply(1,"2013-10-01 00:00", 100, "COMPLETE")
val order = Order.apply("1","2013-10-01 00:00", "100", "COMPLETE")

--Case classes can be pattern matched
--Case classes automatically define hashcode and equals
--Case classes automatically define getter methods for the constructor arguments(if we use var in the argument).

case class Order(orderId:Int, orderDate: String, orderCustomerId: Int, orderStatus:String){
      println("I am inside Order Constructor")
      override def toString = "Order(" + orderId + "," + orderDate + "," + oerCustomerId + "," + orderStatus + ")"
}
case class Order(orderId:Int, orderDate: String, orderCustomerId: Int, orderStatus:String){
      println("I am inside Order Constructor")
}
case class Order(var orderId:Int, var orderDate: String,var orderCustomerId: Int,var orderStatus:String){
      println("I am inside Order Constructor")
}

--Seq, Set and Map
val a = Array(1,2,3,4)
val l = List(1,2,3,4)
val s = Set(1,1,2,2,3,4)
val m = Map("Hello" -> 1 , "World" -> 2)
val l = (1 to 100).toList
val f = l.filter(ele => ele % 2 == 0)
val m = f.map(rec => rec * rec)

import sys.process._
val ordersPath = "/data/retail_db/orders/part-00000"
val orders = Source.fromFile(ordersPath).getLines

orders.map(order => order.split(",")(3)).toSet.toList.sorted.foreach(println)

```
