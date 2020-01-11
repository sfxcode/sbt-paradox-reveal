@@@ slide
## Math Functions

```scala
Compile / paradoxRevealTheme ~= {
  _.withTheme(ParadoxRevealTheme.ThemeSky)
    .withDefaultTransition(ParadoxRevealTheme.TransitionFade)
    .withMathPlugin
}
```

```raw

\[\mathbf{V}_1 \times \mathbf{V}_2 =  \begin{vmatrix}
\mathbf{i} &amp; \mathbf{j} &amp; \mathbf{k} \\
\frac{\partial X}{\partial u} &amp;  \frac{\partial Y}{\partial u} &amp; 0 \\
\frac{\partial X}{\partial v} &amp;  \frac{\partial Y}{\partial v} &amp; 0
\end{vmatrix}  \]
```

@@@


