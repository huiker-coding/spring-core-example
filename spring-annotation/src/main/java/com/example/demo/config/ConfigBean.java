package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 1.在统一的bean容器中进行统一的设置
 * 2.Spring的@Bean注解用于告诉方法，产生一个Bean对象，然后这个Bean对象交给Spring管理。
 *   产生这个Bean对象的方法Spring只会调用一次，随后这个Spring将会将这个Bean对象放在自己的IOC容器中。
 * 3.使用@Bean注解的好处就是能够动态获取一个Bean对象，能够根据环境不同得到不同的Bean对象。
 **/
@Configuration
public class ConfigBean {

    @Bean(name = "zs")
    public Person method1() {
        return new Person("zhangsan");
    }

    @Bean(name = "ls")
    public Person method2() {
        return new Person("lisi");
    }
}
