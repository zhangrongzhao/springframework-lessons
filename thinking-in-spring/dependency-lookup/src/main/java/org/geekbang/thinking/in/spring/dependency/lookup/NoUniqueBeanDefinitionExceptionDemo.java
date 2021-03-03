package org.geekbang.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class NoUniqueBeanDefinitionExceptionDemo {
    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(NoUniqueBeanDefinitionExceptionDemo.class);
        applicationContext.refresh();
        applicationContext.getBean(String.class);
        try{

        }catch(NoUniqueBeanDefinitionException ex){

        }
        applicationContext.close();
    }

    @Bean
    public String bean1(){
        return "bean1";
    }

    @Bean
    public String bean2(){
        return "bean2";
    }
}
