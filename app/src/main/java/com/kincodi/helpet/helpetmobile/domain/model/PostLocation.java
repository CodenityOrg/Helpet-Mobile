package com.kincodi.helpet.helpetmobile.domain.model;

public class PostLocation {
    private String type;
    private Double[] coordinates;

    public Double[] getCoordinates() {
        return coordinates;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
