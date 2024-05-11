package com.group.libraryapp.domain;

import java.time.LocalDate;

public class Fruit {
    private int id;
    private String name;
    private LocalDate warehousingDate;
    private long price;
    private int saled;

    public Fruit(int id, String name, LocalDate warehousingDate, long price, int saled) {
        this.id = id;
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.saled = saled;
    }

    public Fruit(String name, LocalDate warehousingDate, long price, int saled) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.saled = saled;
    }

    public int getId() {
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

    public int getSaled(){
        return saled;
    }

    public void setSaled(int saled) {
        this.saled = saled;
    }
}
