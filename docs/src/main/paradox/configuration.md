# Configuration

## SBT Configuration

You can alter theme and default slide transition in your build.sbt file.

```
Compile / paradoxRevealTheme ~= {
       _.withTheme(ParadoxRevealTheme.ThemeBlack)
        .withDefaultTransition(ParadoxRevealTheme.TransitionFade)
}

```

### Themes

* ThemeBeige
* ThemeBlack
* ThemeBlood
* ThemeLeague
* ThemeMoonm
* ThemeNight
* ThemeSerif
* ThemeSimple
* ThemeSkysk
* ThemeSolerized
* ThemeWhite

### Default Transitions

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
