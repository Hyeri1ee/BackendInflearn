package com.group.libraryapp.repository;

import com.group.libraryapp.domain.Fruit;
import com.group.libraryapp.dto.fruit.response.GetFruitResponseDto;

public interface FruitRepository {
    void saveFruitInfo(Fruit fruit);
    void updateFruitInfo(long id);

    GetFruitResponseDto getFruitInfo(String name);
}
