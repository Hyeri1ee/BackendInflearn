package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.domain.Fruits;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Repository
public class FruitMemoryRepository {
    private final JdbcTemplate jdbcTemplate;
    private List<Fruits> memory = new ArrayList<>();
    private int num = 0;


    public FruitMemoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveFruit(String name, long price, LocalDate warehousingDate) {

        memory.add(new Fruits(num+1,name, warehousingDate,price,1));
    }

    public void saleFruit(int id){
        for (Fruits e : memory){
            if (e.getId() == id)
                e.setSaled(0);
            else
                throw new IllegalArgumentException();
        }
    }

    public List<Fruits> overviewFruit(String name){
        List<Fruits> list = new ArrayList<>();
        for (Fruits e : memory){
            if (e.getName().equals(name)){
                list.add(e);
            }else
                throw new IllegalArgumentException();
        }

        return list;
    }
}
