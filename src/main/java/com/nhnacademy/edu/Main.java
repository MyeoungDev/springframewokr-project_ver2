package com.nhnacademy.edu;

import com.nhnacademy.edu.project.parser.WarterBill;
import com.nhnacademy.edu.project.report.ResultReport;
import com.nhnacademy.edu.project.repository.Tariff;
import com.nhnacademy.edu.project.service.WaterUseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        File file = new File("src/main/resources/data/Tariff_20220331.csv");
//        file.getAbsolutePath();

//        CsvDataParser csvDataParser = new CsvDataParser();
//        csvDataParser.parse(file.getAbsolutePath());
//        csvDataParser.findAll().stream().forEach(d -> System.out.println(d));

        ApplicationContext context = new AnnotationConfigApplicationContext("com.nhnacademy.edu.project");
        Tariff tariffRepository = context.getBean("tariffRepository", Tariff.class);
        tariffRepository.load(file.getAbsolutePath());
//        tariffRepository.findPriceByUsage(1000)
//                .stream().forEach(o -> System.out.println(o));

        WaterUseService defaultWaterUseService = context.getBean("defaultWaterUseService", WaterUseService.class);
        List<WarterBill> warterBills = defaultWaterUseService.calcBillTotal(1000);

        ResultReport defaultResultReport = context.getBean("defaultResultReport", ResultReport.class);
        List<WarterBill> report = defaultResultReport.report(warterBills);
        System.out.println(report);
    }
}
