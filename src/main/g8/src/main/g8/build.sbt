// give the user a nice default project!

val scalatestVersion = "3.0.4"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "$organization$",
      scalaVersion := "2.11.8"
    )),
    name := "$name$",
    libraryDependencies ++= Seq (
      "org.scalatest" %% "scalatest" % scalatestVersion % "test",
      "org.scalactic" %% "scalactic" % scalatestVersion,
      "org.scalamock" %% "scalamock-scalatest-support" % "3.6.0" % Test,
      "org.clapper" %% "grizzled-slf4j" % "1.3.1",
      "ch.qos.logback" % "logback-classic" % "1.0.13",
      "net.codingwell" %% "scala-guice" % "4.1.0"
    )
  )
