package com.gyawaliamit.spring.html.generator.builder.body;

import com.gyawaliamit.spring.html.generator.builder.body.tags.*;
import com.gyawaliamit.spring.html.generator.builder.body.tags.table.TableBuilder;
import com.gyawaliamit.spring.html.generator.constants.HtmlConstants;
import com.gyawaliamit.spring.html.generator.enums.Heading;
import com.gyawaliamit.spring.html.generator.builder.head.HeadBuilder;
import com.gyawaliamit.spring.html.generator.handler.AttributesHandler;
import com.gyawaliamit.spring.html.generator.handler.Handler;
import com.gyawaliamit.spring.html.generator.handler.StyleHandler;

import java.util.*;

/**
 * this is the builder class to create Body Elements
 */
public class BodyBuilder {

    private Queue<BodyTags> bodyTags;
    private StringBuilder content;
    private List<HeadingBuilder> headingBuilder;
    private Map<String, Handler> handlers;

    public BodyBuilder(StringBuilder content, Queue<BodyTags> bodyTags, Map<String, Handler> styleHandler) {
        this.bodyTags = bodyTags;
        this.content = content;
        this.handlers = styleHandler;

    }


    public static BodyBuilder builder() {
        Map<String,Handler> handlers = new HashMap<>();
        handlers.put(HtmlConstants.STYLE, new StyleHandler());
        handlers.put(HtmlConstants.ATTRIBUTE, new AttributesHandler());
        return new BodyBuilder(new StringBuilder(""), null,handlers);
    }

    public StringBuilder getContent() {
        return content;
    }


    public BodyBuilder build() {
        this.content.append("<body ");
        this.handlers.forEach((key,handler) -> {
            handler.handle(this.content);
        });
        this.content.append(">");

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

    public BodyBuilder style(String key, String value) {
        Handler handler = this.handlers.get(HtmlConstants.STYLE);
        handler.addItem(key,value);
        return this;
    }

    public BodyBuilder attribute(String key, String value) {
        Handler handler = this.handlers.get(HtmlConstants.ATTRIBUTE);
        handler.addItem(key,value);
        return this;
    }


}
