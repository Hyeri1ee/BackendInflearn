package com.group.libraryapp.controller.fruit;

import com.group.libraryapp.domain.Fruits;
import com.group.libraryapp.dto.fruit.FruitCountResponse;
import com.group.libraryapp.dto.fruit.FruitCreateRequest;
import com.group.libraryapp.dto.fruit.FruitOverviewResponse;
import com.group.libraryapp.service.fruit.FruitLatestService;
import com.group.libraryapp.service.fruit.FruitService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {
    private final FruitLatestService fruitService;

    public FruitController( FruitLatestService fruitService) {
        this.fruitService = fruitService;
    }

    //문제1
    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request) {
        fruitService.saveFruit(request);
    }

    //문제2
    @PutMapping("/api/v1/fruit")
    public void saleFruit(@RequestParam long id){
        fruitService.saleFruit(id);
    }

    //문제3
    @GetMapping("/api/v1/fruit/stat")
    public FruitOverviewResponse overviewFruit(@RequestParam String name){
        return fruitService.overviewFruit(name);
    }

    @GetMapping("/api/v1/fruit/count")
    @Description("지금까지 거쳐간 특정 과일이름의 개수를 반환(7일차-문제2)")
    public FruitCountResponse countName(@RequestParam String name){
        return fruitService.countName(name);
    }

    @GetMapping("/api/v1/fruit/list")
    @Description("판매되지 않은 특정 금액 이상 혹은 특정 금액 이하의 과일 목록(7일차-문제3)")
    public List<Fruits> getListFruit(@RequestParam String option, @RequestParam long price){
        return fruitService.overviewFruitCondition(option,price);
    }
}