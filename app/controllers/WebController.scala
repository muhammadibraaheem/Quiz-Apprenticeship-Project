package controllers

import javax.inject.Inject
import play.api.mvc.{AnyContent, BaseController, ControllerComponents, Request}

class WebController @Inject() (val controllerComponents: ControllerComponents) extends BaseController {

  def displayPage() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.web_page())
  }

  def submitPage() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.web_page())
  }

}
