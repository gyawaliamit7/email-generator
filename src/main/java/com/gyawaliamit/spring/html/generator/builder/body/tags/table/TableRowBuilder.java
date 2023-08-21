package com.gyawaliamit.spring.html.generator.builder.body.tags.table;

import com.gyawaliamit.spring.html.generator.enums.Styles;
import com.gyawaliamit.spring.html.generator.handler.StyleHandler;

import java.util.ArrayList;
import java.util.List;

public class TableRowBuilder {
    private StringBuilder content;
    private List<TableHeadBuilder> tableHeadBuilderList;
    private List<TableDataBuilder> tableDataBuilderList;
    private StyleHandler styleHandler;


    public TableRowBuilder(StringBuilder content, StyleHandler styleHandler) {
        this.content = content;
        this.styleHandler = styleHandler;
    }

    public TableRowBuilder build() {
        this.content.append("<tr ");
        styleHandler.buildStyles(this.content);
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
        StyleHandler styleHandler = new StyleHandler();
        return new TableRowBuilder(new StringBuilder(),styleHandler);
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
        styleHandler.customStyles(key, value);
        return this;
    }


    public TableRowBuilder style(Styles style) {
        styleHandler.style(style);
        return this;
    }
}
