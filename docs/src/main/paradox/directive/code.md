# Code Directive

The basic of all presentations is the slide directive.

Basic example:

```
@@@ code { dataId='myDataId' title='Some Code' }
val a = 1
@@@
```

## Configuration Options

Code can be configured by several configuration options. All options
are optional by default.

## Basic Configuration

* id
* class
* style

For
[internal navigation between slides](https://github.com/hakimel/reveal.js#internal-links)
use the id option.

```
@@@ code { id=my-slide }
# Code 
@@@
```

## Slide Transition

Every slide transition can be indivudual configured.

* transition (value can be: none, fade, slide, convex, concave, zoom)
* transitionSpeed (value can be: normal, slow, fast)

Example:
```
@@@ code { transition=zoom transitionSpeed=fast }
# Code with custom transition
@@@

```

## Additional Attributes

| Attribute       | Default | Description                                                    |
|:----------------|:--------|:---------------------------------------------------------------|
| trim            | true    |                                                                |
| showLineNumbers | true    | Activate Line Numbers                                          |
| lineNumbers     |         | Render specif line numbers, set showLineNumbers always to true |
| title           |         | Render some Header information                                 |
| footerText      |         | Render some Footer information                                 |

