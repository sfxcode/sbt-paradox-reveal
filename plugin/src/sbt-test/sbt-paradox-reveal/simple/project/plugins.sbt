{
  val pluginVersion = System.getProperty("project.version")
  if(pluginVersion == null)
    throw new RuntimeException("""|The system property 'plugin.version' is not defined.
                                  |Specify this property using the scriptedLaunchOpts -D.""".stripMargin)
  else addSbtPlugin("com.sfxcode.paradox" % """sbt-paradox-reveal""" % "0.9.1")
}

addSbtPlugin("com.lightbend.paradox" % "sbt-paradox" % "0.5.4")

addSbtPlugin("com.lightbend.paradox" % "sbt-paradox-theme" % "0.5.4")
