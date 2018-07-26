name := "api.spluxx.com"

version := "0.1"

scalaVersion := "2.12.6"

val circeVersion = "0.9.3"

libraryDependencies ++=
  List(
    "org.sangria-graphql" %% "sangria" % "1.4.1",
    "org.sangria-graphql" %% "sangria-circe" % "1.2.1",
    "com.typesafe.akka" %% "akka-http"   % "10.1.3",
    "com.typesafe.akka" %% "akka-stream" % "2.5.12",
    "ch.megard" %% "akka-http-cors" % "0.3.0",
    "io.monix" %% "monix" % "3.0.0-RC1",
    "org.scalaj" %% "scalaj-http" % "2.4.0",
    "com.jsuereth" %% "scala-arm" % "2.0",
    "org.sangria-graphql" %% "sangria-circe" % "1.2.1",
    "de.heikoseeberger" %% "akka-http-circe" % "1.21.0",
    "com.typesafe" % "config" % "1.3.2"
) ::: List(
    "io.circe" %% "circe-core",
    "io.circe" %% "circe-generic",
    "io.circe" %% "circe-parser"
  ).map(_ % circeVersion)

mainClass in Compile := Some("Server")
version in Docker := "latest"
packageName in Docker := "spluxxcom_api"

dockerBaseImage       := "openjdk:jre-alpine"

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
enablePlugins(AshScriptPlugin)
