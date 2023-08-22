package com.gyawaliamit.spring.html.generator.builder.body.tags;

import com.gyawaliamit.spring.html.generator.builder.body.BodyTags;
import com.gyawaliamit.spring.html.generator.constants.HtmlConstants;
import com.gyawaliamit.spring.html.generator.handler.AttributesHandler;
import com.gyawaliamit.spring.html.generator.handler.Handler;
import com.gyawaliamit.spring.html.generator.handler.StyleHandler;
import com.gyawaliamit.spring.html.generator.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class ImageBuilder implements BodyTags {
    private StringBuilder content;
    private Pair<String,String> urlPair;
    private Map<String, Handler> handlers;


    public ImageBuilder(StringBuilder content,Map<String, Handler> handler) {
        this.handlers = handler;
        this.content = content;
    }


    public ImageBuilder build() {
        this.content.append("<img src =\"").append(urlPair.getKey()).append("\" ");
        this.handlers.forEach((key,handler) -> {
            handler.handle(this.content);
        });
        this.content.append(">");
        return this;
    }



    public static ImageBuilder builder() {
        Map<String,Handler> handlers = new HashMap<>();
        handlers.put(HtmlConstants.STYLE, new StyleHandler());
        handlers.put(HtmlConstants.ATTRIBUTE, new AttributesHandler());
        return new ImageBuilder(new StringBuilder(),handlers);
    }

    public ImageBuilder src(String url,String info) {
        this.urlPair = new Pair<>(url,info);
        return this;
    }


    public String getContent() {
        return content.toString();
    }

    public ImageBuilder style(String key, String value) {
        Handler handler = this.handlers.get(HtmlConstants.STYLE);
        handler.addItem(key,value);
        return this;
    }

    public ImageBuilder attribute(String key, String value) {
        Handler handler = this.handlers.get(HtmlConstants.ATTRIBUTE);
        handler.addItem(key,value);
        return this;
    }
}
