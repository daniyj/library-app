package com.group.libraryapp.z_self_study.Day6.repository;

import com.group.libraryapp.z_self_study.Day6.dto.GetSalesAmountResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
@Primary
@Repository
public class FruitMysqlRepository implements FruitRepository_Day6 {
    private final JdbcTemplate jdbcTemplate;

    public FruitMysqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveFruit(String name, LocalDate warehousingDate, long price){
        String sql = "INSERT INTO fruit (name, warehousingDate, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,name,warehousingDate,price);
    }
    public void updateFruit(long id){
        String sql = "UPDATE fruit SET is_sold = 1 WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    public GetSalesAmountResponse getSalesAmount(String name){
        String soldSql = "SELECT SUM(price) FROM fruit WHERE name = ? AND is_sold = 1";
        String notSoldSql = "SELECT SUM(price) FROM fruit WHERE name = ? AND is_sold = 0";

        long soldPrice = jdbcTemplate.queryForObject(soldSql,long.class,name);
        long notSoldPrice = jdbcTemplate.queryForObject(notSoldSql, long.class, name);

        return new GetSalesAmountResponse(soldPrice,notSoldPrice);
    }
}
