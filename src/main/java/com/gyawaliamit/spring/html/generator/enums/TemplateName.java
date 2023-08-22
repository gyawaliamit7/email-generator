package com.gyawaliamit.spring.html.generator.enums;

public enum TemplateName {

    NEWSLETTER_BASIC("newsletter_basic"),
    REGISTRATION_SUCCSS_BASIC("registration_success_basic");

    private final String templateName;

    private TemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getName() {
        return templateName;
    }
}
