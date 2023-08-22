package com.gyawaliamit.spring.html.generator.builder.body.tags;

import com.gyawaliamit.spring.html.generator.builder.body.BodyTags;
import com.gyawaliamit.spring.html.generator.constants.HtmlConstants;
import com.gyawaliamit.spring.html.generator.handler.AttributesHandler;
import com.gyawaliamit.spring.html.generator.handler.Handler;
import com.gyawaliamit.spring.html.generator.handler.StyleHandler;
import com.gyawaliamit.spring.html.generator.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class AhrefBuilder implements BodyTags {

    private StringBuilder content;
    private Pair<String,String> urlPair;
    private Map<String, Handler> handlers;


    public AhrefBuilder(StringBuilder content,Map<String, Handler> handler) {
        this.handlers = handler;
        this.content = content;
    }


    public AhrefBuilder build() {
        this.content.append("<a href =\"").append(urlPair.getKey()).append("\" ");
        this.handlers.forEach((key,handler) -> {
            handler.handle(this.content);
        });
        this.content.append(">");
        this.content.append(urlPair.getValue());
        this.content.append("</a>");
        return this;
    }



    public static AhrefBuilder builder() {
        Map<String,Handler> handlers = new HashMap<>();
        handlers.put(HtmlConstants.STYLE, new StyleHandler());
        handlers.put(HtmlConstants.ATTRIBUTE, new AttributesHandler());
        return new AhrefBuilder(new StringBuilder(),handlers);
    }

    public AhrefBuilder ahref(String url,String info) {
        this.urlPair = new Pair<>(url,info);
        return this;
    }


    public String getContent() {
        return content.toString();
    }

    public AhrefBuilder style(String key, String value) {
        Handler handler = this.handlers.get(HtmlConstants.STYLE);
        handler.addItem(key,value);
        return this;
    }

    public AhrefBuilder attribute(String key, String value) {
        Handler handler = this.handlers.get(HtmlConstants.ATTRIBUTE);
        handler.addItem(key,value);
        return this;
    }
}
