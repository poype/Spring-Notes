package com.poype.annotation;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 通过反射机制解析注解
 */
public class ResolveAnnotation {

    public static void resolveUseCases(Class<PasswordUtils> cl) {
        Method[] declaredMethods = cl.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(System.out::println);
        /*
            获取到类中定义的所有方法
            private void com.poype.annotation.PasswordUtils.test()
            public boolean com.poype.annotation.PasswordUtils.validatePassword(java.lang.String)
            public java.lang.String com.poype.annotation.PasswordUtils.encryptPassword(java.lang.String)
            public boolean com.poype.annotation.PasswordUtils.checkForNewPassword(java.lang.String)
         */

        for (Method m : declaredMethods) {
            // 获取方法上声明的 UseCase 注解， 通过 m.getAnnotations() 可以获取到在方法上声明的所有注解
            UseCase uc = m.getAnnotation(UseCase.class);

            // 如果方法生没有UseCase类型的注解，则返回null值
            if (uc != null) {
                // 获取注解属性的值
                System.out.println("测试用例ID：" + uc.id());
                System.out.println("测试用例描述：" + uc.description());

                System.out.println("UserCase对象的toString：" + uc);

                /*
                    打印结果：
                    测试用例ID：47
                    测试用例描述：password must contain at least one numeric
                    UserCase对象的toString：@com.poype.annotation.UseCase(description="password must contain at least one numeric", id=47)
                    测试用例ID：48
                    测试用例描述：no description
                    UserCase对象的toString：@com.poype.annotation.UseCase(description="no description", id=48)
                    测试用例ID：49
                    测试用例描述：New passwords can't equal previously used ones
                    UserCase对象的toString：@com.poype.annotation.UseCase(description="New passwords can\'t equal previously used ones", id=49)
                 */
            }
        }

    }

    public static void main(String[] args) {
        resolveUseCases(PasswordUtils.class);
    }
}
