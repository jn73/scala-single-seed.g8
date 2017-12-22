name := "$name$"
organization := "$organization$"

publishMavenStyle := true

publishTo := {
  val prefix = if (isSnapshot.value) "snapshots" else "releases"
  Some(s"Oobo $prefix" at s"s3://s3-eu-west-1.amazonaws.com/oobo-$prefix")
}

resolvers ++= Seq(
  "Oobo snapshots" at "s3://s3-eu-west-1.amazonaws.com/oobo-snapshots",
  "Oobo releases" at "s3://s3-eu-west-1.amazonaws.com/oobo-releases",
  Resolver.url("typesafe", url("http://repo.typesafe.com/typesafe/ivy-releases/"))(Resolver.ivyStylePatterns)
)

test in Test := {
  val _ = (g8Test in Test).toTask("").value
}

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
