package optionSer

import org.json4s.native.Serialization
import org.json4s.{Formats, NoTypeHints}
import org.json4s.native.Serialization.write
import org.json4s.jackson.JsonMethods.parse
import org.json4s._
object CheckNoTypeHintsSerializer {

  def main(args: Array[String]): Unit = {
    implicit val formats: Formats = Serialization.formats(NoTypeHints)  + CatSerializer
    val ser = write(Cat(Some("Murr"), Some(5)))
    println(ser)

    val jValue = parse(ser)
    println("jValue= " + jValue)
    val animal = jValue.extract[Cat]//Animal wont work
    println(animal)

  }
}
