package com.example.sportsin.MainScreen.HomeScreen;

import android.widget.ImageView;

public class HomeDataModel {
    private String event_title;
    private String event_address;
    private String event_date;
    private String event_image;

    public HomeDataModel(String event_title, String event_address, String event_date, String event_image) {
        this.event_title = event_title;
        this.event_address = event_address;
        this.event_date = event_date;
        this.event_image = event_image;
    }

    public HomeDataModel() {

    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public String getEvent_address() {
        return event_address;
    }

    public void setEvent_address(String event_address) {
        this.event_address = event_address;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) { this.event_date = event_date; }
    public String getEvent_image() { return event_image; }

    public void setEvent_image(String event_image) { this.event_image = event_image; }

}
