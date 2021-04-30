package controllers

import connectors.ApiConnector
import javax.inject.Inject
import play.api.mvc.{AnyContent, BaseController, ControllerComponents, Request}

class WebController @Inject() (apiConnector: ApiConnector, val controllerComponents: ControllerComponents) extends BaseController {

  def displayPage() = Action { implicit request: Request[AnyContent] =>
    apiConnector.callGetApi()
    Ok(views.html.web_page("to do"))

  }

  def submitPage() = Action { implicit request: Request[AnyContent] =>
    val colour = request.getQueryString("colour").get
    val shade = request.getQueryString("shade").getOrElse("")
    apiConnector.callPostApi(colour, shade)
    Ok(views.html.web_page("to do"))
  }


}
