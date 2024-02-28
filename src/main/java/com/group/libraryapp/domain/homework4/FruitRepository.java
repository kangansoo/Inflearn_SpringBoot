package com.group.libraryapp.domain.homework4;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    List<Fruit> findAllByNameAndIsSold(String name, int isSold);
    long countByName(String name);

    List<Fruit> findAllByPriceGreaterThan(long price);
    List<Fruit> findAllByPriceLessThan(long price);
}
