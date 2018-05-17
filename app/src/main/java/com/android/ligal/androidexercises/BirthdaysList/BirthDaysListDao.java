package com.android.ligal.androidexercises.BirthdaysList;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

@Dao
public interface BirthDaysListDao {

        @Query("SELECT * FROM BirthDayList")
        List<BirthDayList> getAllItems();

        @Insert
        void insertAll(BirthDayList birthDayList);

        @Query("DELETE FROM BirthDayList")
        void deleteAll();
}
