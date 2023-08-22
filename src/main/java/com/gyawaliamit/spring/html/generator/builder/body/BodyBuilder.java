package com.gyawaliamit.spring.html.generator.builder.body;

import com.gyawaliamit.spring.html.generator.builder.body.tags.*;
import com.gyawaliamit.spring.html.generator.builder.body.tags.table.TableBuilder;
import com.gyawaliamit.spring.html.generator.enums.Heading;
import com.gyawaliamit.spring.html.generator.builder.head.HeadBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * this is the builder class to create Body Elements
 */
public class BodyBuilder {

    private Queue<BodyTags> bodyTags;
    private StringBuilder content;
    private List<HeadingBuilder> headingBuilder;

    public BodyBuilder(StringBuilder content, Queue<BodyTags> bodyTags) {
        this.bodyTags = bodyTags;
        this.content = content;
    }


    public static BodyBuilder builder() {
        return new BodyBuilder(new StringBuilder("<body>"), null);
    }

    public StringBuilder getContent() {
        return content;
    }


    public BodyBuilder build() {
        for(BodyTags bodyTag : bodyTags) {
            content.append(bodyTag.getContent());
        }
        content.append("</body>");
        return this;

    }

    public BodyBuilder div(DivBuilder divBuilder) {
        if(this.bodyTags == null) {
            this.bodyTags = new LinkedList<>();
        }
        this.bodyTags.add(divBuilder);
        return this;
    }

    public BodyBuilder heading(HeadBuilder headBuilder, Heading headingConstants) {
        this.headingBuilder = headingBuilder;
        return null;
    }

    public BodyBuilder paragraph(ParagraphBuilder paragraphBuilder) {
        if(this.bodyTags  == null) {
            this.bodyTags = new LinkedList<>();
        }
        this.bodyTags.add(paragraphBuilder);
        return this;
    }


    public BodyBuilder ahref(AhrefBuilder ahrefBuilder) {
        if(this.bodyTags  == null) {
            this.bodyTags = new LinkedList<>();
        }
        this.bodyTags.add(ahrefBuilder);
        return this;
    }

    public BodyBuilder table(TableBuilder tableBuilder) {
        if(this.bodyTags  == null) {
            this.bodyTags = new LinkedList<>();
        }
        this.bodyTags.add(tableBuilder);
        return this;
    }


}
