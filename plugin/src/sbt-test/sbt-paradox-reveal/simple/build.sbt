
lazy val docs = project
  .in(file("."))
  .enablePlugins(ParadoxRevealPlugin)
  .settings(
    name := "Paradox Directives Test",
  )
