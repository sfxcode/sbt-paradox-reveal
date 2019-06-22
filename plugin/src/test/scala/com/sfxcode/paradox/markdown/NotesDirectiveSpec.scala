package com.sfxcode.paradox.markdown

import com.lightbend.paradox.markdown.{Page, Writer}
import com.lightbend.paradox.tree.Tree.Location

class NotesDirectiveSpec extends MarkdownBaseSpec   {
  val testProperties = Map("version" -> "1.2.3")

  implicit val context: Location[Page] => Writer.Context = { loc =>
    testkit.writerContext(loc).copy(properties = testProperties)
  }

  "Notes Directive" should {
    "render reveal notes without parameter" in {


      val markdownString = markdown("""
                                      |@@@ slide
                                      |# Hello
                                      |* Version @var[version] is deprecated!
                                      |* Topic2
                                      |
                                      |@@@@ notes
                                      |Some notes
                                      |@@@@
                                      |@@@
                                      |""")
      val htmlString = html("""
                              |<section>
                              |<h1><a href="#hello" name="hello" class="anchor"><span class="anchor-link"></span></a>Hello</h1>
                              |<ul>
                              |  <li>Version 1.2.3 is deprecated!</li>
                              |  <li>Topic2</li>
                              |</ul>
                              |<aside class="notes">
                              |<p>Some notes</p>
                              |</aside>
                              |</section>
                              |""")

      markdownString must be equalTo htmlString

    }




  }
}
