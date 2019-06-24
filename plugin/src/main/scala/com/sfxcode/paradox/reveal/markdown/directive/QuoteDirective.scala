package com.sfxcode.paradox.reveal.markdown.directive

import com.lightbend.paradox.markdown.ContainerBlockDirective
import org.pegdown.Printer
import org.pegdown.ast._

case class QuoteDirective(name: String) extends ContainerBlockDirective(Array(name): _*) {
  def render(node: DirectiveNode, visitor: Visitor, printer: Printer): Unit = {
    val cite = node.attributes.value("cite", "")
    val separator = node.attributes.value("separator", "#")

    val contents = node.contents.replace("\n","")
    val separatorIndex = contents.indexOf(separator)

    printer.println()

    if (separatorIndex == -1 && contents.length > separatorIndex) {
      printer.print(s"""<blockquote""")
      if (cite.nonEmpty)
        printer.print(s""" cite="$cite"""")
      printer.print(s""">""")
      node.contentsNode.accept(visitor)
      printer.println()
      printer.print("""</blockquote>""")
    }
    else {
      printer.print(s"""<p>""")
      printer.print(contents.substring(0, separatorIndex))
      printer.print(s"""<q""")
      if (cite.nonEmpty)
        printer.print(s""" cite="$cite"""")
      printer.print(s""">""")

      val lastIndex = contents.lastIndexOf("#")
      if (lastIndex != separatorIndex) {
        printer.print(contents.substring(separatorIndex+1, lastIndex))
        printer.print(s"""</q>""")
        printer.print(contents.substring(lastIndex+1))
        printer.print(s"""</p>""")

      }
      else  {
        printer.print(contents.substring(separatorIndex+1))
        printer.print(s"""</q></p>""")
      }
    }
  }
}

