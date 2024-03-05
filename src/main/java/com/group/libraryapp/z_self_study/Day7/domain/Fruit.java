package com.group.libraryapp.z_self_study.Day7.domain;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Fruit {
    // @Entity , ID필드 + @Id,@GeneratedValue, 기본생성자 추가
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate warehousingDate;
    private long price;
    private boolean isSold;
    public void setIsSold(boolean isSold){
        this.isSold = isSold;
    }

    public Fruit(){}
    public Fruit(String name, LocalDate warehousingDate, long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.isSold = false; //기본값이 자동으로 false 값을 갖도록 한다.
    }

    public Long getId() {
        return id;
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

    public boolean isSold() {
        return isSold;
    }

}

