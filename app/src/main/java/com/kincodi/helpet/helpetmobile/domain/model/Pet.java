package com.kincodi.helpet.helpetmobile.domain.model;


/**
 * Created by Julio on 20/02/2018.
 */

public class Pet {

    private int urls;
    private String description;
    private String details;
    private String address;

    public Pet(int urls, String description, String details, String address) {
        this.urls = urls;
        this.description = description;
        this.details = details;
        this.address = address;
    }

    public void setUrls(int urls) {
        this.urls = urls;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUrls() {
        return urls;
    }

    public String getDescription() {
        return description;
    }

    public String getDetails() {
        return details;
    }

    public String getAddress() {
        return address;
    }
}
