package com.example.demo;

public class WeekDayCounting {


    public String calculation(String year, String day)
    {
        String weekday = "Monday";

        Integer year_int = Integer.valueOf(year);
        Integer day_int = Integer.valueOf(day);
        Integer days_at_all;
        Integer rest;
        Integer substract = year_int - 2001;
        Integer vis = 0;

        while(substract!=0)
        {
            if(substract % 4 == 0)
                vis++;
            substract--;
        }

        if (day_int>366)
        {
            weekday = "Wrong day";
            return weekday;
        }

        days_at_all = year_int * 365 + day_int;
        rest = days_at_all % 7;
        rest = rest + vis;

        while(rest>7)
        {
            rest = rest - 7;
        }

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

        return weekday;
    }
}
