package com.group.libraryapp.service;

import com.group.libraryapp.domain.Fruit;
import com.group.libraryapp.dto.fruit.FruitCreateRequest;
import com.group.libraryapp.dto.fruit.FruitOverviewResponse;
import com.group.libraryapp.repository.fruit.FruitRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {
    private final FruitRepository fruitRepository;
    private FruitOverviewResponse fruitOverviewResponse;

    public FruitService(@Qualifier("sql") FruitRepository fruitRepository, FruitOverviewResponse fruitOverviewResponse) {
        this.fruitRepository = fruitRepository;
        this.fruitOverviewResponse = fruitOverviewResponse;
    }
    public void saveFruit(FruitCreateRequest request){
        fruitRepository.saveFruit(request.getName(),request.getPrice(),request.getWarehousingDate());
    }

    public void saleFruit(int id) {
        fruitRepository.saleFruit(id);
    }

    public FruitOverviewResponse overviewFruit(String name) {
        List<Fruit> list = fruitRepository.overviewFruit(name);
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
}
