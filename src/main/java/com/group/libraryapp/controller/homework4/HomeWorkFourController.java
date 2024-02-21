package com.group.libraryapp.controller.homework4;

import com.group.libraryapp.dao.homework4.FruitDAO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.group.libraryapp.domain.homework4.Fruit;

@RestController
public class HomeWorkFourController {
    private final FruitDAO fruitDAO;

    public HomeWorkFourController(FruitDAO fruitDAO) {
        this.fruitDAO = fruitDAO;
    }

    @PostMapping("/api/v1/fruit")
    public Fruit saveFruit(@RequestBody Fruit fruit){
        return fruitDAO.save(fruit);
    }
}
