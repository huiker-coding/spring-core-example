package com.example.springaop.core;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * 该实现为非侵入式aop，即直接扫描包，不需要动业务代码，直接进行切面设置
 * */
@Aspect     // 将该类设置为一个切面
@Order(1)   // 给切面设置优先级
@Component
public class NonInvasiveAspect {

    public static final String TAG_NAME=NonInvasiveAspect.class.getSimpleName();

    // 切点的定义会匹配通知所要织入的一个或多个连接点
    @Pointcut("execution(public * com.example.springaop.controller.*.*(..))")
    public void pointcut(){ }


    // 在方法被调用之前调用通知
    @Before("pointcut()")
    public void beforeTest(JoinPoint point){
        System.out.println(TAG_NAME+"---------------beforeTest");
    }

    // 在方法完成之后调用通知,无论方法执行是否成功
    @After("pointcut()")
    public void afterTest(JoinPoint point){
        System.out.println(TAG_NAME+"---------------afterTest" );
    }

    // 在方法成功执行之后调用通知
    @AfterReturning("pointcut()")
    public void afterReturningTest(JoinPoint point){
        System.out.println(TAG_NAME+"---------------afterReturningTest" );
    }

    // 在方法抛出异常后调用通知
    @AfterThrowing("pointcut()")
    public void afterThrowingTest(JoinPoint point){
        System.out.println(TAG_NAME+"---------------afterThrowingTest" );
    }

    // 通知包裹了被通知的方法,在被通知的方法调用之前和调用之后执行自定义的行为
    @Around("pointcut()")
    public Object aroundTest(ProceedingJoinPoint point){
        System.out.println(TAG_NAME+"---------------aroundTest" );
        Object[] args = point.getArgs();
        try {
            //被拦截的方法
            Object object = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

}
