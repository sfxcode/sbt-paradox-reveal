# sbt-paradox-reveal

An sbt AutoPlugin for generating reveal.js presentations with Lightbend
Paradox .

## Use Paradox for Reveal.js presentations

Combine the power of [Paradox](https://developer.lightbend.com/docs/paradox/current/) with the HTML presentation framework [reveal.js](https://revealjs.com/#/).

With **Paradox** for

* [Templating](https://developer.lightbend.com/docs/paradox/current/customization/templating.html)
* [Markdown file inclusion](https://developer.lightbend.com/docs/paradox/current/directives/includes.html)
* [Snippet inclusion](https://developer.lightbend.com/docs/paradox/current/directives/snippets.html)

and **Reveal.js** for

* [Slides](https://revealjs.com/#/1)
* [HTML Transtions](https://revealjs.com/#/transitions)
* [Speager Notes](https://revealjs.com/#/20)

it is easy to create a presentation with code examples in short time.

## Usage

This plugin requires sbt 1.0.0+

Install plugin in project/plugins.sbt:

``` addSbtPlugin("com.sfxcode.paradox" % "sbt-paradox-reveal" %
"$project.version$")
```

Enable Plugin in your build.sbt file:

```
 enablePlugins(ParadoxRevealPlugin)
```

### Testing

Run `test` for regular unit tests.

Run `scripted` for [sbt script tests](http://www.scala-sbt.org/1.x/docs/Testing-sbt-plugins.html).

