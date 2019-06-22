package com.sfxcode.paradox.reveal

import sbt.settingKey

trait ParadoxRevealKeys {

  val paradoxRevealVersion = settingKey[String]("Paradox-Reveal plugin version.")

  val paradoxRevealOrganization = settingKey[String]("Paradox-Reveal organization.")

}
