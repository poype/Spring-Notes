package com.poype.aop;

import org.springframework.stereotype.Component;

@Component
public class AccountService {

    public void anyMethod() {
        System.out.println("anyMethod in AccountService");
    }
}
