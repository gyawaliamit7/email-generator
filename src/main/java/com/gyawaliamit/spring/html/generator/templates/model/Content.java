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
    private List<Content> contentList;
    private String footerButtonContent;
    private String footerButtonContentLink;

    public Content( ) {
    }

    public Content(String title, List<String> description, String buttonContent, String buttonLink, String imageUrl, String imageContent, String footerButtonContent, String footerButtonContentLink) {
        this.title = title;
        this.description = description;
        this.buttonContent = buttonContent;
        this.buttonLink = buttonLink;
        this.imageUrl = imageUrl;
        this.imageContent = imageContent;
        this.footerButtonContent = footerButtonContent;
        this.footerButtonContentLink = footerButtonContentLink;
    }

    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }

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

    public String getFooterButtonContent() {
        return footerButtonContent;
    }

    public void setFooterButtonContent(String footerButtonContent) {
        this.footerButtonContent = footerButtonContent;
    }

    public String getFooterButtonContentLink() {
        return footerButtonContentLink;
    }

    public void setFooterButtonContentLink(String footerButtonContentLink) {
        this.footerButtonContentLink = footerButtonContentLink;
    }
}
