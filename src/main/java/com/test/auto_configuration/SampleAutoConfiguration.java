package com.test.auto_configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleAutoConfiguration {

    @Bean
    public SampleService sampleService1() {
        SampleService sampleService = new SampleService();
        sampleService.setDescription("test auto configuration 111111111111111");
        return sampleService;
    }

    @Bean
    public SampleService sampleService2() {
        SampleService sampleService = new SampleService();
        sampleService.setDescription("test auto configuration 222222222222222");
        return sampleService;
    }
}
