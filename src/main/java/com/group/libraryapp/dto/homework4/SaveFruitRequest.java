package com.group.libraryapp.dto.homework4;

import java.time.LocalDate;

public class SaveFruitRequest {
    private String name;
    private LocalDate warehousingDate;
    private long price;

    public SaveFruitRequest(){};
    public SaveFruitRequest(String name, LocalDate warehousingDate, long price) {
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
