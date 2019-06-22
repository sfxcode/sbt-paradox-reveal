package com.sfxcode.paradox.markdown

import com.lightbend.paradox.markdown.{Page, Writer}
import com.lightbend.paradox.tree.Tree.Location
import org.specs2.mutable.Specification

class Testkit extends testkit.MarkdownTestkit {
}

abstract class MarkdownBaseSpec extends Specification {
  def testkit = new Testkit

  def markdown(text: String)(implicit context: Location[Page] => Writer.Context = testkit.writerContext): String =
    testkit.markdown(text)


  def html(text: String): String = testkit.html(text)

}


