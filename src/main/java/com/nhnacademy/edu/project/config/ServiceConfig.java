package com.nhnacademy.edu.project.config;

import com.nhnacademy.edu.project.service.DefaultWaterUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
public class ServiceConfig {
    @Autowired
    private RepoConfig repoConfig;

    public DefaultWaterUseService defaultWaterUseService() {
        return new DefaultWaterUseService(repoConfig.tariffRepository());
    }

}
