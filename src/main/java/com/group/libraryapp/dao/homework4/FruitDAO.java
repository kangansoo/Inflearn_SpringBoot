package com.group.libraryapp.dao.homework4;

import com.group.libraryapp.domain.homework4.Fruit;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository //데이터 엑세스 계층, 해당 클래스가 데이터베이스와 상호 작용을 담당함
public class FruitDAO {
    private final JdbcTemplate jdbcTemplate;


    public FruitDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Fruit save(Fruit fruit){
        String sql = "insert into fruit (name, warehousingDate, price) values(?, ?, ?)";
        jdbcTemplate.update(sql, fruit.getName(), fruit.getWarehousingDate(), fruit.getPrice());
        return fruit;
    }
}
