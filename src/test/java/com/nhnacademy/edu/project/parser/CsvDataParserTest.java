package com.nhnacademy.edu.project.parser;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.util.Collection;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CsvDataParserTest {

    @InjectMocks
    CsvDataParser csvDataParser;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void parse() {

        File file = new File("src/main/resources/data/Tariff_20220331.csv");

        csvDataParser.parse(file.getAbsolutePath());
        Collection<WaterBill> all = csvDataParser.findAll();

        assertThat(all).isNotEmpty();
    }

    @Test
    void findAll() {

        File file = new File("src/main/resources/data/Tariff_20220331.csv");

        csvDataParser.parse(file.getAbsolutePath());

        // 총 데이터 갯수 303개
        
        Collection<WaterBill> all = csvDataParser.findAll();
        assertThat(all.stream().count()).isEqualTo(303);
    }
}