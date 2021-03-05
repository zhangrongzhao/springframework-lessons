package org.geekbang.thinking.in.spring.dependency.injection;

import org.geekbang.thinking.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 *  注解驱动的依赖注入处理过程
 * ***/
public class AnnotationDependencyInjectionResolutionDemo {

    @Autowired //实时依赖注入
    private User user;
    //DependencyDescriptor ->
    //(required=true)->
    // (eager=true)->
    // 实时注入->
    // 通过类型（User.class）依赖查找处理->
    // 字段名称（"user"）
    //是否是首要的

//    @Autowired
//    private Collection<User> users;

//    @Autowired
//    private Map<String,User> users;

//    @Autowired
//    private Optional<User> optionalUser;

    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(AnnotationDependencyInjectionResolutionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader=new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:META-INF/dependency-lookup-context.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        applicationContext.refresh();

        applicationContext.close();
    }
}
