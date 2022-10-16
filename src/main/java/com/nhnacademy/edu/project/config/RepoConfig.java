package com.nhnacademy.edu.project.config;

import com.nhnacademy.edu.project.repository.TariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
public class RepoConfig {

    @Autowired
    private MainConfig mainConfig;

    public TariffRepository tariffRepository() {
        return new TariffRepository(mainConfig.csvDataParser());
    }


}
