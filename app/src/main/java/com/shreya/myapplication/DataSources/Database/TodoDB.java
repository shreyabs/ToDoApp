package com.shreya.myapplication.DataSources.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.shreya.myapplication.DataSources.Note;

/**
 * Created by Shreya on 1/17/2018.
 */

@Database(entities = {Note.class}, version = 1)
public abstract class TodoDB extends RoomDatabase {
    //Singleton pattern because we need only one DB per app
    private static TodoDB INSTANCE;

    public static TodoDB getDatabaseInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(),
                            TodoDB.class, "todos_db").build();
        }
        return INSTANCE;
    }


    public abstract NoteDao noteDao();
}
