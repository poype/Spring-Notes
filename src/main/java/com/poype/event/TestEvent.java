package com.poype.event;

import org.springframework.context.ApplicationEvent;

public class TestEvent extends ApplicationEvent {

    private final String name;

    public TestEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestEvent [name=" + name + "]";
    }
}
