package com.poype.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContextAwareController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @GetMapping("/test_context_aware")
    public String test() {
        // 从IOC容器中获取HelloController Bean
        HelloController helloController = (HelloController)this.applicationContext.getBean("helloController");
        System.out.println(helloController); // HelloController Bean的ID就是 helloController

        return helloController.hello();
    }
}
