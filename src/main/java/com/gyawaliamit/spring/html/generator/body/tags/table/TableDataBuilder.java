package com.gyawaliamit.spring.html.generator.builder.body.tags.table;

import com.gyawaliamit.spring.html.generator.builder.enums.Styles;
import com.gyawaliamit.spring.html.generator.builder.util.StyleUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableDataBuilder {
    private StringBuilder content;
    private List<Styles> stylesList;
    private Map<String, String> customStyles;
    private String data;


    public TableDataBuilder(StringBuilder content) {
        this.content = content;
    }

    public TableDataBuilder build() {
        this.content.append("<td ");
        StyleUtil.buildStyles(this.content,stylesList, customStyles);
        this.content.append(">");
        this.content.append(data);
        this.content.append("</td>");
        return new TableDataBuilder(content);
    }
    public static TableDataBuilder builder() {
        return new TableDataBuilder(new StringBuilder());
    }

    public TableDataBuilder data(String paragraph) {
        this.data = paragraph;
        return this;

    }

    public String getContent() {
        return content.toString();
    }

    public TableDataBuilder customStyle(String key, String value) {
        if(this.customStyles == null) {
            this.customStyles = new HashMap<>();
        }
        this.customStyles.put(key,value);
        return this;
    }


    public TableDataBuilder style(Styles style) {
        if(this.stylesList == null) {
            this.stylesList = new ArrayList<>();
        }
        this.stylesList.add(style);
        return this;
    }
}
