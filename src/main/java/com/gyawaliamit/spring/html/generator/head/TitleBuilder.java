package com.gyawaliamit.spring.html.generator.builder.head;

public class TitleBuilder {
    private StringBuilder content;

    public TitleBuilder(StringBuilder content) {
        this.content = content;
    }

    public TitleBuilder build() {
        this.content.append("</title>");
        return new TitleBuilder(content);
    }
    public static TitleBuilder builder() {
        return new TitleBuilder(new StringBuilder("<title>"));
    }

    public TitleBuilder title(String title) {
        this.content.append(title);
        return new TitleBuilder(content);

    }

    public StringBuilder getContent() {
        return content;
    }
}