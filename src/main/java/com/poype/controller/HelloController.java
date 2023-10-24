package com.poype.controller;

import com.test.auto_configuration.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/hello")
    public String hello() {
        sampleService.test();
        return "hello";
    }
}
