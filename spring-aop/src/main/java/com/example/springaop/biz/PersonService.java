package com.example.springaop.biz;

import com.example.springaop.annotation.TestAnnotation;
import org.springframework.stereotype.Component;

@Component
public class PersonService {

    @TestAnnotation(name = "zh")
    public String sayHello(String str){
        return "Hi "+str;
    }
}
