package com.group.libraryapp.z_self_study.Day6.controller;

import com.group.libraryapp.z_self_study.Day6.FruitService_Day6;
import com.group.libraryapp.z_self_study.Day6.dto.FruitCreateRequest;
import com.group.libraryapp.z_self_study.Day6.dto.FruitUpdateRequest;
import com.group.libraryapp.z_self_study.Day6.dto.GetSalesAmountResponse;
import org.springframework.web.bind.annotation.*;

//Day6 2.26(월) 과제
@RestController
@RequestMapping("/api/v2")
public class FruitControllerDay6 {
    private final FruitService_Day6 fruitServiceDay6;

    public FruitControllerDay6(FruitService_Day6 fruitServiceDay6) {
        this.fruitServiceDay6 = fruitServiceDay6;
    }

    // 과일 정보 저장 API
    @PostMapping("/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request){
        fruitServiceDay6.saveFruit(request.getName(),request.getWarehousingDate(),request.getPrice());
    }

    // 과일 정보 변경 API
    @PutMapping("/fruit")
    public void updateFruit(@RequestBody FruitUpdateRequest request) {
        fruitServiceDay6.updateFruit(request.getId());
    }

    // 팔린 금액과 팔리지 않은 금액 조회 API
    @GetMapping("/fruit/stat")
    public GetSalesAmountResponse getSalesAmount(@RequestParam String name){
        return fruitServiceDay6.getSalesAmount(name);
    }
}
