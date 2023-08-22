package com.gyawaliamit.spring.html.generator.builder.body.tags.table;

import com.gyawaliamit.spring.html.generator.constants.HtmlConstants;
import com.gyawaliamit.spring.html.generator.handler.AttributesHandler;
import com.gyawaliamit.spring.html.generator.handler.Handler;
import com.gyawaliamit.spring.html.generator.handler.StyleHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableRowBuilder {
    private StringBuilder content;
    private List<TableHeadBuilder> tableHeadBuilderList;
    private List<TableDataBuilder> tableDataBuilderList;
    private Map<String, Handler> handlers;


    public TableRowBuilder(StringBuilder content, Map<String, Handler> handler) {
        this.content = content;
        this.handlers = handler;
    }

    public TableRowBuilder build() {
        this.content.append("<tr ");
        this.handlers.forEach((key,handler) -> {
            handler.handle(this.content);
        });
        this.content.append(">");
        if(tableHeadBuilderList != null) {
            tableHeadBuilderList.stream().forEach(tableHeadBuilder -> this.content.append(tableHeadBuilder.getContent()));
        }
        if(tableDataBuilderList != null){
            tableDataBuilderList.forEach(tableDataBuilder -> this.content.append(tableDataBuilder.getContent()));
        }
        this.content.append("</tr>");
        return this;
    }
    public static TableRowBuilder builder() {
        Map<String,Handler> handlers = new HashMap<>();
        handlers.put(HtmlConstants.STYLE, new StyleHandler());
        handlers.put(HtmlConstants.ATTRIBUTE, new AttributesHandler());
        return new TableRowBuilder(new StringBuilder(),handlers);
    }

    public TableRowBuilder tableHeader(TableHeadBuilder tableHeadBuilder) {
        if(this.tableHeadBuilderList == null) {
            this.tableHeadBuilderList = new ArrayList<>();
        }
        this.tableHeadBuilderList.add(tableHeadBuilder);
        return this;
    }

    public TableRowBuilder tableData(TableDataBuilder tableDataBuilder) {
        if(this.tableDataBuilderList == null) {
            this.tableDataBuilderList = new ArrayList<>();
        }
        this.tableDataBuilderList.add(tableDataBuilder);
        return this;
    }

    public String getContent() {
        return content.toString();
    }


    public TableRowBuilder style(String key, String value) {
        Handler handler = this.handlers.get(HtmlConstants.STYLE);
        handler.addItem(key,value);
        return this;
    }

    public TableRowBuilder attribute(String key, String value) {
        Handler handler = this.handlers.get(HtmlConstants.ATTRIBUTE);
        handler.addItem(key,value);
        return this;
    }
}
