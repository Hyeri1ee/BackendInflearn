package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.domain.Fruit;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FruitMemoryRepository implements FruitRepository {
    private final JdbcTemplate jdbcTemplate;
    private List<Fruit> memory = new ArrayList<>();
    private int num = 0;


    public FruitMemoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveFruit(String name, long price, LocalDate warehousingDate) {

        memory.add(new Fruit(num+1,name, warehousingDate,price,1));
    }

    public void saleFruit(int id){
        for (Fruit e : memory){
            if (e.getId() == id)
                e.setSaled(0);
            else
                throw new IllegalArgumentException();
        }
    }

    public List<Fruit> overviewFruit(String name){
        List<Fruit> list = new ArrayList<>();
        for (Fruit e : memory){
            if (e.getName().equals(name)){
                list.add(e);
            }else
                throw new IllegalArgumentException();
        }

        return list;
    }
}
