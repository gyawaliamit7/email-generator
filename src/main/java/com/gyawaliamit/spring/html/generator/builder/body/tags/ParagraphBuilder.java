package com.gyawaliamit.spring.html.generator.builder.body.tags;

import com.gyawaliamit.spring.html.generator.builder.body.BodyTags;
import com.gyawaliamit.spring.html.generator.constants.HtmlConstants;
import com.gyawaliamit.spring.html.generator.handler.AttributesHandler;
import com.gyawaliamit.spring.html.generator.handler.Handler;
import com.gyawaliamit.spring.html.generator.handler.StyleHandler;

import java.util.HashMap;
import java.util.Map;

public class ParagraphBuilder implements BodyTags {

    private StringBuilder content;
    private String paragraphContent;
    private Map<String, Handler> handlers;

    public ParagraphBuilder(StringBuilder content, Map<String, Handler> handler) {
        this.handlers = handler;
        this.content = content;
    }

    public ParagraphBuilder build() {
        this.content.append("<p ");
        this.handlers.forEach((key,handler) -> {
            handler.handle(this.content);
        });
        this.content.append(">");
        this.content.append(paragraphContent);
        this.content.append("</p>");
        return this;
    }
    public static ParagraphBuilder builder() {
        Map<String,Handler> handlers = new HashMap<>();
        handlers.put(HtmlConstants.STYLE, new StyleHandler());
        handlers.put(HtmlConstants.ATTRIBUTE, new AttributesHandler());
        return new ParagraphBuilder(new StringBuilder(), handlers);
    }

    public ParagraphBuilder paragraph(String paragraph) {
        this.paragraphContent = paragraph;
        return this;

    }

    public String getContent() {
        return content.toString();
    }

    public ParagraphBuilder style(String key, String value) {
        Handler handler = this.handlers.get(HtmlConstants.STYLE);
        handler.addItem(key,value);
        return this;
    }

    public ParagraphBuilder attribute(String key, String value) {
        Handler handler = this.handlers.get(HtmlConstants.ATTRIBUTE);
        handler.addItem(key,value);
        return this;
    }
}
