package br.edu.uniritter.mobile.uniritterapp.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

public class Album implements Parcelable {

    private int postId;
    private int id;
    private String title;

    public Album(int postId, int id, String title){
        this.postId = postId;
        this.id = id;
        this.title = title;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    private Album(Parcel parcel) {
        this.postId = parcel.readInt();
        this.id = parcel.readInt();
        this.title = parcel.readString();
    }

    public static final Parcelable.Creator<Album> CREATOR = new Parcelable.Creator<Album>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    @Override
    public int describeContents() { return 0; }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.postId);
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
