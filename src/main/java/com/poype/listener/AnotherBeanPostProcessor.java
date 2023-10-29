package com.poype.listener;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class AnotherBeanPostProcessor implements BeanPostProcessor, Ordered {

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("AnotherBeanPostProcessor postProcessAfterInitialization --- >"+beanName);
        return bean;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("AnotherBeanPostProcessor postProcessBeforeInitialization --- >"+beanName);
        return bean;
    }

    public int getOrder() {
        return 1;
    }

}
