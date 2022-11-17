package optionSer
import org.json4s._
import org.json4s.native.Serialization
import org.json4s.jackson.JsonMethods.parse

object DeserializeEmptyObject {


    def main(args: Array[String]): Unit =
    {
//      val hints = ShortTypeHints(List(classOf[Cat]))
      implicit val formats: Formats = Serialization.formats(NoTypeHints)

      val jValue = parse("""{"name":"Murr"}""")
      val animal = jValue.extract[Cat]
      println(animal)
      val jValue2 = parse("""{}""")
      val animal2 = jValue2.extract[Cat]
      println(animal2)

      val o = Some(5)
      o.contains(1)
    }

}
