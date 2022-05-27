package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeekDayControllerTest {

    @Test
    void request() {
        String year = "2022";
        String day = "1";
        WeekDayCounting counting = new WeekDayCounting();
        String actual = counting.calculation(year, day);
        String expected = "Saturday";
        assertEquals(expected, actual);
    }
}