package com.poype;

import com.poype.service.TestInitializingBeanService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
    这里使用了SpringBootApplication一个注解，相当于同时使用了下面三个注解：
    @SpringBootConfiguration
    @EnableAutoConfiguration
    @ComponentScan
 */
@SpringBootApplication
public class App {
    // App就是一个配置类

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);  // 注意要把args也传给run方法
    }

    @Bean
    public TestInitializingBeanService testInitializingBeanService() {
        TestInitializingBeanService testInitializingBeanService = new TestInitializingBeanService();
        testInitializingBeanService.setName("test_name");
        testInitializingBeanService.setDescription("test_description");
        return testInitializingBeanService;
    }
}
