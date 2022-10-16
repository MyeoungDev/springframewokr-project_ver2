package com.nhnacademy.edu.project.service;

import com.nhnacademy.edu.project.parser.WaterBill;
import com.nhnacademy.edu.project.repository.TariffRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultWaterUseService implements WaterUseService {

    private final TariffRepository tariffRepository;

    public DefaultWaterUseService(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    @Override
    public List<WaterBill> calcBillTotal(int waterUsage) {

        List<WaterBill> priceByUsage = tariffRepository.findPriceByUsage(waterUsage);
        priceByUsage.forEach(waterBill -> waterBill.setBillTotal(waterBill.getUnitPrice() * waterUsage));

        return priceByUsage;
    }
}
