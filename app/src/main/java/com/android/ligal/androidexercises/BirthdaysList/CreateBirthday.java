package com.android.ligal.androidexercises.BirthdaysList;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import com.android.ligal.androidexercises.R;

public class CreateBirthday extends AppCompatActivity {

    EditText name;
    EditText birthDate;
    CalendarView calendarView;
    EditText comment;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_birthday);

        name = findViewById(R.id.name);
        birthDate = findViewById(R.id.birth_date);
        calendarView = findViewById(R.id.calendar_view);
        comment = findViewById(R.id.comment);
        button = findViewById(R.id.buttonAdd);

        final BirthdaysListDatabase db = Room.databaseBuilder(getApplicationContext(), BirthdaysListDatabase.class, "BirthDays List")
                .allowMainThreadQueries()
                .build();

        birthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarView.setVisibility(View.VISIBLE);
            }
        });

        calendarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long date = calendarView.getDate();
                birthDate.setText(String.valueOf(date));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: make a database
                db.birthDaysListDao().insertAll(new BirthDayList(name.getText().toString(),"",comment.getText().toString()));
                startActivity(new Intent(CreateBirthday.this, BirthdayActivity.class));

            }
        });

    }
}
