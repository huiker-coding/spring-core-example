package com.example.springaop.controller;


import com.example.springaop.biz.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/test")
    public String test() {
        personService.sayHello("zs");
        return "hello";
    }

}
