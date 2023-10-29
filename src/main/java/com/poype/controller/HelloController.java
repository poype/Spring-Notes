package com.poype.controller;

import com.poype.event.TestEvent;
import com.test.auto_configuration.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /**
     * 有两个SampleService类型的Bean，如果不加以限制，就会产生歧义进而报错。
     * 使用@Qualifier注解可以根据Bean的名字明确指定要注入的是哪个Bean
     */
    @Qualifier("sampleService2")
    @Autowired
    private SampleService sampleService;

    @GetMapping("/hello")
    public String hello() {
        sampleService.test();
        return "hello";
    }

    @GetMapping("/test_aop")
    public String targetMethod() {
        System.out.println("test aop");
        return "test_aop";
    }

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("/send_event")
    public String sendEvent(@RequestParam("message") String message) {
        TestEvent event = new TestEvent(this, message);
        applicationEventPublisher.publishEvent(event);
        return "send_event_success";
    }
}
