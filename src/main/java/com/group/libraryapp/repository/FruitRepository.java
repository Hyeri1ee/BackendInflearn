package com.group.libraryapp.repository;

import com.group.libraryapp.domain.Fruit;

import java.time.LocalDate;
import java.util.List;

public interface FruitRepository {
    public void saveFruit(String name, long price, LocalDate warehousingDate);
    public void saleFruit(int id);
    public List<Fruit> overviewFruit(String name);
}
