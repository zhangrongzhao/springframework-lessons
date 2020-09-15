package org.geekbang.thinking.in.spring.ioc.java.beans;

import java.beans.PropertyEditorSupport;

public class String2IntegerPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws java.lang.IllegalArgumentException {
         Integer value = Integer.valueOf(text);
         setValue(value);
    }
}
