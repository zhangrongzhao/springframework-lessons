package org.geekbang.thinking.in.spring.dependency.lookup;

import org.geekbang.thinking.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HierarchicalDependencyLookupDemo {
    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(HierarchicalDependencyLookupDemo.class);

        //BeanFactory <- HierarchicalBeanFactory <- ConfigurableListableBeanFactory
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        System.out.println("当前Bean Factory 的parent Bean Factory:"+beanFactory.getParentBeanFactory());

        //设置parent BeanFactory
        String configLocation = "classpath:/META-INF/dependency-lookup-context.xml";
        BeanFactory beanFactory2 = new ClassPathXmlApplicationContext(configLocation);

        beanFactory.setParentBeanFactory(beanFactory2);

        User user = beanFactory.getBean(User.class);
        System.out.println(user);

        applicationContext.refresh();
        applicationContext.close();
    }
}
