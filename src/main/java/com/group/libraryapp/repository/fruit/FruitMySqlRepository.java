package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.domain.Fruits;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

//@Repository
//@Qualifier("sql")
public class FruitMySqlRepository{

    private final JdbcTemplate jdbcTemplate;

    public FruitMySqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveFruit(String name, long price, LocalDate warehousingDate) {
        String sql = "INSERT INTO fruits(name, warehousingDate, price,saled) Values (?,?,?,?)";
        jdbcTemplate.update(sql, name, warehousingDate,price, 1);
    }

    public void saleFruit(int id){
        String readSql = "SELECT * FROM fruits WHERE id = ?";
        boolean fruitNotExist = jdbcTemplate.query(readSql, (rs,rowNum)-> 0,id).isEmpty();
        if (fruitNotExist){
            throw new IllegalArgumentException();
        }
        //fruit exists
        String sql = "UPDATE fruits SET saled = ? WHERE id = ?";
        jdbcTemplate.update(sql, 0,id);
    }

    public List<Fruits> overviewFruit(String name){
        String readSql = "SELECT * FROM fruits WHERE name = ?";
        List<Fruits> list  = jdbcTemplate.query(readSql, (rs, rowNum) -> {
            String rs_name = rs.getString("name");
            long rs_price = rs.getLong("price");
            LocalDate rs_warehousingDate = rs.getDate("warehousingDate").toLocalDate();
            int rs_saled = rs.getInt("saled");
            return new Fruits(rs_name, rs_warehousingDate,rs_price,rs_saled);
        }, name);

        if (list.isEmpty())
            throw new IllegalArgumentException();

        return list;
    }
}
