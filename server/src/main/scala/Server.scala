import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.http.scaladsl.Http.ServerBinding
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import ch.megard.akka.http.cors.scaladsl.CorsDirectives._
import com.typesafe.config.ConfigFactory

import scala.concurrent.{ExecutionContext, Future}
import scala.io.StdIn
import scala.util.{Failure, Success}

import endpoint.QueryRoute._
import endpoint.DataRoute._
import repository.Resolvers.Resolvers
import persistence.Fetch
import repository.schema.QueryTypes

object Server extends App {
  implicit val system: ActorSystem = ActorSystem("spluxx-com")
  implicit val mat: ActorMaterializer = ActorMaterializer()
  implicit val ec: ExecutionContext = system.dispatcher
  val log = Logging(system.eventStream, "spluxx-com")

  for {
    data <- Fetch.pokemonData
  } {
    val env = sys.env.getOrElse("SPLUXX-COM-EXEC-ENV", "dev")
    val HOST = ConfigFactory.load().getString(s"server.${env}.host")
    val PORT = ConfigFactory.load().getInt(s"server.${env}.port")

    val schema = QueryTypes.schema
    val queryResolver = new Resolvers(data)
    val route: Route = cors() {
      pathPrefix("api") {
        dataRoute ~ queryRoute(schema, queryResolver)
      } ~
      get { ctx =>
        ctx.complete(ctx.request.toString)
      }
    }

    val binding: Future[ServerBinding] = Http().bindAndHandle(route, HOST, PORT)

    binding.onComplete {
      case Success(_) =>
        log.info(s"server bound to $HOST:$PORT")
      case Failure(error) =>
        log.error(error, "Failed to Bind server")
        system.terminate()
    }

    log.info("Press enter to stop server...")

    StdIn.readLine()
    binding.flatMap(_.unbind()).onComplete(_ => system.terminate())
  }
}
