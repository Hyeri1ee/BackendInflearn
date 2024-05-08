package com.group.libraryapp.dto.fruit.response;

public class GetFruitResponseDto {
    private long salesAmount;

    private long notSalesAmount;

    public GetFruitResponseDto(long salesAmount, long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }

    public long getSalesAmount() {
        return salesAmount;
    }

    public long getNotSalesAmount() {
        return notSalesAmount;
    }
}
