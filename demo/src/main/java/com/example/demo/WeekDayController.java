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

        Integer year_int = Integer.valueOf(year);
        Integer day_int = Integer.valueOf(day);
        Integer days_at_all;
        Integer rest;

        if (day_int>365)
        {
            weekday = "Wrong day";
            return new WeekDay(counter.incrementAndGet(), String.format(template, weekday));
        }

        days_at_all = year_int * 365 + day_int;
        rest = days_at_all % 7;

        switch(rest)
        {
            case 0:
                weekday = "Monday";
                break;
            case 1:
                weekday = "Tuesday";
                break;
            case 2:
                weekday = "Wednesday";
                break;
            case 3:
                weekday = "Thursday";
                break;
            case 4:
                weekday = "Friday";
                break;
            case 5:
                weekday = "Saturday";
                break;
            case 6:
                weekday = "Sunday";
                break;
        }

        return new WeekDay(counter.incrementAndGet(), String.format(template, weekday));
    }
}