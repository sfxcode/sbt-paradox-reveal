package com.sfxcode.paradox.markdown

import com.lightbend.paradox.markdown.{Page, Writer}
import com.lightbend.paradox.tree.Tree.Location

class CodeDirectiveSpec extends MarkdownBaseSpec {
  val testProperties = Map("version" -> "1.2.3")

  implicit val context: Location[Page] => Writer.Context = { loc =>
    testkit.writerContext(loc).copy(properties = testProperties)
  }

  "CodeDirective" should {
    "render reveal section without parameter" in {

      val markdownString =
        markdown(
          """
                                      |@@@ code { id='myId' dataId='myDataId' trim=true lineNumbers='1,2' }
                                      |val a = 1
                                      |@@@
                                      |"""
        )
      val htmlString =
        html(
          """
                              |<section id="myId" data-auto-animate>
                              |<pre data-id="myDataId"><code class="hljs" data-trim data-line-numbers="1,2">
                              |val a = 1
                              |
                              |</code></pre>
                              |</section>
                              |"""
        )

      markdownString must be equalTo htmlString

    }

  }
}
