package com.group.libraryapp.domain;

import java.time.LocalDate;

public class Fruit {
    private String name;
    private LocalDate warehousingDate;
    private long price;
    private int saled;

    public Fruit(String name, LocalDate warehousingDate, long price,int saled) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.saled = saled;
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

    public int getSaled(){
        return saled;
    }
}
