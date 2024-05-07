package com.group.libraryapp.controller.fruit;

import com.group.libraryapp.domain.Fruit;
import com.group.libraryapp.dto.fruit.FruitCreateRequest;
import com.group.libraryapp.dto.fruit.FruitOverviewResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FruitController {

    private final JdbcTemplate jdbcTemplate;
    private final FruitOverviewResponse fruitOverviewResponse;

    public FruitController(JdbcTemplate jdbcTemplate, FruitOverviewResponse fruitOverviewResponse) {
        this.jdbcTemplate = jdbcTemplate;
        this.fruitOverviewResponse = fruitOverviewResponse;
    }

    //문제1
    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request) {
        String sql = "INSERT INTO fruits(name, warehousingDate, price,saled) Values (?,?,?,?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehousingDate(), request.getPrice(), 1);
    }

    //문제2
    @PutMapping("/api/v1/fruit")
    public void saledFruit(@RequestParam int id){
        String readSql = "SELECT * FROM fruits WHERE id = ?";
        boolean fruitNotExist = jdbcTemplate.query(readSql, (rs,rowNum)-> 0,id).isEmpty();
        if (fruitNotExist){
            throw new IllegalArgumentException();
        }
        //fruit exists
        String sql = "UPDATE fruits SET saled = ? WHERE id = ?";
        jdbcTemplate.update(sql, 0,id);
    }

    //문제3
    @GetMapping("/api/v1/fruit/stat")
    public FruitOverviewResponse overviewFruit(@RequestParam String name){

        String readSql = "SELECT * FROM fruits WHERE name = ?";
        List<Fruit> list  = jdbcTemplate.query(readSql, (rs,rowNum) -> {
            String rs_name = rs.getString("name");
            long rs_price = rs.getLong("price");
            LocalDate rs_warehousingDate = rs.getDate("warehousingDate").toLocalDate();
            int rs_saled = rs.getInt("saled");
            return new Fruit(rs_name,rs_warehousingDate,rs_price,rs_saled);
        }, name);

        if (list.isEmpty())
            throw new IllegalArgumentException();

        return fruitOverviewLogic(list);
    }
    //문제3 내의 서브 메서드
    private FruitOverviewResponse fruitOverviewLogic(List<Fruit> list) {
        long notsalesamount = 0;
        long salesamount = 0;
        for(Fruit e : list){
            if (e.getSaled() == 1)
                notsalesamount += e.getPrice();
            else
                salesamount += e.getPrice();
        }
        fruitOverviewResponse.setNotSalesAmount(notsalesamount);
        fruitOverviewResponse.setSalesAmount(salesamount);

        return fruitOverviewResponse;
    }

    //문제3
    @GetMapping("/api/v1/fruit/stat2")
    public FruitOverviewResponse overviewFruit2(@RequestParam String name){

    }


}