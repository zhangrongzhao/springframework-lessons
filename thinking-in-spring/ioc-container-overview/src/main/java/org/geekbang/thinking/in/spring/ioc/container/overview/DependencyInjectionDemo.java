package org.geekbang.thinking.in.spring.ioc.container.overview;

import org.geekbang.thinking.in.spring.ioc.container.overview.domain.User;
import org.geekbang.thinking.in.spring.ioc.container.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.util.Map;

/**
 * 依赖注入示例
 * */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        //配置xml
        //启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");
        //1.依赖来源：自定义Bean
        UserRepository userRepository = beanFactory.getBean("userRepository",UserRepository.class);
        //System.out.println(userRepository.getUsers());
        //依赖注入（内建依赖）
        //System.out.println(userRepository.getBeanFactory());
        //System.out.println(userRepository.getBeanFactory()==beanFactory);
        //依赖查找（错误）
        //2.依赖来源：内部依赖
        //System.out.println(beanFactory.getBean(BeanFactory.class));

        //ObjectFactory<User> userObjectFactory=userRepository.getUserObjectFactory();
        //System.out.println(userObjectFactory.getObject());

//        ObjectFactory<ApplicationContext> objectFactory=userRepository.getObjectFactory();
//        System.out.println(objectFactory.getObject());
//        System.out.println(beanFactory);
//        System.out.println(objectFactory.getObject()==beanFactory);

        //容器内建Bean
        //3.内初初始化的Bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println(environment);

        MessageSource messageSource = beanFactory.getBean(MessageSource.class);
        System.out.println(messageSource);

        ApplicationEventMulticaster multicaster = beanFactory.getBean(ApplicationEventMulticaster.class);
        System.out.println(multicaster);
    }
}
