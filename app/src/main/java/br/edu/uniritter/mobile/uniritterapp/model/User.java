package br.edu.uniritter.mobile.uniritterapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private int id;
    private String name;
    private String email;
    private Adress adress;

    public User(int id, String name, String email, Adress adress){
        this.id = id;
        this.name = name;
        this.email = email;
        this.adress = adress;
    }

    private User(Parcel parcel) {

        id = parcel.readInt();
        name = parcel.readString();
        email = parcel.readString();

        //parcel.writeParcelable(this.address);
        Adress adress = new Adress(
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                null);
        adress.geo = new Geo(
                parcel.readFloat(),
                parcel.readFloat());

        this.adress = adress;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.email);
        //parcel.writeParcelable(this.address);
        parcel.writeString(this.adress.street);
        parcel.writeString(this.adress.suite);
        parcel.writeString(this.adress.city);
        parcel.writeString(this.adress.zipcode);
        parcel.writeFloat(this.adress.geo.lat);
        parcel.writeFloat(this.adress.geo.lng);
    }
}
