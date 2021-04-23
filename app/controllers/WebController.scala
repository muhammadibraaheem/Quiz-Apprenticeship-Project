package controllers


import javax.inject.Inject

import scala.concurrent.Future
import scala.concurrent.duration._
import play.api.mvc._
import play.api.libs.ws._
import play.api.http.HttpEntity
import akka.actor.ActorSystem
import akka.stream.scaladsl._
import akka.util.ByteString

import scala.concurrent.ExecutionContext
import javax.inject.Inject
import play.api.libs.json.{JsResult, Json}
import play.api.libs.ws
import play.api.mvc.{AnyContent, BaseController, ControllerComponents, Request}

import scala.concurrent.ExecutionContext.Implicits.global

class WebController @Inject() (ws: WSClient, val controllerComponents: ControllerComponents) extends BaseController {

  def displayPage() = Action { implicit request: Request[AnyContent] =>
    callApi()
    Ok(views.html.web_page("to do"))

  }

  def submitPage() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.web_page("to do"))
  }


  private def callApi()= {
    val url = "http://localhost:9000/apicall/red"
    ws.url(url).get().map { response =>
     (response.json \ "colour").as[String]

    }
    println(url)
  }



}
