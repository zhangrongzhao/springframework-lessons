package org.geekbang.thinking.in.spring.ioc.java.beans;
 /**
  * 描述 Person 的 Pojo 类
  * <p>
  *  setter/getter
  *  writable/readable
  * </p>
  * @author
  * */
public class Person {
    //String to String
    private String name; // Properties
    //String to Integer
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
