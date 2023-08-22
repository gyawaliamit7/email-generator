package com.gyawaliamit.spring.html.generator.templates.email;

public interface Template<T> {

    String generate(T t);
}
