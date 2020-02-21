import sbt._, Keys._

lazy val root = (project in file("."))
  .settings(
    organization := "com.slamdata",
    name         := "slamdata-predef")
  .settings(commonBuildSettings)
  .settings(publishSettings)
  .settings(libraryDependencies ++= Seq(
    "org.scalaz"    %% "scalaz-core" % "7.2.28",
    "org.scalactic" %% "scalactic"   % "3.1.1")) // this is just for the Position macro
  .enablePlugins(AutomateHeaderPlugin)

lazy val publishSettings = commonPublishSettings ++ Seq(
  organizationName := "SlamData Inc.",
  organizationHomepage := Some(url("http://slamdata.com")),
  homepage := Some(url("https://github.com/slamdata/slamdata-predef")),
  scmInfo := Some(
    ScmInfo(
      url("https://github.com/slamdata/slamdata-predef"),
      "scm:git@github.com:slamdata/slamdata-predef.git")))
