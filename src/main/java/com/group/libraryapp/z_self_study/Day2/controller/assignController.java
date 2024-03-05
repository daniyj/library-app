package com.group.libraryapp.z_self_study.Day2.controller;

import com.group.libraryapp.z_self_study.Day2.dto.*;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;


@RestController
@RequestMapping("/api/v1")
public class assignController {

    // 두 수의 덧셈, 뺄셈, 곱셈 결과를 알려주는 API
    @GetMapping("/calc") // GET /api/v1/calc
    public CalculatorResponse calculateTwoNumbers(CalculatorRequest request) {
        int addResult = request.getNum1() + request.getNum2();
        int minusResult = request.getNum1() - request.getNum2();
        int multiplyResult = request.getNum1() * request.getNum2();
        return new CalculatorResponse(addResult, minusResult, multiplyResult);
    }

    // 날짜를 입력 시, 몇 요일인지 알려주는 API
    @GetMapping("/day-of-the-week")
    public DayOfTheWeekResponse getDayOfTheWeek(DayOfTheWeekRequest request) {
        LocalDate localDate = LocalDate.parse(request.getDate());
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return new DayOfTheWeekResponse(dayOfWeek.toString().substring(0,3));
    }

    // 여러 수를 받아 총 합을 반환하는 API
    @PostMapping("/sum")
    public NumbersResponse sumNumbers(@RequestBody NumbersRequest request) {
        int sum = 0;
        for (int i = 0; i < request.getNumbers().size(); i++) {
            sum += request.getNumbers().get(i);
        }
        return new NumbersResponse(sum);
    }
}
