package com.gyawaliamit.spring.html.generator.builder.body.tags.table;

import com.gyawaliamit.spring.html.generator.builder.body.tags.AhrefBuilder;
import com.gyawaliamit.spring.html.generator.constants.HtmlConstants;
import com.gyawaliamit.spring.html.generator.handler.AttributesHandler;
import com.gyawaliamit.spring.html.generator.handler.Handler;
import com.gyawaliamit.spring.html.generator.handler.StyleHandler;

import java.util.HashMap;
import java.util.Map;

public class TableHeadBuilder {
    private StringBuilder content;
    private Map<String, Handler> handlers;
    private String data;


    public TableHeadBuilder(StringBuilder content, Map<String, Handler> handler) {
        this.content = content;
        this.handlers = handler;
    }

    public TableHeadBuilder build() {
        this.content.append("<th ");
        this.handlers.forEach((key,handler) -> {
            handler.handle(this.content);
        });
        this.content.append(">");
        this.content.append(data);
        this.content.append("</th>");
        return this;
    }
    public static TableHeadBuilder builder() {
        Map<String,Handler> handlers = new HashMap<>();
        handlers.put(HtmlConstants.STYLE, new StyleHandler());
        handlers.put(HtmlConstants.ATTRIBUTE, new AttributesHandler());
        return new TableHeadBuilder(new StringBuilder(),handlers);
    }

    public TableHeadBuilder data(String data) {
        this.data = data;
        return this;

    }

    public String getContent() {
        return content.toString();
    }
    public TableHeadBuilder style(String key, String value) {
        Handler handler = this.handlers.get(HtmlConstants.STYLE);
        handler.addItem(key,value);
        return this;
    }

    public TableHeadBuilder attribute(String key, String value) {
        Handler handler = this.handlers.get(HtmlConstants.ATTRIBUTE);
        handler.addItem(key,value);
        return this;
    }
}
