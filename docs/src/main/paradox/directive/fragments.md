# Fragments Directive

Easy use of [reveal.js fragments](https://github.com/hakimel/reveal.js#fragments).

Each line can be used as

* Fragment line
* Fragment Parts in one line
* Fragment line with in and out transition


## Configuration

| Attribute      | Default    | Description                           |
|:---------------|:-----------|:--------------------------------------|
| transition     |            | line transition                       |
| index          |            | set data-fragment-index for each line |
| separator      | -=-        | used for fragment parts in one line   |
| partTransition | transition | line part transition                  |
| outTransition  |            | line with in and out transition       |

## Simple Example

```
@@@ slide
# Hello World
@@@@ fragments
Fragment1
Fragment2
@@@@
@@@
```

## Line Parts Example

```
@@@ slide
@@@@ fragments { transition=grow partTransition=fade-in }
Fragment
FragmentPart1 -=- FragmentPart2
@@@@
@@@
```

## In and Out  Example

```
@@@ slide
@@@@ fragments { transition=fade-in outTransition=fade-out }
Fragment
@@@@
@@@
```
