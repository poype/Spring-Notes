package com.test.auto_configuration;

public class SampleService {

    private String description;

    public String toString() {
        return "SampleService " + description;
    }

    public void test() {
        System.out.println(this);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
