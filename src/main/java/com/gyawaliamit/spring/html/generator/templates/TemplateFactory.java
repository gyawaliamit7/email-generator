package com.gyawaliamit.spring.html.generator.templates;

import com.gyawaliamit.spring.html.generator.enums.TemplateName;
import com.gyawaliamit.spring.html.generator.templates.email.NewsLetterBasicTemplate;
import com.gyawaliamit.spring.html.generator.templates.email.RegistrationSuccessBasic;
import com.gyawaliamit.spring.html.generator.templates.email.Template;

public class TemplateFactory {

    public static Template getTemplate(TemplateName templateName) {

        if(templateName.getName().equalsIgnoreCase(TemplateName.NEWSLETTER_BASIC.getName())) {
            return new NewsLetterBasicTemplate();
        }
        if(templateName.getName().equalsIgnoreCase(TemplateName.REGISTRATION_SUCCSS_BASIC.getName())) {
            return new RegistrationSuccessBasic();
        }
        return null;
    }

}
