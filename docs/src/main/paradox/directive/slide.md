# Slide Directive

The basic of all presentations is the slide directive.

Basic example:

```
@@@ slide
# My Presentation
This Preasentation was made by Paradox and reveal.js
@@@
```

## Vertical Slides

Use Paradox default pattern for nesting slides.

```

@@@ slide

@@@@ slide
## Vertical Slides
Slides can be nested inside of each other.
@@@@

@@@

```

## Configuration Options

Slides can be configured by several configuration options. All options
are optional by default.

## Basic Configuration

* id
* class
* style

For
[internal navigation between slides](https://github.com/hakimel/reveal.js#internal-links)
use the id option.

```
@@@ slide { id=my-slide }
Slide with custom id
@@@
```

## Slide Transition

Every slide transition can be indivudual configured.

* transition (value can be: none, fade, slide, convex, concave, zoom)
* transitionSpeed (value can be: normal, slow, fast)

Example:
```
@@@ slide { transition=zoom transitionSpeed=fast }
Slide with custom transition
@@@

```

## Color Background

All CSS color formats are supported, including hex values, keywords, rgba() or hsl().

* color

```
{ color=#dddddd }
```

## Image Background

By default, background images are resized to cover the full page. Available options:


| Attribute        | Default    | Description |
| :----------------| :--------- | :---------- |
| image            |            | URL of the image to show. GIFs restart when the slide opens. |
| size             | cover      | See [background-size](https://developer.mozilla.org/docs/Web/CSS/background-size) on MDN.  |
| position         | center     | See [background-position](https://developer.mozilla.org/docs/Web/CSS/background-position) on MDN. |
| repeat           | no-repeat  | See [background-repeat](https://developer.mozilla.org/docs/Web/CSS/background-repeat) on MDN. |
| opacity          | 1          | Opacity of the background image on a 0-1 scale. 0 is transparent and 1 is fully opaque. |

Example:

```

@@@@ slide { repeat=true size=cover image='https://s3.amazonaws.com/hakim-static/reveal-js/image-placeholder.png' }
## Image Backgrounds
@@@@

```

## Video Background

Automatically plays a full size video behind the slide.

| Attribute  | Default | Description |
| :--------- | :------ | :---------- |
| video      |         | A single video source, or a comma separated list of video sources. |
| loop       | false   | Flags if the video should play repeatedly. |
| muted      | false   | Flags if the audio should be muted. |
| size       | cover   | Use `cover` for full screen and some cropping or `contain` for letterboxing. |
| opacity    | 1       | Opacity of the background video on a 0-1 scale. 0 is transparent and 1 is fully opaque. |

## Iframe Background

Embeds a web page as a slide background that covers 100% of the reveal.js width and height. The iframe is in the background layer, behind your slides, and as such it's not possible to interact with it by default. To make your background interactive, you can add interactive attribute.

| Attribute   | Default | Description |
| :--------   | :------ | :---------- |
| iframe      |         | A single video source, or a comma separated list of video sources. |
| interactive | false   | Flags if the video should play repeatedly. |

