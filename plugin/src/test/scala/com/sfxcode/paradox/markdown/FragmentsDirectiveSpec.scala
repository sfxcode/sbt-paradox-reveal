package com.sfxcode.paradox.markdown

import com.lightbend.paradox.markdown.{Page, Writer}
import com.lightbend.paradox.tree.Tree.Location

class FragmentsDirectiveSpec extends MarkdownBaseSpec   {
  val testProperties = Map("version" -> "1.2.3")

  implicit val context: Location[Page] => Writer.Context = { loc =>
    testkit.writerContext(loc).copy(properties = testProperties)
  }

  "Fragments Directive" should {
    "render reveal fragments without parameter" in {


      val markdownString = markdown("""
                                      |@@@ slide
                                      |# Hallo
                                      |@@@@ fragments
                                      |Fragment1
                                      |Fragment2
                                      |@@@@
                                      |@@@
                                      |""")
      val htmlString = html("""
                              |<section>
                              |<h1><a href="#hallo" name="hallo" class="anchor"><span class="anchor-link"></span></a>Hallo</h1>
                              |<p class="fragment">Fragment1</p>
                              |<p class="fragment">Fragment2</p>
                              |</section>
                              |""")

      markdownString must be equalTo htmlString

    }

    "render reveal fragments with parameter" in {


      val markdownString = markdown("""
                                      |@@@ slide
                                      |# Hallo
                                      |@@@@ fragments { transition=grow }
                                      |Fragment1
                                      |Fragment2
                                      |@@@@
                                      |@@@
                                      |""")
      val htmlString = html("""
                              |<section>
                              |<h1><a href="#hallo" name="hallo" class="anchor"><span class="anchor-link"></span></a>Hallo</h1>
                              |<p class="fragment grow">Fragment1</p>
                              |<p class="fragment grow">Fragment2</p>
                              |</section>
                              |""")

      markdownString must be equalTo htmlString

    }



  }

  "Fragments Directive 2" should {
    "render reveal fragments with separator" in {


      val markdownString = markdown("""
                                      |@@@ slide
                                      |# Hallo
                                      |@@@@ fragments { spanIgnorePrefix=-  }
                                      |
                                      |Frag # ment1
                                      |Fragment2
                                      |@@@@
                                      |@@@
                                      |""")
      val htmlString = html("""
                              |<section>
                              |<h1><a href="#hallo" name="hallo" class="anchor"><span class="anchor-link"></span></a>Hallo</h1>
                              |<p><span class="fragment">Frag</span> <span class="fragment">ment1</span> </p>
                              |<p class="fragment">Fragment2</p>
                              |</section>
                              |""")

      markdownString must be equalTo htmlString

    }

  }

  }
