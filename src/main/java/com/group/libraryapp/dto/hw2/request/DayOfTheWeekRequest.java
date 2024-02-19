package com.group.libraryapp.dto.hw2.request;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayOfTheWeekRequest {
    private LocalDate date;
    private DayOfWeek dayOfWeek;

    public DayOfTheWeekRequest(LocalDate date, DayOfWeek dayOfWeek) {
        this.date = date;
        this.dayOfWeek = dayOfWeek;
    }

    public LocalDate getDate() {
        return date;
    }

    public DayOfWeek getdayOfWeek() {
        return dayOfWeek;
    }
}
