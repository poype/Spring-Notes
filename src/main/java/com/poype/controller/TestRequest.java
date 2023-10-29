package com.poype.controller;

public class TestRequest {

    private String name;

    private int age;

    private String description;

    @Override
    public String toString() {
        return "TestRequest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
