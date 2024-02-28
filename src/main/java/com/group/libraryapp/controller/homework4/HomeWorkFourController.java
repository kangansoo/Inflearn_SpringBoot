package com.group.libraryapp.controller.homework4;

import com.group.libraryapp.domain.homework4.Fruit;
import com.group.libraryapp.dto.homework4.FruitResponse;
import com.group.libraryapp.dto.homework4.FruitUpdateRequest;
import com.group.libraryapp.dto.homework4.SaveFruitRequest;
import com.group.libraryapp.service.homework4.FruitServiceV2;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class HomeWorkFourController {

    private final FruitServiceV2 fruitService;

    public HomeWorkFourController(FruitServiceV2 fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody SaveFruitRequest request){
        fruitService.saveFruit(request);
    }

    @PutMapping("/api/v1/fruit")
    public void updateFruit(@RequestBody FruitUpdateRequest request){
        fruitService.updateFruit(request);
    }

    @GetMapping("/api/v1/fruit/stat")
    public FruitResponse getFruits(@RequestParam String name){
        
        return fruitService.getFruits(name);
    }

    @GetMapping("api/v1/fruit/count")
    public long countFruit(@RequestParam String name){
        return fruitService.countFruit(name);
    }

    @GetMapping("api/v1/fruit/list")
    public List<Fruit> fruitList(@RequestParam String option, @RequestParam long price){
        return fruitService.getFruitList(option, price);
    }
}
