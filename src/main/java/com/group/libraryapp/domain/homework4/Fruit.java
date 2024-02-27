package com.group.libraryapp.domain.homework4;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    String name;
    @Column(name="warehousing_date")
    LocalDate warehousingDate;
    long price;
    @Column(name="is_sold")
    int isSold;

    protected Fruit(){};

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

    public Long getId() {
        return id;
    }

    public int getIsSold() {
        return isSold;
    }

    public void updateSold(int isSold){
        this.isSold = isSold;
    }
}
