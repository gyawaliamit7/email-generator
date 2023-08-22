package com.gyawaliamit.spring.html.generator.builder.body.tags;

import com.gyawaliamit.spring.html.generator.builder.body.BodyTags;
import com.gyawaliamit.spring.html.generator.constants.HtmlConstants;
import com.gyawaliamit.spring.html.generator.enums.Heading;
import com.gyawaliamit.spring.html.generator.handler.AttributesHandler;
import com.gyawaliamit.spring.html.generator.handler.Handler;
import com.gyawaliamit.spring.html.generator.handler.StyleHandler;
import com.gyawaliamit.spring.html.generator.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class HeadingBuilder implements BodyTags {
    private StringBuilder content;
    private Pair<String,String> headingPair;
    private Map<String, Handler> handlers;


    public HeadingBuilder(StringBuilder content,Map<String, Handler> handler) {
        this.handlers = handler;
        this.content = content;
    }


    public HeadingBuilder build() {
        this.content.append("<").append(headingPair.getValue()).append(" ");
        this.handlers.forEach((key,handler) -> {
            handler.handle(this.content);
        });
        this.content.append(">");
        this.content.append(headingPair.getKey());
        this.content.append("</").append(headingPair.getValue()).append(">");
        return this;
    }



    public static HeadingBuilder builder() {
        Map<String,Handler> handlers = new HashMap<>();
        handlers.put(HtmlConstants.STYLE, new StyleHandler());
        handlers.put(HtmlConstants.ATTRIBUTE, new AttributesHandler());
        return new HeadingBuilder(new StringBuilder(),handlers);
    }

    public HeadingBuilder heading(String content, Heading heading) {
        this.headingPair = new Pair<>(content, heading.getTag());
        return this;
    }


    public String getContent() {
        return content.toString();
    }

    public HeadingBuilder style(String key, String value) {
        Handler handler = this.handlers.get(HtmlConstants.STYLE);
        handler.addItem(key,value);
        return this;
    }

    public HeadingBuilder attribute(String key, String value) {
        Handler handler = this.handlers.get(HtmlConstants.ATTRIBUTE);
        handler.addItem(key,value);
        return this;
    }
}
