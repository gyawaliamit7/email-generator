package com.gyawaliamit.spring.html.generator.builder.body.tags.table;

import com.gyawaliamit.spring.html.generator.builder.enums.Styles;
import com.gyawaliamit.spring.html.generator.builder.util.StyleUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableRowBuilder {
    private StringBuilder content;
    private List<Styles> stylesList;
    private Map<String, String> customStyles;
    private List<TableHeadBuilder> tableHeadBuilderList;
    private List<TableDataBuilder> tableDataBuilderList;


    public TableRowBuilder(StringBuilder content) {
        this.content = content;
    }

    public TableRowBuilder build() {
        this.content.append("<tr ");
        StyleUtil.buildStyles(this.content,stylesList, customStyles);
        this.content.append(">");
        if(tableHeadBuilderList != null) {
            tableHeadBuilderList.stream().forEach(tableHeadBuilder -> this.content.append(tableHeadBuilder.getContent()));
        }
        if(tableDataBuilderList != null){
            tableDataBuilderList.forEach(tableDataBuilder -> this.content.append(tableDataBuilder.getContent()));
        }
        this.content.append("</tr>");
        return this;
    }
    public static TableRowBuilder builder() {
        return new TableRowBuilder(new StringBuilder());
    }

    public TableRowBuilder tableHeader(TableHeadBuilder tableHeadBuilder) {
        if(this.tableHeadBuilderList == null) {
            this.tableHeadBuilderList = new ArrayList<>();
        }
        this.tableHeadBuilderList.add(tableHeadBuilder);
        return this;
    }

    public TableRowBuilder tableData(TableDataBuilder tableDataBuilder) {
        if(this.tableDataBuilderList == null) {
            this.tableDataBuilderList = new ArrayList<>();
        }
        this.tableDataBuilderList.add(tableDataBuilder);
        return this;
    }

    public String getContent() {
        return content.toString();
    }

    public TableRowBuilder customStyle(String key, String value) {
        if(this.customStyles == null) {
            this.customStyles = new HashMap<>();
        }
        this.customStyles.put(key,value);
        return this;
    }


    public TableRowBuilder style(Styles style) {
        if(this.stylesList == null) {
            this.stylesList = new ArrayList<>();
        }
        this.stylesList.add(style);
        return this;
    }
}
