package org.geekbang.thinking.in.spring.ioc.container.overview.dependency.lookup;

import org.geekbang.thinking.in.spring.ioc.container.overview.annotation.Super;
import org.geekbang.thinking.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * {@link ApplicationContext} 依赖查找示例
 * @see ApplicationContext
 * */
public class DependencyLookupDemo {
    public static void main(String[] args) {
        String configLocation = "classpath:/META-INF/dependency-lookup-context.xml";
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(configLocation);
        //by name
        //lookupByNameInRealTime(beanFactory);
        //lookupByNameInLazy(beanFactory);

        //by type
        //lookupByTypeInRealTime(beanFactory);
        //lookupByTypeInLazy(beanFactory);

        //collection by type
        lookupCollectionByType(beanFactory);

        //by annotation
        lookupByAnnotationType(beanFactory);
    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory=(ListableBeanFactory)beanFactory;
            Map<String,User> userMap = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找注解Super的所有用户："+userMap);
        }
    }
    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory=(ListableBeanFactory)beanFactory;
            Map<String,User>  userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到所有User(集合对象)="+userMap);
        }
    }

    private static void lookupByTypeInLazy(BeanFactory beanFactory) {
         ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean(ObjectFactory.class);
         User user = objectFactory.getObject();
         System.out.println("延迟查找(lookupByTypeInLazy)："+user);
    }
    private static void lookupByTypeInRealTime(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("实时查找(lookupByTypeInRealTime)："+user);
    }

    private static void lookupByNameInRealTime(BeanFactory beanFactory){
        User user = (User)beanFactory.getBean("user");
        System.out.println("实时查找(lookupByNameInRealTime)："+user);
    }
    private static void lookupByNameInLazy(BeanFactory beanFactory){
        ObjectFactory<User> objectFactory = (ObjectFactory<User>)beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找(lookupByNameInLazy)："+user);
    }
}
