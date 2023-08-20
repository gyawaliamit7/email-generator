# Spring HTML Generator

## Introduction

Spring HTML Generator is a simple and lightweight Java application that empowers you to create HTML pages using the Builder pattern. This application is deliberately minimalistic, with no external dependencies other than Java itself. It has been crafted with a singular purpose: to facilitate the creation of HTML templates via Java code.

## Table of Contents

- [Features](#features)
- [Use Cases](#use-cases)
- [Getting Started](#getting-started)
- [Example](#example)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Builder Pattern**: Spring HTML Generator leverages the Builder pattern to construct HTML pages, providing a clean and intuitive way to generate dynamic HTML content programmatically.

- **Lightweight**: This application is designed to be minimalistic and lightweight, ensuring that it doesn't introduce unnecessary complexity to your project.

- **Dependency-Free**: You won't need to manage any external dependencies when using Spring HTML Generator. It relies solely on Java, making it easy to integrate into your existing Java projects.

## Use Cases

Spring HTML Generator can be incredibly useful in various scenarios where you need to generate and serve HTML content from your backend:

1. **Composing HTML Emails**: When you need to compose HTML emails dynamically and send them from your backend, this library simplifies the task by providing a structured way to create HTML templates.

2. **Serving HTML Pages**: If your application serves HTML pages directly from the backend, Spring HTML Generator streamlines the process, making your code cleaner and more maintainable.

3. **Improving Readability**: Traditional approaches to generating HTML content within Java code often result in convoluted and hard-to-maintain code. Spring HTML Generator is designed with readability in mind, making it easier for developers to understand and maintain.

## Getting Started

To get started with Spring HTML Generator, follow these steps:

1. **Clone the Repository**: Clone this repository to your local machine.

   ```shell
   git clone https://github.com/your-username/jspring-html-generator.git



## Examples

### Creating Tables
The following code will help to generate html content for tables using custom syles.

```java
public static String buildTable() {
    String htmlContent = HtmlBuilder
            .builder()
            .head(HeadBuilder
                    .builder()
                    .title(TitleBuilder.builder().title("Hello World").build())
                    .build())
            .body(BodyBuilder.builder()
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
    return htmlContent;
}
```



This code will result for creating tables that will look like below.
<!DOCTYPE html> <html><head><title>Hello World</title></head><body><table style="border-radius:8px;box-shadow:0 0 10px rgba(0, 0, 0, 0.2);margin:auto;overflow:hidden;width:80%;border-collapse:collapse;"><tr ><th style="background-color:#333;padding:15px;color:#fff;text-align:center;">Title 1</th><th style="background-color:#333;padding:15px;color:#fff;text-align:center;">Title 2</th><th style="background-color:#333;padding:15px;color:#fff;text-align:center;">Title 3</th></tr><tr style="padding:15px;text-align:center;"><td >testData1</td><td >testData2</td><td >testData3</td></tr><tr style="padding:15px;text-align:center;"><td >testData1</td><td >testData2</td><td >testData3</td></tr><tr style="padding:15px;text-align:center;"><td >testData1</td><td >testData2</td><td >testData3</td></tr><tr style="padding:15px;text-align:center;"><td >testData1</td><td >testData2</td><td >testData3</td></tr></table></body></html>

### Creating Links
The above links will help you create links using spring-html-generator
```java
String htmlContent = HtmlBuilder
        .builder()
        .head(HeadBuilder
                .builder()
                .title(TitleBuilder.builder().title("Hello World").build())
                .build())
        .body(BodyBuilder.builder()
                .ahref(AhrefBuilder.builder()
                        .ahref("https://gyawaliamit.com/", "Test Link 2")
                        .style(Styles.COLOR_RED)
                        .style(Styles.TEXT_CENTER)
                        .customStyle("font-size", "18px")
                        .build())
                .build())
        .build();
```
This code will generate corresponding html code that will create links and will look like below.
<!DOCTYPE html> <html><head><title>Hello World</title></head><body><a href ="https://gyawaliamit.com/" style="color: red;text-align: center;font-size:18px;">Test Link 2</a></body></html>

### Creating Paragraphs

```java
String htmlContent = HtmlBuilder
    .builder()
    .head(HeadBuilder
        .builder()
        .title(TitleBuilder.builder().title("Hello World").build())
        .build())
    .body(BodyBuilder.builder()
        .paragraph(ParagraphBuilder.builder()
            .paragraph("This is just a first paragraph")
            .style(Styles.COLOR_RED)
            .style(Styles.TEXT_CENTER)
            .customStyle("font-size", "18px")
            .build())
        .build())
    .build();
return htmlContent;
```
The above links will help you create paragraphs which will look like:
<!DOCTYPE html> <html><head><title>Hello World</title></head><body><p style="color: red;text-align: center;font-size:18px;">This is just a first paragraph</p></body></html>


[..I will be adding more examples in the future ]
##  About Contribution
Since this is an open-source project, if you want some sort of feature enhancement or to fix a bug, please feel free to raise an issue or create a pull request and help maintain the project.

