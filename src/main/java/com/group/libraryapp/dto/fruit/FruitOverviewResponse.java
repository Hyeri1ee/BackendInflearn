package com.group.libraryapp.dto.fruit;

import org.springframework.stereotype.Service;

@Service
public class FruitOverviewResponse {
    private long salesAmount;
    private long notSalesAmount;

    public long getSalesAmount() {
        return salesAmount;
    }

    public long getNotSalesAmount() {
        return notSalesAmount;
    }

    public void setSalesAmount(long salesAmount) {
        this.salesAmount = salesAmount;
    }

    public void setNotSalesAmount(long notSalesAmount) {
        this.notSalesAmount = notSalesAmount;
    }
}
