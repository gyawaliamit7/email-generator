package com.gyawaliamit.spring.html.generator.builder.body;

import com.gyawaliamit.spring.html.generator.builder.body.tags.*;
import com.gyawaliamit.spring.html.generator.builder.body.tags.table.TableBuilder;
import com.gyawaliamit.spring.html.generator.builder.enums.Heading;
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
    private DivBuilder divBuilder;
    private List<HeadingBuilder> headingBuilder;
    private List<ParagraphBuilder> paragraphBuilder;
    private TableBuilder tableBuilder;
    private AhrefBuilder ahrefBuilder;

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
        this.divBuilder = divBuilder;
     //   return new BodyBuilder(content,titleBuilder);
        return null;
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
        return new BodyBuilder(content,bodyTags);
    }


    public BodyBuilder ahref(AhrefBuilder ahrefBuilder) {
        if(this.bodyTags  == null) {
            this.bodyTags = new LinkedList<>();
        }
        this.bodyTags.add(ahrefBuilder);
        return new BodyBuilder(content,bodyTags);
    }

    public BodyBuilder table(TableBuilder tableBuilder) {
        if(this.bodyTags  == null) {
            this.bodyTags = new LinkedList<>();
        }
        this.bodyTags.add(tableBuilder);
        return new BodyBuilder(content,bodyTags);
    }


}
