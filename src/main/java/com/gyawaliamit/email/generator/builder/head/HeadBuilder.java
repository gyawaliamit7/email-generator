package com.gyawaliamit.email.generator.builder.head;


/**
 * this is the builder class to create Header Elements
 * Header elements can include title, meta, style and more.
 * As of Aug 2023, it currently supports only titleBuilder
 */
public class HeadBuilder {
    private StringBuilder content;
    private TitleBuilder titleBuilder;

    public HeadBuilder(StringBuilder content) {
        this.content = content;
    }

    public HeadBuilder(StringBuilder content, TitleBuilder titleBuilder) {
        this.titleBuilder = titleBuilder;
        this.content = content;
    }


    public static HeadBuilder builder() {
        return new HeadBuilder(new StringBuilder("<head>"));
    }

    public StringBuilder getContent() {
        return content;
    }

    public HeadBuilder title(TitleBuilder titleBuilder) {
        this.titleBuilder = titleBuilder;
        return new HeadBuilder(content,titleBuilder);
    }

    public HeadBuilder build() {
        if(titleBuilder.getContent() != null) {
            content.append(titleBuilder.getContent());
        }
        content.append("</head>");
        return new HeadBuilder(content,titleBuilder);
    }
}