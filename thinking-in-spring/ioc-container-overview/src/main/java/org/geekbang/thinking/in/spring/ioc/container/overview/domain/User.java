package org.geekbang.thinking.in.spring.ioc.container.overview.domain;

/**
 * 用户类
 * **/
public class User  {//implements InitializingBean, DisposableBean
    private Long id;
    private String name;

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
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

    public static  User  createUser(){
        User user = new User();
        user.setId(-1L);
        user.setName("default user");
        return user;
    }
}
