package org.geekbang.thinking.in.spring.ioc.container.overview.dependency.injection;

import org.geekbang.thinking.in.spring.ioc.container.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * {@link ApplicationContext} 依赖注入示例
 * @see ApplicationContext
 * */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        String configLocation = "classpath:/META-INF/dependency-injection-context.xml";
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(configLocation);

        UserRepository repository = beanFactory.getBean("userRepository",UserRepository.class);
        System.out.println(repository.getUsers());

        //依赖注入
        System.out.println(repository.getBeanFactory());
        System.out.println(beanFactory);
        System.out.println(repository.getBeanFactory()==beanFactory);

        //依赖查找:异常NoSuchBeanDefinitionException
        //结论：依赖注入和依赖查找不同源。
        //System.out.println(beanFactory.getBean(BeanFactory.class));

        //依赖注入
        System.out.println(repository.getUserObjectFactory());
        System.out.println(repository.getUserObjectFactory().getObject());

        //依赖注入
        System.out.println(repository.getObjectFactory());
        System.out.println(repository.getObjectFactory().getObject());
        System.out.println(beanFactory);
        System.out.println(repository.getObjectFactory().getObject()==beanFactory);
    }
}
