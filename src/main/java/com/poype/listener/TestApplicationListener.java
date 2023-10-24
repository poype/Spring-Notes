package com.poype.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class TestApplicationListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("Test Application Listener " + event);
    }
}
