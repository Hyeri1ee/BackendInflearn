package com.group.libraryapp.repository;

import com.group.libraryapp.domain.Fruit;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FruitJdbcRepository implements FruitRepository{
    private final JdbcTemplate jdbcTemplate;

    public FruitJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveFruitInfo(Fruit fruit) {
        String sql = "INSERT INTO other_fruits (name, warehousingDate,price) VALUES (?,?,?)";

        jdbcTemplate.update(sql, fruit.getName(),fruit.getWarehousingDate(),fruit.getPrice());
    }
}
