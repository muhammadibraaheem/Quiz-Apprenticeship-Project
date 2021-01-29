package controllers

import javax.inject.Inject
import play.api.mvc.{AnyContent, BaseController, ControllerComponents, _}
import play.api.libs.json._

class ApiController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def getApiCall: Action[AnyContent] = Action { implicit request =>
    val json: JsValue = Json.parse("""{"hello":"get"}""")
    Ok(json)
  }

  def postApiCall: Action[AnyContent] = Action { implicit request =>
    val json: JsValue = Json.parse("""{"hello":"post"}""")
    Ok(json)
  }
}
