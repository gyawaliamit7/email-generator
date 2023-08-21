package com.gyawaliamit.spring.html.generator.builder.body.tags;

import com.gyawaliamit.spring.html.generator.builder.body.BodyTags;
import com.gyawaliamit.spring.html.generator.enums.Styles;
import com.gyawaliamit.spring.html.generator.handler.StyleHandler;
import com.gyawaliamit.spring.html.generator.util.Pair;

public class AhrefBuilder implements BodyTags {

    private StringBuilder content;
    private Pair<String,String> urlPair;
    private StyleHandler styleHandler;


    public AhrefBuilder(StringBuilder content, StyleHandler styleHandler) {
        this.styleHandler = styleHandler;
        this.content = content;
    }


    public AhrefBuilder build() {
        this.content.append("<a href =\"").append(urlPair.getKey()).append("\" ");
        styleHandler.buildStyles(this.content);
        this.content.append(">");
        this.content.append(urlPair.getValue());
        this.content.append("</a>");
        return this;
    }



    public static AhrefBuilder builder() {
        StyleHandler styleHandler = new StyleHandler();
        return new AhrefBuilder(new StringBuilder(),styleHandler);
    }

    public AhrefBuilder ahref(String url,String info) {
        this.urlPair = new Pair<>(url,info);
        return this;
    }


    public String getContent() {
        return content.toString();
    }

    public AhrefBuilder customStyle(String key, String value) {
        styleHandler.customStyles(key, value);
        return this;
    }


    public AhrefBuilder style(Styles style) {
        styleHandler.style(style);
        return this;
    }
}
