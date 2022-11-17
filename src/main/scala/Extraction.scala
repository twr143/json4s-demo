import bins.CardBin
import org.json4s.JsonAST.JString
import org.json4s.{FileInput, Formats, JValue, JsonInput, NoTypeHints, ReaderInput, StreamInput, StringInput}
import org.json4s.jackson.JsonMethods.parse
import org.json4s.native.Serialization
import org.json4s._

object Extraction {


  val body = "[{\"tran_date\":\"2021-08-31T21:00:07+06:00\", \"incomfl\":1, \"srcamount\":35350, \"srccurrency\":\"KZT\", \"dstamount\":35350, \"dstcurrency\":\"KZT\", \"srciban\":\"KZ389650100007000099\", \"dstiban\":\"KZ0796501F0007094642\", \"txt_dscr\":\"Исполнение сделки по ForteForex\", \"mibcode\": 0.00},{\"tran_date\":\"2021-08-31T21:00:07+06:00\", \"incomfl\":1, \"srcamount\":315, \"srccurrency\":\"KZT\", \"dstamount\":315, \"dstcurrency\":\"KZT\", \"srciban\":\"KZ4996501F0007094856\", \"dstiban\":\"KZ389650100007000099\", \"txt_dscr\":\"Исполнение сделки по ForteForex\", \"mibcode\": 0.00},{\"tran_date\":\"2021-08-31T21:00:07+06:00\", \"incomfl\":1, \"srcamount\":70, \"srccurrency\":\"EUR\", \"dstamount\":70, \"dstcurrency\":\"EUR\", \"srciban\":\"KZ749650000022152602\", \"dstiban\":\"KZ229650100007000096\", \"txt_dscr\":\"Исполнение сделки по ForteForex\", \"mibcode\": 0.00},{\"tran_date\":\"2021-08-31T21:00:07+06:00\", \"incomfl\":1, \"srcamount\":70, \"srccurrency\":\"EUR\", \"dstamount\":70, \"dstcurrency\":\"EUR\", \"srciban\":\"KZ7696502F0013585560\", \"dstiban\":\"KZ659650000001351211\", \"txt_dscr\":\"Исполнение сделки по ForteForex\", \"mibcode\": 0.00}]"
  val ser ="""
|{"ps":"VISA","bin":486169,"issuer":"Wings Financial Credit Union","issuercountry":840,"isfrt":"0","bik":null}
|""".stripMargin


  val nested = "{\"data\": [        {            \"id\": 61427380,            \"name\": null,            \"avatar\": null,            \"phone\": \"77082282812\",            \"external_id\": null,            \"assigned_name\": \"Сергей Семенович\",            \"comment\": null,            \"client_phone\": null,            \"region_id\": null,            \"country_id\": 218,            \"client_external_id\": null,            \"external_ids\": {},            \"extra_comment_1\": null,            \"extra_comment_2\": null,            \"custom_fields\": {},            \"extra_comment_3\": null        }    ],    \"meta\": {        \"total\": 1,        \"limit\": 20,        \"offset\": 0    },    \"status\": \"success\"}"
  case class Client(id: Long)
  case class Meta(total: Int, limit: Int, offset:Int)
  case class Result(data: Seq[Client], meta: Meta, status: String)

  class MetaSerializer extends CustomSerializer[Meta](format => (
    {
      case JObject(
        JField("total", JInt(total))
        :: JField("limit", JInt(limit))
        :: JField("offset", JInt(offset))
        :: Nil
      ) => Meta(total.intValue, limit.intValue, offset.intValue)
    },
    {
      case _: Meta =>
        JObject(Nil)
    }
  ))

  class ClientSerializer extends CustomSerializer[Client](format => (
    {
      case JObject(
        JField("id", JInt(id))
        :: _
      ) => Client(id.intValue)
    },
    {
      case _: Client =>
        JObject(Nil)
    }
  ))

  def main(args: Array[String]): Unit =
  {
    implicit val formats: Formats = Serialization.formats(NoTypeHints) //+ new MetaSerializer + new ClientSerializer

//    val jValue = parse(body)
//    val transactionDetails = jValue.extract[Seq[GetTransactionDetailsResponse]]
//    println(transactionDetails.head)

//        val jValue = parse(ser)
//        val bin = jValue.extract[CardBin]
//        println(bin)

        val jValue = parse(nested)
        val result = jValue.extract[Result]
        println(result)

  }

}
