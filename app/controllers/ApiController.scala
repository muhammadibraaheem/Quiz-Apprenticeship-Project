package controllers

import javax.inject.Inject
import play.api.mvc.{AnyContent, BaseController, ControllerComponents, _}
import play.api.libs.json._

class ApiController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  val paramColour = "colour"
  val paramShade = "shade"

  def getApiCall(colour: String, shade: Option[String]): Action[AnyContent] = Action { implicit request =>
    val json: JsValue = Json.parse(s"""{"hello":"get", "$paramColour": "$colour", "$paramShade": "${shade.getOrElse("")}"}""")
    Ok(json)
  }

  def postApiCall: Action[AnyContent] = Action { implicit request =>
    val jsonBody = request.body.asJson
    val colourValue = jsonBody.map{json => (json \ s"$paramColour").as[String]}.getOrElse("")
    val shadeValue = jsonBody.map{json => (json \ s"$paramShade").asOpt[String].getOrElse("")}.getOrElse("")
    val json: JsValue = Json.parse(s"""{"hello":"post", "$paramColour":"$colourValue", "$paramShade":"$shadeValue"}""")
    Ok(json)
  }

  def putApiCall: Action[AnyContent] = Action { implicit request =>
    val json: JsValue = Json.parse("""{"hello":"put"}""")
    Ok(json)
  }

  def deleteApiCall: Action[AnyContent] = Action { implicit request =>
    val json: JsValue = Json.parse("""{"hello":"delete"}""")
    Ok(json)
  }
}
