import Settings._
import Dependencies._

// alias
addCommandAlias("dev", ";fastOptJS::startWebpackDevServer;~fastOptJS")
addCommandAlias("build", "fullOptJS::webpack")

enablePlugins(ScalaJSBundlerPlugin)

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val root: Project = (project in file("."))
  .settings(name := "todo-list")
  .settings(baseSettings)
  .settings(webpackSettings)
  .settings(
    npmDependencies in Compile ++= Seq(
      "react" -> "16.13.1",
      "react-dom" -> "16.13.1",
      "react-proxy" -> "1.1.8"
    ),
    npmDevDependencies in Compile ++= Seq(
      "file-loader" -> "6.0.0",
      "style-loader" -> "1.2.1",
      "css-loader" -> "3.5.3",
      "html-webpack-plugin" -> "4.3.0",
      "copy-webpack-plugin" -> "5.1.1",
      "webpack-merge" -> "4.2.2"
    ),
    libraryDependencies ++= {
      // slinkyもDepenciesに移動させたい
      // https://stackoverflow.com/questions/29473377/how-to-import-in-build-scala-in-a-scalajs-project
      val slinkyVersion = "0.6.6"

      Seq(
        "me.shadaj" %%% "slinky-web" % slinkyVersion,
        "me.shadaj" %%% "slinky-hot" % slinkyVersion,
        ScalaTest.scalaTest % Test
      )
    }
  )
