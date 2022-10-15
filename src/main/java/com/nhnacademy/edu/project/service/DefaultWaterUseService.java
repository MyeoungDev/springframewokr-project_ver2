package com.nhnacademy.edu.project.service;

import com.nhnacademy.edu.project.parser.WarterBill;
import com.nhnacademy.edu.project.repository.TariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultWaterUseService implements WaterUseService {

    @Autowired
    TariffRepository tariffRepository;

    @Override
    public List<WarterBill> calcBillTotal(int waterUsage) {

        List<WarterBill> priceByUsage = tariffRepository.findPriceByUsage(waterUsage);
        priceByUsage.forEach(warterBill -> warterBill.setBillTotal(warterBill.getUnitPrice() * waterUsage));

        return priceByUsage;
    }
}
