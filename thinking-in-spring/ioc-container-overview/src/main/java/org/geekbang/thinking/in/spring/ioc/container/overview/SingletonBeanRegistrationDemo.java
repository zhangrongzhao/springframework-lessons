package org.geekbang.thinking.in.spring.ioc.container.overview;

import org.geekbang.thinking.in.spring.ioc.container.overview.factory.DefaultUserFactory;
import org.geekbang.thinking.in.spring.ioc.container.overview.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonBeanRegistrationDemo {
    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        UserFactory userFactory = new DefaultUserFactory();
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        beanFactory.registerSingleton("userFactory",userFactory);
        applicationContext.refresh();

        UserFactory userFactoryByLookup = applicationContext.getBean("userFactory",UserFactory.class);
        System.out.println(userFactory);
        System.out.println(userFactoryByLookup);
        System.out.println(userFactory == userFactoryByLookup);

        applicationContext.close();
    }
}
