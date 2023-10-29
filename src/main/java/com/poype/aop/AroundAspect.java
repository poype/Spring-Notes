package com.poype.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAspect {

    @Around(value = "com.poype.aop.NewPointcut.testAroundPointcut()")
    public Object testAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around advice before~~~~~~~~");
        System.out.println(joinPoint.getSignature().getName());
        System.out.println("Args: ");
        for (Object o : joinPoint.getArgs()) {  // 获取joinPoint的调用参数
            System.out.println(o);
        }
        Object result;
        try {
            result = joinPoint.proceed(); // 调用连接点
            System.out.println("around advice after~~~~~~~~ " + result);
        } catch (Exception ex) {
            ex.printStackTrace();
            result = "fail fail fail~~~~~~~~~~~~~~~";
        }
        return result;
    }
}
