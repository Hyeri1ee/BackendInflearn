package com.group.libraryapp.dto.fruit;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
public class FruitCreateRequest {

    private String name;
    private LocalDate warehousingDate;
    private long price;
    private int saled;

    public FruitCreateRequest() {
    }

    public FruitCreateRequest(String name, LocalDate warehousingDate, long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }

    public int getSaled() {
        return saled;
    }
}
