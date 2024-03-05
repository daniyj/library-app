package com.group.libraryapp.z_self_study.Day7.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FruitRepository_Day7 extends JpaRepository<Fruit,Long> {
    @Query("SELECT SUM(f.price) FROM Fruit f WHERE f.name = :name AND f.isSold = true")
    Long getTotalSoldPrice(@Param("name") String name);

    @Query("SELECT SUM(f.price) FROM Fruit f WHERE f.name = :name AND f.isSold = false")
    Long getTotalNotSoldPrice(@Param("name") String name);

    Long countByName(String name);
    List<Fruit> findByPriceGreaterThanEqual(Long price);

    List<Fruit> findByPriceLessThanEqual(Long price);

}
