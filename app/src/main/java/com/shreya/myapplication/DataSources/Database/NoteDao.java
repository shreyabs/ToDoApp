package com.shreya.myapplication.DataSources.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.shreya.myapplication.DataSources.Note;

import java.util.List;

/**
 * Created by Shreya on 1/17/2018.
 */

/**
 * Data Acc
 */
@Dao
public interface NoteDao {

    @Query("SELECT * from Note WHERE isDeleted=0 AND isCompleted=0")
    List<Note> getAllToDos();

    @Query("SELECT * from Note WHERE isDeleted=0 AND isCompleted=1")
    List<Note> getAllCompleted();

    @Insert
    void insertToDos(Note... notes);

    @Delete
    void delete(Note todo);
}
