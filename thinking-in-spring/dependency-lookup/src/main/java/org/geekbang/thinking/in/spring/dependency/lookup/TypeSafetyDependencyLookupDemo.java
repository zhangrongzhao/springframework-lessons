package org.geekbang.thinking.in.spring.dependency.lookup;

import org.geekbang.thinking.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TypeSafetyDependencyLookupDemo {
    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(TypeSafetyDependencyLookupDemo.class);
        applicationContext.refresh();
        displayBeanFactoryGetBean(applicationContext);
        displayObjectFactoryGetBean(applicationContext);
        displayObjectProviderGetIfAvailable(applicationContext);
        displayListableBeanFactory(applicationContext);
        displayObjectProviderStreamOps(applicationContext);
        applicationContext.close();
    }

    private static void displayObjectProviderStreamOps(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        printBeansExceptions("displayObjectProviderStreamOps",()->userObjectProvider.forEach(System.out::println));
    }

    private static void displayListableBeanFactory(ListableBeanFactory beanFactory) {
        printBeansExceptions("displayListableBeanFactory",()->beanFactory.getBeansOfType(User.class));
    }

    private static void displayObjectProviderGetIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        printBeansExceptions("displayObjectProviderGetIfAvailable",()->userObjectProvider.getIfAvailable());
    }

    private static void displayObjectFactoryGetBean(AnnotationConfigApplicationContext applicationContext) {
        ObjectFactory<User> userObjectFactory = applicationContext.getBeanProvider(User.class);
        printBeansExceptions("displayObjectFactoryGetBean",()->userObjectFactory.getObject());
    }

    public static void displayBeanFactoryGetBean(BeanFactory beanFactory){
        printBeansExceptions("displayBeanFactoryGetBean",()->beanFactory.getBean(User.class));
    }

    public static void printBeansExceptions(String source,Runnable task){
        System.err.println("=============================================");
        System.err.println("source:" + source);
        try{
            task.run();
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
