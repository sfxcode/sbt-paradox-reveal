package com.sfxcode.paradox.markdown.testkit

import com.lightbend.paradox.markdown.Writer.Context
import com.lightbend.paradox.markdown._
import com.sfxcode.paradox.reveal.markdown.directive.{
  CodeDirective,
  FragmentsDirective,
  NotesDirective,
  QuoteDirective,
  SlideDirective
}
import org.pegdown.plugins.ToHtmlSerializerPlugin
import org.pegdown.{LinkRenderer, ToHtmlSerializer, VerbatimSerializer}
import RevealWriter._

import scala.collection.JavaConverters._

class RevealWriter(serializer: Writer.Context => ToHtmlSerializer)
    extends Writer(serializer) {

  println("Reveal: " + this)

  def this(
      linkRenderer: Writer.Context => LinkRenderer = Writer.defaultLinks,
      verbatimSerializers: Map[String, VerbatimSerializer] =
        Writer.defaultVerbatims,
      serializerPlugins: Seq[Writer.Context => ToHtmlSerializerPlugin] =
        Writer.defaultPlugins(defaultDirectives)
  ) =
    this((context: Writer.Context) =>
      new ToHtmlSerializer(
        linkRenderer(context),
        verbatimSerializers.asJava,
        serializerPlugins.map(p => p(context)).asJava
      )
    )

}

object RevealWriter {
  def apply(): RevealWriter = new RevealWriter()

  def defaultDirectives: Seq[Context => Directive] =
    Seq(
      RefDirective.apply,
      LinkDirective.apply,
      ExtRefDirective.apply,
      ScaladocDirective.apply,
      JavadocDirective.apply,
      GitHubDirective.apply,
      SnipDirective.apply,
      FiddleDirective.apply,
      context => TocDirective(context.location, context.includeIndexes),
      context => VarDirective(context.properties),
      context => VarsDirective(context.properties),
      context => CalloutDirective("note", "Note"),
      context => CalloutDirective("warning", "Warning"),
      context => WrapDirective("div"),
      context => InlineWrapDirective("span"),
      context =>
        InlineGroupDirective(
          context.groups.values.flatten.map(_.toLowerCase).toSeq
        ),
      DependencyDirective.apply,
      IncludeDirective.apply,
      context => SlideDirective("slide"),
      context => FragmentsDirective("fragments"),
      context => NotesDirective("notes"),
      context => QuoteDirective("quote"),
      context => CodeDirective("code")
    )

}
