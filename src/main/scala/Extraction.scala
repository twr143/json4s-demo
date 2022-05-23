import bins.CardBin
import org.json4s.{FileInput, Formats, JValue, JsonInput, NoTypeHints, ReaderInput, StreamInput, StringInput}
import org.json4s.jackson.JsonMethods.parse
import org.json4s.native.Serialization
import org.json4s._

object Extraction {


  val body = "[{\"tran_date\":\"2021-08-31T21:00:07+06:00\", \"incomfl\":1, \"srcamount\":35350, \"srccurrency\":\"KZT\", \"dstamount\":35350, \"dstcurrency\":\"KZT\", \"srciban\":\"KZ389650100007000099\", \"dstiban\":\"KZ0796501F0007094642\", \"txt_dscr\":\"Исполнение сделки по ForteForex\", \"mibcode\": 0.00},{\"tran_date\":\"2021-08-31T21:00:07+06:00\", \"incomfl\":1, \"srcamount\":315, \"srccurrency\":\"KZT\", \"dstamount\":315, \"dstcurrency\":\"KZT\", \"srciban\":\"KZ4996501F0007094856\", \"dstiban\":\"KZ389650100007000099\", \"txt_dscr\":\"Исполнение сделки по ForteForex\", \"mibcode\": 0.00},{\"tran_date\":\"2021-08-31T21:00:07+06:00\", \"incomfl\":1, \"srcamount\":70, \"srccurrency\":\"EUR\", \"dstamount\":70, \"dstcurrency\":\"EUR\", \"srciban\":\"KZ749650000022152602\", \"dstiban\":\"KZ229650100007000096\", \"txt_dscr\":\"Исполнение сделки по ForteForex\", \"mibcode\": 0.00},{\"tran_date\":\"2021-08-31T21:00:07+06:00\", \"incomfl\":1, \"srcamount\":70, \"srccurrency\":\"EUR\", \"dstamount\":70, \"dstcurrency\":\"EUR\", \"srciban\":\"KZ7696502F0013585560\", \"dstiban\":\"KZ659650000001351211\", \"txt_dscr\":\"Исполнение сделки по ForteForex\", \"mibcode\": 0.00}]"
  val ser ="""
|{"bin":486169,"ps":"VISA","issuer":"Wings Financial Credit Union","issuercountry":840,"isfrt":"0","bik":null}
|""".stripMargin

  def main(args: Array[String]): Unit =
  {
    implicit val formats: Formats = Serialization.formats(NoTypeHints)

//    val jValue = parse(body)
//    val transactionDetails = jValue.extract[Seq[GetTransactionDetailsResponse]]
//    println(transactionDetails.head)

        val jValue = parse(ser)
        val bin = jValue.extract[CardBin]
        println(bin)

  }

}
