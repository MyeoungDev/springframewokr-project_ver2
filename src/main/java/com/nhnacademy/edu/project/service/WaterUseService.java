package com.nhnacademy.edu.project.service;

import com.nhnacademy.edu.project.parser.WarterBill;

import java.util.List;

public interface WaterUseService {

    public List<WarterBill> calcBillTotal(int waterUsage);
}
