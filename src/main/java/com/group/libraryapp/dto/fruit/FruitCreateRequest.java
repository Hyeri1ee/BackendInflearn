package com.group.libraryapp.dto.fruit;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class FruitCreateRequest {

    private String name;
    private LocalDate warehousingDate;
    private long price;
    private int saled;

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
