package com.android.ligal.androidexercises.BirthdaysList;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {BirthDayList.class}, version = 1)
public abstract class BirthdaysListDatabase extends RoomDatabase {
    public abstract BirthDaysListDao birthDaysListDao();

}






