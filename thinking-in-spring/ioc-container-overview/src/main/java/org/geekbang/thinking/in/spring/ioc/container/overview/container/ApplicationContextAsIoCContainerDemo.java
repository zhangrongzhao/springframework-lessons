package org.geekbang.thinking.in.spring.ioc.container.overview.container;

import org.geekbang.thinking.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * {@link ApplicationContext}作为IoC容器的示例
 * @see ApplicationContext
 * @see AnnotationConfigApplicationContext
 * @see Bean
 * **/
public class ApplicationContextAsIoCContainerDemo {

    @Bean
    public User user(){
        User user = new User();
        user.setId(1L);
        user.setName("小马哥");
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ApplicationContextAsIoCContainerDemo.class);
        applicationContext.refresh();
        //User user = applicationContext.getBean(User.class);
        //ApplicationContextAsIoCContainerDemo demo = applicationContext.getBean(ApplicationContextAsIoCContainerDemo.class);
        //System.out.println(demo.user);
        //System.out.println(user);
        lookupByCollection(applicationContext);

        applicationContext.close();
    }

    public static void lookupByCollection(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory=(ListableBeanFactory)beanFactory;
            Map<String,User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(userMap);
        }
    }
}
