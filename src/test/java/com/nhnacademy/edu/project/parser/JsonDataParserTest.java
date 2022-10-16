package com.nhnacademy.edu.project.parser;

import com.nhnacademy.edu.project.config.MainConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class JsonDataParserTest {

    @Test
    void parse() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

        DataParser jsonDataParser = context.getBean("jsonDataParser", DataParser.class);
        File jsonFile = new File("src/main/resources/data/Tariff_20220331.json");
        jsonDataParser.parse(jsonFile.getAbsolutePath());

        Assertions.assertThat(jsonDataParser.findAll()).isNotEmpty();
        Assertions.assertThat(jsonDataParser.findAll().stream().count()).isEqualTo(303);

    }
}