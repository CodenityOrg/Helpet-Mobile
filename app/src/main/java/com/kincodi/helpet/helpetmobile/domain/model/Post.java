package com.kincodi.helpet.helpetmobile.domain.model;


import java.util.Date;

/**
 * Created by Julio on 20/02/2018.
 */

public class Post {

    private String name;
    private String description;
    private String race;
    private String kind;
    private String age;
    private Object position;
    private String phone;
    private Date date;

    public Post(String name, String description, String race, String kind, String age, Object position, String phone, Date date) {
        this.name = name;
        this.description = description;
        this.race = race;
        this.kind = kind;
        this.age = age;
        this.position = position;
        this.phone = phone;
        this.date = date;
    }

    public Post() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Object getPosition() {
        return position;
    }

    public void setPosition(Object position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
