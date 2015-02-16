name := "scala bowling kata"

version := "1.0"

scalaVersion := "2.11.5"

libraryDependencies += "org.specs2" %% "specs2-core" % "2.4" % "test"

scalacOptions in Test ++= Seq("-Yrangepos")

