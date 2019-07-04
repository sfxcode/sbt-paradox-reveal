libraryDependencies += "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value

// updates, release

addSbtPlugin("org.foundweekends" % "sbt-bintray" % "0.5.5")

addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.11")

addSbtPlugin("com.typesafe.sbt" % "sbt-license-report" % "1.2.0")

// paradox
addSbtPlugin("com.lightbend.paradox" % "sbt-paradox" % "0.6.0")

addSbtPlugin("com.lightbend.paradox" % "sbt-paradox-theme" % "0.6.0")

addSbtPlugin("io.github.jonas" % "sbt-paradox-material-theme" % "0.6.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-site" % "1.4.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-ghpages" % "0.6.3")

addSbtPlugin("com.sfxcode.paradox" % "sbt-paradox-reveal" % "1.0.5-SNAPSHOT")
