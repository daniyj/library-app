package com.group.libraryapp.z_self_study.Day6;

import com.group.libraryapp.z_self_study.Day6.dto.GetSalesAmountResponse;
import com.group.libraryapp.z_self_study.Day6.repository.FruitRepository_Day6;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FruitService_Day6 {
    private final FruitRepository_Day6 fruitRepository;

    public FruitService_Day6(FruitRepository_Day6 fruitRepository) {
        this.fruitRepository = fruitRepository;
    }
    public void saveFruit(String name, LocalDate warehousingDate,long price){
        fruitRepository.saveFruit(name,warehousingDate,price);
    }
    public void updateFruit(long id){
        fruitRepository.updateFruit(id);
    }
    public GetSalesAmountResponse getSalesAmount(String name){
        return fruitRepository.getSalesAmount(name);
    }
}
