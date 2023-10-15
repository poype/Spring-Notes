package com.poype.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ContainerAnnotation {

    UseCase[] value(); // 当属性的名字是value时，在使用注解的时候可以省略属性的名字，直接提供value属性的值即可
}
