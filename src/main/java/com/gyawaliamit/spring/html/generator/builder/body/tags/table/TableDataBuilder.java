package com.gyawaliamit.spring.html.generator.builder.body.tags.table;

import com.gyawaliamit.spring.html.generator.enums.Styles;
import com.gyawaliamit.spring.html.generator.handler.StyleHandler;

public class TableDataBuilder {
    private StringBuilder content;
    private String data;
    private StyleHandler styleHandler;


    public TableDataBuilder(StringBuilder content, StyleHandler styleHandler) {
        this.styleHandler = styleHandler;
        this.content = content;
    }

    public TableDataBuilder build() {
        this.content.append("<td ");
        styleHandler.buildStyles(this.content);
        this.content.append(">");
        this.content.append(data);
        this.content.append("</td>");
        return new TableDataBuilder(content, styleHandler);
    }
    public static TableDataBuilder builder() {
        StyleHandler styleHandler = new StyleHandler();
        return new TableDataBuilder(new StringBuilder(),styleHandler);
    }

    public TableDataBuilder data(String paragraph) {
        this.data = paragraph;
        return this;

    }

    public String getContent() {
        return content.toString();
    }

    public TableDataBuilder customStyle(String key, String value) {
        styleHandler.customStyles(key, value);
        return this;
    }


    public TableDataBuilder style(Styles style) {
        styleHandler.style(style);
        return this;
    }
}
