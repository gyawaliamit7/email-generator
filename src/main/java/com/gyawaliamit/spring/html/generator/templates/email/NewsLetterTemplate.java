package com.gyawaliamit.spring.html.generator.templates.email;

import com.gyawaliamit.spring.html.generator.builder.HtmlBuilder;
import com.gyawaliamit.spring.html.generator.builder.body.BodyBuilder;
import com.gyawaliamit.spring.html.generator.builder.body.tags.*;
import com.gyawaliamit.spring.html.generator.builder.head.HeadBuilder;
import com.gyawaliamit.spring.html.generator.builder.head.TitleBuilder;
import com.gyawaliamit.spring.html.generator.enums.Heading;

public class NewsLetterTemplate {
    public static void main(String[] args) {
        String htmlContent = HtmlBuilder.builder()
                .head(HeadBuilder.builder()
                        .title(TitleBuilder.builder().title("News Letter").build())
                        .build())
                .body(BodyBuilder.builder()
                        .style("style", "margin: 0; padding: 0; font-family: Arial, sans-serif; background-color: #f0f0f0;")
                        .div(DivBuilder.builder()
                                .style("style", "max-width: 600px; margin: 0 auto; padding: 20px; background-color: #ffffff;")
                                .div(DivBuilder.builder()
                                        .style("style", "text-align: center; background-color: #007bff; padding: 20px;")
                                        .heading(HeadingBuilder.builder().heading("Your Newsletter", Heading.HEADING_1).build())
                                        .build())
                                .div(DivBuilder.builder()
                                        .style("style", "padding: 20px;")
                                        .image(ImageBuilder.builder()
                                                .src("https://via.placeholder.com/600x200", "link")
                                                .style("style", "max-width: 100%; height: auto;")
                                                .build())
                                        .heading(HeadingBuilder.builder().style("style", "font-size: 20px; margin-top: 20px;").heading("Featured Article", Heading.HEADING_2).build())
                                        .paragraph(ParagraphBuilder.builder().style("style", "font-size: 16px; line-height: 1.5; margin-top: 10px;")
                                                .paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
                                                .build())
                                        .ahref(AhrefBuilder.builder().style("style", "display: inline-block; padding: 10px 20px; background-color: #007bff; color: #ffffff; text-decoration: none; font-weight: bold; border-radius: 5px;")
                                                .ahref("#", "Read More").build())
                                        .build())
                                .div(DivBuilder.builder()
                                        .style("style", "text-align: center; padding: 20px; background-color: #007bff; color: #ffffff;")
                                        .content(" &copy; 2023 Your Company | ")
                                        .ahref(AhrefBuilder.builder().style("style", "color: #ffffff; text-decoration: none;")
                                                .ahref("#", " Unsubscribe ").build())
                                        .build())
                                .build())
                        .build())
                .build();


        System.out.println(htmlContent);
    }
}

