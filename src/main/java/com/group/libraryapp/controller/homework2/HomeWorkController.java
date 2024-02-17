package com.group.libraryapp.controller.homework2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HomeWorkController {

    @GetMapping("/hw2")
    public HashMap<String, Integer> hwResult(@RequestParam int num1, @RequestParam int num2){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("add", num1+num2);
        map.put("minus", num1-num2);
        map.put("multiply", num1*num2);

        return map;
    }
}
