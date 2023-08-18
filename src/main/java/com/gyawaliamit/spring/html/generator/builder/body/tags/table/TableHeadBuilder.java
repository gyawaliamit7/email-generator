package com.gyawaliamit.spring.html.generator.builder.body.tags.table;

import com.gyawaliamit.spring.html.generator.builder.enums.Styles;
import com.gyawaliamit.spring.html.generator.builder.util.StyleUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableHeadBuilder {
    private StringBuilder content;
    private List<Styles> stylesList;
    private Map<String, String> customStyles;
    private String data;


    public TableHeadBuilder(StringBuilder content) {
        this.content = content;
    }

    public TableHeadBuilder build() {
        this.content.append("<th ");
        StyleUtil.buildStyles(this.content,stylesList, customStyles);
        this.content.append(">");
        this.content.append(data);
        this.content.append("</th>");
        return new TableHeadBuilder(content);
    }
    public static TableHeadBuilder builder() {
        return new TableHeadBuilder(new StringBuilder());
    }

    public TableHeadBuilder data(String paragraph) {
        this.data = paragraph;
        return this;

    }

    public String getContent() {
        return content.toString();
    }

    public TableHeadBuilder customStyle(String key, String value) {
        if(this.customStyles == null) {
            this.customStyles = new HashMap<>();
        }
        this.customStyles.put(key,value);
        return this;
    }


    public TableHeadBuilder style(Styles style) {
        if(this.stylesList == null) {
            this.stylesList = new ArrayList<>();
        }
        this.stylesList.add(style);
        return this;
    }
}
