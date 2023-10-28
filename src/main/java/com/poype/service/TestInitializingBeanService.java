package com.poype.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class TestInitializingBeanService implements InitializingBean, DisposableBean {

    private String name;

    private String description;

    /*
     * 当所有的properties都被set好之后，spring会调用afterPropertiesSet这个方法
     * 在这个实例中，afterPropertiesSet会在构造函数之后被调用
     */
    @Override
    public void afterPropertiesSet() {
        System.out.println("afterPropertiesSet method is invoked");
        System.out.println(this.name);
        System.out.println(this.description);
    }

    @Override
    public String toString() {
        return "TestInitializingBeanService{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*
     * DisposableBean接口提供方法public void destroy()
     * 当容器被close时，destroy方法会被调用
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("ApplicationContext has bean closed");
    }
}
