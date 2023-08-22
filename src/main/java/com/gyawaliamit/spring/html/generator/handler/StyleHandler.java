package com.gyawaliamit.spring.html.generator.handler;

import java.util.HashMap;
import java.util.Map;

public class StyleHandler implements Handler {
    protected Map<String, String> customStyles;

    public StyleHandler() {
        this.customStyles = new HashMap<>();
    }


    @Override
    public void handle(StringBuilder content) {
        if (customStyles != null) {

            if (customStyles.containsKey("style")) {
                content.append("style= \"");
                content.append(customStyles.get("style"));
                content.append("\" ");

            }

        }

    }

    @Override
    public void addItem(String key, String value) {
        if (this.customStyles == null) {
            this.customStyles = new HashMap<>();
        }
        this.customStyles.put(key, value);
    }
}