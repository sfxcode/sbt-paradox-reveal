# Paradox Reveal Theme

## Motivation

As a software developer i like to create presentations with code examples
fast and easy. For technical presentations i prefer reveal.js (simple,
portable, nice transitions ...).

After using Paradox for my software documentation, i decided to use it
also for my presentation slides. Having the presentation inside my
project i like to present, the full power of paradox is available for a
nice presentation with reveal.js. Maybe someone find it useful as well.

## Use Paradox for Reveal.js presentations

Combine the power of [Paradox](https://developer.lightbend.com/docs/paradox/current/) with the HTML presentation framework [reveal.js](https://revealjs.com/#/).

With **Paradox** for

* [Templating](https://developer.lightbend.com/docs/paradox/current/customization/templating.html)
* [Markdown file inclusion](https://developer.lightbend.com/docs/paradox/current/directives/includes.html)
* [Snippet inclusion](https://developer.lightbend.com/docs/paradox/current/directives/snippets.html)

and **Reveal.js** for

* [Slides](https://revealjs.com/#/1)
* [HTML Transtions](https://revealjs.com/#/transitions)
* [Speaker Notes](https://revealjs.com/#/20)

it is easy to create a presentation with code examples in short time.

## Giter8 Template

Giter8 Template available under [https://github.com/sfxcode/paradox-reveal-template.g8](https://github.com/sfxcode/paradox-reveal-template.g8)

## Usage

Install plugin in project/plugins.sbt:


**addSbtPlugin("com.sfxcode.paradox" % "sbt-paradox-reveal" % "$project.version$")**

Enable Plugin in your build.sbt file:

**enablePlugins(ParadoxRevealPlugin)**

@@@ index

- [Start](getting_started.md)
- [Configuration](configuration.md)
- [Directives](directive/index.md)
- [Plugins](plugins/index.md)
- [includes](includes.md)
- [Demo](demo.md)

@@@
