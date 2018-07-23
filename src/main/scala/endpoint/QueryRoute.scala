package endpoint

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import io.circe.Json
import repository.Resolvers.Resolvers
import sangria.execution._
import sangria.marshalling.circe._
import sangria.parser.QueryParser
import sangria.schema.Schema

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Try

import endpoint.QueryExceptionHandler.queryExceptionHandler

object QueryRoute {
  def queryRoute(schema: Schema[Resolvers, Unit], queryResolver: Resolvers)(implicit ec: ExecutionContext): Route = {
    handleExceptions(queryExceptionHandler) {
      (post & path("graphql")) {
        entity(as[Json]) { query =>
          queryResult(query, schema, queryResolver)
        }
      } ~ {
        getFromResource("graphiql.html")
      }
    }
  }

  def queryResult(request: Json, schema: Schema[Resolvers, Unit], resolvers: Resolvers)(
    implicit ec: ExecutionContext
  ): Route = { ctx =>
    def formatQuery(s: String): String = s.replaceAllLiterally("\\n","").replaceAllLiterally("\"", "")
    for {
      queryJson <- Future.fromTry(Try(request.findAllByKey("query").head))
      queryAst  <- Future.fromTry(QueryParser.parse(formatQuery(queryJson.noSpaces)))
      variables =  request.findAllByKey("variables").find(_.isObject).getOrElse(Json.obj())
      opName    =  request.findAllByKey("operationName").headOption.flatMap(_.asString)
      result    <- Executor.execute(schema, queryAst, resolvers, operationName = opName, variables = variables)
      response  <- ctx.complete(StatusCodes.OK -> result)
    } yield response
  }

}