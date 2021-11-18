
import org.json4s._
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{read, write}

object Entry01 {
  val hints = ShortTypeHints(List(classOf[Person]))
  implicit val formats: Formats = Serialization.formats(hints)
  sealed trait DomainObject
  case class Child(name: String, age: Int, birthdate: Option[java.util.Date]) extends DomainObject
  case class Address(street: String, city: String) extends DomainObject
  case class Person(name: String, address: Address, children: List[Child]) extends DomainObject
  def main(args: Array[String]): Unit =
  {
    val ser = write(Child("Mary", 5, None))
    println(ser)
    val ser2 = write(Person("Person", null, null))
    println(ser2)
  }
}
