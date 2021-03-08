package org.geekbang.thinking.in.spring.dependency.source;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ResourceLoader;

/**
 *  注解驱动的依赖注入处理过程
 * ***/
public class DependencySourceDemo {

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(DependencySourceDemo.class);

        applicationContext.refresh();
        DependencySourceDemo demo = applicationContext.getBean(DependencySourceDemo.class);

        System.out.println(demo.beanFactory);
        System.out.println(demo.resourceLoader);
        System.out.println(demo.applicationEventPublisher);
        System.out.println(demo.applicationContext);

        applicationContext.close();
    }
}
