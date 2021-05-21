package connectors

import javax.inject.Inject
import play.api.libs.json.Json
import play.api.libs.ws.{WSClient, WSResponse}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class ApiConnector  @Inject() (ws: WSClient) {

  def callGetApi()= {
    val url = "http://localhost:9000/apicall/red"
    ws.url(url).get().map { response =>
      (response.json \ "colour").as[String]
    }

  }

  def callPostApi(colour: String, shade: String)= {
    val url = "http://localhost:9000/apicall"
    val data = Json.obj(
      "colour" -> s"$colour",
      "shade" -> s"$shade"
    )
    ws.url(url).post(data).map { response =>
      (response.json \ "colour").as[String]
    }
    println(colour)
  }
}
