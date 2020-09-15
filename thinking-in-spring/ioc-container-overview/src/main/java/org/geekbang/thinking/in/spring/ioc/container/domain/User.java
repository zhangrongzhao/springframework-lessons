package org.geekbang.thinking.in.spring.ioc.container.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 用户类
 * **/
public class User  {//implements InitializingBean, DisposableBean
    private Long Id;
    private String name;

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }

//    @Override
//    public void destroy() throws Exception {
//        System.out.println("====User 对象====销毁===== ");
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("====User 对象====初始化==== ");
//    }
}
