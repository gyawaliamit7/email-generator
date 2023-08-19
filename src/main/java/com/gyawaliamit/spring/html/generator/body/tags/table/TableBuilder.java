package com.gyawaliamit.spring.html.generator.builder.body.tags.table;

import com.gyawaliamit.spring.html.generator.builder.body.BodyTags;
import com.gyawaliamit.spring.html.generator.builder.enums.Styles;
import com.gyawaliamit.spring.html.generator.builder.util.StyleUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableBuilder implements BodyTags {

    private StringBuilder content;
    private List<Styles> stylesList;
    private Map<String, String> customStyles;
    private List<TableRowBuilder> tableRowBuilderList;
    private String border;


    public TableBuilder(StringBuilder content) {
        this.content = content;
    }

    public TableBuilder build() {
        this.content.append("<table ");
        if(this.border != null) {
            this.content.append("border=").append(border);
        }
        StyleUtil.buildStyles(this.content,stylesList, customStyles);
        this.content.append(">");
//
        if(tableRowBuilderList != null) {
//            this.content.append(tableRowBuilderList.getContent());
            this.tableRowBuilderList.forEach(tableRowBuilder -> {
                this.content.append(tableRowBuilder.getContent());
            });
        }
        this.content.append("</table>");
        return new TableBuilder(content);
    }
    public static TableBuilder builder() {
        return new TableBuilder(new StringBuilder());
    }

    public TableBuilder tableRow(TableRowBuilder tableRowBuilder) {
        if(this.tableRowBuilderList == null) {
            this.tableRowBuilderList = new ArrayList<>();
        }
        this.tableRowBuilderList.add(tableRowBuilder);
        return this;

    }

    public String getContent() {
        return content.toString();
    }

    public TableBuilder customStyle(String key, String value) {
        if(this.customStyles == null) {
            this.customStyles = new HashMap<>();
        }
        this.customStyles.put(key,value);
        return this;
    }

    public TableBuilder border(String border) {
        this.border = border;
        return this;
    }


    public TableBuilder style(Styles style) {
        if(this.stylesList == null) {
            this.stylesList = new ArrayList<>();
        }
        this.stylesList.add(style);
        return this;
    }
}
