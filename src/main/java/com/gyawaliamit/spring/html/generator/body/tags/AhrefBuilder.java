package com.gyawaliamit.spring.html.generator.builder.body.tags;

import com.gyawaliamit.spring.html.generator.builder.body.BodyTags;
import com.gyawaliamit.spring.html.generator.builder.enums.Styles;
import com.gyawaliamit.spring.html.generator.builder.util.Pair;
import com.gyawaliamit.spring.html.generator.builder.util.StyleUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AhrefBuilder implements BodyTags {

    private StringBuilder content;
    private Pair<String,String> urlPair;
    private List<Styles> stylesList;
    private Map<String, String> customStyles;


    public AhrefBuilder(StringBuilder content) {
        this.content = content;
    }


    public AhrefBuilder build() {
        this.content.append("<a href =\"").append(urlPair.getKey()).append("\" ");
        StyleUtil.buildStyles(this.content,stylesList, customStyles);
        this.content.append(">");
        this.content.append(urlPair.getValue());
        this.content.append("</a>");
        return this;
    }



    public static AhrefBuilder builder() {
        return new AhrefBuilder(new StringBuilder());
    }

    public AhrefBuilder ahref(String url,String info) {
        this.urlPair = new Pair<>(url,info);
        return this;
    }

    public AhrefBuilder style(Styles style) {
        if(this.stylesList == null) {
            this.stylesList = new ArrayList<>();
        }
        this.stylesList.add(style);
        return this;
    }

    public String getContent() {
        return content.toString();
    }

    public AhrefBuilder customStyle(String key, String value) {
        if(this.customStyles == null) {
            this.customStyles = new HashMap<>();
        }
        this.customStyles.put(key,value);
        return this;
    }
}
