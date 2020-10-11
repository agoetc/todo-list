import sbt._

object Dependencies {
  object ScalaTest {
    private val version = "3.2.2"
    val scalaTest: ModuleID = "org.scalatest" %% "scalatest" % version
  }
}
