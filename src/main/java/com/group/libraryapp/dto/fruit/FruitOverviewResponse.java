package com.group.libraryapp.dto.fruit;

import com.group.libraryapp.domain.Fruits;

import java.time.LocalDate;
import java.util.List;

public class FruitOverviewResponse {
    private long salesAmount;
    private long notSalesAmount;


    public FruitOverviewResponse(long salesAmount, long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }

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
