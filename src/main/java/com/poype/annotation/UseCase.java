package com.poype.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)          // 定义注解用在什么地方，是用在一个方法还是一个类
@Retention(RetentionPolicy.RUNTIME)  // 定义注解在哪一个级别可用，在源代码中(SOURCE)，类文件中(CLASS)或者运行时(RUNTIME)。
public @interface UseCase {

    public int id();  // 注解中的元素类似方法定义

    // public 可以省略
    String description() default "no description";  // 如果没提供description值，则会使用默认值 "no description"
}


/**
 * Annotation在一定程度上把元数据与源代码结合在一起。
 * 注解与类和接口一样，也会被编译成class文件
 *
 * 原注解：
 * 一共有四种元注解，元注解负责注解其它的注解
 * @Target 声明该注解可以用于什么地方
 *
 * @Retention 表示需要在什么级别保存注解的信息，可选的RetentionPolicy参数包括：
 * SOURCE: 注解将被编译器丢弃
 * CLASS: 注解在class文件中可用，但会被VM丢弃。
 * RUNTIME: VM将在运行期也保留注解，因此可以通过反射机制读取注解的信息。这个应该是最常用的。
 *
 * @Inherited 允许子类继承父类中的注解
 *
 * @Documentd 将此注解包含在Javadoc中
 *
 *
 * 主要是通过反射机制来解析注解
 *
 * 注解的元素可以使用如下类型：
 * 1. 所有基本类型(int, float, boolean等)
 * 2. String
 * 3. Class
 * 4. enum
 * 5. Annotation
 * 6. 以上类型的数组
 * 如果你使用其它类型，那编译器就会报错。
 *
 */