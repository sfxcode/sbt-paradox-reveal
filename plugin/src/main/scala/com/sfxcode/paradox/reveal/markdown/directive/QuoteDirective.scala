package com.sfxcode.paradox.reveal.markdown.directive

import com.lightbend.paradox.markdown.ContainerBlockDirective
import org.pegdown.Printer
import org.pegdown.ast._

case class QuoteDirective(name: String) extends ContainerBlockDirective(Array(name): _*) {
  def render(node: DirectiveNode, visitor: Visitor, printer: Printer): Unit = {
    val cite = node.attributes.value("cite", "http://searchservervirtualization.techtarget.com/definition/Our-Favorite-Technology-Quotations")
    val separator = node.attributes.value("separator", "#")

    val contents = node.contents
    val separatorIndex = contents.indexOf(separator)

    if (separatorIndex == -1 && contents.length > separatorIndex) {
      printer.println()
      printer.print(s"""<blockquote cite="$cite">""")
      node.contentsNode.accept(visitor)
      printer.println()
      printer.print("""</blockquote>""")
    }
    else {
      printer.println()
      printer.print(s"""<p>""")
      printer.print(contents.substring(0, separatorIndex))
      printer.print(s"""<q cite="$cite">""")

      val lastIndex = contents.lastIndexOf("#")
      if (lastIndex != separatorIndex) {
        printer.print(contents.substring(separatorIndex+1, lastIndex))
        printer.print(s"""</q>""")
        printer.print(contents.substring(lastIndex+1))
      }
      else  {
        printer.print(contents.substring(separatorIndex))
        printer.print(s"""</q>""")
      }
      printer.print(s"""</p>""")
    }
  }
}

