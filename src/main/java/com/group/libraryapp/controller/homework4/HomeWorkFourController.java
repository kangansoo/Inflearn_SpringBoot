package com.group.libraryapp.controller.homework4;

import com.group.libraryapp.dto.homework4.FruitResponse;
import com.group.libraryapp.dto.homework4.FruitUpdateRequest;
import com.group.libraryapp.dto.homework4.SaveFruitRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeWorkFourController {
    private final JdbcTemplate jdbcTemplate;

    public HomeWorkFourController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody SaveFruitRequest request){
        String sql = "insert into fruit (name, warehousingDate, price) values(?, ?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    @PutMapping("/api/v1/fruit")
    public void updateFruit(@RequestBody FruitUpdateRequest request){
        String readsql = "select * from fruit where id=?";
        boolean isFruitNotExist = jdbcTemplate.query(readsql, (rs, rowNum) ->0, request.getId()).isEmpty();
        if(isFruitNotExist){
            throw new IllegalArgumentException();
        }
        String sql = "update fruit set isSold = true where id = ?";
        jdbcTemplate.update(sql, request.getId());
    }

    @GetMapping("/api/v1/fruit/stat")
    public FruitResponse getFruits(@RequestParam String name){
        String readsql="select price from fruit where name=?";
        boolean isFruitNotExist = jdbcTemplate.query(readsql, (rs, rowNum) ->0, name).isEmpty();
        if(isFruitNotExist){
            throw new IllegalArgumentException();
        }
        String sales = "select * from fruit where name=? and isSold=1";
        List<Long> salesAmount = jdbcTemplate.query(sales, (rs, rowNum)-> rs.getLong("price"), name);

        long totalSalesAmount=0;
        for (Long amount : salesAmount){
            totalSalesAmount += amount;
        }

        String notSales = "select * from fruit where name=? and isSold=0";
        List<Long> notSalesAmount = jdbcTemplate.query(notSales, (rs, rowNum)-> rs.getLong("price"), name);

        long totalNotSalesAmount=0;
        for (Long amount : notSalesAmount){
            totalNotSalesAmount += amount;
        }

        return new FruitResponse(totalSalesAmount, totalNotSalesAmount);
    }
}
