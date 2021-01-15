# Configuration

## SBT Configuration

You can alter theme and default slide transition in your build.sbt file.

@@snip [/build.sbt](/build.sbt) { #demo }

### Options

#### True by default

Example without controls:

```
.withControls(false)
```

* withControls
* withProgress
* withCenter
* withHash

#### Empty by default

* withCustomStylesheet
* withCustomJavaScript


### Themes

withTheme()

Example :
```
.withTheme(ThemeMoon)
```

Default ThemeBlack.

* ThemeBeige
* ThemeBlack
* ThemeBlood
* ThemeLeague
* ThemeMoon
* ThemeNight
* ThemeSerif
* ThemeSimple
* ThemeSkysk
* ThemeSolerized
* ThemeWhite

### Default Transitions

withDefaultTransition()

Example :
```
.withDefaultTransition(TransitionConvex)
```

Default TransitionSlide.

* TransitionNone
* TransitionFade
* TransitionSlide
* TransitionConvex
* TransitionConcave
* TransitionZoom

## Paradox Customization

Use Paradox patterns for additional options.

* [Templating](https://developer.lightbend.com/docs/paradox/current/customization/templating.html)
* [Variable Substitution](https://developer.lightbend.com/docs/paradox/current/variable-substitution.html)

## Reveal.js Customization

* [Custom Theming](https://github.com/hakimel/reveal.js/#theming)
* [Plugins](https://github.com/hakimel/reveal.js/#plugins)
