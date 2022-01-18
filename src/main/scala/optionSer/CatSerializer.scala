package optionSer

import org.json4s.CustomSerializer
import org.json4s.JsonAST._
import org.json4s.JsonDSL._
import org.json4s._

case object CatSerializer extends CustomSerializer[Cat](formats => (
  {
    case jsonObj: JObject =>
      implicit val fmt = org.json4s.DefaultFormats
        val name = (jsonObj \ "name").extract[String]
        val age = (jsonObj \ "age").extract[Int]

        Cat(Some(name), Some(age))
  },
  {
    case c: Cat =>
      ("name" -> c.name.getOrElse("")) ~
        ("age" -> c.age.getOrElse(0))
  }
))