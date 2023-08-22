package com.gyawaliamit.spring.html.generator.handler;

public interface Handler {

    void handle(StringBuilder content);
    void addItem(String key, String value);
}
