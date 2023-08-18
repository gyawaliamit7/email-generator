package com.gyawaliamit.email.generator.builder;

import com.gyawaliamit.email.generator.builder.body.BodyBuilder;
import com.gyawaliamit.email.generator.builder.head.HeadBuilder;

public class HtmlBuilder {

    private StringBuilder content;
    private HeadBuilder headBuilder;
    private BodyBuilder bodyBuilder;


    public HtmlBuilder(StringBuilder content, HeadBuilder headBuilder, BodyBuilder bodyBuilder) {
        this.content = content;
        this.headBuilder = headBuilder;
    }

    public static HtmlBuilder builder() {
        return new HtmlBuilder(new StringBuilder("<html>"),null, null);
    }

    public String build() {
        content.append(headBuilder.getContent())
                .append("</html>");
        return content.toString();
    }

    public HtmlBuilder head(HeadBuilder headBuilder) {
        this.headBuilder = headBuilder;
        return new HtmlBuilder(content,headBuilder,bodyBuilder);
    }

    public HtmlBuilder body(BodyBuilder bodyBuilder) {
        this.bodyBuilder = bodyBuilder;
        return new HtmlBuilder(content,headBuilder,bodyBuilder);
    }




}
