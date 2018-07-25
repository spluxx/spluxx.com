package endpoint

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.directives.ContentTypeResolver.Default

import scala.concurrent.ExecutionContext

object DataRoute {
  def dataRoute(implicit ec: ExecutionContext): Route = {
    get {
      path("images" / IntNumber) { pokenum =>
        getFromResource(s"data/image_fetcher/images/$pokenum.png")
      } ~ path("cries" / IntNumber) { pokenum =>
        getFromResource(s"data/cries/$pokenum.mp3")
      }
    }
  }
}
