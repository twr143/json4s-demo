import Dependencies._

ThisBuild / scalaVersion     := "2.12.12"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.iv"
ThisBuild / organizationName := "orgname"
ThisBuild / useCoursier := false

val json4s = "3.5.3"
val libs = Seq(  "org.json4s" %% "json4s-core"        % json4s,
  "org.json4s" %% "json4s-jackson"     % json4s,
  "org.json4s" %% "json4s-native"      % json4s,
)
lazy val root = (project in file("."))
  .settings(
    name := "json4s-demo",
    libraryDependencies ++= libs,
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
