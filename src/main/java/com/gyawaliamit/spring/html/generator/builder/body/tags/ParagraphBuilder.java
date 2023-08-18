package com.gyawaliamit.spring.html.generator.builder.body.tags;

import com.gyawaliamit.spring.html.generator.builder.body.BodyTags;
import com.gyawaliamit.spring.html.generator.builder.enums.Styles;
import com.gyawaliamit.spring.html.generator.builder.util.StyleUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParagraphBuilder implements BodyTags {

    private StringBuilder content;
    private List<Styles> stylesList;
    private Map<String, String> customStyles;
    private String paragraphContent;


    public ParagraphBuilder(StringBuilder content) {
        this.content = content;
    }

    public ParagraphBuilder build() {
        this.content.append("<p ");
        StyleUtil.buildStyles(this.content,stylesList, customStyles);
        this.content.append(">");
        this.content.append(paragraphContent);
        this.content.append("</p>");
        return new ParagraphBuilder(content);
    }
    public static ParagraphBuilder builder() {
        return new ParagraphBuilder(new StringBuilder());
    }

    public ParagraphBuilder paragraph(String paragraph) {
        this.paragraphContent = paragraph;
        return this;

    }

    public String getContent() {
        return content.toString();
    }

    public ParagraphBuilder customStyle(String key, String value) {
        if(this.customStyles == null) {
            this.customStyles = new HashMap<>();
        }
        this.customStyles.put(key,value);
        return this;
    }


    public ParagraphBuilder style(Styles style) {
        if(this.stylesList == null) {
            this.stylesList = new ArrayList<>();
        }
        this.stylesList.add(style);
        return this;
    }
}
