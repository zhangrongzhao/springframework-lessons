package org.geekbang.thinking.in.spring.dependency.lookup;

import org.geekbang.thinking.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

//@Configuration 非必须注解
public class ObjectProviderDemo {
    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);
        applicationContext.refresh();
        //lookupByObjectProvider(applicationContext);
        //lookupIfAvailable(applicationContext);
        lookupByStreamOps(applicationContext);
        applicationContext.close();
    }

    private static void lookupByStreamOps(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        objectProvider.stream().forEach(System.out::println);
    }

    private static void lookupIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> objectProvider  =  applicationContext.getBeanProvider(User.class);
        User result = objectProvider.getIfAvailable(User::createUser);
        System.out.println(result);
    }

    @Bean
    public User user(){
        User user=new User();
        user.setId(1L);
        user.setName("joy");
        return user;
    }

    @Bean
    @Primary
    public String helloWorld(){
        return "hello,world";
    }

    @Bean
    public String message(){
        return "message";
    }

    public static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext){
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());
    }
}
