package com.shreya.myapplication.DataSources;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.shreya.myapplication.Util.DateConverter;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Shreya on 1/17/2018.
 */

@Entity
public class Note {

    @PrimaryKey
    private int noteId;

    @ColumnInfo(name = "noteData")
    private String noteData;

    @ColumnInfo(name = "createdTime")
    @TypeConverters(DateConverter.class)
    private Date createdTime;

    @ColumnInfo(name = "modifiedTime")
    @TypeConverters(DateConverter.class)
    private Date modifiedTime;

    @ColumnInfo(name = "group")
    private String group;

    @ColumnInfo(name = "isDeleted")
    private int isDeleted;

    @ColumnInfo(name = "isCompleted")
    private int isCompleted;

    //Default constructor
    public Note(int noteId){
        this.noteId = noteId;
        this.noteData = "New note - "+noteId;
        this.createdTime = Calendar.getInstance().getTime();
        this.modifiedTime = Calendar.getInstance().getTime();
        this.isDeleted = 0;
        this.isCompleted = 0;

        //TODO: Create groups
    }

    public Note(int noteId, String todoString){
        this.noteId = noteId;
        this.noteData = todoString;
        this.createdTime = Calendar.getInstance().getTime();
        this.modifiedTime = Calendar.getInstance().getTime();
        this.isDeleted = 0;
        this.isCompleted = 0;
    }


    public String getNoteData() {
        return noteData;
    }

    public void setNoteData(String noteData) {
        this.noteData = noteData;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(int isCompleted) {
        this.isCompleted = isCompleted;
    }

}
