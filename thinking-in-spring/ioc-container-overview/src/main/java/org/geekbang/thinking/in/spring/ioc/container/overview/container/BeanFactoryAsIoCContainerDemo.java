package org.geekbang.thinking.in.spring.ioc.container.overview.container;

import org.geekbang.thinking.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * IoC 容器 示例 {@link BeanFactory}
 * {@link ApplicationContext}
 * @see
 * */
public class BeanFactoryAsIoCContainerDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(beanFactory);
        int beanDefinitionCount = reader.loadBeanDefinitions("classpath:META-INF/dependency-lookup-context.xml");

        System.out.println("IoC容器共加载Bean定义的个数为："+beanDefinitionCount);
        lookupByCollection(beanFactory);
        //User user = beanFactory.getBean(User.class);
        //System.out.println(user);
    }

    public static void lookupByCollection(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory=(ListableBeanFactory)beanFactory;
            Map<String,User> userMap=listableBeanFactory.getBeansOfType(User.class);
            System.out.println(userMap);
        }
    }
}
