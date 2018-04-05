package com.kincodi.helpet.helpetmobile.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import static android.os.UserHandle.readFromParcel;

/**
 * Created by Julio on 31/03/2018.
 */

public class Notification implements Parcelable{

    int id;
    String date;
    String description;
    String Comment_id;
    String Message_id;
    int Request_id;
    int Bill_id;
    int User_id;
    int Notification_Type_id;
    double latitude;
    double longitude;


    public Notification(){}
    public Notification(Parcel in) {
        readFromParcel(in);
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(date);
        parcel.writeString(description);
        parcel.writeString(Comment_id);
        parcel.writeString(Message_id);
        parcel.writeInt(Request_id);
        parcel.writeInt(Bill_id);
        parcel.writeInt(User_id);
        parcel.writeInt(Notification_Type_id);
    }

    private void readFromParcel(Parcel in) {
        id = in.readInt();
        date = in.readString();
        description = in.readString();
        Comment_id = in.readString();
        Message_id = in.readString();
        Request_id = in.readInt();
        Bill_id = in.readInt();
        User_id = in.readInt();
        Notification_Type_id = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Notification> CREATOR = new Parcelable.Creator<Notification>() {
        public Notification createFromParcel(Parcel in) {
            return new Notification(in);
        }

        public Notification[] newArray(int size) {
            return new Notification[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment_id() {
        return Comment_id;
    }

    public void setComment_id(String comment_id) {
        Comment_id = comment_id;
    }

    public String getMessage_id() {
        return Message_id;
    }

    public void setMessage_id(String message_id) {
        Message_id = message_id;
    }

    public int getRequest_id() {
        return Request_id;
    }

    public void setRequest_id(int request_id) {
        Request_id = request_id;
    }

    public int getBill_id() {
        return Bill_id;
    }

    public void setBill_id(int bill_id) {
        Bill_id = bill_id;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public int getNotification_Type_id() {
        return Notification_Type_id;
    }

    public void setNotification_Type_id(int notification_Type_id) {
        Notification_Type_id = notification_Type_id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
