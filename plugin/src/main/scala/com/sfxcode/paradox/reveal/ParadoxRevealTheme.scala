package com.sfxcode.paradox.reveal

case class ParadoxRevealTheme(properties: Map[String, String]) {

  def withFavicon(favicon: String) =
    withProperties("favicon" -> favicon)

  def withTheme(theme: String) =
    withProperties("theme" -> theme)

  def withDefaultTransition(defaultTransition: String) =
    withProperties("default.transition" -> defaultTransition)


  def withCustomStylesheet(path: String) =
    withProperties("custom.stylesheet" -> path)

  def withCustomJavaScript(path: String) =
    withProperties("custom.javascript" -> path)


  def paradoxProperties(): Map[String, String] =
    properties.map(p => s"reveal.${p._1}" -> p._2)

  override def toString = paradoxProperties().toString

  private def withProperties(props: (String, String)*): ParadoxRevealTheme =
    copy(properties = properties ++ props.toMap)

  private def withoutProperties(keys: String*): ParadoxRevealTheme =
    copy(properties = properties -- keys)
}

object ParadoxRevealTheme {

  val ThemeBeige = "beige"
  val ThemeBlack = "black"
  val ThemeBlood = "blood"
  val ThemeLeague = "league"
  val ThemeMoon = "moon"
  val ThemeNight = "night"
  val ThemeSerif = "serif"
  val ThemeSimple = "simple"
  val ThemeSky = "sky"
  val ThemeSolerized = "solarized"
  val ThemeWhite = "white"

  val TransitionNone = "none"
  val TransitionFade = "fade"
  val TransitionSlide = "slide"
  val TransitionConvex = "convex"
  val TransitionConcave = "concave"
  val TransitionZoom = "zoom"

  def apply():ParadoxRevealTheme = {
    ParadoxRevealTheme(Map.empty)
      .withTheme(ThemeBlack)
      .withDefaultTransition(TransitionSlide)

  }

}


