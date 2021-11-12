package com.mvvmfirstapp.com.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mvvmfirstapp.com.room_database.MartialArt;
import com.mvvmfirstapp.com.room_database.MartialArtRepository;

import java.util.List;

public class MartialArtViewModel extends AndroidViewModel {
    private MartialArtRepository martialArtRepository;
    private final LiveData<List<MartialArt>> liveData;

    public MartialArtViewModel(@NonNull Application application) {
        super(application);
        martialArtRepository = new MartialArtRepository(application);
        liveData = martialArtRepository.getAllMartialArts();
    }

    public LiveData<List<MartialArt>> getAllMartialArts(){
        return liveData;
    }

    public void insertMartialArts(MartialArt martialArt){
        martialArtRepository.insertMartialArt(martialArt);
    }


    public  void delteMartialArts(MartialArt martialArt){
        martialArtRepository.deleteMartialArt(martialArt);
    }
}
