package com.group.libraryapp.controller.homework2;

import com.group.libraryapp.dto.hw2.request.CalSumRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalSumController {
    @PostMapping("/sum")
    public int addFiveNumbers(@RequestBody CalSumRequest request){
        List<Integer> numbers = request.getNumbers();

        int sum = 0;
        for(int number : numbers){
            sum+=number;
        }
        return sum;
    }
}
