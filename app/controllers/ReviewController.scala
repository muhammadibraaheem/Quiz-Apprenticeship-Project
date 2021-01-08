package controllers

import javax.inject.Inject
import play.api.mvc.{AnyContent, BaseController, ControllerComponents, Request}

class ReviewController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def review() = Action { implicit request: Request[AnyContent] =>
    val tbox = request.getQueryString("tbox").get
    val cbox = request.getQueryString("cbox").getOrElse("")
    val rbox = request.getQueryString("rbox").getOrElse("")
    val tarea = request.getQueryString("tarea").get

    Ok(views.html.review(tbox, cbox, rbox, tarea))
  }

}
