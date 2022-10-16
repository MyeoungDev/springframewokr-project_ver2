package com.nhnacademy.edu;

import com.nhnacademy.edu.project.parser.WaterBill;
import com.nhnacademy.edu.project.report.ResultReport;
import com.nhnacademy.edu.project.repository.Tariff;
import com.nhnacademy.edu.project.service.WaterUseService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

//        File file = new File("src/main/resources/data/Tariff_20220331.csv");

        File file = new File("src/main/resources/data/Tariff_20220331.json");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.nhnacademy.edu.project");

        int waterUsage;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Tariff tariffRepository = context.getBean("tariffRepository", Tariff.class);
        tariffRepository.load(file.getAbsolutePath());

        while ((waterUsage = Integer.parseInt(br.readLine())) > 0) {

            WaterUseService defaultWaterUseService = context.getBean("defaultWaterUseService", WaterUseService.class);

            List<WaterBill> waterBills = defaultWaterUseService.calcBillTotal(waterUsage);

            ResultReport defaultResultReport = context.getBean("defaultResultReport", ResultReport.class);
            List<WaterBill> report = defaultResultReport.report(waterBills);
            System.out.println(report);

        }










    }
}
