package org.geekbang.thinking.in.spring.dependency.injection;

import org.geekbang.thinking.in.spring.dependency.injection.annotation.UserGroup;
import org.geekbang.thinking.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

/**
 *  {@Qualifier}
 * ***/
public class QualifierAnnotationDependencyInjectionDemo {

    @Autowired
    private User user;

    @Autowired
    @Qualifier("user")
    private User namedUser;

    @Autowired
    private Collection<User> allUser;

    @Autowired
    @Qualifier
    private Collection<User> qualifiedUsers;

    @Autowired
    @UserGroup
    private Collection<User> groupedUsers;

    @Bean
    @Qualifier
    public User user1(){
        User user = new User();
        user.setId(0010L);
        return user;
    }

    @Bean
    @Qualifier
    public User user2(){
        User user = new User();
        user.setId(0020L);
        return user;
    }

    @Bean
    @UserGroup
    public User user3(){
        User user = new User();
        user.setId(0030L);
        return user;
    }

    @Bean
    @UserGroup
    public User user4(){
        User user = new User();
        user.setId(0040L);
        return user;
    }

    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(QualifierAnnotationDependencyInjectionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader=new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:META-INF/dependency-lookup-context.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        applicationContext.refresh();

        QualifierAnnotationDependencyInjectionDemo demo = applicationContext.getBean(QualifierAnnotationDependencyInjectionDemo.class);
        System.out.println("demo.user=" + demo.user);
        System.out.println("demo.namedUser=" + demo.namedUser);
        System.out.println("demo.allUser=" + demo.allUser);
        System.out.println("demo.qualifiedUsers=" + demo.qualifiedUsers);
        System.out.println("demo.groupedUsers=" + demo.groupedUsers);
        applicationContext.close();
    }
}
