package com.group.libraryapp.controller.homework2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
public class LocalDateController {
    @GetMapping("/weekday")
    public Map<String, String> DateResult(@RequestParam String date){
        HashMap<String, String> map = new HashMap<>();
        LocalDate parsedDate = LocalDate.parse(date);
        DayOfWeek dayOfWeek = parsedDate.getDayOfWeek();
        map.put("dayOfWeek", dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US));

        return map;
    }
}
