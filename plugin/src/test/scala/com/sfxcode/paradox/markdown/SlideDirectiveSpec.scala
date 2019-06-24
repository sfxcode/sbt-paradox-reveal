package com.sfxcode.paradox.markdown

import com.lightbend.paradox.markdown.{Page, Writer}
import com.lightbend.paradox.tree.Tree.Location

class SlideDirectiveSpec extends MarkdownBaseSpec   {
  val testProperties = Map("version" -> "1.2.3")

  implicit val context: Location[Page] => Writer.Context = { loc =>
    testkit.writerContext(loc).copy(properties = testProperties)
  }

  "SectionDirective" should {
    "render reveal section without parameter" in {


      val markdownString = markdown("""
                                      |@@@ slide
                                      |# Hello
                                      |* Version @var[version] is deprecated!
                                      |* Topic2
                                      |@@@
                                      |""")
      val htmlString = html("""
                              |<section>
                              |<h1><a href="#hello" name="hello" class="anchor"><span class="anchor-link"></span></a>Hello</h1>
                              |<ul>
                              |  <li>Version 1.2.3 is deprecated!</li>
                              |  <li>Topic2</li>
                              |</ul>
                              |</section>
                              |""")

      markdownString must be equalTo htmlString

    }

    "render reveal section with parameter" in {

      val markdownString = markdown("""
                                      |@@@ slide { transition=zoom transitionSpeed=fast }
                                      |Version @var[version] is deprecated!
                                      |@@@
                                      |""")
      val htmlString = html("""
                              |<section data-transition="zoom" data-transition-speed="fast">
                              |<p>Version 1.2.3 is deprecated!</p>
                              |</section>
                              |""")

      markdownString must be equalTo htmlString

    }





  }
}
