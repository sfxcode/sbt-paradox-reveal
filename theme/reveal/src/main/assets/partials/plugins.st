

<script src="js/reveal.js"></script>
<script src="plugin/zoom/zoom.js"></script>
<script src="plugin/notes/notes.js"></script>
<script src="plugin/search/search.js"></script>
<script src="plugin/highlight/highlight.js"></script>

<!-- Reveal-->

$ if (page.properties.("reveal.plugin.math")) $
<script src="../plugin/math/math.js"></script>
$ endif $

$ if (page.properties.("reveal.plugin.math")) $
<script>

    // Also available as an ES module, see:
    // https://revealjs.com/initialization/
    Reveal.initialize({
        transition: '$page.properties.("reveal.default.transition")$',
        controls: ('true' === '$page.properties.("reveal.default.controls")$'),
        progress: ('true' === '$page.properties.("reveal.default.progress")$'),
        center: ('true' === '$page.properties.("reveal.default.center")$'),
        hash: ('true' === '$page.properties.("reveal.default.hash")$'),

            math: {
                // mathjax: 'https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.0/MathJax.js',
                config: 'TeX-AMS_HTML-full',
                    TeX: {
                    Macros: {
                        R: '\\mathbb{R}',
                            set: [ '\\left\\{#1 \\; ; \\; #2\\right\\}', 2 ]
                    }
                }
            },

        // Learn about plugins: https://revealjs.com/plugins/
        plugins: [ RevealZoom, RevealNotes, RevealSearch, RevealHighlight ,RevealMath]
    });

</script>
$ endif $

$ if (! page.properties.("reveal.plugin.math")) $
<script>

    // Also available as an ES module, see:
    // https://revealjs.com/initialization/
    Reveal.initialize({
        controls: true,
        progress: true,
        center: true,
        hash: true,

        // Learn about plugins: https://revealjs.com/plugins/
        plugins: [ RevealZoom, RevealNotes, RevealSearch, RevealHighlight]
    });

</script>
$ endif $


