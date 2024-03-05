package com.group.libraryapp.z_self_study.Day6.repository;

import com.group.libraryapp.z_self_study.Day6.dto.GetSalesAmountResponse;

import java.time.LocalDate;

public interface FruitRepository_Day6 {
    public void saveFruit(String name, LocalDate warehousingDate, long price);
    public void updateFruit(long id);
    public GetSalesAmountResponse getSalesAmount(String name);
}
