package com.group.libraryapp.domain;

import java.time.LocalDate;

public class Fruit {
    private long id;
    private String name;
    private LocalDate warehousingDate;
    private long price;
    private boolean isSold;

    public Fruit(String name, LocalDate warehousingDate, long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
    }

    public long getId() {
        return id;
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

    public boolean isSold() {
        return isSold;
    }
}