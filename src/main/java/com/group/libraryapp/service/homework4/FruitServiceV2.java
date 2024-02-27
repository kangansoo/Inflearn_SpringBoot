package com.group.libraryapp.service.homework4;

import com.group.libraryapp.domain.homework4.Fruit;
import com.group.libraryapp.domain.homework4.FruitRepository;
import com.group.libraryapp.dto.homework4.FruitResponse;
import com.group.libraryapp.dto.homework4.FruitUpdateRequest;
import com.group.libraryapp.dto.homework4.SaveFruitRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceV2 {
    private final FruitRepository fruitRepository;

    public FruitServiceV2(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void saveFruit(SaveFruitRequest request){
        Fruit f = fruitRepository.save(new Fruit(request.getName(), request.getWarehousingDate(), request.getPrice()));
    }

    public void updateFruit(FruitUpdateRequest request){
        Fruit fruit = fruitRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);
        fruit.updateSold(1);
        fruitRepository.save(fruit);
    }

    public FruitResponse getFruits(String name){
        List<Fruit> soldFruits = fruitRepository.findAllByNameAndIsSold(name, 1);
        List<Fruit> notSoldFruits = fruitRepository.findAllByNameAndIsSold(name, 0);

        long salesAmount = soldFruits.stream()
                .mapToLong(Fruit::getPrice).sum();
        long notSalesAmount = notSoldFruits.stream()
                .mapToLong(Fruit::getPrice).sum();
        return new FruitResponse(salesAmount, notSalesAmount);
    }
}
