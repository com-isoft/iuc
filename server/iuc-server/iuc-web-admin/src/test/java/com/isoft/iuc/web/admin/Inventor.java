package com.isoft.iuc.web.admin;

import java.util.Date;

public class Inventor{
    private String name;
    private Date date;
    private String location;

    public Inventor(String name,Date date,String location){
        this.name = name;
        this.date = date;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}