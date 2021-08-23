package com.andryanstgkr.parsamosir.api.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
    @Before(value="execution(* com.andryanstgkr.parsamosir.api.service.UserService.*())")
    public void beforeAdvice(JoinPoint joinPoint) {  
        System.out.println("Before method:" + joinPoint.getSignature());  
       
    }
}
