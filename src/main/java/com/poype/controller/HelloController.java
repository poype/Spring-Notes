package com.poype.controller;

import com.test.auto_configuration.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
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
}
