package com.sfxcode.paradox.markdown.testkit

import com.lightbend.paradox.markdown.Writer.Context
import com.lightbend.paradox.markdown._
import com.sfxcode.paradox.reveal.markdown.directive.{FragmentsDirective, NotesDirective, SlideDirective}
import org.pegdown.plugins.ToHtmlSerializerPlugin
import org.pegdown.{LinkRenderer, ToHtmlSerializer, VerbatimSerializer}
import RevealWriter._

import scala.collection.JavaConverters._

class RevealWriter(serializer: Writer.Context => ToHtmlSerializer) extends
  Writer(serializer) {

  println("Reveal: " + this)

  def this(
            linkRenderer: Writer.Context => LinkRenderer = Writer.defaultLinks,
            verbatimSerializers: Map[String, VerbatimSerializer] = Writer.defaultVerbatims,
            serializerPlugins: Seq[Writer.Context => ToHtmlSerializerPlugin] =
            Writer.defaultPlugins(defaultDirectives)) =

    this((context: Writer.Context) => new ToHtmlSerializer(
      linkRenderer(context),
      verbatimSerializers.asJava,
      serializerPlugins.map(p => p(context)).asJava))

}

object RevealWriter {
  def apply():RevealWriter = new RevealWriter()

  def defaultDirectives: Seq[Context => Directive] = Seq(
    context => RefDirective(context.location.tree.label, context.paths, context.pageMappings, context.properties),
    context => ExtRefDirective(context.location.tree.label, context.properties),
    context => ScaladocDirective(context.location.tree.label, context.properties),
    context => JavadocDirective(context.location.tree.label, context.properties),
    context => GitHubDirective(context.location.tree.label, context.properties),
    context => SnipDirective(context.location.tree.label, context.properties),
    context => FiddleDirective(context.location.tree.label, context.properties),
    context => TocDirective(context.location, context.includeIndexes),
    context => VarDirective(context.properties),
    context => VarsDirective(context.properties),
    context => CalloutDirective("note", "Note"),
    context => CalloutDirective("warning", "Warning"),
    context => WrapDirective("div"),
    context => InlineWrapDirective("span"),
    context => InlineGroupDirective(context.groups.values.flatten.map(_.toLowerCase).toSeq),
    context => DependencyDirective(context.properties),
    context => IncludeDirective(context.location.tree.label, context.properties),
    context => SlideDirective("slide"),
    context => FragmentsDirective("fragments"),
    context => NotesDirective("notes")
  )

}
