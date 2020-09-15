package org.geekbang.thinking.in.spring.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

/**
 * {@link BeanInfo} 示例j
 * @see BeanInfo
 *
 * @author rongzhao
 * */
public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);
        System.out.println(beanInfo.getBeanDescriptor());
        //Stream.of(beanInfo.getPropertyDescriptors()).forEach(System.out::println);
        Stream.of(beanInfo.getPropertyDescriptors())
              .forEach((propertyDescriptor)->{
                  //propertyDescriptor 允许添加属性编辑器 -> PropertyEditor
                  //GUI -> text(String) -> PropertyType
                  //name -> String
                  //age -> Integer
                  Class<?> propertyType = propertyDescriptor.getPropertyType();
                  String propertyName = propertyDescriptor.getName();
                  if("age".equals(propertyName)){
                      //String ->Integer
                      //Integer.valueOf("");
                      propertyDescriptor.setPropertyEditorClass(String2IntegerPropertyEditor.class);
                  }
                  System.out.println(propertyDescriptor);
              });
        //Stream.of(beanInfo.getMethodDescriptors()).forEach(System.out::println);
        Stream.of(beanInfo.getMethodDescriptors()).forEach((methodDescriptor)->{
            System.out.println(methodDescriptor);
        });
    }
}
