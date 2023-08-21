package com.gyawaliamit.spring.html.generator.builder.body.tags.table;

import com.gyawaliamit.spring.html.generator.enums.Styles;
import com.gyawaliamit.spring.html.generator.handler.StyleHandler;

public class TableHeadBuilder {
    private StringBuilder content;
    private StyleHandler styleHandler;
    private String data;


    public TableHeadBuilder(StringBuilder content, StyleHandler styleHandler) {
        this.content = content;
        this.styleHandler = styleHandler;
    }

    public TableHeadBuilder build() {
        this.content.append("<th ");
        styleHandler.buildStyles(this.content);
        this.content.append(">");
        this.content.append(data);
        this.content.append("</th>");
        return new TableHeadBuilder(content, styleHandler);
    }
    public static TableHeadBuilder builder() {
        StyleHandler styleHandler = new StyleHandler();
        return new TableHeadBuilder(new StringBuilder(),styleHandler);
    }

    public TableHeadBuilder data(String data) {
        this.data = data;
        return this;

    }

    public String getContent() {
        return content.toString();
    }

    public TableHeadBuilder customStyle(String key, String value) {
        styleHandler.customStyles(key, value);
        return this;
    }


    public TableHeadBuilder style(Styles style) {
        styleHandler.style(style);
        return this;
    }
}
