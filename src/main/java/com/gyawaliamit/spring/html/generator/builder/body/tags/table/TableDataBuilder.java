package com.gyawaliamit.spring.html.generator.builder.body.tags.table;

import com.gyawaliamit.spring.html.generator.builder.body.BodyTags;
import com.gyawaliamit.spring.html.generator.builder.body.tags.AhrefBuilder;
import com.gyawaliamit.spring.html.generator.builder.body.tags.HeadingBuilder;
import com.gyawaliamit.spring.html.generator.builder.body.tags.ImageBuilder;
import com.gyawaliamit.spring.html.generator.builder.body.tags.ParagraphBuilder;
import com.gyawaliamit.spring.html.generator.builder.head.HeadBuilder;
import com.gyawaliamit.spring.html.generator.constants.HtmlConstants;
import com.gyawaliamit.spring.html.generator.handler.AttributesHandler;
import com.gyawaliamit.spring.html.generator.handler.Handler;
import com.gyawaliamit.spring.html.generator.handler.StyleHandler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TableDataBuilder {
    private StringBuilder content;
    private String data;
    private Map<String, Handler> handlers;
    private Queue<BodyTags> bodyTags;


    public TableDataBuilder(StringBuilder content, Map<String, Handler> handler) {
        this.handlers = handler;
        this.content = content;
    }

    public TableDataBuilder build() {
        this.content.append("<td ");
        this.handlers.forEach((key,handler) -> {
            handler.handle(this.content);
        });
        this.content.append(">");
        if(bodyTags != null) {
            for (BodyTags bodyTag : bodyTags) {
                content.append(bodyTag.getContent());
            }
        }
        if(this.data != null) {
            this.content.append(data);
        }
        this.content.append("</td>");
        return this;
    }
    public static TableDataBuilder builder() {
        Map<String,Handler> handlers = new HashMap<>();
        handlers.put(HtmlConstants.STYLE, new StyleHandler());
        handlers.put(HtmlConstants.ATTRIBUTE, new AttributesHandler());
        return new TableDataBuilder(new StringBuilder(),handlers);
    }

    public TableDataBuilder data(String paragraph) {
        this.data = paragraph;
        return this;

    }

    public String getContent() {
        return content.toString();
    }

    public TableDataBuilder style(String key, String value) {
        Handler handler = this.handlers.get(HtmlConstants.STYLE);
        handler.addItem(key,value);
        return this;
    }

    public TableDataBuilder attribute(String key, String value) {
        Handler handler = this.handlers.get(HtmlConstants.ATTRIBUTE);
        handler.addItem(key,value);
        return this;
    }

    public TableDataBuilder image(ImageBuilder imageBuilder) {
        if(this.bodyTags  == null) {
            this.bodyTags = new LinkedList<>();
        }
        this.bodyTags.add(imageBuilder);
        return this;
    }

    public TableDataBuilder heading(HeadingBuilder headingBuilder) {
        if(this.bodyTags  == null) {
            this.bodyTags = new LinkedList<>();
        }
        this.bodyTags.add(headingBuilder);
        return this;
    }

    public TableDataBuilder paragraph(ParagraphBuilder paragraphBuilder) {
        if(this.bodyTags  == null) {
            this.bodyTags = new LinkedList<>();
        }
        this.bodyTags.add(paragraphBuilder);
        return this;
    }

    public TableDataBuilder ahref(AhrefBuilder ahrefBuilder) {
        if(this.bodyTags  == null) {
            this.bodyTags = new LinkedList<>();
        }
        this.bodyTags.add(ahrefBuilder);
        return this;
    }

    public TableDataBuilder table(TableBuilder tableBuilder) {
        if(this.bodyTags  == null) {
            this.bodyTags = new LinkedList<>();
        }
        this.bodyTags.add(tableBuilder);
        return this;
    }
}
