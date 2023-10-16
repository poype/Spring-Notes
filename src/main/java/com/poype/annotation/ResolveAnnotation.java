package com.poype.annotation;

import com.poype.App;
import com.poype.controller.HelloController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
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

    public static void resolveContainerAnnotation(Class<UserService> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            ContainerAnnotation ca = m.getAnnotation(ContainerAnnotation.class);
            UseCase[] useCaseList = ca.value();

            for (UseCase uc : useCaseList) {
                System.out.println(uc);

                /*
                    打印结果：
                    @com.poype.annotation.UseCase(description="one", id=1)
                    @com.poype.annotation.UseCase(description="two", id=2)
                    @com.poype.annotation.UseCase(description="no description", id=3)
                 */
            }
        }
    }

    // 解析注解头顶上的注解
    private static void resolveCombinationAnnotation() {
        Class<App> cl1 = App.class;
        SpringBootApplication sba = cl1.getAnnotation(SpringBootApplication.class);
        // App上声明了 SpringBootApplication 注解
        System.out.println(sba);

        // 通过 sba.getClass() 获取到的不是 SpringBootApplication.class，所以下面只能显示使用SpringBootApplication.class
        Class<SpringBootApplication> cl2 = SpringBootApplication.class;
        // 在SpringBootApplication注解上又声明了其它注解，其中包括ComponentScan注解
        ComponentScan cs = cl2.getAnnotation(ComponentScan.class);
        System.out.println(cs);

        // 注解与其它普通的类一样，注解的头顶上也可以声明其它注解。也可以通过反射机制对注解头顶上的注解进行解析。
    }

    private static void resolveCombinationAnnotation2() {
        Class<HelloController> cl1 = HelloController.class;
        RestController rc = cl1.getAnnotation(RestController.class);
        System.out.println(rc);

        Class<RestController> cl2 = RestController.class;
        for (Annotation annotation : cl2.getAnnotations()) {
            System.out.println(annotation);

            /*
                RestController是 Controller 与 ResponseBody两个注解的组合
                打印结果：
                @org.springframework.stereotype.Controller("")
                @org.springframework.web.bind.annotation.ResponseBody()
             */
        }
    }

    public static void main(String[] args) {
        resolveCombinationAnnotation();
        System.out.println("-----------------------------------------------------");
        resolveCombinationAnnotation2();
    }
}
