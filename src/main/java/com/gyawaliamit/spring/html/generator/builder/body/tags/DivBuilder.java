package com.gyawaliamit.spring.html.generator.builder.body.tags;

import com.gyawaliamit.spring.html.generator.builder.body.BodyTags;
import com.gyawaliamit.spring.html.generator.builder.body.tags.table.TableBuilder;
import com.gyawaliamit.spring.html.generator.enums.Heading;
import com.gyawaliamit.spring.html.generator.enums.Styles;
import com.gyawaliamit.spring.html.generator.builder.head.HeadBuilder;
import com.gyawaliamit.spring.html.generator.handler.StyleHandler;

import java.util.*;

public class DivBuilder implements BodyTags {

    private Queue<BodyTags> bodyTags;
    private StringBuilder content;
    private DivBuilder divBuilder;
    private List<HeadingBuilder> headingBuilder;
    private List<ParagraphBuilder> paragraphBuilder;
    private TableBuilder tableBuilder;
    private AhrefBuilder ahrefBuilder;
    private StyleHandler styleHandler;


    public DivBuilder(StringBuilder content, Queue<BodyTags> bodyTags, StyleHandler styleHandler) {
        this.bodyTags = bodyTags;
        this.content = content;
        this.styleHandler = styleHandler;
    }


    public static DivBuilder builder() {
        StyleHandler styleHandler = new StyleHandler();
        return new DivBuilder(new StringBuilder("<div>"), null,styleHandler);
    }


    public DivBuilder build() {
        for(BodyTags bodyTag : bodyTags) {
            content.append(bodyTag.getContent());
        }
        content.append("</div>");
        return this;

    }

    public DivBuilder div(DivBuilder divBuilder) {
        this.divBuilder = divBuilder;
        return this;
    }

    public DivBuilder heading(HeadBuilder headBuilder, Heading headingConstants) {
        this.headingBuilder = headingBuilder;
        return this;
    }

    public DivBuilder paragraph(ParagraphBuilder paragraphBuilder) {
        if(this.bodyTags  == null) {
            this.bodyTags = new LinkedList<>();
        }
        this.bodyTags.add(paragraphBuilder);
        return this;
    }


    public DivBuilder ahref(AhrefBuilder ahrefBuilder) {
        if(this.bodyTags  == null) {
            this.bodyTags = new LinkedList<>();
        }
        this.bodyTags.add(ahrefBuilder);
        return this;
    }

    public DivBuilder table(TableBuilder tableBuilder) {
        if(this.bodyTags  == null) {
            this.bodyTags = new LinkedList<>();
        }
        this.bodyTags.add(tableBuilder);
        return this;
    }


    public String getContent() {
        return content.toString();
    }


    public DivBuilder customStyle(String key, String value) {
        styleHandler.customStyles(key, value);
        return this;
    }


    public DivBuilder style(Styles style) {
        styleHandler.style(style);
        return this;
    }

}
