package com.group.libraryapp.z_self_study.Day2.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class NumbersRequest {
    private List<Integer> numbers = new ArrayList<>();
//    public NumbersRequest(){}

    @JsonCreator
    public NumbersRequest(@JsonProperty("numbers") List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
