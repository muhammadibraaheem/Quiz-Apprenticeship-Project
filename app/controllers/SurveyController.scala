package controllers

import javax.inject.Inject
import play.api.mvc.{AnyContent, BaseController, ControllerComponents, Request}

class SurveyController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

    def survey() = Action { implicit request: Request[AnyContent] =>
      Ok(views.html.survey())
    }

}
