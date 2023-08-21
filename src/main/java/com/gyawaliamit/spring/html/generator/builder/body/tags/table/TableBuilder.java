package com.gyawaliamit.spring.html.generator.builder.body.tags.table;

import com.gyawaliamit.spring.html.generator.builder.body.BodyTags;
import com.gyawaliamit.spring.html.generator.enums.Styles;
import com.gyawaliamit.spring.html.generator.handler.StyleHandler;

import java.util.ArrayList;
import java.util.List;

public class TableBuilder implements BodyTags {

    private StringBuilder content;
    private List<TableRowBuilder> tableRowBuilderList;
    private StyleHandler styleHandler;
    private String border;


    public TableBuilder(StringBuilder content, StyleHandler styleHandler) {
        this.content = content;
        this.styleHandler = styleHandler;
    }

    public TableBuilder build() {
        this.content.append("<table ");
        if(this.border != null) {
            this.content.append("border=").append(border);
        }
        styleHandler.buildStyles(this.content);
        this.content.append(">");
//
        if(tableRowBuilderList != null) {
//            this.content.append(tableRowBuilderList.getContent());
            this.tableRowBuilderList.forEach(tableRowBuilder -> {
                this.content.append(tableRowBuilder.getContent());
            });
        }
        this.content.append("</table>");
        return new TableBuilder(content, styleHandler);
    }
    public static TableBuilder builder() {
        StyleHandler styleHandler = new StyleHandler();
        return new TableBuilder(new StringBuilder(), styleHandler);
    }

    public TableBuilder tableRow(TableRowBuilder tableRowBuilder) {
        if(this.tableRowBuilderList == null) {
            this.tableRowBuilderList = new ArrayList<>();
        }
        this.tableRowBuilderList.add(tableRowBuilder);
        return this;

    }

    public String getContent() {
        return content.toString();
    }


    public TableBuilder border(String border) {
        this.border = border;
        return this;
    }


    public TableBuilder customStyle(String key, String value) {
        styleHandler.customStyles(key, value);
        return this;
    }


    public TableBuilder style(Styles style) {
        styleHandler.style(style);
        return this;
    }
}
