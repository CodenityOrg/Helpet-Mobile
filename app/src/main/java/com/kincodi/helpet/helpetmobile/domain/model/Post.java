package com.kincodi.helpet.helpetmobile.domain.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.sql.Array;
import java.util.Date;
import java.util.List;

/**
 * Created by Julio on 20/02/2018.
 */

public class Post implements Parcelable {

    private String name;
    private String description;
    private String race;
    private String age;
    private String kind;
    private Date date;
    private String gender;
    private Double[] position;
    private String phone;
    private int type;
    private PostLocation postLocation;
    private List<Photo> photos;

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double[] getPosition() {
        return position;
    }

    public void setPosition(Double[] position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Post() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Post(String name, String description, String race, String age, String kind, Date date, Double[] position, String phone) {
        this.name = name;
        this.description = description;
        this.race = race;
        this.age = age;
        this.kind = kind;
        this.date = date;
        this.position = position;
        this.phone = phone;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(race);
        parcel.writeString(age);
        parcel.writeString(kind);
        parcel.writeString(gender);
    }

    public Post(Parcel in) {
        readFromParcel(in);
    }

    private void readFromParcel(Parcel in) {
        name = in.readString();
        description = in.readString();
        race = in.readString();
        age = in.readString();
        kind = in.readString();
        gender = in.readString();
    }

    public PostLocation getPostLocation() {
        return postLocation;
    }

    public void setPostLocation(PostLocation postLocation) {
        this.postLocation = postLocation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Post> CREATOR = new Parcelable.Creator<Post>() {
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

}
