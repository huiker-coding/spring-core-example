package com.example.springaop.core;

import com.example.springaop.annotation.TestAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * 该实现为侵入式aop，即根据方法上定义的注解来进行切面，在方法上定义注解即可进行切面织入
 * */
@Aspect
@Component
public class InvasiveAspect {


    public static final String TAG_NAME=InvasiveAspect.class.getSimpleName();

    // 切点的定义会匹配通知所要织入的一个或多个连接点
    @Pointcut("@annotation(test)")
    public void pointcut(TestAnnotation test){ }


    // 在方法被调用之前调用通知
    @Before("pointcut(test)")
    public void beforeTest(JoinPoint point,TestAnnotation test){
        System.out.println(TAG_NAME+"---------------beforeTest");
    }

    // 在方法完成之后调用通知,无论方法执行是否成功
    @After("pointcut(test)")
    public void afterTest(JoinPoint point,TestAnnotation test){
        System.out.println(TAG_NAME+"---------------afterTest" );
    }

    // 在方法成功执行之后调用通知
    @AfterReturning("pointcut(test)")
    public void afterReturningTest(JoinPoint point,TestAnnotation test){
        System.out.println(TAG_NAME+"---------------afterReturningTest" );
    }

    // 在方法抛出异常后调用通知
    @AfterThrowing("pointcut(test)")
    public void afterThrowingTest(JoinPoint point,TestAnnotation test){
        System.out.println(TAG_NAME+"---------------afterThrowingTest" );
    }

    // 通知包裹了被通知的方法,在被通知的方法调用之前和调用之后执行自定义的行为
    @Around("pointcut(test)")
    public Object aroundTest(ProceedingJoinPoint point,TestAnnotation test){
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
