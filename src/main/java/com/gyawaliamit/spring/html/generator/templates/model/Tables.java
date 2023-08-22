package com.gyawaliamit.spring.html.generator.templates.model;

import java.util.List;

public class Tables {

    private List<String> tableHeads;
    private List<List<String>> tableData;

    public List<String> getTableHeads() {
        return tableHeads;
    }

    public void setTableHeads(List<String> tableHeads) {
        this.tableHeads = tableHeads;
    }

    public List<List<String>> getTableData() {
        return tableData;
    }

    public void setTableData(List<List<String>> tableData) {
        this.tableData = tableData;
    }
}
