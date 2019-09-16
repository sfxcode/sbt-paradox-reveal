# Getting Started

## Setup

Install plugin in project/plugins.sbt:


**addSbtPlugin("com.sfxcode.paradox" % "sbt-paradox-reveal" % "$project.version$")**

Enable Plugin in your build.sbt file:

**enablePlugins(ParadoxRevealPlugin)**

## Write markdown using reveal directives

```
@@@ slide
# My First Presentation
This Preasentation was made by Paradox and reveal.js
@@@
```

## Generating presentation

Call paradox in sbt which will generate the site in
target/paradox/site/main.