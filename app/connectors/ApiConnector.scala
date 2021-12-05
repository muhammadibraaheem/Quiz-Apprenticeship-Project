package connectors

import javax.inject.Inject
import play.api.libs.json.Json
import play.api.libs.ws.{WSClient, WSResponse}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class ApiConnector  @Inject() (ws: WSClient) {

  // no idea
}
