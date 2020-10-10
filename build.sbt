import Settings._

enablePlugins(ScalaJSBundlerPlugin)

// TODO: ホットリロードの設定。可能ならSettingsに切り出したい
Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val root: Project = (project in file("."))
  .settings(name := "todo-list")
  .settings(baseSettings)
  .settings(
    libraryDependencies ++= Seq(
      "me.shadaj" %%% "slinky-web" % "0.6.5",
      "me.shadaj" %%% "slinky-hot" % "0.6.5",
      "org.scalatest" %%% "scalatest" % "3.1.1" % Test
    ),
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
    )
  )

// TODO webpack系の設定。切り出したい
version in webpack := "4.43.0"
version in startWebpackDevServer := "3.11.0"

webpackResources := baseDirectory.value / "webpack" * "*"

webpackConfigFile in fastOptJS := Some(baseDirectory.value / "webpack" / "webpack-fastopt.config.js")
webpackConfigFile in fullOptJS := Some(baseDirectory.value / "webpack" / "webpack-opt.config.js")
webpackConfigFile in Test := Some(baseDirectory.value / "webpack" / "webpack-core.config.js")

webpackDevServerExtraArgs in fastOptJS := Seq("--inline", "--hot")
webpackBundlingMode in fastOptJS := BundlingMode.LibraryOnly()

requireJsDomEnv in Test := true


// alias
addCommandAlias("dev", ";fastOptJS::startWebpackDevServer;~fastOptJS")
addCommandAlias("build", "fullOptJS::webpack")
