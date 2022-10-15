package com.nhnacademy.edu.project.parser;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class CsvDataParser implements DataParser {

    Collection<WaterBill> list;

    public CsvDataParser() {
        this.list = new ArrayList<>();
    }

    @Override
    public void parse(String fileLocation) {

//        File file = new File("src/main/resources/data/Tariff_20220331.csv");
//        try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileLocation))) {
            String line;
            br.readLine();  // 첫 라인 스킵
            while ((line = br.readLine()) != null) {
                String[] value = line.split(",");
                WaterBill temp = new WaterBill(
                        Integer.parseInt(value[0]), // seq
                        value[1],   // city
                        value[2],   // sctor
                        Integer.parseInt(value[4]),  // 구간시작
                        Integer.parseInt(value[5]),
                        Integer.parseInt(value[6])  // unitPrice
                );
                list.add(temp);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<WaterBill> findAll() {
        return list;
    }
}
