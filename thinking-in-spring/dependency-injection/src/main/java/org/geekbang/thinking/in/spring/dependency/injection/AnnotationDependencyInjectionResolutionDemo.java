package org.geekbang.thinking.in.spring.dependency.injection;

import org.geekbang.thinking.in.spring.dependency.injection.annotation.InjectedUser;
import org.geekbang.thinking.in.spring.dependency.injection.annotation.MyAutowired;
import org.geekbang.thinking.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.inject.Inject;

/**
 *  注解驱动的依赖注入处理过程
 * ***/
public class AnnotationDependencyInjectionResolutionDemo {

    @MyAutowired
    private User myAutowiredUser;

    @Inject
    private User injectedUser;

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

    @InjectedUser
    private User myUser;

//    @Bean(name=AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME)
//    public static AutowiredAnnotationBeanPostProcessor beanPostProcessor(){
//        AutowiredAnnotationBeanPostProcessor beanPostProcessor=new AutowiredAnnotationBeanPostProcessor();
//        Set<Class<? extends Annotation>> autowiredAnnotationTypes=
//                new LinkedHashSet<>(asList(Autowired.class,Inject.class,InjectedUser.class));
//        beanPostProcessor.setAutowiredAnnotationTypes(autowiredAnnotationTypes);
//        //beanPostProcessor.setAutowiredAnnotationType(InjectedUser.class);
//        return beanPostProcessor;
//    }


    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE-3)
    public static AutowiredAnnotationBeanPostProcessor beanPostProcessor(){
        AutowiredAnnotationBeanPostProcessor beanPostProcessor=new AutowiredAnnotationBeanPostProcessor();
        beanPostProcessor.setAutowiredAnnotationType(InjectedUser.class);
        return beanPostProcessor;
    }

    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(AnnotationDependencyInjectionResolutionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader=new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:META-INF/dependency-lookup-context.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        applicationContext.refresh();

        AnnotationDependencyInjectionResolutionDemo demo=applicationContext.getBean(AnnotationDependencyInjectionResolutionDemo.class);
        System.out.println(demo.injectedUser);
        System.out.println(demo.user);

        //System.out.println(demo.myAutowiredUser);
        //System.out.println(demo.user);

        System.out.println(demo.myUser);
        applicationContext.close();
    }
}
