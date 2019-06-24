import java.lang.management.ManagementFactory

import com.lightbend.paradox.sbt.ParadoxThemePlugin
import sbt.Keys.{publish, publishMavenStyle}

import scala.collection.JavaConverters._

inThisBuild(List(
  organization := "com.sfxcode.paradox",
  version := "1.0.4",
  licenses += "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"),
  scalaVersion := "2.12.8",
  bintrayPackageLabels := Seq("sbt", "plugin", "paradox", "reveal.js"),

  organizationName := "sfxcode",
  organizationHomepage := Some(url("https://github.com/sfxcode")),
  homepage := Some(url("https://github.com/sfxcode")),
  developers := List(
    Developer("sfxcode", "Tom Lamers", "tom@sfxcode.com", url("https://github.com/sfxcode"))),
  description := "Paradox Reveal is a paradox plugin for reveal.js presentations.",
  bintrayReleaseOnPublish in ThisBuild := true,
  publishMavenStyle  := true



))



lazy val paradox_reveal = project
  .in(file("."))
  .aggregate(plugin, paradoxRevealTheme)
  .settings(
    publish / skip := true
  )


lazy val plugin = project
  .in(file("plugin"))
  .enablePlugins(SbtPlugin)
  .settings(
    name := "sbt-paradox-reveal",
    libraryDependencies += Library.paradox,
    libraryDependencies += Library.specs2 % Test,
    scalacOptions in Test ++= Seq("-Yrangepos"),
    parallelExecution in Test := false,
    sbtPlugin := true,
    addSbtPlugin(Library.sbtWeb),
    addSbtPlugin(Library.sbtParadox),

    scriptedLaunchOpts += ("-Dproject.version=" + version.value),
    scriptedLaunchOpts ++= ManagementFactory.getRuntimeMXBean.getInputArguments.asScala.filter(
      a => Seq("-Xmx", "-Xms", "-XX", "-Dfile").exists(a.startsWith)
    ),
    scriptedDependencies := {
      val p1 = publishLocal.value
      val p2 = (publishLocal in paradoxRevealTheme).value
    },
    
    resourceGenerators in Compile += Def.task {
      val file = (resourceManaged in Compile).value / "paradox_reveal.properties"
      IO.write(file,
        s"""|paradox.reveal.organization=${organization.value}
            |paradox.reveal.version=${version.value}
            |""".stripMargin)
      Seq(file)
    }.taskValue

  )

lazy val paradoxRevealTheme = (project in (file("theme") / "reveal"))
  .enablePlugins(ParadoxThemePlugin)
  .settings(
    name := "paradox-reveal-theme",
  )

lazy val docs = (project in file("docs"))
  .enablePlugins(ParadoxSitePlugin)
  .enablePlugins(ParadoxMaterialThemePlugin)
  .enablePlugins(GhpagesPlugin)
  .settings(
    name := "paradox reveal docs",
    publish / skip := true,
    git.remoteRepo := "git@github.com:sfxcode/sbt-paradox-reveal.git",
    Compile / paradoxMaterialTheme ~= {
      _.withRepository(uri("https://github.com/sfxcode/sbt-paradox-reveal"))
      .withColor("teal", "indigo")
    }
  )



lazy val demo = (project in file("demo"))
  .enablePlugins(ParadoxSitePlugin)
  .enablePlugins(ParadoxRevealPlugin)
  .settings(
    name := "paradox reveal demo",
    publish / skip := true

  )
