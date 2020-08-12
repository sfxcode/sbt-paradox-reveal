{
  val pluginVersion = System.getProperty("project.version")
  if(pluginVersion == null)
    throw new RuntimeException("""|The system property 'plugin.version' is not defined.
                                  |Specify this property using the scriptedLaunchOpts -D.""".stripMargin)
  else addSbtPlugin("com.sfxcode.paradox" % """sbt-paradox-reveal""" % "1.0.6")
}

addSbtPlugin("com.lightbend.paradox" % "sbt-paradox" % "0.8.0")

addSbtPlugin("com.lightbend.paradox" % "sbt-paradox-theme" % "0.8.0")
