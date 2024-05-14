package com.group.libraryapp.service.fruit;

import com.group.libraryapp.domain.Fruits;
import com.group.libraryapp.dto.fruit.FruitCreateRequest;
import com.group.libraryapp.dto.fruit.FruitOverviewResponse;
import com.group.libraryapp.repository.fruit.FruitMySqlRepository;

import java.util.List;

//@Service
public class FruitService {
    private final FruitMySqlRepository fruitRepository;
    private FruitOverviewResponse fruitOverviewResponse;

    public FruitService(FruitMySqlRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
        //this.fruitOverviewResponse = fruitOverviewResponse;
    }
    public void saveFruit(FruitCreateRequest request){
        fruitRepository.saveFruit(request.getName(),request.getPrice(),request.getWarehousingDate());
    }

    public void saleFruit(int id) {
        fruitRepository.saleFruit(id);
    }

    public FruitOverviewResponse overviewFruit(String name) {
        List<Fruits> list = fruitRepository.overviewFruit(name);
        long notsalesamount = 0;
        long salesamount = 0;
        for(Fruits e : list){
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
