package com.android.ligal.androidexercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.ligal.androidexercises.BirthdaysList.BirthdayActivity;
import com.android.ligal.androidexercises.Calculator.CalculatorActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onCalcClicked(View view) {
        startActivity(new Intent(MainActivity.this, CalculatorActivity.class));
    }

    public void onBirthdayClicked(View view) {
        startActivity(new Intent(MainActivity.this, BirthdayActivity.class));
    }

}
