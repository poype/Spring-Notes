package com.poype.event;

import org.springframework.context.ApplicationEvent;

public class AnotherEvent extends ApplicationEvent {

    private final String name;

    public AnotherEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    @Override
    public String toString() {
        return "AnotherEvent [name=" + name + "]";
    }
}
