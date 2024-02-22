package com.group.libraryapp.dto.homework4;

public class FruitResponse {
    private long SalesAmount;
    private long notSalesAmount;

    public FruitResponse(long salesAmount, long notSalesAmount) {
        this.SalesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }

    public long getSalesAmount() {
        return SalesAmount;
    }

    public long getNotSalesAmount() {
        return notSalesAmount;
    }
}
