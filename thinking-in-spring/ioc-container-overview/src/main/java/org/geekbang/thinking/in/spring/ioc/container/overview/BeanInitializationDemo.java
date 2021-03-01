package org.geekbang.thinking.in.spring.ioc.container.overview;

import org.geekbang.thinking.in.spring.ioc.container.overview.factory.DefaultUserFactory;
import org.geekbang.thinking.in.spring.ioc.container.overview.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class BeanInitializationDemo {
    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDemo.class);
        applicationContext.refresh();
        System.out.println("Spring应用上下文已启动...");
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        System.out.println(userFactory);
        System.out.println("Spring应用上下文准备关闭...");
        applicationContext.close();
        System.out.println("Spring应用上下文已关闭...");
    }

    @Lazy(false)
    @Bean(initMethod = "initUserFactory",destroyMethod = "customDestroy")
    public UserFactory userFactory(){
        return new DefaultUserFactory();
    }
}
