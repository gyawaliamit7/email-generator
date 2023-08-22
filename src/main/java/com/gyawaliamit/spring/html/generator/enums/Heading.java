package com.gyawaliamit.spring.html.generator.enums;

public enum Heading {

    HEADING_1("h1"),
    HEADING_2("h2"),
    HEADING_3("h3"),
    HEADING_4("h4"),
    HEADING_5("h5"),
    HEADING_6("h6");

    private final String tag;

    private Heading(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }
}
