package org.geekbang.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

public class BeanCreationExceptionDemo {
    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(POJO.class);
        applicationContext.registerBeanDefinition("errorBean",beanDefinitionBuilder.getBeanDefinition());
        applicationContext.refresh();
        applicationContext.close();
    }

    static class POJO implements InitializingBean{

        @PostConstruct // CommonAnnotationBeanPostProcessor
        public void init() throws Exception {
            throw new Exception("init() : For purpose");
        }

        @Override
        public void afterPropertiesSet() throws Exception {
             throw new Exception("afterPropertiesSet() : For purpose");
        }
    }
}
