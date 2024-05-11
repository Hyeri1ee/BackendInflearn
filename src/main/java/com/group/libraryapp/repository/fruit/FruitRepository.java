package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit,Long> {
    public void saveFruit(String name, long price, LocalDate warehousingDate);
    public void saleFruit(int id);
    public List<Fruit> overviewFruit(String name);
}

