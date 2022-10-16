package com.nhnacademy.edu.project.repository;

import com.nhnacademy.edu.project.config.MainConfig;
import com.nhnacademy.edu.project.parser.CsvDataParser;
import com.nhnacademy.edu.project.parser.WaterBill;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TariffRepositoryTest {

    TariffRepository tariffRepository;

    @InjectMocks
    CsvDataParser csvDataParser;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        tariffRepository = new TariffRepository(new MainConfig());
    }

    @Test
    void load() {

        File file = new File("src/main/resources/data/Tariff_20220331.csv");

        tariffRepository.load(file.getAbsolutePath());

        assertThat(csvDataParser.findAll()).isNotEmpty();

    }

    @Test
    void findPriceByUsage() {

        // 사용량
        int usage = 1000;

        File file = new File("src/main/resources/data/Tariff_20220331.csv");

        tariffRepository.load(file.getAbsolutePath());

        List<WaterBill> priceByUsage = tariffRepository.findPriceByUsage(usage);

        assertThat(priceByUsage.stream().count()).isEqualTo(103);

        // 에러 던지는 상황 ( 사용량 < 0 || 사용량 > 999999999 )
        assertThrows(NoSuchElementException.class, () -> tariffRepository.findPriceByUsage(-1));

    }
}