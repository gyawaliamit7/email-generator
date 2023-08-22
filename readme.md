# Spring HTML Generator

## Introduction

Spring HTML Generator is a simple and lightweight Java application that empowers you to create HTML pages using the Builder pattern. This application is deliberately minimalistic, with no external dependencies other than Java itself. It has been crafted with a singular purpose: to facilitate the creation of HTML templates via Java code.

## Table of Contents

- [Features](#features)
- [Use Cases](#use-cases)
- [Getting Started](#getting-started)
- [Example](#example)
- [Templates](#templates)
- [Contributing](#about-contribution)

## Features

- **Builder Pattern**: Spring HTML Generator leverages the Builder pattern to construct HTML pages, providing a clean and intuitive way to generate dynamic HTML content programmatically.

- **Lightweight**: This application is designed to be minimalistic and lightweight, ensuring that it doesn't introduce unnecessary complexity to your project.

- **Dependency-Free**: You won't need to manage any external dependencies when using Spring HTML Generator. It relies solely on Java, making it easy to integrate into your existing Java projects.

## Use Cases

Spring HTML Generator can be incredibly useful in various scenarios where you need to generate and serve HTML content from your backend:

1. **Composing HTML Emails**: When you need to compose HTML emails dynamically and send them from your backend, this library simplifies the task by providing a structured way to create HTML templates.

2. **Serving HTML Pages**: If your application serves HTML pages directly from the backend, Spring HTML Generator streamlines the process, making your code cleaner and more maintainable.

3. **Improving Readability**: Traditional approaches to generating HTML content within Java code often result in convoluted and hard-to-maintain code. Spring HTML Generator is designed with readability, making it easier for developers to understand and maintain.

## Getting Started

To get started with Spring HTML Generator, follow these steps:

1. **Clone the Repository**: Clone this repository to your local machine.

   ```shell
   https://github.com/gyawaliamit7/spring-html-generator.git


## Example
### Building  Paragraphs
```java
ParagraphBuilder paragraphBuilder = ParagraphBuilder.builder().paragraph("This is just simple Paragraph").build();
String paragraphContent = HtmlBuilder.builder().body(BodyBuilder.builder().paragraph(paragraphBuilder).build()).build();
```

### Building  Links
```java
AhrefBuilder ahrefBuilder = AhrefBuilder.builder().ahref("#", "url details").build();
String ahrefContent = HtmlBuilder.builder().body(BodyBuilder.builder().ahref(ahrefBuilder).build()).build();
```

### Building Images
```java
ImageBuilder imageBuilder = ImageBuilder.builder().src("https://images.unsplash.com/photo-1682685797332-e678a04f8a64?ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHw2fHx8ZW58MHx8fHx8&auto=format&fit=crop&w=500&q=60", "image details").build();
String imageContent = HtmlBuilder.builder().body(BodyBuilder.builder().image(imageBuilder).build()).build();
```

### Building Headings
```java
HeadingBuilder headingBuilder = HeadingBuilder.builder().heading("heading content", Heading.HEADING_1).build();
String headingContent = HtmlBuilder.builder().body(BodyBuilder.builder().heading(headingBuilder).build()).build();
```

### Styling

```java
 ImageBuilder imageBuilder = ImageBuilder.builder()
                .src("https://via.placeholder.com/600x200", "placeholder")
                .attribute("alt", "placeholder")
                .attribute("width", "200")
                .attribute("height", "auto")
                .style("style", "display: block;")
                .build();
String imageContent = HtmlBuilder.builder().body(BodyBuilder.builder().image(imageBuilder).build()).build();
```

## Templates

### HTML Email Template - Successful User Registration

![Email Template Screenshot](https://github.com/gyawaliamit7/spring-html-generator/assets/34220616/3c1c6099-9f57-4c1f-8148-6d56673b822f)

This is an example of an HTML email template sent to users after successfully creating an account. It provides a clean and basic layout.

if you directly want to use this template in your code. Here is a sample code that you can use to use the template
```java
public static void main(String[] args) {

    // Generate registration HTML
    Template registrationTemplate = TemplateFactory.getTemplate(TemplateName.REGISTRATION_SUCCSS_BASIC);
    String html = registrationTemplate.generate(generateRegistrationContent());
    System.out.println(html);
}

 public static Content generateRegistrationContent() {
        Content content = new Content();
        content.setTitle("Welcome to Our Portal");

        List<String> descriptionList = new ArrayList<>();
        descriptionList.add("Thank you for registering with us. Your account has been successfully registered.");
        descriptionList.add("Please feel free to reach out to us for any questions or concerns regarding our services.");
        descriptionList.add("To get started, please click the button below:");
        content.setButtonContent("Get Started");
        content.setButtonLink("https://images.unsplash.com");
        content.setDescription(descriptionList);
        content.setImageUrl("https://images.unsplash.com/photo-1563694983011-6f4d90358083?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=687&q=80");
        content.setImageContent("Image Caption");

        List<String> footerNotes = new ArrayList<>();
        footerNotes.add("If you have any questions or need assistance, feel free to contact us.");
        footerNotes.add("Best regards,<br> Your Company Name ");
        content.setFooterNotes(footerNotes);
        return content;
    }
```

You can find the complete source code for this HTML email template in the following Java class:

[SuccessfulRegistration.java](src/main/java/com/gyawaliamit/spring/html/generator/templates/email/SuccessfulRegistration.java)

Feel free to use this template as a starting point for your own email notifications.

### HTML Email Template - Email Newsletter
![Email Newsletter Template](https://github.com/gyawaliamit7/spring-html-generator/assets/34220616/aca3ad45-3721-4c84-8e81-0e174ba186cd)

This is an example of a simple Email newsletter template where you can send company news or recent updates.

if you directly want to use this template in your code. Here is a sample code that you can use to use the template
```java
public static void main(String[] args) {

        Template newsletterTemplate = TemplateFactory.getTemplate(TemplateName.NEWSLETTER_BASIC);
        String newsletterHtml = newsletterTemplate.generate(generateNewsLetterContent());
        System.out.println(newsletterHtml);
}

  private static Content generateNewsLetterContent() {
        Content mainContent = new Content();
        mainContent.setTitle("Your Newsletter");

        List<Content> featureContent = getFeatureContents();
        mainContent.setContentList(featureContent);
        mainContent.setFooterButtonContent("Unsubscribe");
        mainContent.setFooterButtonContentLink("#");
        List<String> footerNotes = new ArrayList<>();
        footerNotes.add("&copy; 2023 Your Company |  ");
        mainContent.setFooterNotes(footerNotes);
        return mainContent;
    }

    private static List<Content> getFeatureContents() {
        List<Content> contents = new ArrayList<>();
        contents.add(new Content(
                "Sample Content 1",
                Arrays.asList("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"),
                "Learn More",
                "https://example.com/learnmore1",
                "https://via.placeholder.com/600x200",
                "Image 1",
                "Footer Button",
                "https://example.com/footerbutton1"
        ));
        contents.add(new Content(
                "Sample Content 2",
                Arrays.asList("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"),
                "Click Here",
                "https://example.com/clickhere",
                "https://via.placeholder.com/600x200",
                null,
                "Footer Action",
                "https://example.com/footeraction"
        ));

        return contents;
    }
```

You can find the complete source code for this HTML email template in the following Java class:

[SuccessfulRegistration.java](src/main/java/com/gyawaliamit/spring/html/generator/templates/email/SuccessfulRegistration.java)

Feel free to use this template as a starting point for your own email notifications.

> ℹ️ **Note:** More templates will be added in the future.

##  About Contribution
Since this is an open-source project, if you want some sort of feature enhancement or to fix a bug, please feel free to raise an issue or create a pull request and help maintain the project.

