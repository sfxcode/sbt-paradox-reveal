# Includes

If you like to partition your slides in seperate markdown files, you need to create an index directive.

Otherwise, you will see some kind of error like

```

[error] Unexpected top-level pages (pages that do no have a parent in the Table of Contents).
[error] If this is intentional, update the `paradoxRoots` sbt setting to reflect the new expected roots.
[error] Current ToC roots: [includes/code.html, index.html]

```

## Example

Example from the demo project:

```

@@@ index

- [backgrounds](../../../../demo/src/main/paradox/includes/backgrounds.md)
- [code](../../../../demo/src/main/paradox/includes/code.md)
- [fragments](../../../../demo/src/main/paradox/includes/fragments.md)
- [math](../../../../demo/src/main/paradox/includes/math.md)
- [quotes](../../../../demo/src/main/paradox/includes/quotes.md)
- [transitions](../../../../demo/src/main/paradox/includes/transitions.md)
- [vertical_slides](../../../../demo/src/main/paradox/includes/vertical_slides.md)

@@@



```
