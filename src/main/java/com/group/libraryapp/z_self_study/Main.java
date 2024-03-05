package com.group.libraryapp.z_self_study;

import com.group.libraryapp.z_self_study.Day7.dto.ComparisonOption;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        Integer num = list.get(0);
        System.out.println("num = " + num);

        // ENUM 사용하기
        ComparisonOption option = ComparisonOption.LTE;
        String str = option.name();
    }
}
