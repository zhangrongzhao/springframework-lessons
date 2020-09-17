package org.geekbang.thinking.in.spring.ioc.container.overview;

import org.geekbang.thinking.in.spring.ioc.container.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入示例
 * */
public class WhoIsIoCContainerDemo {
    public static void main(String[] args) {
        //配置xml
        //启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");
        //1.依赖来源：自定义Bean
        UserRepository userRepository = beanFactory.getBean("userRepository",UserRepository.class);

        //为什么？
        System.out.println(beanFactory == userRepository.getBeanFactory());

        //ApplicationContext is BeanFactory
    }
}
