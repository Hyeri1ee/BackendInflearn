package com.group.libraryapp.controller.fruit;

import com.group.libraryapp.dto.fruit.request.SaveFruitInfoRequestDto;
import com.group.libraryapp.service.FruitService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/v1")
@RestController
public class FruitController {
    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/fruit")
    public void saveFruitInfo(@RequestBody @Valid SaveFruitInfoRequestDto requestDto) {
        this.fruitService.saveFruitInfo(requestDto);
    }

}