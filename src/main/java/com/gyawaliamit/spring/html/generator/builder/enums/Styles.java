package com.gyawaliamit.spring.html.generator.builder.enums;

public enum Styles {

    BOLD("font-weight: bold;"),
    ITALIC("font-style: italic;"),
    UNDERLINE("text-decoration: underline;"),
    STRIKETHROUGH("text-decoration: line-through;"),

    FONT_SIZE_LARGE("font-size: large;"),
    FONT_SIZE_SMALL("font-size: small;"),

    TEXT_CENTER("text-align: center;"),
    TEXT_RIGHT("text-align: right;"),
    TEXT_SHADOW("text-shadow: 2px 2px 4px #000000;"),

    BORDER("border: 1px solid black;"),
    OPACITY_HALF("opacity: 0.5;"),

    BACKGROUND_ORANGE("background-color: orange;"),
    BACKGROUND_PURPLE("background-color: purple;"),
    BACKGROUND_PINK("background-color: pink;"),
    BACKGROUND_CYAN("background-color: cyan;"),
    BACKGROUND_GRAY("background-color: gray;"),
    BACKGROUND_YELLOW("background-color: yellow;"),
    BACKGROUND_GREEN("background-color: green;"),

    COLOR_YELLOW("color: yellow;"),
    COLOR_GREEN("color: green;"),
    COLOR_PURPLE("color: purple;"),
    COLOR_PINK("color: pink;"),
    COLOR_CYAN("color: cyan;"),
    COLOR_RED("color: red;"),
    COLOR_BLUE("color: blue;");


    private String css;

    Styles(String css) {
        this.css = css;
    }

    public String getCss() {
        return css;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
