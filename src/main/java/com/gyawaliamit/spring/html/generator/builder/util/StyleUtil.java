package com.gyawaliamit.spring.html.generator.builder.util;

import com.gyawaliamit.spring.html.generator.builder.enums.Styles;

import java.util.List;
import java.util.Map;

public class StyleUtil {

    public static void buildStyles(StringBuilder content, List<Styles> stylesList, Map<String, String> customStyles) {
        if((stylesList != null && !stylesList.isEmpty()) || (customStyles != null && !customStyles.isEmpty())) {
            content.append("style=\"");
            if(stylesList != null) {
                stylesList.forEach(style -> content.append(style.getCss()));
            }
            if(customStyles != null) {
                customStyles.forEach((key, value) -> {
                    content.append(key).append(":").append(value).append(";");
                });
            }
            content.append("\"");

        }
    }
}
