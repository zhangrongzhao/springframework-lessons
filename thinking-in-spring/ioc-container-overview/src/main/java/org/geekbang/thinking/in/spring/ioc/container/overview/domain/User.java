package org.geekbang.thinking.in.spring.ioc.container.overview.domain;

import org.geekbang.thinking.in.spring.ioc.container.overview.enums.City;
import org.springframework.core.io.Resource;


/**
 * 用户类
 * **/
public class User  {//implements InitializingBean, DisposableBean
    private Long id;
    private String name;
    private City city;
    private Resource  configLocationFile;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }

    public Resource getConfigLocationFile() {
        return configLocationFile;
    }
    public void setConfigLocationFile(Resource configLocationFile) {
        this.configLocationFile = configLocationFile;
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

    public static  User  createUser(){
        User user = new User();
        user.setId(-1L);
        user.setName("default user");
        return user;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", configLocationFile=" + configLocationFile +
                '}';
    }
}
