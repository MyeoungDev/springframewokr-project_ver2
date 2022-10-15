package com.nhnacademy.edu.project.service;

import com.nhnacademy.edu.project.parser.WaterBill;

import java.util.List;

public interface WaterUseService {

    public List<WaterBill> calcBillTotal(int waterUsage);
}
