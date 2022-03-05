package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController

public class WeekDayController {

    private static final String template = " %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET, path = "/weekday")
    WeekDay greeting(@RequestParam(defaultValue = "2001") String year, @RequestParam(defaultValue = "1") String day)
    {
        String weekday = "Monday";
        WeekDayCounting a = new WeekDayCounting();
        weekday = a.calculation(year, day);

        return new WeekDay(counter.incrementAndGet(), String.format(template, weekday));
    }
}