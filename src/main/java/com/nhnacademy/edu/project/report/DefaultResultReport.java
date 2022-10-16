package com.nhnacademy.edu.project.report;

import com.nhnacademy.edu.project.parser.WaterBill;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultResultReport implements ResultReport {

    @Override
    public List<WaterBill> report(List<WaterBill> data) {

        // 요금 내림차순 정렬 && limit 5
        List<WaterBill> reportList = data.stream()
                .sorted(Comparator.comparingLong(WaterBill::getUnitPrice))
                .limit(5)
                .collect(Collectors.toList());

        return reportList;
    }
}
