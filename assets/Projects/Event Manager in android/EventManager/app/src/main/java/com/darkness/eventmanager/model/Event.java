package com.darkness.eventmanager.model;

public class Event {
    private String title, time, readable_date;
    private int id,rc;

    public Event() {
    }

    public Event(String title, String time, String readable_date, int id,int rc) {
        this.title = title;
        this.time = time;
        this.readable_date = readable_date;
        this.id = id;
        this.rc = rc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReadable_date() {
        return readable_date;
    }

    public void setReadable_date(String readable_date) {
        this.readable_date = readable_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRc() {
        return rc;
    }

    public void setRc(int rc) {
        this.rc = rc;
    }
}
