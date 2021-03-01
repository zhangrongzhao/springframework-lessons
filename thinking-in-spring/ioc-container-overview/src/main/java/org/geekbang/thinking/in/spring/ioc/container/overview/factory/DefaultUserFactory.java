package org.geekbang.thinking.in.spring.ioc.container.overview.factory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {

    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct: userFactory 初始化中...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet(): userFactory 初始化中...");
    }

    public void initUserFactory(){
        System.out.println("自定义初始化方法 initUserFactory(): userFactory 初始化中...");
    }
    /************************************************************************************/
    @PreDestroy
    public void preDestroy(){
        System.out.println("@PreDestroy: userFactory 销毁中...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean#destroy(): userFactory 销毁中...");
    }

    public void customDestroy(){
        System.out.println("自定义销毁方法 customDestroy(): userFactory 销毁中...");
    }

    /************************************************************************************/
    @Override
    protected void finalize()throws Throwable{
        System.out.println("目前DefaultUserFactory对象正在被回收");
    }
}
