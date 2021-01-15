<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <meta name="generator" content="Paradox, Paradox-Reveal-Theme : $page.properties.("reveal.theme.version")$">

    $ if (page.properties.("description")) $
    <meta name="description" content="$page.properties.("description")$">
    $ elseif (page.properties.("project.description")) $
    <meta name="description" content="$page.properties.("project.description")$">
    $ endif $

    $ if (page.properties.("author")) $
    <meta name="author" content="$page.properties.("author")$">
    $ elseif (page.properties.("material.author")) $
    <meta name="author" content="$page.properties.("site.author")$">
    $ endif $

    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">


    <title>$page.properties.("title")$</title>

    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/reveal.css">
    <link rel="stylesheet" href="css/theme/$page.properties.("reveal.theme")$.css">

    <!-- Theme used for syntax highlighting of code -->
    <link rel="stylesheet" href="lib/css/monokai.css">

    $ if (page.properties.("reveal.custom.stylesheet")) $
    <link rel="stylesheet" href="$page.base$$page.properties.("reveal.custom.stylesheet")$">
    $ endif $

    <!-- Printing and PDF exports -->
    <script>
        var link = document.createElement( 'link' );
        link.rel = 'stylesheet';
        link.type = 'text/css';
        link.href = window.location.search.match( /print-pdf/gi ) ? 'css/print/pdf.css' : 'css/print/paper.css';
        document.getElementsByTagName( 'head' )[0].appendChild( link );
    </script>

    <!--[if lt IE 9]>
    <script src="../lib/js/html5shiv.js"></script>
    <![endif]-->
</head>
