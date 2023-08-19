package com.gyawaliamit.spring.html.generator.builder;

import com.gyawaliamit.spring.html.generator.builder.body.BodyBuilder;
import com.gyawaliamit.spring.html.generator.builder.head.HeadBuilder;

public class HtmlBuilder {

    private StringBuilder content;
    private HeadBuilder headBuilder;
    private BodyBuilder bodyBuilder;


    public HtmlBuilder(StringBuilder content, HeadBuilder headBuilder, BodyBuilder bodyBuilder) {
        this.content = content;
        this.headBuilder = headBuilder;
        this.bodyBuilder =bodyBuilder;
    }

    public static HtmlBuilder builder() {
        return new HtmlBuilder(new StringBuilder("<!DOCTYPE html> <html>"),null, null);
    }

    public String build() {
        if(headBuilder != null && headBuilder.getContent() != null) {
            content.append(headBuilder.getContent());
        }
        if(bodyBuilder != null && bodyBuilder.getContent() != null) {
            content.append(bodyBuilder.getContent());
        }
        content.append("</html>");
        return content.toString();
    }




    public HtmlBuilder head(HeadBuilder headBuilder) {
        this.headBuilder = headBuilder;
        return this;
    }

    public HtmlBuilder body(BodyBuilder bodyBuilder) {
        this.bodyBuilder = bodyBuilder;
        return this;
    }




}
