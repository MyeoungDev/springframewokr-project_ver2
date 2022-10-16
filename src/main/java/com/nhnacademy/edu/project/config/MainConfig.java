package com.nhnacademy.edu.project.config;


import com.nhnacademy.edu.project.aop.LogAspect;
import com.nhnacademy.edu.project.parser.CsvDataParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.nhnacademy.edu.project")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MainConfig {

    public CsvDataParser csvDataParser() {
        return new CsvDataParser();
    }

}
