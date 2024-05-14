package com.group.libraryapp.dto.fruit;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
public class FruitCreateRequest {

    private String name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
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
