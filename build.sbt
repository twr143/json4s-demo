import Dependencies._

ThisBuild / scalaVersion     := "2.13.6"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.iv"
ThisBuild / organizationName := "orgname"
ThisBuild / useCoursier := false

val json4sVersion = "4.0.1"
val libs = Seq("org.json4s" %% "json4s-native" % json4sVersion,
  "org.json4s" %% "json4s-jackson" % json4sVersion)
lazy val root = (project in file("."))
  .settings(
    name := "json4s-demo",
    libraryDependencies ++= libs ++ Seq(scalaTest % Test),
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
