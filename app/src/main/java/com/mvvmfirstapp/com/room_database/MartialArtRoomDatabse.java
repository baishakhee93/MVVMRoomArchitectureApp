package com.mvvmfirstapp.com.room_database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {MartialArt.class},version = 1,exportSchema = false)
public abstract class MartialArtRoomDatabse extends RoomDatabase {// when we create roomdatabase class it muts be abstract class

    public abstract MartialArtDAO martialArtDAO();

    private static volatile MartialArtRoomDatabse INSTANCE;

    private static final int NUMBER_OF_THREADS=4;

    public static final ExecutorService databaseWriterExecutor= Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static MartialArtRoomDatabse getDatabase(Context context){
        if (INSTANCE==null){
            synchronized (MartialArtRoomDatabse.class){
                INSTANCE= Room.databaseBuilder(context, MartialArtRoomDatabse.class,"martial_art_databas").build();

            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback databaseCallback=new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriterExecutor.execute(()->{
                // delete all database data
                MartialArtDAO dao=INSTANCE.martialArtDAO();
                dao.dleteAllMartialArt();

                //add some dfault data
               // MartialArt martialArt =new MartialArt("Boxing");
                MartialArt martialArt =new MartialArt("Boxing","b","00000");
                dao.insertMartailArt(martialArt);

                martialArt=new MartialArt("Baishakhee","bs","666666663");
                dao.insertMartailArt(martialArt);
            });
        }
    };
}
