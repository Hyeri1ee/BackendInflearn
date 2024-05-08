package com.group.libraryapp.service;

import com.group.libraryapp.domain.Fruit;
import com.group.libraryapp.dto.fruit.request.SaveFruitInfoRequestDto;
import com.group.libraryapp.repository.FruitRepository;
import org.springframework.stereotype.Service;

@Service
public class FruitService {
    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void saveFruitInfo(SaveFruitInfoRequestDto requestDto){
        Fruit fruit = requestDto.toEntity();
        this.fruitRepository.saveFruitInfo(fruit);
    }
}
