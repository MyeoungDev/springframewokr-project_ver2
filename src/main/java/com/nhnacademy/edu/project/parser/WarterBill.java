package com.nhnacademy.edu.project.parser;

public class WarterBill {

    private final int index;
    private final String city;
    private String sector;

    private int sctionStart;
    private int sctionEnd;

    private int unitPrice;
    private int billTotal;

    public WarterBill(int index, String city, String sector,int sctionStart, int sctionEnd, int unitPrice) {
        this.index = index;
        this.city = city;
        this.sector = sector;
        this.sctionStart = sctionStart;
        this.sctionEnd = sctionEnd;
        this.unitPrice = unitPrice;
        // 총 금액
//        this.billTotal = null;
    }

    public String getCity() {
        return city;
    }

    public String getSector() {
        return sector;
    }

    public int getSctionStart() {
        return sctionStart;
    }

    public int getSctionEnd() {
        return sctionEnd;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getBillTotal() {
        return billTotal;
    }

    @Override
    public String toString() {
        return "WarterBill{" +
                "index=" + index +
                ", city='" + city + '\'' +
                ", sector='" + sector + '\'' +
                ", sctionStart=" + sctionStart +
                ", sctionEnd=" + sctionEnd +
                ", unitPrice=" + unitPrice +
                ", billTotal=" + billTotal +
                '}';
    }
}
