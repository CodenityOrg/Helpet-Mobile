package com.kincodi.helpet.helpetmobile.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import static android.os.UserHandle.readFromParcel;

/**
 * Created by Julio on 31/03/2018.
 */

public class Notification implements Parcelable{

    int id;
    String description;
    String postId;

    public Notification(){}
    public Notification(Parcel in) {
        readFromParcel(in);
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(description);
        parcel.writeString(postId);
    }

    private void readFromParcel(Parcel in) {
        id = in.readInt();
        description = in.readString();
        postId = in.readString();
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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

}
