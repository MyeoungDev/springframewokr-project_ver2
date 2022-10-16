package com.nhnacademy.edu.project.service;

import com.nhnacademy.edu.project.parser.CsvDataParser;
import com.nhnacademy.edu.project.parser.WaterBill;
import com.nhnacademy.edu.project.repository.TariffRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class DefaultWaterUseServiceTest {

    @InjectMocks
    CsvDataParser csvDataParser;

    @InjectMocks
    TariffRepository tariffRepository;

    DefaultWaterUseService defaultWaterUseService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        tariffRepository = new TariffRepository(csvDataParser);
        defaultWaterUseService = new DefaultWaterUseService(tariffRepository);

        File file = new File("src/main/resources/data/Tariff_20220331.csv");

        tariffRepository.load(file.getAbsolutePath());

    }

    @Test
    void calcBillTotal() {

        // 사용량
        int usage = 1000;

        List<WaterBill> waterBills = defaultWaterUseService.calcBillTotal(usage);
        boolean checkNull = true;
        boolean checkPrice = true;

        for (WaterBill bill : waterBills) {
            if (bill.getBillTotal() == 0) {
                checkNull = false;
            }

            if (bill.getBillTotal() / usage != bill.getUnitPrice()) {
                checkPrice = false;
            }

        }

        assertThat(checkNull).isTrue();
        assertThat(checkPrice).isTrue();


    }
}