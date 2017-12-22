name := "$name;format="normalize"$"
organization := "$organization$"

scalaVersion := "2.12.3"

val akkaVersion = "$akka_version$"
val scalatestVersion = "$scalatest_version$"

publishMavenStyle := true

publishTo := {
  val prefix = if (isSnapshot.value) "snapshots" else "releases"
  Some(s"Oobo \$prefix" at s"s3://s3-eu-west-1.amazonaws.com/oobo-\$prefix")
}

resolvers ++= Seq(
  "Oobo snapshots" at "s3://s3-eu-west-1.amazonaws.com/oobo-snapshots",
  "Oobo releases" at "s3://s3-eu-west-1.amazonaws.com/oobo-releases",
  Resolver.url("typesafe", url("http://repo.typesafe.com/typesafe/ivy-releases/"))(Resolver.ivyStylePatterns)
)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "net.codingwell" %% "scala-guice" % "4.1.0",
  "org.clapper" %% "grizzled-slf4j" % "1.3.1",
  "ch.qos.logback" % "logback-classic" % "1.0.13",
  "org.scalatest" %% "scalatest" % scalatestVersion % Test,
  "org.scalactic" %% "scalactic" % scalatestVersion
)

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
