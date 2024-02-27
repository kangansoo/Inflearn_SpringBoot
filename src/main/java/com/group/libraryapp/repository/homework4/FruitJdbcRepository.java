package com.group.libraryapp.repository.homework4;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class FruitJdbcRepository {

    private final JdbcTemplate jdbcTemplate;
    public FruitJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveFruit(String name, LocalDate warehousingDate, long price){
        String sql = "insert into fruit (name, warehousingDate, price) values(?, ?, ?)";
        jdbcTemplate.update(sql, name, warehousingDate, price);
    }

    public boolean isFruitNotExist(long id){
        String readsql = "select * from fruit where id=?";
        return jdbcTemplate.query(readsql, (rs, rowNum) ->0, id).isEmpty();
    }

    public void updateFruit(long id){
        String sql = "update fruit set isSold = true where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public boolean isFruitNotExist(String name){
        String readsql="select price from fruit where name=?";
        return jdbcTemplate.query(readsql, (rs, rowNum) ->0, name).isEmpty();
    }

    public Long getSoldFruitPrice(String name){
        String query = "select sum(price) from fruit where name=? and isSold=1";
        return jdbcTemplate.queryForObject(query, Long.class, name);
    }

    public Long getNotSoldFruitPrice(String name){
        String query = "select sum(price) from fruit where name=? and isSold=0";
        return jdbcTemplate.queryForObject(query, Long.class, name);
    }

}
