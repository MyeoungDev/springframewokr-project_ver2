package com.nhnacademy.edu.project.config;

import com.nhnacademy.edu.project.service.DefaultWaterUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ServiceConfig {
    @Autowired
    private RepoConfig repoConfig;

    @Bean
    public DefaultWaterUseService defaultWaterUseService() {
        return new DefaultWaterUseService(repoConfig.tariffRepository());
    }

}
