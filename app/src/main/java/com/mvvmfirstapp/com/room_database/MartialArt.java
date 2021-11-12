package com.mvvmfirstapp.com.room_database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "martial_art_table")// if not use by defoult table name as a  class name
public class MartialArt {

    @PrimaryKey // it is primary key
    @NonNull// it should not null
    @ColumnInfo(name="fav_martial_art") // if we not use by default column name is a variablee name in the table
    private String mFavMartialArt;

    @ColumnInfo(name="fav_name") // if we not use by default column name is a variablee name in the table
    private String mName;

    @ColumnInfo(name="fav_mobile_number") // if we not use by default column name is a variablee name in the table
    private String mMobileNumber;


    public MartialArt(@NonNull String favMartialArt,@NonNull String favName,@NonNull String favMobileNumber){
        mFavMartialArt=favMartialArt;
        mName=favName;
        mMobileNumber=favMobileNumber;
    }

    public MartialArt() {

    }


    /* public MartialArt(@NonNull String favMartialArt){
         mFavMartialArt=favMartialArt;

     }*/
    public String getFavMartialArt(){
        return mFavMartialArt;
    }
    public String getFavName(){
        return mName;
    }
    public String getFavMobileNumber(){
        return mMobileNumber;
    }

    public void setFavMartialArt(@NonNull String favMartialArt) {
        mFavMartialArt = favMartialArt;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getMobileNumber() {
        return mMobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        mMobileNumber = mobileNumber;
    }
}
