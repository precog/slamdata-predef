import sbt._, Keys._

import slamdata.SbtSlamData.transferPublishAndTagResources

lazy val root = (project in file("."))
  .settings(
    organization := "com.slamdata",
    name         := "slamdata-predef")
  .settings(commonBuildSettings)
  .settings(publishSettings)
  .settings(transferPublishAndTagResources)
  .settings(libraryDependencies ++= Seq(
    "org.scalaz"    %% "scalaz-core" % "7.2.15",
    "org.scalactic" %% "scalactic"   % "3.0.8")) // this is just for the Position macro
  .enablePlugins(AutomateHeaderPlugin)

lazy val publishSettings = commonPublishSettings ++ Seq(
  organizationName := "SlamData Inc.",
  organizationHomepage := Some(url("http://slamdata.com")),
  homepage := Some(url("https://github.com/slamdata/slamdata-predef")),
  scmInfo := Some(
    ScmInfo(
      url("https://github.com/slamdata/slamdata-predef"),
      "scm:git@github.com:slamdata/slamdata-predef.git")))
