package com.kincodi.helpet.helpetmobile.domain.model;


/**
 * Created by Julio on 20/02/2018.
 */

public class Post {

    private String name;
    private String kind;
    private String species;
    private String race;
    private String description;
    private String location;
    private String person_contact;
    private String phone;
    private String images;

    public Post() {
    }

    public Post(String name, String kind, String species, String race, String description, String location, String person_contact, String phone, String images) {
        this.name = name;
        this.kind = kind;
        this.species = species;
        this.race = race;
        this.description = description;
        this.location = location;
        this.person_contact = person_contact;
        this.phone = phone;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPerson_contact() {
        return person_contact;
    }

    public void setPerson_contact(String person_contact) {
        this.person_contact = person_contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
