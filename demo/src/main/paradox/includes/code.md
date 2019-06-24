@@@ slide
## Code

```scala
package example

object Hello extends Greeting with App {
  println(greeting)
}

trait Greeting {
  lazy val greeting: String = "hello"
}

```


@@@

@@@ slide
## Code Snippet File
@@snip [Application](../../scala/example/Hello.scala)

@@@
