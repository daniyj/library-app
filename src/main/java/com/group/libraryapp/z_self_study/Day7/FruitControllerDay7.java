package com.group.libraryapp.z_self_study.Day7;

import com.group.libraryapp.z_self_study.Day6.dto.FruitCreateRequest;
import com.group.libraryapp.z_self_study.Day6.dto.FruitUpdateRequest;
import com.group.libraryapp.z_self_study.Day6.dto.GetSalesAmountResponse;
import com.group.libraryapp.z_self_study.Day7.dto.GetFruitCountResponse;
import com.group.libraryapp.z_self_study.Day7.dto.GetFruitResponse;
import com.group.libraryapp.z_self_study.Day7.dto.GetFruitsByAmountRangeRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Day7 2.26(월) 과제
@RestController
@RequestMapping("/api/v3") // Day7에서 JPA를 이용한 코드이므로 v3로 바꿈
public class FruitControllerDay7 {
    private final FruitService_Day7 fruitServiceDay7;

    public FruitControllerDay7(FruitService_Day7 fruitServiceDay7) {
        this.fruitServiceDay7 = fruitServiceDay7;
    }

    // 과일 정보 저장 API
    @PostMapping("/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request){
        fruitServiceDay7.saveFruit(request.getName(),request.getWarehousingDate(),request.getPrice());
    }

    // 과일 정보 변경 API
    @PutMapping("/fruit")
    public void updateFruit(@RequestBody FruitUpdateRequest request) {
        fruitServiceDay7.updateFruit(request.getId());
    }

    // 팔린 금액과 팔리지 않은 금액 조회 API
    @GetMapping("/fruit/stat")
    public GetSalesAmountResponse getSalesAmount(@RequestParam String name){
        return fruitServiceDay7.getSalesAmount(name);
    }

    // DAY7 추가 메서드 2개
    // 특정 과일 개수 세기(팔리든 팔리지 않든 모든 개수)
    @GetMapping("/fruit/count")
    public GetFruitCountResponse getFruitCount(@RequestParam String name) {
        return fruitServiceDay7.getFruitCount(name);
    }

    // 특정 금액 이상 또는 이하의 과일 목록 조회
    @GetMapping("/fruit/list")
    public List<GetFruitResponse> getFruitsByAmountRange(GetFruitsByAmountRangeRequest request){
        return fruitServiceDay7.getFruitsByAmountRange(request.getOption(), request.getPrice());
    }
}
