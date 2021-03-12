package controllers

import javax.inject.Inject
import play.api.mvc.{AnyContent, BaseController, ControllerComponents, _}
import play.api.libs.json._

class ApiController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def getApiCall(colour: String, shade: Option[String]): Action[AnyContent] = Action { implicit request =>
    val shadeValue = shade.getOrElse("")
    val json: JsValue = Json.parse(s"""{"hello":"get", "colour": "$colour", "shade": "$shadeValue"}""")
    Ok(json)
  }

  def postApiCall: Action[AnyContent] = Action { implicit request =>
    val paramName = "colour"
    val paramValue = request.body.asJson.map{json => (json \ s"$paramName").as[String]}.getOrElse("")
    val json: JsValue = Json.parse(s"""{"hello":"post", "$paramName":"$paramValue"}""")
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
