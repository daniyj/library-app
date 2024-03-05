package com.group.libraryapp.z_self_study.Day7.dto;

public class GetFruitsByAmountRangeRequest {
    private ComparisonOption option;
    private Long price;

    public GetFruitsByAmountRangeRequest(ComparisonOption option, Long price) {
        this.option = option;
        this.price = price;
    }

    public ComparisonOption getOption() {
        return option;
    }

    public Long getPrice() {
        return price;
    }
}
