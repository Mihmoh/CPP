package com.example.demo;

public class WeekDay {
    private Long id;
    private String content;

    public WeekDay(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
