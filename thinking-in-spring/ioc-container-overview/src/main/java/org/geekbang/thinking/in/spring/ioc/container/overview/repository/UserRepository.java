package org.geekbang.thinking.in.spring.ioc.container.overview.repository;

import org.geekbang.thinking.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * User 仓库
 * */
public class UserRepository {
    private Collection<User> users;//自定义Bean
    private BeanFactory beanFactory;//内置非Bean对象（依赖）
    private ObjectFactory<User> userObjectFactory;//延迟依赖注入
    private ObjectFactory<ApplicationContext> objectFactory;//延迟依赖注入

    public ObjectFactory<User> getUserObjectFactory() {
        return userObjectFactory;
    }
    public void setUserObjectFactory(ObjectFactory<User> userObjectFactory) {
        this.userObjectFactory = userObjectFactory;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Collection<User> getUsers() {
        return users;
    }
    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }
    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }
}
