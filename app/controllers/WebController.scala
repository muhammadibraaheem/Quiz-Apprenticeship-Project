package controllers

import connectors.ApiConnector
import javax.inject.Inject
import play.api.mvc.{AnyContent, BaseController, ControllerComponents, Request}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

class WebController @Inject() (apiConnector: ApiConnector, val controllerComponents: ControllerComponents) extends BaseController {

  def displayPage() = Action { implicit request: Request[AnyContent] =>

    Ok(views.html.web_page("username"))

  }

  def submitPage() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.web_page("username"))
  }


}
