package com.gyawaliamit.spring.html.generator.builder.body.tags;

import com.gyawaliamit.spring.html.generator.builder.body.BodyTags;
import com.gyawaliamit.spring.html.generator.enums.Styles;
import com.gyawaliamit.spring.html.generator.handler.StyleHandler;

public class ParagraphBuilder implements BodyTags {

    private StringBuilder content;
    private String paragraphContent;
    private StyleHandler styleHandler;

    public ParagraphBuilder(StringBuilder content, StyleHandler styleHandler) {
        this.styleHandler = styleHandler;
        this.content = content;
    }

    public ParagraphBuilder build() {
        this.content.append("<p ");
        styleHandler.buildStyles(this.content);
        this.content.append(">");
        this.content.append(paragraphContent);
        this.content.append("</p>");
        return new ParagraphBuilder(content, styleHandler);
    }
    public static ParagraphBuilder builder() {
        StyleHandler styleHandler = new StyleHandler();
        return new ParagraphBuilder(new StringBuilder(), styleHandler);
    }

    public ParagraphBuilder paragraph(String paragraph) {
        this.paragraphContent = paragraph;
        return this;

    }

    public String getContent() {
        return content.toString();
    }


    public ParagraphBuilder customStyle(String key, String value) {
        styleHandler.customStyles(key, value);
        return this;
    }


    public ParagraphBuilder style(Styles style) {
        styleHandler.style(style);
        return this;
    }
}
