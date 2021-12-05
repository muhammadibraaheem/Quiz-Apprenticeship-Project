package controllers

import connectors.ApiConnector
import javax.inject.Inject
import play.api.mvc.{AnyContent, BaseController, ControllerComponents, Request}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

class WebController @Inject() (apiConnector: ApiConnector, val controllerComponents: ControllerComponents) extends BaseController {

  def displayPage() = Action { implicit request: Request[AnyContent] =>
    val colour = apiConnector.callGetApi().onComplete {
     case Success(x) => x
     case Failure(e) => e.toString
    }

    println(colour)

    Ok(views.html.web_page("username"))

  }

  def submitPage() = Action { implicit request: Request[AnyContent] =>
    val colour = request.getQueryString("username").get
    val shade = request.getQueryString("password").getOrElse("")
    apiConnector.callPostApi(colour, shade)
    Ok(views.html.web_page("username"))
  }


}
