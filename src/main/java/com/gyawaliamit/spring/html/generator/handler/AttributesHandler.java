package com.gyawaliamit.spring.html.generator.handler;

import java.util.HashMap;
import java.util.Map;

public class AttributesHandler implements Handler{

    private Map<String,String> attributesList;


    @Override
    public void handle(StringBuilder content) {
        if(this.attributesList != null) {
            this.attributesList.forEach((key, value) -> {
                content.append(" ").append(key).append("= \"").append(value).append("\" ");
            });
        }
    }

    @Override
    public void addItem(String key, String value) {
        if(this.attributesList == null) {
            this.attributesList = new HashMap<>();
        }
        this.attributesList.put(key, value);
    }
}
