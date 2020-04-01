import sbt._, Keys._

name := "slamdata-predef"

ThisBuild / homepage := Some(url("https://github.com/precog/slamdata-predef"))

ThisBuild / scmInfo := Some(ScmInfo(
  url("https://github.com/precog/slamdata-predef"),
  "scm:git@github.com:precog/slamdata-predef.git"))


ThisBuild / githubRepository := "slamdata-predef"

libraryDependencies ++= Seq(
  "org.scalaz"    %% "scalaz-core" % "7.2.28",
  "org.scalactic" %% "scalactic"   % "3.0.8")
