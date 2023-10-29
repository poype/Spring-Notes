package com.poype.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterThrowingAspect {

    // @AfterThrowing声明的切面只有当目标连接点真正抛出与其匹配的异常时才会被调用，而与目标连接点是否在方法上声明了异常没有关系
    // 例如在本例中，只有TestAopController.testAop1真正抛出了ArithmeticException异常时，testAfterThrowingAdvice方法才会被调用
    // 如果只是在TestAopController.testAop1方法签名中声明了ArithmeticException异常，但没有真实抛ArithmeticException异常，那么testAfterThrowingAdvice方法不会被调用
    @AfterThrowing(pointcut="com.poype.aop.NewPointcut.testAfterThrowingPointcut()", throwing="ex")
    public void testAfterThrowingAdvice(ArithmeticException ex) {
        System.out.println("AfterThrowingAspect.testAfterThrowingAdvice is invoked ");
        System.out.println(ex);
    }
}
