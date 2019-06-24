package com.sfxcode.paradox.markdown

import com.lightbend.paradox.markdown.{Page, Writer}
import com.lightbend.paradox.tree.Tree.Location

class QuoteDirectiveSpec extends MarkdownBaseSpec   {
  val testProperties = Map("version" -> "1.2.3")

  implicit val context: Location[Page] => Writer.Context = { loc =>
    testkit.writerContext(loc).copy(properties = testProperties)
  }

  "Quote Directive" should {
    "render reveal quotes as block" in {


      val markdownString = markdown("""
                                      |@@@ slide
                                      |@@@@ quote
                                      |Some quote
                                      |@@@@
                                      |@@@
                                      |""")
      val htmlString = html("""
                              |<section>
                              |<blockquote>
                              |<p>Some quote</p>
                              |</blockquote>
                              |</section>
                              |""")

      markdownString must be equalTo htmlString

    }

    "render reveal quotes as block with cite" in {


      val markdownString = markdown("""
                                      |@@@ slide
                                      |@@@@ quote { cite=http://searchservervirtualization.techtarget.com/definition/Our-Favorite-Technology-Quotations }
                                      |Some quote
                                      |@@@@
                                      |@@@
                                      |""")
      val htmlString = html("""
                              |<section>
                              |<blockquote cite="http://searchservervirtualization.techtarget.com/definition/Our-Favorite-Technology-Quotations">
                              |<p>Some quote</p>
                              |</blockquote>
                              |</section>
                              |""")

      markdownString must be equalTo htmlString

    }

    "render reveal quotes as inline quote" in {


      val markdownString = markdown("""
                                      |@@@ slide
                                      |@@@@ quote
                                      |Some Text # Some quote
                                      |@@@@
                                      |@@@
                                      |""")
      val htmlString = html("""
                              |<section>
                              |<p>Some Text <q> Some quote</q></p>
                              |</section>
                              |""")

      markdownString must be equalTo htmlString

    }

    "render reveal quotes as inline quote" in {


      val markdownString = markdown("""
                                      |@@@ slide
                                      |@@@@ quote
                                      |Some Text # Some quote # Some Text
                                      |@@@@
                                      |@@@
                                      |""")
      val htmlString = html("""
                              |<section>
                              |<p>Some Text <q> Some quote </q> Some Text</p>
                              |</section>
                              |""")

      markdownString must be equalTo htmlString

    }



  }
}
