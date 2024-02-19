package com.group.libraryapp.controller.homework2;

import com.group.libraryapp.dto.hw2.request.CalcRequest;
import com.group.libraryapp.dto.hw2.request.DayOfTheWeekRequest;
import com.group.libraryapp.dto.hw2.request.NumbersRequest;
import com.group.libraryapp.dto.hw2.response.CalcResponse;
import com.group.libraryapp.dto.hw2.response.DayOfTheWeekResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@RestController
public class HomeworkTwoController {
    @GetMapping("api/v1/calc")
    public CalcResponse homeworkTwoCalc(CalcRequest request){
        return new CalcResponse(request);
    }

    @GetMapping("api/v1/day-of-the-week")
    public DayOfTheWeekResponse dayOfTheWeekResponse(DayOfTheWeekRequest request){
        LocalDate date = request.getDate();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return new DayOfTheWeekResponse(dayOfWeek);
    }

    @PostMapping("/addList")
    public int addList(@RequestBody NumbersRequest request){
        List<Integer> numList = request.getNumbers();
        int sum = 0;
        for (Integer number : numList){
            sum+=number;
        }
        return sum;
    }
}
