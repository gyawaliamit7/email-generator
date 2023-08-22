package com.gyawaliamit.spring.html.generator.templates.email;

import com.gyawaliamit.spring.html.generator.builder.HtmlBuilder;
import com.gyawaliamit.spring.html.generator.builder.body.BodyBuilder;
import com.gyawaliamit.spring.html.generator.builder.body.tags.*;
import com.gyawaliamit.spring.html.generator.builder.body.tags.table.TableBuilder;
import com.gyawaliamit.spring.html.generator.builder.body.tags.table.TableDataBuilder;
import com.gyawaliamit.spring.html.generator.builder.body.tags.table.TableRowBuilder;
import com.gyawaliamit.spring.html.generator.builder.head.HeadBuilder;
import com.gyawaliamit.spring.html.generator.enums.Heading;
import com.gyawaliamit.spring.html.generator.templates.model.Content;

import java.util.List;
import java.util.stream.Collectors;

public class RegistrationSuccessBasic implements Template<Content> {

    @Override
    public String generate(Content content) {

        List<ParagraphBuilder> paragraphBuilderList = content.getDescription().stream().map(item -> ParagraphBuilder.builder()
                .style("style", "color: #555;")
                .paragraph(item)
                .build()).collect(Collectors.toList());
        List<ParagraphBuilder> footerList = content.getFooterNotes().stream().map(item -> ParagraphBuilder.builder()
                .style("style", "color: #555;")
                .paragraph(item)
                .build()).collect(Collectors.toList());

        return HtmlBuilder
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
                                                                                        .src(content.getImageUrl(), content.getImageContent())
                                                                                        .attribute("alt", content.getImageContent())
                                                                                        .attribute("width", "200")
                                                                                        .attribute("height", "auto")
                                                                                        .style("style", "display: block;")
                                                                                        .build())
                                                                                .heading(HeadingBuilder.builder()
                                                                                        .style("style", "color: #333;")
                                                                                        .heading(content.getTitle(), Heading.HEADING_1)
                                                                                        .build())
                                                                                .paragraphList(paragraphBuilderList)
                                                                                .ahref(AhrefBuilder.builder()
                                                                                        .style("style", "display: inline-block; padding: 10px 20px; background-color: #007bff; color: #fff; text-decoration: none; border-radius: 3px;")
                                                                                        .ahref(content.getImageUrl(), content.getButtonContent())
                                                                                        .build())
                                                                                .paragraphList(footerList)
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
