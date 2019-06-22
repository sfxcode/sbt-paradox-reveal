<!doctype html>
<html>
$partials/header()$

<body>
<div class="reveal">
    <div class="slides">
        $page.content$
    </div>
</div>

<script src="js/reveal.js"></script>

$partials/plugins()$

$ if (page.properties.("reveal.custom.javascript")) $
<script src="$page.base$$page.properties.("reveal.custom.javascript")$"></script>
$ endif $

</body>

</html>
