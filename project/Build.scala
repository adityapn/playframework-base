import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "playframework"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(      
      "mysql" % "mysql-connector-java" % "5.1.18",
      "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final",
      "javax.validation" % "validation-api" % "1.0.0.GA"

    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
    )

}
