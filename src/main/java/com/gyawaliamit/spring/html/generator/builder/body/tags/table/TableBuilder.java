package com.gyawaliamit.spring.html.generator.builder.body.tags.table;

import com.gyawaliamit.spring.html.generator.builder.body.BodyTags;
import com.gyawaliamit.spring.html.generator.builder.body.tags.AhrefBuilder;
import com.gyawaliamit.spring.html.generator.constants.HtmlConstants;
import com.gyawaliamit.spring.html.generator.handler.AttributesHandler;
import com.gyawaliamit.spring.html.generator.handler.Handler;
import com.gyawaliamit.spring.html.generator.handler.StyleHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableBuilder implements BodyTags {

    private StringBuilder content;
    private List<TableRowBuilder> tableRowBuilderList;
    private Map<String, Handler> handlers;


    public TableBuilder(StringBuilder content,Map<String, Handler> handler) {
        this.content = content;
        this.handlers = handler;
    }

    public TableBuilder build() {
        this.content.append("<table ");
        this.handlers.forEach((key,handler) -> {
            handler.handle(this.content);
        });
        this.content.append(">");
//
        if(tableRowBuilderList != null) {
//            this.content.append(tableRowBuilderList.getContent());
            this.tableRowBuilderList.forEach(tableRowBuilder -> {
                this.content.append(tableRowBuilder.getContent());
            });
        }
        this.content.append("</table>");
        return this;
    }
    public static TableBuilder builder() {
        Map<String,Handler> handlers = new HashMap<>();
        handlers.put(HtmlConstants.STYLE, new StyleHandler());
        handlers.put(HtmlConstants.ATTRIBUTE, new AttributesHandler());
        return new TableBuilder(new StringBuilder(), handlers);
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

    public TableBuilder style(String key, String value) {
        Handler handler = this.handlers.get(HtmlConstants.STYLE);
        handler.addItem(key,value);
        return this;
    }

    public TableBuilder attribute(String key, String value) {
        Handler handler = this.handlers.get(HtmlConstants.ATTRIBUTE);
        handler.addItem(key,value);
        return this;
    }
}
