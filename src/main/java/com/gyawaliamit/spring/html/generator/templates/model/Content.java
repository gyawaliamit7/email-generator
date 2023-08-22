package com.gyawaliamit.spring.html.generator.templates.model;

import java.util.List;

public class Content {

    private String title;
    private List<String> description;
    private String buttonContent;
    private String buttonLink;
    private String imageUrl;
    private String imageContent;
    private List<String> footerNotes;


    public List<String> getFooterNotes() {
        return footerNotes;
    }

    public void setFooterNotes(List<String> footerNotes) {
        this.footerNotes = footerNotes;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public String getImageContent() {
        return imageContent;
    }

    public void setImageContent(String imageContent) {
        this.imageContent = imageContent;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getButtonContent() {
        return buttonContent;
    }

    public void setButtonContent(String buttonContent) {
        this.buttonContent = buttonContent;
    }

    public String getButtonLink() {
        return buttonLink;
    }

    public void setButtonLink(String buttonLink) {
        this.buttonLink = buttonLink;
    }
}
