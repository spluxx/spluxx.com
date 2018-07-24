package endpoint

import akka.http.scaladsl.server.ExceptionHandler
import akka.http.scaladsl.model.StatusCodes._
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import sangria.marshalling.circe._
import sangria.execution.{ErrorWithResolver, QueryAnalysisError}
import sangria.parser.{SyntaxError => QuerySyntaxError}

object QueryExceptionHandler {
  val queryExceptionHandler = ExceptionHandler {
    case error: QueryAnalysisError => _.complete(BadRequest -> error.resolveError)
    case error: ErrorWithResolver => _.complete(InternalServerError -> error.resolveError)
    case error: QuerySyntaxError => _.complete(BadRequest -> error.getMessage)
  }
}

