package com.poype.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestListener2 implements ApplicationListener<TestEvent> {

    private int sum = 1;

    @Override
    public void onApplicationEvent(TestEvent event) {
        System.out.println("Listener2 接收到消息" + sum + ":" + event);
        sum++;
    }
}
