package com.nhnacademy.edu.project.config;


import com.nhnacademy.edu.project.parser.CsvDataParser;
import com.nhnacademy.edu.project.parser.DataParser;
import com.nhnacademy.edu.project.parser.JsonDataParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "com.nhnacademy.edu.project")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MainConfig {

    @Bean
    public DataParser csvDataParser() {
        return new CsvDataParser();
    }

    @Bean
    public DataParser jsonDataParser() {
        return new JsonDataParser();
    }

    public DataParser getDataParser(String fileExtension) {
        if (fileExtension.equals("csv")) {
            return csvDataParser();
        } else if (fileExtension.equals("json")) {
            return jsonDataParser();
        } else {
            return null;
        }
    }


}
