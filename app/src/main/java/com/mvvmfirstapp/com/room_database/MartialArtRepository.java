package com.mvvmfirstapp.com.room_database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MartialArtRepository {

    private  MartialArtDAO martialArtDAO;
    private LiveData<List<MartialArt>> listLiveData;


    public  MartialArtRepository(Application application){

        MartialArtRoomDatabse martialArtRoomDatabse=MartialArtRoomDatabse.getDatabase(application);
        martialArtDAO=martialArtRoomDatabse.martialArtDAO();
        listLiveData=martialArtDAO.getAllMartialArtsInAnAlphabeticalOrder();// room excute all queries on a separate thread so the UI thrad is not blocked
    }
    public LiveData<List<MartialArt>> getAllMartialArts(){
        return listLiveData;
    }

    public void insertMartialArt(MartialArt martialArt){


        MartialArtRoomDatabse.databaseWriterExecutor.execute(()->martialArtDAO.insertMartailArt(martialArt));
       /* MartialArtRoomDatabse.databaseeWriterExecutor.excute(new Runnable(){
            @Override
            public void run() {
                martialArtDAO.insertMartailArt(martialArt);
            }
        });*/
    }
    public void deleteMartialArt(MartialArt martialArt){
        MartialArtRoomDatabse.databaseWriterExecutor.execute(()->martialArtDAO.deleteMartialArt(martialArt));

      /*  MartialArtRoomDatabse.databaseWriterExecutor.excute(new Runnable(){
            @Override
            public void run() {
                martialArtDAO.deleteMartialArt(martialArt);
            }
        });*/
    }
}
