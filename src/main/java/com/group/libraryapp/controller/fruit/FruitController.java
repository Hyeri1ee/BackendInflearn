package com.group.libraryapp.controller.fruit;

import com.group.libraryapp.dto.fruit.FruitCreateRequest;
import com.group.libraryapp.dto.fruit.FruitOverviewResponse;
import com.group.libraryapp.service.fruit.FruitLatestService;
import com.group.libraryapp.service.fruit.FruitService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

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


}