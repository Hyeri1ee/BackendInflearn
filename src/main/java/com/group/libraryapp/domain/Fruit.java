package com.group.libraryapp.domain;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 20, name = "name" )
    private String name;
    @Column(nullable = false, name = "warehousingDate")
    private LocalDate warehousingDate;
    @Column(nullable = false, name = "price")
    private long price;
    @Column(nullable = false,name = "saled")
    private int saled;

    public Fruit() {
    }

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
