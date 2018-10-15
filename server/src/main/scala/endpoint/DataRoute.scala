package endpoint

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.directives.ContentTypeResolver.Default

import scala.concurrent.ExecutionContext

object DataRoute {
  def dataRoute(implicit ec: ExecutionContext): Route = {
    get {
      path("images" / Segment) { imageFile =>
        getFromResource(s"data/image_fetcher/images/$imageFile")
      } ~ path("cries" / Segment) { soundFile =>
        getFromResource(s"data/cries/$soundFile")
      }
    }
  }
}
