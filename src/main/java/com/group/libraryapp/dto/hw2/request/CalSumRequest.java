package com.group.libraryapp.dto.hw2.request;

import java.util.List;

public class CalSumRequest {
    private final List<Integer> numbers;

    public CalSumRequest(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
