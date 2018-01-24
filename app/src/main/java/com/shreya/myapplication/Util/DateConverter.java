package com.shreya.myapplication.Util;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by Shreya on 1/17/2018.
 */

public class DateConverter {

    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}