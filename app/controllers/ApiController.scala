package controllers

import javax.inject.Inject
import play.api.mvc.{AnyContent, BaseController, ControllerComponents, _}

class ApiController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def apiCall: Action[AnyContent] = Action { implicit request =>
    Ok("hello world")
  }

}
