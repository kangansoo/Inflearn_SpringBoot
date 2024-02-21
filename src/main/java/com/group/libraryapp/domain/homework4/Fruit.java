package com.group.libraryapp.domain.homework4;

import java.time.LocalDate;

public class Fruit {
    String name;
    LocalDate warehousingDate;
    long price;

    public Fruit(String name, LocalDate warehousingDate, long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }
}
