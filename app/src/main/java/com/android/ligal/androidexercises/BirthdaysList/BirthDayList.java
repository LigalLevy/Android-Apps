package com.android.ligal.androidexercises.BirthdaysList;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
public class BirthDayList {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Name")
    private String name;

    @ColumnInfo(name = "BirthDay")
    private String birthDay;

    @ColumnInfo(name = "Comment")
    private String comment;

    public BirthDayList(String name, String birthDay, String comment) {
        setName(name);
        setBirthDay(birthDay);
        setComment(comment);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public String getBirthDay() { return birthDay; }

    public String getAge() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse(birthDay);

        Calendar birhday_tmp = Calendar.getInstance();
        birhday_tmp.setTime(date);
        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - birhday_tmp.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < birhday_tmp.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        Integer ageInt = Integer.valueOf(age);
        String _age = ageInt.toString();

        return _age;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDay(String date) {
        this.birthDay = date;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int calcBirthDay(String birthday) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse(birthday);

        Calendar _birhday = Calendar.getInstance();
        _birhday.setTime(date);
        Calendar today = Calendar.getInstance();
        int nextBDay = 0;

        if ( _birhday.get(Calendar.MONTH) >= today.get(Calendar.MONTH)){
            nextBDay = (_birhday.get(Calendar.MONTH) - today.get(Calendar.MONTH)) * 31;
            if (_birhday.get(Calendar.DAY_OF_MONTH) >= today.get(Calendar.DAY_OF_MONTH)){
                nextBDay += _birhday.get(Calendar.DAY_OF_MONTH) - today.get(Calendar.DAY_OF_MONTH);
            } else {
                nextBDay += (12 * 31) - (today.get(Calendar.DAY_OF_MONTH) - _birhday.get(Calendar.DAY_OF_MONTH));
            }
        } else {
            nextBDay = (12 - (today.get(Calendar.MONTH) - _birhday.get(Calendar.MONTH))) * 31;
            if (_birhday.get(Calendar.DAY_OF_MONTH) >= today.get(Calendar.DAY_OF_MONTH)){
                nextBDay += _birhday.get(Calendar.DAY_OF_MONTH) - today.get(Calendar.DAY_OF_MONTH);
            } else {
                nextBDay += today.get(Calendar.DAY_OF_MONTH) - _birhday.get(Calendar.DAY_OF_MONTH);
            }
        }
        return nextBDay;
    }
}

