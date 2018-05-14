package com.android.ligal.androidexercises.BirthdaysList;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.ligal.androidexercises.R;


import java.util.List;

public class BirthdayActivity extends AppCompatActivity {

    private static final String TAG = "BirthdayActivity";

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler_view);

        BirthdaysListDatabase db = Room.databaseBuilder(getApplicationContext(), BirthdaysListDatabase.class, "BirthDays List")
                .allowMainThreadQueries()
                .build();

        List<BirthDayList> birthdays = db.birthDaysListDao().getAllItems();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(birthdays);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(BirthdayActivity.this , CreateBirthday.class));

            }
        });
    }

}
