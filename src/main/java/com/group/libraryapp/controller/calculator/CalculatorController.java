package com.group.libraryapp.controller.calculator;

//클래스를 controller로 지정

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @GetMapping("/add") //HTTP 메소드가 GET이고 HTTP Path가 /add인 api로 지정
    public int addTwoNumbers(CalculatorAddRequest request){
        //@RequestParam 주어지는 쿼리를 함수 파라미터에 넘겨주는 것
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply") //HTTP 메소드와 Path 지정
    //@RequestBody post api에서 바디안의 데이터를 객체로 반환해주는 어노테이션
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request){
        return request.getNumber1() * request.getNumber2();
    }

}
