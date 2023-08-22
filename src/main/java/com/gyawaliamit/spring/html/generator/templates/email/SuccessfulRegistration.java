package com.gyawaliamit.spring.html.generator.templates.email;

import com.gyawaliamit.spring.html.generator.builder.HtmlBuilder;
import com.gyawaliamit.spring.html.generator.builder.body.BodyBuilder;
import com.gyawaliamit.spring.html.generator.builder.body.tags.*;
import com.gyawaliamit.spring.html.generator.builder.body.tags.table.TableBuilder;
import com.gyawaliamit.spring.html.generator.builder.body.tags.table.TableDataBuilder;
import com.gyawaliamit.spring.html.generator.builder.body.tags.table.TableRowBuilder;
import com.gyawaliamit.spring.html.generator.builder.head.HeadBuilder;
import com.gyawaliamit.spring.html.generator.enums.Heading;

public class SuccessfulRegistration {


    public static void main(String[] args) {
        String htmlContent = HtmlBuilder
                .builder()
                .head(HeadBuilder
                        .builder()
                        .build())
                .body(BodyBuilder.builder().table(TableBuilder.builder()
                                .attribute("cellspacing", "0")
                                .attribute("cellpadding", "0")
                                .attribute("border", "0")
                                .attribute("width", "100%")
                                .tableRow(TableRowBuilder.builder()
                                        .tableData(TableDataBuilder.builder()
                                                .style("style", "background-color: #f4f4f4;")
                                                .table(TableBuilder.builder()
                                                        .attribute("align", "center")
                                                        .attribute("cellspacing", "0")
                                                        .attribute("cellpadding", "0")
                                                        .attribute("border", "0")
                                                        .attribute("width", "600")
                                                        .style("style", "background-color: #ffffff; border-radius: 5px; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);")
                                                        .tableRow(TableRowBuilder.builder()
                                                                .tableData(
                                                                        TableDataBuilder.builder()
                                                                                .attribute("align", "center")
                                                                                .style("style", "padding: 20px;")
                                                                                .image(ImageBuilder.builder()
                                                                                        .src("https://images.unsplash.com/photo-1563694983011-6f4d90358083?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=687&q=80", "image caption")
                                                                                        .attribute("alt", "main logo")
                                                                                        .attribute("width", "200")
                                                                                        .attribute("height", "auto")
                                                                                        .style("style", "display: block;")
                                                                                        .build())
                                                                                .heading(HeadingBuilder.builder()
                                                                                        .style("style", "color: #333;")
                                                                                        .heading("Welcome to our Community", Heading.HEADING_1)
                                                                                        .build())
                                                                                .paragraph(ParagraphBuilder.builder()
                                                                                        .style("style", "color: #555;")
                                                                                        .paragraph("Thank you for registering with us. Your account has been successfully created.")
                                                                                        .build())
                                                                                .paragraph(ParagraphBuilder.builder()
                                                                                        .style("style", "color: #555;")
                                                                                        .paragraph("To get started, please click the button below:")
                                                                                        .build())
                                                                                .ahref(AhrefBuilder.builder()
                                                                                        .style("style", "display: inline-block; padding: 10px 20px; background-color: #007bff; color: #fff; text-decoration: none; border-radius: 3px;")
                                                                                        .ahref("https://www.example.com", "Get Started")
                                                                                        .build())
                                                                                .paragraph(ParagraphBuilder.builder()
                                                                                        .style("style", "color: #555;")
                                                                                        .paragraph("If you have any questions or need assistance, feel free to contact us.")
                                                                                        .build())
                                                                                .paragraph(ParagraphBuilder.builder()
                                                                                        .style("style", "color: #555;")
                                                                                        .paragraph("Best regards,<br> Your Company Name ")
                                                                                        .build())
                                                                                .build())

                                                                .build())
                                                        .build())
                                                .build())
                                        .build())
                                .build())
                        .build())
                .build();


    }
}
