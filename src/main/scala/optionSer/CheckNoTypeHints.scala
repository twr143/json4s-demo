package optionSer

import org.json4s.native.Serialization
import org.json4s.{Formats, NoTypeHints}
import org.json4s.native.Serialization.write
import org.json4s.jackson.JsonMethods.parse

object CheckNoTypeHints {

  def main(args: Array[String]): Unit =
  {
    implicit val formats: Formats = Serialization.formats(NoTypeHints)
    val ser = write(Cat(Some("Murr"), Some(5)))
    println(ser)

    val jValue = parse(ser)
    val animal = jValue.extract[Animal]
    println(animal)


  }
}
