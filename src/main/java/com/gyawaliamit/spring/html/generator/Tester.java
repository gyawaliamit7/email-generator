package com.gyawaliamit.spring.html.generator;

import com.gyawaliamit.spring.html.generator.body.BodyBuilder;
import com.gyawaliamit.spring.html.generator.body.tags.AhrefBuilder;
import com.gyawaliamit.spring.html.generator.body.tags.ParagraphBuilder;
import com.gyawaliamit.spring.html.generator.body.tags.table.TableBuilder;
import com.gyawaliamit.spring.html.generator.body.tags.table.TableDataBuilder;
import com.gyawaliamit.spring.html.generator.body.tags.table.TableHeadBuilder;
import com.gyawaliamit.spring.html.generator.body.tags.table.TableRowBuilder;
import com.gyawaliamit.spring.html.generator.enums.Styles;
import com.gyawaliamit.spring.html.generator.head.HeadBuilder;
import com.gyawaliamit.spring.html.generator.head.TitleBuilder;

public class Tester {

    public static void main(String[] args) {

        String htmlContent = HtmlBuilder
                .builder()
                .head(HeadBuilder
                        .builder()
                        .title(TitleBuilder.builder().title("Hello World").build())
                        .build())
                .body(BodyBuilder.builder()
                        .paragraph(ParagraphBuilder.builder().
                                paragraph("This is just a first paragraph")
                                .style(Styles.COLOR_RED)
                                .style(Styles.TEXT_CENTER)
                                .customStyle("font-size", "18px")
                                .build())
                        .ahref(AhrefBuilder.builder()
                                .ahref("https://www.tutorialspoint.com/online_html_editor.php", "Test Link 1")
                                .build())
                        .paragraph(ParagraphBuilder.builder().paragraph("This is just a second paragraph").build())
                        .ahref(AhrefBuilder.builder()
                                .ahref("https://www.tutorialspoint.com/online_html_editor2.php", "Test Link 2")
                                .style(Styles.COLOR_RED)
                                .style(Styles.TEXT_CENTER)
                                .customStyle("font-size", "18px")
                                .build())
                        .table(TableBuilder.builder()
                                .customStyle("border-collapse", "collapse")
                                .customStyle("width", "80%")
                                .customStyle("margin", "auto")
                                .customStyle("border-radius", "8px")
                                .customStyle("overflow", "hidden")
                                .customStyle("box-shadow", "0 0 10px rgba(0, 0, 0, 0.2)")

                                .tableRow(TableRowBuilder.builder()
                                        .tableHeader(TableHeadBuilder.builder()
                                                .customStyle("padding", "15px")
                                                .customStyle("text-align", "center")
                                                .customStyle("background-color", "#333")
                                                .customStyle("color", "#fff")
                                                .data("Title 1").build())

                                        .tableHeader(TableHeadBuilder.builder()
                                                .customStyle("padding", "15px")
                                                .customStyle("text-align", "center")
                                                .customStyle("background-color", "#333")
                                                .customStyle("color", "#fff")
                                                .data("Title 2").build())
                                        .tableHeader(TableHeadBuilder.builder()
                                                .customStyle("padding", "15px")
                                                .customStyle("text-align", "center")
                                                .customStyle("background-color", "#333")
                                                .customStyle("color", "#fff")
                                                .data("Title 3").build())
                                        .build())
                                .tableRow(TableRowBuilder.builder()
                                        .customStyle("background-color", "#f2f2f2")
                                        .customStyle("padding", "15px")
                                        .customStyle("text-align", "center")
                                        .tableData(TableDataBuilder.builder().data("testData1").build())
                                        .tableData(TableDataBuilder.builder().data("testData2").build())
                                        .tableData(TableDataBuilder.builder().data("testData3").build())
                                        .build())
                                .tableRow(TableRowBuilder.builder()
                                        .customStyle("background-color", "#f2f2f2")
                                        .tableData(TableDataBuilder.builder().data("testData1").build())
                                        .tableData(TableDataBuilder.builder().data("testData2").build())
                                        .customStyle("padding", "15px")
                                        .customStyle("text-align", "center")
                                        .tableData(TableDataBuilder.builder().data("testData3").build())
                                        .build())
                                .tableRow(TableRowBuilder.builder()
                                        .tableData(TableDataBuilder.builder().data("testData1").build())
                                        .tableData(TableDataBuilder.builder().data("testData2").build())
                                        .customStyle("padding", "15px")
                                        .customStyle("text-align", "center")
                                        .tableData(TableDataBuilder.builder().data("testData3").build())
                                        .build())
                                .tableRow(TableRowBuilder.builder()
                                        .tableData(TableDataBuilder.builder().data("testData1").build())
                                        .tableData(TableDataBuilder.builder().data("testData2").build())
                                        .customStyle("padding", "15px")
                                        .customStyle("text-align", "center")
                                        .tableData(TableDataBuilder.builder().data("testData3").build())
                                        .build())
                                .build())
                        .build())
                .build();
    }
}
