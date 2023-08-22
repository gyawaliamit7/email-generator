package com.gyawaliamit.spring.html.generator.builder.body.tags;

import com.gyawaliamit.spring.html.generator.builder.body.BodyTags;
import com.gyawaliamit.spring.html.generator.builder.body.tags.table.TableBuilder;
import com.gyawaliamit.spring.html.generator.builder.body.tags.table.TableDataBuilder;
import com.gyawaliamit.spring.html.generator.constants.HtmlConstants;
import com.gyawaliamit.spring.html.generator.enums.Heading;
import com.gyawaliamit.spring.html.generator.builder.head.HeadBuilder;
import com.gyawaliamit.spring.html.generator.handler.AttributesHandler;
import com.gyawaliamit.spring.html.generator.handler.Handler;
import com.gyawaliamit.spring.html.generator.handler.StyleHandler;

import java.util.*;

public class DivBuilder implements BodyTags {

    private Queue<BodyTags> bodyTags;
    private StringBuilder content;
    private Map<String,Handler> handlers;
    private String divContent;



    public DivBuilder(StringBuilder content, Queue<BodyTags> bodyTags, Map<String, Handler> styleHandler) {
        this.bodyTags = bodyTags;
        this.content = content;
        this.handlers = styleHandler;
    }


    public static DivBuilder builder() {
        Map<String,Handler> handlers = new HashMap<>();
        handlers.put(HtmlConstants.STYLE, new StyleHandler());
        handlers.put(HtmlConstants.ATTRIBUTE, new AttributesHandler());
        return new DivBuilder(new StringBuilder(), null,handlers);
    }


    public DivBuilder build() {
        this.content.append("<div ");
        this.handlers.forEach((key,handler) -> {
            handler.handle(this.content);
        });
        this.content.append(">");

        if(bodyTags != null) {
            for (BodyTags bodyTag : bodyTags) {
                content.append(bodyTag.getContent());
            }
        }
        if (this.divContent != null) {
            content.append(this.divContent);
        }
        content.append("</div>");
        return this;

    }

    public DivBuilder div(DivBuilder divBuilder) {
        if(this.bodyTags  == null) {
            this.bodyTags = new LinkedList<>();
        }
        this.bodyTags.add(divBuilder);
        return this;
    }

    public DivBuilder heading(HeadingBuilder headingBuilder) {
        if(this.bodyTags  == null) {
            this.bodyTags = new LinkedList<>();
        }
        this.bodyTags.add(headingBuilder);
        return this;
    }

    public DivBuilder paragraph(ParagraphBuilder paragraphBuilder) {
        if(this.bodyTags  == null) {
            this.bodyTags = new LinkedList<>();
        }
        this.bodyTags.add(paragraphBuilder);
        return this;
    }

    public DivBuilder content(String content) {
        this.divContent = content;
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

    public DivBuilder image(ImageBuilder imageBuilder) {
        if(this.bodyTags  == null) {
            this.bodyTags = new LinkedList<>();
        }
        this.bodyTags.add(imageBuilder);
        return this;
    }


    public String getContent() {
        return content.toString();
    }


    public DivBuilder style(String key, String value) {
        Handler handler = this.handlers.get(HtmlConstants.STYLE);
        handler.addItem(key,value);
        return this;
    }

    public DivBuilder attribute(String key, String value) {
        Handler handler = this.handlers.get(HtmlConstants.ATTRIBUTE);
        handler.addItem(key,value);
        return this;
    }

    public DivBuilder paragraphList(List<ParagraphBuilder> paragraphBuilderList) {
        if(this.bodyTags  == null) {
            this.bodyTags = new LinkedList<>();
        }
        this.bodyTags.addAll(paragraphBuilderList);
        return this;
    }

    public DivBuilder divList(List<DivBuilder> divBuilder) {
        if(this.bodyTags  == null) {
            this.bodyTags = new LinkedList<>();
        }
        this.bodyTags.addAll(divBuilder);
        return this;
    }

}
