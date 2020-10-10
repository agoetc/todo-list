import sbt.Global
import sbt.Keys._
import sbt.nio.Keys.onChangedBuildSource

object Settings {
  lazy val baseSettings = Seq (
    organization := "agoetc",
    scalaVersion := "2.13.3",
    scalacOptions ++= Seq(
      "-Ymacro-annotations",
      "UTF-8"
    )
  )
}