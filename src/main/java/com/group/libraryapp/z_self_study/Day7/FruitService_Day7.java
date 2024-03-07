package com.group.libraryapp.z_self_study.Day7;

import com.group.libraryapp.z_self_study.Day6.dto.GetSalesAmountResponse;
import com.group.libraryapp.z_self_study.Day7.domain.Fruit;
import com.group.libraryapp.z_self_study.Day7.domain.FruitRepository_Day7;
import com.group.libraryapp.z_self_study.Day7.dto.ComparisonOption;
import com.group.libraryapp.z_self_study.Day7.dto.GetFruitCountResponse;
import com.group.libraryapp.z_self_study.Day7.dto.GetFruitResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FruitService_Day7 {

    private final FruitRepository_Day7 fruitRepositoryDay7;

    public FruitService_Day7(FruitRepository_Day7 fruitRepositoryDay7) {
        this.fruitRepositoryDay7 = fruitRepositoryDay7;
    }

    public void saveFruit(String name, LocalDate warehousingDate, long price) {
        fruitRepositoryDay7.save(new Fruit(name, warehousingDate, price));
    }

    public void updateFruit(Long id) {
        Fruit fruit = fruitRepositoryDay7.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 과일의 ID를 찾을 수 없습니다."));
        fruit.setIsSold(true);
        fruitRepositoryDay7.save(fruit);
    }

    public GetSalesAmountResponse getSalesAmount(String name) {
//        Fruit fruit = fruitRepositoryDay7.findByName(name).orElseThrow(() -> new IllegalArgumentException());
//        System.out.println("fruit.getId() = " + fruit.getId());
        Long soldPrice = fruitRepositoryDay7.getTotalSoldPrice(name);

        Long notSoldPrice;
        if (fruitRepositoryDay7.getTotalNotSoldPrice(name) != null) {
            notSoldPrice = fruitRepositoryDay7.getTotalNotSoldPrice(name);
        } else {
            notSoldPrice = 0L;
        }

        return new GetSalesAmountResponse(soldPrice, notSoldPrice);
    }

    public GetFruitCountResponse getFruitCount(String name) {
        Long fruitCount = fruitRepositoryDay7.countByName(name);
        return new GetFruitCountResponse(fruitCount);
    }
    public List<GetFruitResponse> getFruitsByAmountRange(ComparisonOption option, Long price){
        List<Fruit> fruits;
        if (option == ComparisonOption.LTE)
            fruits = fruitRepositoryDay7.findByPriceLessThanEqual(price);
        else
            fruits = fruitRepositoryDay7.findByPriceGreaterThanEqual(price);

        List<GetFruitResponse> response = new ArrayList<>();
        for (Fruit fruit : fruits) {
            response.add(new GetFruitResponse(fruit.getName(),fruit.getPrice(),fruit.getWarehousingDate()));
        }
        return response;
    }
}