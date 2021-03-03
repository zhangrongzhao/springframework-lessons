package org.geekbang.thinking.in.spring.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class AutowiringByNameDependencySetterInjectionDemo {
    public static void main(String[] args){
        DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader=new XmlBeanDefinitionReader(beanFactory);
        String xmlResourcePath = "classpath:META-INF/autowiring-dependency-setter-injection.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        UserHolder userHolder = beanFactory.getBean(UserHolder.class);
        System.out.println(userHolder);
    }
}
