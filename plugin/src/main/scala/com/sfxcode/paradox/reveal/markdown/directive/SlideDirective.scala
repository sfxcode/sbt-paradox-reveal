package com.sfxcode.paradox.reveal.markdown.directive

import com.lightbend.paradox.markdown.ContainerBlockDirective
import com.sfxcode.paradox.reveal.markdown.directive.SlideDirective._
import org.pegdown.Printer
import org.pegdown.ast._


case class SlideDirective(name: String) extends ContainerBlockDirective(Array(name): _*) {
  def render(node: DirectiveNode, visitor: Visitor, printer: Printer): Unit = {

    val id = node.attributes.value("id", "")
    val styleclass = node.attributes.value("class", "")

    val transition = node.attributes.value("transition", "")
    val transitionSpeed = node.attributes.value("transitionSpeed", "")

    val background = node.attributes.value("background", "")
    val backgroundRepeat = node.attributes.booleanValue("backgroundRepeat", false)
    val backgroundSize = node.attributes.value("backgroundSize", "")
    val backgroundTransition = node.attributes.value("backgroundTransition", "")

    val video = node.attributes.value("video", "")
    val iframe = node.attributes.value("iframe", "")

    printer.println()

    printer.print(s"""<section""")

    if (id.nonEmpty)
      printer.print(s""" id="${id}"""")

    if (styleclass.nonEmpty)
      printer.print(s""" id="${styleclass}"""")

    if (transition.nonEmpty && TransitionList.contains(transition.toLowerCase))
      printer.print(s""" data-transition="${transition.toLowerCase}"""")

    if (transitionSpeed.nonEmpty && TransitionSpeedList.contains(transitionSpeed.toLowerCase))
      printer.print(s""" data-transition-speed="${transitionSpeed.toLowerCase}"""")

    if (background.nonEmpty)
      printer.print(s""" data-background="${background}"""")

    if (backgroundRepeat)
      printer.print(s""" data-background-repeat="repeat"""")

    if (backgroundSize.nonEmpty)
      printer.print(s""" data-background-Size="${backgroundSize}"""")

    if (backgroundTransition.nonEmpty && TransitionList.contains(transition.toLowerCase))
      printer.print(s""" data-background-transition="${backgroundTransition.toLowerCase}"""")

    if (video.nonEmpty)
      printer.print(s""" data-background-video="${background}"""")

    if (iframe.nonEmpty)
      printer.print(s""" data-background-iframe="${iframe}" data-background-interactive""")

    printer.print(s""">""")
    node.contentsNode.accept(visitor)
    printer.println()
    printer.print("""</section>""")
  }
}

object SlideDirective {
  val TransitionList = List("none", "fade", "slide", "convex", "concave", "zoom")
  val TransitionSpeedList = List("normal", "slow", "fast")
}
