package com.group.libraryapp.controller.fruit;

import com.group.libraryapp.dto.fruit.FruitCreateRequest;
import com.group.libraryapp.dto.fruit.FruitOverviewResponse;
import com.group.libraryapp.service.fruit.FruitService;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

@RestController
public class FruitController {
    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    //문제1
    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request) {
        fruitService.saveFruit(request);
    }

    //문제2
    @PutMapping("/api/v1/fruit")
    public void saledFruit(@RequestParam int id){
        fruitService.saleFruit(id);
    }

    //문제3
    @GetMapping("/api/v1/fruit/stat")
    public FruitOverviewResponse overviewFruit(@RequestParam String name){
        return fruitService.overviewFruit(name);
    }


    //7일차 과제 문제2
    @GetMapping("/api/v1/fruit/count")
    @Description("거쳐간 특정 과일의 개수 반환")
    public FruitCountResponse countFruit(@RequestParam Long count){
        return fruitService.countFruit(count);
    }
}