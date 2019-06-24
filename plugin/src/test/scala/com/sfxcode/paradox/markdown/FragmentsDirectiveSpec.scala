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

    "render reveal fragments with index parameter" in {


      val markdownString = markdown("""
                                      |@@@ slide
                                      |@@@@ fragments { index=1 }
                                      |Fragment1
                                      |Fragment2
                                      |@@@@
                                      |@@@
                                      |""")
      val htmlString = html("""
                              |<section>
                              |<p class="fragment" data-fragment-index="1">Fragment1</p>
                              |<p class="fragment" data-fragment-index="1">Fragment2</p>
                              |</section>
                              |""")

      markdownString must be equalTo htmlString

    }

    "render reveal fragments with transition parameter" in {


      val markdownString = markdown("""
                                      |@@@ slide
                                      |@@@@ fragments { transition=grow }
                                      |Fragment1
                                      |Fragment2
                                      |@@@@
                                      |@@@
                                      |""")
      val htmlString = html("""
                              |<section>
                              |<p class="fragment grow">Fragment1</p>
                              |<p class="fragment grow">Fragment2</p>
                              |</section>
                              |""")

      markdownString must be equalTo htmlString

    }



  }

  "Fragments Directive with out transition" should {
    "render reveal fragments" in {

      val markdownString = markdown("""
                                      |@@@ slide
                                      |@@@@ fragments { transition=fade-in outTransition=fade-out index=3 }
                                      |Fragment
                                      |@@@@
                                      |@@@
                                      |""")
      val htmlString = html("""
                              |<section>
                              |<p data-fragment-index="3"><span class="fragment fade-in">
                              |<span class="fragment fade-out">Fragment</span>
                              |</span></p>
                              |</section>
                              |""")

      markdownString must be equalTo htmlString

    }

  }

  "Fragments Directive with separated parts" should {
    "render reveal fragments" in {

      val markdownString = markdown("""
                                      |@@@ slide
                                      |@@@@ fragments { transition=grow partTransition=fade-in index=2 }
                                      |Fragment
                                      |FragmentPart1 -=- FragmentPart2
                                      |@@@@
                                      |@@@
                                      |""")
      val htmlString = html("""
                              |<section>
                              |<p class="fragment grow" data-fragment-index="2">Fragment</p>
                              |<p data-fragment-index="2">
                              |<span class="fragment fade-in">FragmentPart1</span>
                              |<span class="fragment fade-in">FragmentPart2</span>
                              |</p>
                              |</section>
                              |""")

      markdownString must be equalTo htmlString

    }

  }

  }
