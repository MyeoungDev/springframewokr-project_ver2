package com.nhnacademy.edu.project.repository;

import com.nhnacademy.edu.project.parser.DataParser;
import com.nhnacademy.edu.project.parser.WaterBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TariffRepository implements Tariff {

    private final DataParser dataParser;

    public TariffRepository(DataParser dataParser) {
        this.dataParser = dataParser;
    }

    @Override
    public void load(String fileLocation) {
        dataParser.parse(fileLocation);
    }

    @Override
    public List<WaterBill> findPriceByUsage(int waterUsage) {
        
        // sectionStart 가 waterUsage 보다 작고, sectionEnd가 waterUsage보다 큰 구간만 filter

        return dataParser.findAll().stream()
                .filter(bill ->
                    waterUsage >= bill.getSctionStart() && waterUsage <= bill.getSctionEnd()
                )
                .collect(Collectors.toList());
    }
}
