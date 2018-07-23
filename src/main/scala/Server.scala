import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.http.scaladsl.Http.ServerBinding
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import endpoint.QueryRoute._
import repository.Resolvers.Resolvers
import persistence.Fetch
import repository.schema.QueryTypes

import scala.concurrent.{ExecutionContext, Future}
import scala.io.StdIn
import scala.util.{Failure, Success}

object Server extends App {
  implicit val system: ActorSystem = ActorSystem("spluxx-com")
  implicit val mat: ActorMaterializer = ActorMaterializer()
  implicit val ec: ExecutionContext = system.dispatcher
  val log = Logging(system.eventStream, "spluxx-com")

  val PORT = 8080
  val HOST = "localhost"

  for {
    data <- Fetch.pokemonData
  } {
    val schema = QueryTypes.schema
    val queryResolver = new Resolvers(data)
    val route: Route = queryRoute(schema, queryResolver)
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
