lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.13.6"
    )),
    name := "scalatest-example"
  )

libraryDependencies += "org.scalamock" %% "scalamock" % "5.2.0" % Test
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.13" % Test
