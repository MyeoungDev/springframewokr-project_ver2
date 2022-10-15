package com.nhnacademy.edu.project.report;

import com.nhnacademy.edu.project.parser.WaterBill;

import java.util.List;

public interface ResultReport {

    public List<WaterBill> report(List<WaterBill> data);

}
