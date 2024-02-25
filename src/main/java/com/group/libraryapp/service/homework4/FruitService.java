package com.group.libraryapp.service.homework4;

import com.group.libraryapp.dto.homework4.FruitResponse;
import com.group.libraryapp.dto.homework4.FruitUpdateRequest;
import com.group.libraryapp.dto.homework4.SaveFruitRequest;
import com.group.libraryapp.repository.homework4.FruitRepository;
import org.springframework.stereotype.Service;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }
    public void saveFruit(SaveFruitRequest request){
        fruitRepository.saveFruit(request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    public void updateFruit(FruitUpdateRequest request){
        if(fruitRepository.isFruitNotExist(request.getId())){
            throw new IllegalArgumentException();
        }
        fruitRepository.updateFruit(request.getId());
    }

    public FruitResponse getFruits(String name){
        if(fruitRepository.isFruitNotExist(name)){
            throw new IllegalArgumentException();
        }
        long soldFruitPrice = fruitRepository.getSoldFruitPrice(name);
        long notSoldFruitPrice = fruitRepository.getNotSoldFruitPrice(name);
        return new FruitResponse(soldFruitPrice, notSoldFruitPrice);
    }
}
