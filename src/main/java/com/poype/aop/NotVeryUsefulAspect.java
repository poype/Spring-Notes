package com.poype.aop;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * AOP有这几个概念：
 * 1.切面(aspect)：切面就是一个类，这个类包含的方法就是这个切面要执行的动作。
 * 2.连接点(join point)：在Spring aop中，连接点就是可以被拦截的方法，spring aop只能拦截public的方法。
 * 3.切点(pointcut)：切点就是一个类似正则表达式的东西，用于指定哪些方法需要被拦截
 * 4.通知(advice)：用于指定切面的动作如何在匹配的连接点处执行，是在连接点前执行，还是在连接点后执行等等。
 *
 * 上面中的4个概念，除了第2点以外都要在程序中提供相应的组件。
 */

@Component
@Aspect  // @Aspect注解声明了一个切面
public class NotVeryUsefulAspect {

    // @Pointcut注解声明了一个切点testPointCut1, 这个切点的全名称为包名+类名+方法名+小括号，即“com.poype.aop.NotVeryUsefulAspect.testPointCut1()”
    @Pointcut("execution(* targetMethod(..))")  // @Pointcut的值中指定匹配连接点的表达式，在该例中是所有类的targetMethod方法都会被拦截。
    public void testPointCut1() {}  // testPointCut1方法可以没有任何实现体，只是作为一个占位符的概念。

    // @Before和@AfterReturning这两个注解都是用来定义advice，@Before表示在连接点被调用之前执行testBefore方法
    @Before("com.poype.aop.NotVeryUsefulAspect.testPointCut1()")
    public void testBefore() {
        System.out.println("testBefore");
    }

    // @AfterReturning表示在连接点被执行完返回之后执行testAfterReturn方法
    @AfterReturning(pointcut = "testPointCut1()", returning = "result")  // 在本例中，由于Pointcut和Advice是在同一个类中声明的，所以Advice关联切点不用必须写全包名和类名，只提供方法名即可
    public void testAfterReturn(String result) {
        System.out.println("testAfter, the result is " + result);
    }
}