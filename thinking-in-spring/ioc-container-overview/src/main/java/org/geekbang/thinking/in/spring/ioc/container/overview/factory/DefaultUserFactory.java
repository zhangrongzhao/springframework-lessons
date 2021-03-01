package org.geekbang.thinking.in.spring.ioc.container.overview.factory;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
public class DefaultUserFactory implements UserFactory, InitializingBean {

    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct: userFactory 初始化中...");
    }

    public void initUserFactory(){
        System.out.println("自定义初始化方法 initUserFactory(): userFactory 初始化中...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet(): userFactory 初始化中...");
    }
}
