package com.gyawaliamit.spring.html.generator.builder.head;


public class HeadBuilder {
    private StringBuilder content;
    private TitleBuilder titleBuilder;

    public HeadBuilder(StringBuilder content) {
        this.content = content;
    }



    public static HeadBuilder builder() {
        return new HeadBuilder(new StringBuilder("<head>"));
    }

    public StringBuilder getContent() {
        return content;
    }

    public HeadBuilder build() {
        if(titleBuilder != null && titleBuilder.getContent() != null) {
            content.append(titleBuilder.getContent());
        }
        content.append("</head>");

        return this;
    }

    public HeadBuilder title(TitleBuilder titleBuilder) {
        this.titleBuilder = titleBuilder;
        return this;
    }
}