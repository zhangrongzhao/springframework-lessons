package org.geekbang.thinking.in.spring.dependency.injection;

import org.geekbang.thinking.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

public class AnnotationDependencyMethodInjectionDemo {
    private UserHolder userHolder;
    private UserHolder userHolder2;

    @Autowired
    public void init1(UserHolder userHolder){
        this.userHolder=userHolder;
    }

    @Resource
    public void init2(UserHolder userHolder){
        this.userHolder2=userHolder;
    }

    @Bean
    public UserHolder userHolder(User user){
        return new UserHolder(user);
    }

    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationDependencyMethodInjectionDemo.class);
        XmlBeanDefinitionReader beanDefinitionReader=new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:META-INF/dependency-lookup-context.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        applicationContext.refresh();

        AnnotationDependencyMethodInjectionDemo demo = applicationContext.getBean(AnnotationDependencyMethodInjectionDemo.class);
        UserHolder userHolder = demo.userHolder;
        System.out.println("userHolder1:" + userHolder);

        UserHolder userHolder2=demo.userHolder2;
        System.out.println("userHolder2:" + userHolder2);

        System.out.println("userHolder==userHolder2:"+(userHolder==userHolder2));

        applicationContext.close();
    }
}
