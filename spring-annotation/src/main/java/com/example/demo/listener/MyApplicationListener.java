package com.example.demo.listener;

import com.example.demo.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/4/9.
 */

@Component
public class MyApplicationListener implements ApplicationListener<ApplicationReadyEvent> {


    // 先进行依赖注入，然后根据Qualifier值进行筛选
    @Autowired
    @Qualifier("ls")
    private Person person;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println(person.getName());
    }
}
