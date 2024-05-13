package com.group.libraryapp.domain;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
@Entity
public class Fruits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    @Column(nullable = false, length = 20 )
    private String name;
    @Column(nullable = false)
    private LocalDate warehousingDate;
    @Column(nullable = false)
    private long price;
    @Column(nullable = false)
    private int saled;

    public Fruits(){

    }
    public Fruits(long id, String name, LocalDate warehousingDate, long price, int saled) {
        this.id = id;
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.saled = saled;
    }

    public Fruits(String name, LocalDate warehousingDate, long price, int saled) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.saled = saled;
    }

    public Long getId() {
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
