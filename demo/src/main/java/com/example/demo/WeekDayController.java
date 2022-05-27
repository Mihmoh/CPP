package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class WeekDayController {

    private static final String template = " %s!";      //строка, в которую помещается результат работы
    private WeekDayCounting counting = new WeekDayCounting();       //объект, который обрабатывает входные параметры

    @RequestMapping(method = RequestMethod.GET, path = "/weekday")      //берём параметры из url по /weekday
    WeekDay request(@RequestParam(defaultValue = "2001") String year, @RequestParam(defaultValue = "1") String day)
    {       //запрашиваемые параметры - это год и день, например http://localhost:8080/weekday?year=2022&day=64
        String weekday = "Monday";
        weekday = counting.calculation(year, day);      //обрабатываем полученные значения

        return new WeekDay(String.format(template, weekday));       //возвращаем обработанное значение
    }
}

