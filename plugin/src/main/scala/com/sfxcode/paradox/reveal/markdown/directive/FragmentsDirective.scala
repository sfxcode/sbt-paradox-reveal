package com.sfxcode.paradox.reveal.markdown.directive

import com.lightbend.paradox.markdown.ContainerBlockDirective
import org.pegdown.Printer
import org.pegdown.ast._


case class FragmentsDirective(name: String) extends ContainerBlockDirective(Array(name): _*) {
  def render(node: DirectiveNode, visitor: Visitor, printer: Printer): Unit = {
    val transition = node.attributes.value("transition", "")
    val index = node.attributes.intValue("index", 0)
    val outTransition = node.attributes.value("outTransition", "")
    val separator = node.attributes.value("separator", "-=-")
    val partTransition = node.attributes.value("partTransition", "")

    val lines = node.contents.split("\n").map(_.trim).filter(line => line.nonEmpty)
    lines.foreach(line => {
      printer.println()
      if (line.contains(separator))  {
        printer.print(s"""<p""")
        if (index > 0)
          printer.print(s""" data-fragment-index="$index"""")
        printer.print(s""">""")
        val parts = line.split(separator).map(_.trim).filter(line => line.nonEmpty)
        parts.foreach(part => {
          printer.println()
          printer.print(s"""<span class="fragment""")
          if (partTransition.nonEmpty)
            printer.print(s""" $partTransition""")
          else if (transition.nonEmpty)
            printer.print(s""" $transition""")

          printer.print(s"""">$part</span>""")
        })
        printer.println()
        printer.print(s"""</p>""")
      }
      else if (outTransition.nonEmpty)  {
        printer.print(s"""<p""")
        if (index > 0)
          printer.print(s""" data-fragment-index="$index"""")
        printer.print(s"""><span class="fragment""")
        if (transition.nonEmpty)
          printer.print(s""" $transition""")

        printer.print(s"""">""")
        printer.println()
        printer.print(s"""<span class="fragment""")
        printer.print(s""" $outTransition">$line</span>""")
        printer.println()
        printer.print(s"""</span></p>""")
      }
      else {
        printer.print(s"""<p class="fragment""")
        if (transition.nonEmpty)
          printer.print(s""" $transition""")
        printer.print(s""""""")

        if (index > 0)
          printer.print(s""" data-fragment-index="$index"""")

        printer.print(s""">$line</p>""")

      }

    })


  }


}

