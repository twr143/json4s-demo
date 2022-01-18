package optionSer

import org.json4s.native.Serialization
import org.json4s.{DefaultFormats, Formats, FullTypeHints, ShortTypeHints}
import org.json4s.native.Serialization.write
import org.json4s.jackson.JsonMethods.parse
import org.json4s._
object CheckWTypeHints {

  def main(args: Array[String]): Unit =
  {
    val hints = ShortTypeHints(List(classOf[Cat]))
    implicit val formats: Formats = Serialization.formats(hints)
    val ser = write(Cat(Some("Murr"), Some(5)))
    println(ser)

    val jValue = parse(ser)
    val animal = jValue.extract[Animal]
    println(animal)


  }
}
