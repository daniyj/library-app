package com.group.libraryapp.z_self_study.Day4.controller;

import com.group.libraryapp.z_self_study.Day4.dto.FruitCreateRequest;
import com.group.libraryapp.z_self_study.Day4.dto.FruitUpdateRequest;
import com.group.libraryapp.z_self_study.Day4.dto.GetSalesAmountResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class FruitControllerDay4 {
    private JdbcTemplate jdbcTemplate;
    public FruitControllerDay4(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 과일 정보 저장 API
    @PostMapping("/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request){
        String sql = "INSERT INTO fruit (name, warehousingDate, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,request.getName(),request.getWarehousingDate(),request.getPrice());
    }

    // 과일 정보 변경 API
    @PutMapping("/fruit")
    public void updateFruit(@RequestBody FruitUpdateRequest request) {
        String sql = "UPDATE fruit SET is_sold = 1 WHERE id = ?";
        jdbcTemplate.update(sql, request.getId());
    }

    // 팔린 금액과 팔리지 않은 금액 조회 API
    @GetMapping("/fruit/stat")
    public GetSalesAmountResponse getSalesAmount(@RequestParam String name){

        String soldSql = "SELECT SUM(price) FROM fruit WHERE name = ? AND is_sold = 1";
        String notSoldSql = "SELECT SUM(price) FROM fruit WHERE name = ? AND is_sold = 0";

        long soldPrice = jdbcTemplate.queryForObject(soldSql,long.class,name);
        long notSoldPrice = jdbcTemplate.queryForObject(notSoldSql, long.class, name);

        return new GetSalesAmountResponse(soldPrice,notSoldPrice);
    }
}
