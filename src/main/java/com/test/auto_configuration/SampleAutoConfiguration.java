package com.test.auto_configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleAutoConfiguration {

    @Bean
    public SampleService sampleService() {
        SampleService sampleService = new SampleService();
        sampleService.setDescription("test auto configuration");
        return sampleService;
    }
}
