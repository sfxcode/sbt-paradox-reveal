package com.sfxcode.paradox.reveal

import com.lightbend.paradox.markdown.Writer
import com.lightbend.paradox.sbt.ParadoxPlugin
import com.lightbend.paradox.sbt.ParadoxPlugin.readProperty
import com.sfxcode.paradox.reveal
import com.sfxcode.paradox.reveal.markdown.directive.{FragmentsDirective, NotesDirective, QuoteDirective, SlideDirective}
import sbt._
import sbt.Keys._

object ParadoxRevealPlugin extends AutoPlugin with ParadoxRevealKeys {


  object autoImport {
    type ParadoxRevealTheme = _root_.com.sfxcode.paradox.reveal.ParadoxRevealTheme
    val ParadoxRevealTheme = _root_.com.sfxcode.paradox.reveal.ParadoxRevealTheme

    val paradoxRevealTheme = settingKey[ParadoxRevealTheme]("Reveal theme options")
  }

  import autoImport._
  import ParadoxPlugin.autoImport._


  override def requires: Plugins = ParadoxPlugin

  override def trigger: PluginTrigger = noTrigger

  override def projectSettings: Seq[Setting[_]] = Def.settings(
    revealParadoxGlobalSettings,
    revealParadoxSettings(Compile)
  )

  def revealParadoxGlobalSettings: Seq[Setting[_]] = Seq(
    paradoxRevealVersion := readProperty("paradox_reveal.properties", "paradox.reveal.version"),
    paradoxRevealOrganization := readProperty("paradox_reveal.properties", "paradox.reveal.organization"),
    paradoxDirectives ++= Def.taskDyn {
      Def.task {
        Seq(
          { _: Writer.Context ⇒
            SlideDirective("slide")
          },
          { _: Writer.Context ⇒
            FragmentsDirective("fragments")
          },
          { _: Writer.Context ⇒
            NotesDirective("notes")
          },
          { _: Writer.Context ⇒
            QuoteDirective("quote")
          }
        )
      }

    }.value,
    paradoxTheme := Some(paradoxRevealOrganization.value % "paradox-reveal-theme" % paradoxRevealVersion.value)

  )

  def revealParadoxSettings(config: Configuration): Seq[Setting[_]] =
    inConfig(config)(Def.settings(
      paradoxRevealTheme := reveal.ParadoxRevealTheme(),

      paradoxProperties += ("reveal.theme.version" -> readProperty("paradox_reveal.properties", "paradox.reveal.version")),
      paradoxProperties += ("snip.github_link" -> "false"),
      paradoxProperties ++= paradoxRevealTheme.value.paradoxProperties

    ))
}
