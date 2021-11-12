package com.mvvmfirstapp.com.room_database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao //if you not use then room databes not have idea that is actualy is daata access class
public interface MartialArtDAO {

    @Insert
    void insertMartailArt(MartialArt martialArt);

    @Query("Delete FROM martial_art_table")
    void dleteAllMartialArt();

    @Delete
    void deleteMartialArt(MartialArt martialArt);

    @Query("Select * FROM martial_art_table ORDER BY fav_martial_art ASC")
    LiveData<List<MartialArt>> getAllMartialArtsInAnAlphabeticalOrder();


}
