package com.sfxcode.paradox.reveal.markdown.directive

import com.lightbend.paradox.markdown.ContainerBlockDirective
import com.sfxcode.paradox.reveal.markdown.directive.SlideDirective._
import org.pegdown.Printer
import org.pegdown.ast._

case class CodeDirective(name: String)
    extends ContainerBlockDirective(Array(name): _*) {
  def render(node: DirectiveNode, visitor: Visitor, printer: Printer): Unit = {

    val id = node.attributes.value("id", "")

    val dataId = node.attributes.value("dataId", "")

    val styleclass = node.attributes.value("class", "")
    val style = node.attributes.value("style", "")

    val transition = node.attributes.value("transition", "")
    val transitionSpeed = node.attributes.value("transitionSpeed", "")

    val title = node.attributes.value("title", "")
    val footerText = node.attributes.value("footerText", "")

    val autoAnimate = node.attributes.booleanValue("autoAnimate", true)
    val trimData = node.attributes.booleanValue("trim", true)
    var showLineNumbers = node.attributes.booleanValue("showLineNumbers", true)
    val lineNumbers = node.attributes.value("lineNumbers", "")
    if (lineNumbers.nonEmpty)
      showLineNumbers = true

    printer.println()

    printer.print(s"""<section""")

    if (id.nonEmpty)
      printer.print(s""" id="${id}"""")

    if (style.nonEmpty)
      printer.print(s""" style="${style}"""")

    if (styleclass.nonEmpty)
      printer.print(s""" class="${styleclass}"""")

    if (transition.nonEmpty && TransitionList.contains(transition.toLowerCase))
      printer.print(s""" data-transition="${transition.toLowerCase}"""")

    if (
      transitionSpeed.nonEmpty && TransitionSpeedList.contains(
        transitionSpeed.toLowerCase
      )
    ) {
      printer.print(
        s""" data-transition-speed="${transitionSpeed.toLowerCase}""""
      )
    }

    if (autoAnimate)
      printer.print(s""" data-auto-animate""")

    printer.print(s""">""")

    if (title.nonEmpty) {
      printer.println()
      printer.print(s"""<h2 data-id="code-title">${title}</h2>""")
      printer.println()
    }

    printer.println()
    printer.print(s"""<pre""")
    if (dataId.nonEmpty)
      printer.print(s""" data-id="${dataId}"""")

    printer.print(s"""><code class="hljs"""")

    if (trimData)
      printer.print(s""" data-trim""")

    if (showLineNumbers)
      printer.print(s""" data-line-numbers""")

    if (lineNumbers.nonEmpty)
      printer.print(s"""="${lineNumbers}"""")

    printer.print(s""">""")
    printer.println()
    printer.print(node.contents)
    printer.print(s"""</code></pre>""")
    printer.println()
    if (footerText.nonEmpty) {
      printer.println()
      printer.print(s"""<p>${footerText}</p>""")
      printer.println()
    }
    printer.print("""</section>""")
  }
}
