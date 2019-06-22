package com.sfxcode.paradox.reveal.markdown.directive

import com.lightbend.paradox.markdown.ContainerBlockDirective
import org.pegdown.Printer
import org.pegdown.ast._


case class FragmentsDirective(name: String) extends ContainerBlockDirective(Array(name): _*) {
  def render(node: DirectiveNode, visitor: Visitor, printer: Printer): Unit = {
    val transition = node.attributes.value("transition", "none")
    val separator = node.attributes.value("separator", "#")
    val spanTransition = node.attributes.value("spanTransition", transition)
    val spanIgnorePrefix = node.attributes.value("spanIgnorePrefix", "NoSpanIgnorePrefix")


    val lines = node.contents.split("\n").map(_.trim).filter(line => line.nonEmpty)
    lines.foreach(line => {
      printer.println()
      if (separator.nonEmpty && line.contains(separator))  {
        printer.print(s"""<p>""")
        val parts = line.split(separator).map(_.trim).filter(line => line.nonEmpty)
        parts.foreach(part => {
          if (part.startsWith(spanIgnorePrefix))
            printer.print(part.substring(spanIgnorePrefix.size))
          else {
            val html = s"""<span class="fragment $spanTransition">$part</span> """
            printer.print(html.replace(" none", ""))
          }
        })
        printer.print(s"""</p>""")

      }
      else {
        val html = s"""<p class="fragment $transition">$line</p>"""
        printer.print(html.replace(" none", ""))
      }

    })


  }


}

