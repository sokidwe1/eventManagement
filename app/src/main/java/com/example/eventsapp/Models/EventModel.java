package com.example.eventsapp.Models;

public class EventModel {
    private String day, month, title, place, count,description;
    private int url;

    public EventModel(String day, String month, String title, String place, String count, int url,String description) {
        this.day = day;
        this.month = month;
        this.title = title;
        this.place = place;
        this.count = count;
        this.url = url;
        this.description = description;
    }


    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getTitle() {
        return title;
    }

    public String getPlace() {
        return place;
    }

    public String getCount() {
        return count;
    }

    public int getUrl() {
        return url;
    }
    public String getDescription() {
        return description;
    }
}
