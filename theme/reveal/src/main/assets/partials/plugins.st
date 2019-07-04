<script>
    // More info about config & dependencies:
    // - https://github.com/hakimel/reveal.js#configuration
    // - https://github.com/hakimel/reveal.js#dependencies
    Reveal.initialize({
        transition: '$page.properties.("reveal.default.transition")$',
        dependencies: [
            { src: 'plugin/search/search.js', async: true },
            { src: 'plugin/zoom-js/zoom.js', async: true },
            { src: 'plugin/notes/notes.js', async: true },
            $ if (page.properties.("reveal.plugin.math")) $
             { src: '../../plugin/math/math.js', async: true },
            $ endif $
            { src: 'plugin/highlight/highlight.js', async: true }
        ]
    });
</script>