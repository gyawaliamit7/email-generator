package com.gyawaliamit.spring.html.generator.handler;

import com.gyawaliamit.spring.html.generator.enums.Styles;
import com.gyawaliamit.spring.html.generator.util.StyleUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StyleHandler {
    protected List<Styles> stylesList;
    protected Map<String, String> customStyles;

    public StyleHandler() {
        this.stylesList = new ArrayList<>();
        this.customStyles = new HashMap<>();
    }

    public void buildStyles(StringBuilder content) {
        StyleUtil.buildStyles(content,stylesList, customStyles);

    }

    public void customStyles(String key, String value) {
        if(this.customStyles == null) {
            this.customStyles = new HashMap<>();
        }
        this.customStyles.put(key,value);
    }

    public void style(Styles style) {
        if(this.stylesList == null) {
            this.stylesList = new ArrayList<>();
        }
        this.stylesList.add(style);
    }
}