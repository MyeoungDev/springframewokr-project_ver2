package com.nhnacademy.edu.project.parser;

public class WaterBill {

    private final int index;
    private final String city;
    private String sector;

    private int sctionStart;
    private int sctionEnd;

    private int unitPrice;
    private long billTotal;

    public WaterBill(int index, String city, String sector, int sctionStart, int sctionEnd, int unitPrice) {
        this.index = index;
        this.city = city;
        this.sector = sector;
        this.sctionStart = sctionStart;
        this.sctionEnd = sctionEnd;
        this.unitPrice = unitPrice;
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

    public long getBillTotal() {
        return billTotal;
    }

    public void setBillTotal(int billTotal) {
        this.billTotal = billTotal;
    }

    @Override
    public String toString() {
        return "WaterBill{" +
                "city='" + city + '\'' +
                ", sector='" + sector + '\'' +
                ", unitPrice=" + unitPrice +
                ", billTotal=" + billTotal +
                '}' + '\n';
    }
}
