package com.group.libraryapp.service.fruit;

import com.group.libraryapp.domain.Fruits;
import com.group.libraryapp.dto.fruit.FruitCreateRequest;
import com.group.libraryapp.dto.fruit.FruitOverviewResponse;
import com.group.libraryapp.repository.fruit.FruitRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class FruitLatestService {
    private final FruitRepository fruitRepository;

    public FruitLatestService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void saveFruit(FruitCreateRequest request){
        fruitRepository.save(new Fruits(request.getName(), request.getWarehousingDate(),request.getPrice(),1));
    }

    public void saleFruit(long id){
        Fruits finded = fruitRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        finded.setSaled(0);
        fruitRepository.save(finded);
    }
    public FruitOverviewResponse overviewFruit(String name){
        long salesAmount = fruitRepository.countByNameAndSaled(name, 0);
        long notSalesAmount = fruitRepository.countByNameAndSaled(name, 1);

        return new FruitOverviewResponse(salesAmount, notSalesAmount);
    }
}
