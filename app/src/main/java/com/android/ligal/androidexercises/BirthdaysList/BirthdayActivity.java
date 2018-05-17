package com.android.ligal.androidexercises.BirthdaysList;


import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.android.ligal.androidexercises.R;


import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BirthdayActivity extends AppCompatActivity {

    private static final String TAG = "BirthdayActivity";

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    FloatingActionButton fab;
    List<BirthDayList> birthdays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BirthdaysListDatabase db = Room.databaseBuilder(getApplicationContext(), BirthdaysListDatabase.class,
                "BirthDayList")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();


        birthdays = db.birthDaysListDao().getAllItems();
        Log.d(TAG, "List count:" + String.valueOf(birthdays.size()));
        Collections.sort(birthdays, new Comparator<BirthDayList>() {
            @Override
            public int compare(BirthDayList n1, BirthDayList n2) {
                try {
                    int bdayInt1 = n1.calcBirthDay(n1.getBirthDay());
                    int bdayInt2 = n2.calcBirthDay(n2.getBirthDay());
                    return Integer.compare(bdayInt1, bdayInt2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });

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
