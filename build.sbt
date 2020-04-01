import sbt._, Keys._

name := "slamdata-predef"

ThisBuild / organization := "com.slamdata"

ThisBuild / homepage := Some(url("https://github.com/precog/slamdata-predef"))

ThisBuild / scmInfo := Some(ScmInfo(
  url("https://github.com/precog/slamdata-predef"),
  "scm:git@github.com:precog/slamdata-predef.git"))

ThisBuild / githubRepository := "slamdata-predef"

ThisBuild / crossScalaVersions := Seq("2.13.1", "2.12.11", "2.11.12")
ThisBuild / scalaVersion := (ThisBuild / crossScalaVersions).value.head

libraryDependencies ++= Seq(
  "org.scalaz"    %% "scalaz-core" % "7.2.28",
  "org.scalactic" %% "scalactic"   % "3.0.8")
