package org.geekbang.thinking.in.spring.dependency.injection;

import org.geekbang.thinking.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collection;

/**
 *  {@link ObjectProvider} 延迟依赖注入
 * ***/
public class LazyAnnotationDependencyInjectionDemo {

    @Autowired //实时依赖注入
    private User user;

    @Autowired //延迟依赖注入
    private ObjectProvider<User> userObjectProvider;

    @Autowired
    private ObjectFactory<Collection<User>> userObjectFactory;

    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(LazyAnnotationDependencyInjectionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader=new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:META-INF/dependency-lookup-context.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        applicationContext.refresh();

        LazyAnnotationDependencyInjectionDemo demo = applicationContext.getBean(LazyAnnotationDependencyInjectionDemo.class);
        System.out.println("demo.user=" + demo.user);
        System.out.println("demo.userObjectProvider=" + demo.userObjectProvider.getObject());
        demo.userObjectProvider.forEach(System.out::println);

        System.out.println("demo.userObjectFactory=" + demo.userObjectFactory.getObject());
        applicationContext.close();
    }
}
