package com.gyawaliamit.email.generator.builder.body;

import com.gyawaliamit.email.generator.builder.constant.HeadingConstants;
import com.gyawaliamit.email.generator.builder.head.HeadBuilder;
import com.gyawaliamit.email.generator.builder.head.TitleBuilder;

/**
 * this is the builder class to create Body Elements
 */
public class BodyBuilder {
    private StringBuilder content;
    private DivBuilder divBuilder;
    private HeadingBuilder headingBuilder;
    private ParagraphBuilder paragraphBuilder;
    private TableBuilder tableBuilder;
    private AhrefBuilder ahrefBuilder;

    public BodyBuilder(StringBuilder content) {
        this.content = content;
    }


    public static BodyBuilder builder() {
        return new BodyBuilder(new StringBuilder("<body>"));
    }

    public StringBuilder getContent() {
        return content;
    }


    public BodyBuilder build() {
        content.append("</body>");
        return null;

    }

    private BodyBuilder div(DivBuilder divBuilder) {
        this.divBuilder = divBuilder;
     //   return new BodyBuilder(content,titleBuilder);
        return null;
    }

    private BodyBuilder heading(HeadBuilder headBuilder, HeadingConstants headingConstants) {
        this.headingBuilder = headingBuilder;
        return null;
    }

    private BodyBuilder paragraph(ParagraphBuilder paragraphBuilder) {
        this.paragraphBuilder = paragraphBuilder;
        return null;
    }

    private TableBuilder table(TableBuilder tableBuilder) {
        this.tableBuilder = tableBuilder;
        return null;
    }

    private AhrefBuilder ahref(AhrefBuilder ahrefBuilder) {
        this.ahrefBuilder = ahrefBuilder;
        return null;
    }


}
