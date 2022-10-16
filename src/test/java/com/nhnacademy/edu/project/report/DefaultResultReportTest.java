package com.nhnacademy.edu.project.report;

import com.nhnacademy.edu.project.config.MainConfig;
import com.nhnacademy.edu.project.parser.CsvDataParser;
import com.nhnacademy.edu.project.parser.WaterBill;
import com.nhnacademy.edu.project.repository.TariffRepository;
import com.nhnacademy.edu.project.service.DefaultWaterUseService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class DefaultResultReportTest {


    @InjectMocks
    CsvDataParser csvDataParser;

    TariffRepository tariffRepository;
    DefaultWaterUseService defaultWaterUseService;

    DefaultResultReport defaultResultReport;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        File file = new File("src/main/resources/data/Tariff_20220331.csv");


        tariffRepository = new TariffRepository(new MainConfig());

        tariffRepository.load(file.getAbsolutePath());

        defaultWaterUseService = new DefaultWaterUseService(tariffRepository);
        defaultResultReport = new DefaultResultReport();

    }

    @Test
    void report() {

        List<WaterBill> report = defaultResultReport.report(defaultWaterUseService.calcBillTotal(1000));
        assertThat(report.size()).isEqualTo(5);
        assertThat(report.get(0).getUnitPrice()).isEqualTo(370);
    }
}