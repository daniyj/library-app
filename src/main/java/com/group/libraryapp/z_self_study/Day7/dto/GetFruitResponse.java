package com.group.libraryapp.z_self_study.Day7.dto;

import java.time.LocalDate;

public class GetFruitResponse {
    private String name;
    private Long price;
    private LocalDate warehousingDate;

    public GetFruitResponse(String name, Long price, LocalDate warehousingDate) {
        this.name = name;
        this.price = price;
        this.warehousingDate = warehousingDate;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }
}
