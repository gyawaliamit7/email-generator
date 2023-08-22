package com.gyawaliamit.spring.html.generator.templates.email;

import com.gyawaliamit.spring.html.generator.builder.HtmlBuilder;
import com.gyawaliamit.spring.html.generator.builder.body.BodyBuilder;
import com.gyawaliamit.spring.html.generator.builder.body.tags.*;
import com.gyawaliamit.spring.html.generator.builder.head.HeadBuilder;
import com.gyawaliamit.spring.html.generator.builder.head.TitleBuilder;
import com.gyawaliamit.spring.html.generator.enums.Heading;
import com.gyawaliamit.spring.html.generator.templates.model.Content;

import java.util.List;
import java.util.stream.Collectors;

public class NewsLetterBasicTemplate implements Template<Content> {

    @Override
    public String generate(Content content) {


        List<DivBuilder> divBuilders = content.getContentList().stream().map(item -> {
            List<ParagraphBuilder> paragraphBuilderList = item.getDescription().stream().map(item2 -> ParagraphBuilder.builder()
                    .style("style", "color: #555;")
                    .paragraph(item2)
                    .build()).collect(Collectors.toList());

            return DivBuilder.builder()
                    .style("style", "padding: 20px;")
                    .image(ImageBuilder.builder()
                            .src(item.getImageUrl(), item.getImageContent())
                            .style("style", "max-width: 100%; height: auto;")
                            .build())
                    .heading(HeadingBuilder.builder().style("style", "font-size: 20px; margin-top: 20px;").heading(item.getTitle(), Heading.HEADING_2).build())
                    .paragraphList(paragraphBuilderList)
                    .ahref(AhrefBuilder.builder().style("style", "display: inline-block; padding: 10px 20px; background-color: #007bff; color: #ffffff; text-decoration: none; font-weight: bold; border-radius: 5px;")
                            .ahref(item.getButtonLink(), item.getButtonContent()).build())
                    .build();

        }).collect(Collectors.toList());

        List<ParagraphBuilder> footerList = content.getFooterNotes().stream().map(item -> ParagraphBuilder.builder()
                .paragraph(item)
                .build()).collect(Collectors.toList());

        return HtmlBuilder.builder()
                .head(HeadBuilder.builder()
                        .title(TitleBuilder.builder().title("News Letter").build())
                        .build())
                .body(BodyBuilder.builder()
                        .style("style", "margin: 0; padding: 0; font-family: Arial, sans-serif; background-color: #f0f0f0;")
                        .div(DivBuilder.builder()
                                .style("style", "max-width: 600px; margin: 0 auto; padding: 20px; background-color: #ffffff;")
                                .div(DivBuilder.builder()
                                        .style("style", "text-align: center; background-color: #007bff; padding: 20px;")
                                        .heading(HeadingBuilder.builder().heading(content.getTitle(), Heading.HEADING_1).build())
                                        .build())
                                .divList(divBuilders)
                                .div(DivBuilder.builder()
                                        .style("style", "text-align: center; padding: 20px; background-color: #007bff; color: #ffffff;")
                                        .paragraphList(footerList)
                                        .ahref(AhrefBuilder.builder().style("style", "color: #ffffff; text-decoration: none;")
                                                .ahref(content.getFooterButtonContentLink(), content.getFooterButtonContent()).build())
                                        .build())
                                .build())
                        .build())
                .build();
    }

}

