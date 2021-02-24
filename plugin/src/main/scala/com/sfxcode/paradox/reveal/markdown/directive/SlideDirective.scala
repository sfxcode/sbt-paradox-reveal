package com.sfxcode.paradox.reveal.markdown.directive

import com.lightbend.paradox.markdown.ContainerBlockDirective
import com.sfxcode.paradox.reveal.markdown.directive.SlideDirective._
import org.pegdown.Printer
import org.pegdown.ast._

case class SlideDirective(name: String)
    extends ContainerBlockDirective(Array(name): _*) {
  def render(node: DirectiveNode, visitor: Visitor, printer: Printer): Unit = {

    val id = node.attributes.value("id", "")
    val styleclass = node.attributes.value("class", "")
    val style = node.attributes.value("style", "")

    val transition = node.attributes.value("transition", "")
    val transitionSpeed = node.attributes.value("transitionSpeed", "")

    val color = node.attributes.value("color", "")

    val image = node.attributes.value("image", "")

    val video = node.attributes.value("video", "")
    val videoLoop =
      video.nonEmpty && node.attributes.booleanValue("loop", false)
    val videoMuted =
      video.nonEmpty && node.attributes.booleanValue("muted", false)

    val iframe = node.attributes.value("iframe", "")
    val iframeInteractive =
      iframe.nonEmpty && node.attributes.booleanValue("interactive", false)

    val backgroundSize = node.attributes.value("size", "")
    val backgroundPosition = node.attributes.value("position", "")
    val backgroundRepeat = node.attributes.value("repeat", "")
    val backgroundOpacity = node.attributes.value("opacity", "")
    val backgroundTransition = node.attributes.value("backgroundTransition", "")

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
    )
      printer.print(
        s""" data-transition-speed="${transitionSpeed.toLowerCase}""""
      )

    if (color.nonEmpty)
      printer.print(s""" data-background="${color}"""")

    if (video.nonEmpty)
      printer.print(s""" data-background-color="${video}"""")

    if (videoLoop)
      printer.print(s"""  data-background-video-loop""")

    if (iframe.nonEmpty)
      printer.print(s""" data-background-iframe="${iframe}"""")

    if (iframeInteractive)
      printer.print(s"""  data-background-interactive""")

    if (image.nonEmpty)
      printer.print(s""" data-background="${image}"""")

    if (backgroundSize.nonEmpty)
      printer.print(s""" data-background-size="${backgroundSize}"""")

    if (backgroundRepeat.nonEmpty)
      printer.print(s""" data-background-repeat="${backgroundRepeat}"""")

    if (backgroundPosition.nonEmpty)
      printer.print(s""" data-background-position="${backgroundPosition}"""")

    if (backgroundOpacity.nonEmpty)
      printer.print(s""" data-background-opacity="${backgroundOpacity}"""")

    if (
      backgroundTransition.nonEmpty && TransitionList.contains(
        transition.toLowerCase
      )
    )
      printer.print(
        s""" data-background-transition="${backgroundTransition.toLowerCase}""""
      )

    printer.print(s""">""")
    node.contentsNode.accept(visitor)
    printer.println()
    printer.print("""</section>""")
  }
}

object SlideDirective {
  val TransitionList =
    List("none", "fade", "slide", "convex", "concave", "zoom")
  val TransitionSpeedList = List("normal", "slow", "fast")
}
