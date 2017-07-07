package com.example.devra.attendanceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button toMap = (Button)findViewById(R.id.buttonMap);
        toMap.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        Button toPresent = (Button)findViewById(R.id.buttonPresent);
        toPresent.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, ReportPresentActivity.class);
                startActivity(intent);
            }
        });

        Button toLate = (Button)findViewById(R.id.buttonLate);
        toLate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, ReportLateActivity.class);
                startActivity(intent);
            }
        });

        Button toAbsent = (Button)findViewById(R.id.buttonAbsent);
        toAbsent.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, ReportAbsentActivity.class);
                startActivity(intent);
            }
        });
    }
}
