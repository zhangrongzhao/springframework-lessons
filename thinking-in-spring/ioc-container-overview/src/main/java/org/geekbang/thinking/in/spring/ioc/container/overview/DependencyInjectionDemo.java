package org.geekbang.thinking.in.spring.ioc.container.overview;

import org.geekbang.thinking.in.spring.ioc.container.overview.domain.User;
import org.geekbang.thinking.in.spring.ioc.container.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖注入示例
 * */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        //配置xml
        //启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");
        UserRepository userRepository = beanFactory.getBean("userRepository",UserRepository.class);
        //System.out.println(userRepository.getUsers());
        //依赖注入
        //System.out.println(userRepository.getBeanFactory());
        //System.out.println(userRepository.getBeanFactory()==beanFactory);
        //依赖查找
        //System.out.println(beanFactory.getBean(BeanFactory.class));

        //ObjectFactory<User> userObjectFactory=userRepository.getUserObjectFactory();
        //System.out.println(userObjectFactory.getObject());

        ObjectFactory<ApplicationContext> objectFactory=userRepository.getObjectFactory();
        System.out.println(objectFactory.getObject());
        System.out.println(beanFactory);
        System.out.println(objectFactory.getObject()==beanFactory);
    }
}
