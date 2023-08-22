package com.gyawaliamit.spring.html.generator;

import com.gyawaliamit.spring.html.generator.enums.TemplateName;
import com.gyawaliamit.spring.html.generator.templates.TemplateFactory;
import com.gyawaliamit.spring.html.generator.templates.email.RegistrationSuccessBasic;
import com.gyawaliamit.spring.html.generator.templates.email.Template;
import com.gyawaliamit.spring.html.generator.templates.model.Content;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationTest {



    public static void main(String[] args) {


        Template registrationTemplate = TemplateFactory.getTemplate(TemplateName.REGISTRATION_SUCCSS_BASIC);
        String html = registrationTemplate.generate(generateRegistrationContent());
//        System.out.println(html);

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
        contents.add(new Content(
                "Sub Content 1",
                Arrays.asList("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"),
                "Visit Sub",
                "https://example.com/subcontent1",
                "https://via.placeholder.com/600x200",
                "Sub Image 1",
                "Footer Link",
                "https://example.com/footerlink1"
        ));

        return contents;
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
}
