import de.heikoseeberger.sbtheader.AutomateHeaderPlugin
import de.heikoseeberger.sbtheader.license.Apache2_0

lazy val akkaHttpVersion = "10.0.0"
lazy val circeVersion    = "0.7.0-M1"

lazy val buildSettings = Seq(
  organization := "io.fcomb",
  organizationName := "fcomb",
  description := "Akka Http Circe marshallers",
  startYear := Option(2016),
  version in ThisBuild := s"${akkaHttpVersion}_$circeVersion",
  homepage := Option(url("https://github.com/fcomb/akka-http-circe")),
  organizationHomepage := Option(new URL("https://github.com/fcomb/akka-http-circe")),
  scalaVersion := "2.12.1",
  crossScalaVersions := Seq("2.11.8", "2.12.1"),
  headers := Map("scala" -> Apache2_0("2016", "fcomb. <https://github.com/fcomb/akka-http-circe>"))
)

lazy val commonSettings =
  Seq(
    resolvers ++= Seq(
      "Typesafe Releases" at "http://repo.typesafe.com/typesafe/maven-releases/",
      Resolver.jcenterRepo,
      Resolver.sonatypeRepo("releases"),
      Resolver.sonatypeRepo("snapshots")
    ),
    scalacOptions ++= Seq(
      "-encoding",
      "UTF-8",
      "-target:jvm-1.8",
      "-unchecked",
      "-deprecation",
      "-feature",
      "-language:higherKinds",
      "-language:existentials",
      "-language:postfixOps",
      "-Xexperimental",
      "-Xlint",
      "-Xfatal-warnings",
      "-Xfuture",
      "-Ydelambdafy:method",
      "-Yno-adapted-args",
      "-Yno-imports",
      "-Yno-predef",
      "-Ywarn-dead-code",
      "-Ywarn-infer-any",
      "-Ywarn-numeric-widen",
      "-Ywarn-unused",
      "-Ywarn-unused-import",
      "-Ywarn-value-discard"
    ),
    javaOptions ++= Seq("-Dfile.encoding=UTF-8"),
    javacOptions ++= Seq(
      "-source",
      "1.8",
      "-target",
      "1.8",
      "-Xlint:unchecked",
      "-Xlint:deprecation"
    )
  )

lazy val publishSettings = Seq(
  bintrayOrganization := Some("fcomb"),
  publishMavenStyle := true,
  publishArtifact in Test := false,
  homepage := Some(url("https://github.com/fcomb/akka-http-circe")),
  scmInfo := Some(
    ScmInfo(url("https://github.com/fcomb/akka-http-circe"),
            "scm:git://github.com:fcomb/akka-http-circe.git")),
  licenses := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")),
  pomExtra := (
    <developers>
      <developer>
        <id>TimothyKlim</id>
        <name>Timothy Klim</name>
        <url>https://twitter.com/TimothyKlim</url>
      </developer>
    </developers>
  )
)

lazy val allSettings = buildSettings ++ commonSettings ++ publishSettings

lazy val root = project
  .in(file("."))
  .enablePlugins(AutomateHeaderPlugin)
  .settings(allSettings)
  .settings(publishSettings)
  .settings(
    name := "akka-http-circe",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http"     % akkaHttpVersion,
      "io.circe"          %% "circe-parser"  % circeVersion,
      "io.circe"          %% "circe-generic" % circeVersion
    )
  )
