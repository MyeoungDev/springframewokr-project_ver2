package com.nhnacademy.edu.project.report;

import com.nhnacademy.edu.project.parser.WarterBill;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultResultReport implements ResultReport {


    // 여기서 데이터를 어떻게 가공해서 내보낼지 ?
    @Override
    public List<WarterBill> report(List<WarterBill> data) {

        // 요금 내림차순 정렬 && limit 5
        return data.stream()
                .sorted((b1, b2) -> b1.getBillTotal() - b2.getBillTotal())
                .limit(5)
                .collect(Collectors.toList());
    }
}
