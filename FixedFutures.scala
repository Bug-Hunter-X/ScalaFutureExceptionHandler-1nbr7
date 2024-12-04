```scala
import scala.concurrent.{ExecutionContext, Future}

class MyClass(implicit ec: ExecutionContext) {
  def myMethod(param: Int): Future[Int] = Future {
    // Simulate some asynchronous operation
    Thread.sleep(1000)
    param * 2
  }.recover { case e: Exception =>
    println(s"Error in myMethod: ", e)
    0 // Return a default value or throw a more informative exception
  }

  def anotherMethod(param: Int): Future[Int] = myMethod(param).map(_ + 1)
}

object Main extends App {
  implicit val ec = scala.concurrent.ExecutionContext.global
  val myClass = new MyClass()
  val result = myClass.anotherMethod(5)
  result.onComplete { result => println(result)}
  Thread.sleep(2000)
}
```