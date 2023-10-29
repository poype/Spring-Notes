package com.poype.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAopController {

    @GetMapping("/test_aop_1")
    public String testAop1() {
        System.out.println("testAop1 has been invoked");
        System.out.println(10 / 0);
        return "test_aop_1";
    }

    @GetMapping("/test_aop_2")
    public String testAop2() {
        System.out.println("testAop2 has been invoked");
        return "test_aop_2";
    }
}
