package org.geekbang.thinking.in.spring.ioc.container.overview;

import org.geekbang.thinking.in.spring.ioc.container.annotation.Super;
import org.geekbang.thinking.in.spring.ioc.container.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 * byName查找
 * byType查找
 * @author
 * @see
 * ***/
public class DependencyLookupDemo {
    public static void main(String[] args){
        // 配置XML文件
        // 启动Spring 上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        // 通过名称查找 byName
        //lookupInRealTime(beanFactory);
        //lookupInLazy(beanFactory);

        //通过类型查找
        //lookupByType(beanFactory);

        //通过集合类型查找
        //lookupByCollectionType(beanFactory);

        //通过注解查找
        lookupByAnnotation(beanFactory);
    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String,User>  users = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("通过注解查找到所有的User对象：" + users);
        }
    }

    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory=(ListableBeanFactory)beanFactory;
            Map<String,User> map = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到所有的User集合对象：" + map);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("通过类型实时查找User："+user);
    }

    public static void lookupInRealTime(BeanFactory beanFactory ){
        User user = beanFactory.getBean("user",User.class);
        System.out.println("实时查找："+user);
    }

    public static void lookupInLazy(BeanFactory beanFactory){
        ObjectFactory<User> objectFactory = beanFactory.getBean("objectFactory",ObjectFactory.class);
        User user = objectFactory.getObject();
        System.out.println("延迟查找："+user);
    }
}
