package com.nhnacademy.edu.project.repository;

import com.nhnacademy.edu.project.parser.WaterBill;

import java.util.List;

public interface Tariff {

    // csv 파일 로드
    public void load(String fileLocation);

    // 사용량에 따른 표금 찾기
    public List<WaterBill> findPriceByUsage(int waterUsage);
}
