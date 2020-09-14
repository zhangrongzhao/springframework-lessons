package org.geekbang.thinking.in.spring.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;

/**
 * {@link BeanInfo} 示例
 * @see BeanInfo
 *
 * @author rongzhao
 * */
public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);
        System.out.println(beanInfo);
    }
}
