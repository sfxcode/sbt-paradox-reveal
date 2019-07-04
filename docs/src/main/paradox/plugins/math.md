# Math Plugin

## Configuration

Use **withMathPlugin** in build.sbt


```scala
    Compile / paradoxRevealTheme ~= {
      _.withTheme(ParadoxRevealTheme.ThemeSky)
        .withMathPlugin
    }
```

### Markdown Usage

@@snip [example.log](../snippets/math.txt) { type=text }