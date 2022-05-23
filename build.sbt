import Dependencies._

ThisBuild / scalaVersion     := "2.13.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.iv"
ThisBuild / organizationName := "orgname"
ThisBuild / useCoursier := false

val json4sVersion = "4.0.3"
val libs = Seq("org.json4s" % "json4s-native_2.13" % json4sVersion,
  "org.json4s" % "json4s-jackson_2.13" % json4sVersion)
lazy val root = (project in file("."))
  .settings(
    name := "json4s-demo",
    libraryDependencies ++= libs,
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
