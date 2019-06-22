package com.sfxcode.paradox.reveal.markdown.directive

import com.lightbend.paradox.markdown.ContainerBlockDirective
import org.pegdown.Printer
import org.pegdown.ast._


case class NotesDirective(name: String) extends ContainerBlockDirective(Array(name): _*) {
  def render(node: DirectiveNode, visitor: Visitor, printer: Printer): Unit = {
    printer.println()
    printer.print(s"""<aside class="notes">""")
    node.contentsNode.accept(visitor)
    printer.println()
    printer.print("""</aside>""")
  }
}

