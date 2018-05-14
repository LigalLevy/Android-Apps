package com.android.ligal.androidexercises.BirthdaysList;

import android.app.DatePickerDialog;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.android.ligal.androidexercises.R;

import java.util.Calendar;

public class CreateBirthday extends AppCompatActivity {

    EditText name;
    EditText birthDate;
    EditText comment;
    Button button;
    String date;
    int day, month, year;
    Calendar mCurrentDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_birthday);

        name = findViewById(R.id.name);
        birthDate = findViewById(R.id.birth_date);
        comment = findViewById(R.id.comment);
        button = findViewById(R.id.buttonAdd);

        mCurrentDate = Calendar.getInstance();

        day = mCurrentDate.get(Calendar.DAY_OF_MONTH);
        month = mCurrentDate.get(Calendar.MONTH);
        year = mCurrentDate.get(Calendar.YEAR);
        month = month+1;


        final BirthdaysListDatabase db = Room.databaseBuilder(getApplicationContext(), BirthdaysListDatabase.class, "BirthdaysList")
                .allowMainThreadQueries()
                .build();

        birthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(CreateBirthday.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month+1;
                        birthDate.setText(dayOfMonth+"/"+month+"/"+year);
                        date = dayOfMonth+"/"+month+"/"+year;
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.birthDaysListDao().insertAll(new BirthDayList(
                        name.getText().toString(),
                        birthDate.getText().toString(),
                        comment.getText().toString()));
                startActivity(new Intent(CreateBirthday.this, BirthdayActivity.class));
            }
        });
    }
}
