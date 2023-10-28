package com.poype.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewPointcut {

    /*
     * 匹配任何方法的pointcut
     */
    @Pointcut("execution(public * *(..))")
    public void allPublicMethod() {}

    /*
     * 匹配任何名字以set开头的方法名
     * 可以看到，public可以省略
     */
    @Pointcut("execution(* set*(..))")
    public void beginWithName() {}

    /*
     * 匹配AccountService中定义的任何方法
     */
    @Pointcut("execution(* com.poype.aop.AccountService.*(..))")
    public void AccountServicePointcut(){}

	/*
	 * 其它的一些execution表达式
	 the execution of any method defined in the service package:
			execution(* com.xyz.service.*.*(..))
	 the execution of any method defined in the service package or a sub-package:
			execution(* com.xyz.service..*.*(..))
	 any join point (method execution only in Spring AOP) within the service package:
	 		within(com.xyz.service.*)
	 any join point (method execution only in Spring AOP) within the service package or a sub-package:
	 		within(com.xyz.service..*)
	 */
}
