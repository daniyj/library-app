package com.group.libraryapp.z_self_study.Day4.dto;

public class GetSalesAmountResponse {
    private long salesAmount;
    private long notSalesAmount;

    public GetSalesAmountResponse(long salesAmount, long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }

    public long getNotSalesAmount() {
        return notSalesAmount;
    }

    public long getSalesAmount() {
        return salesAmount;
    }
}
