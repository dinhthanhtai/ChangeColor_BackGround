package com.example.randomcolor_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button buttonA;
    private Button buttonB;
    private TextView text;
    private ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout1);
        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        text = findViewById(R.id.text1);

        SharedPreferences pref = getSharedPreferences( "color", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int color1 = Color.argb(255, random.nextInt(256),random.nextInt(256),random.nextInt(256));

                layout.setBackgroundColor(color1);
                edit.putInt("color1",color1);
                edit.commit();
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int color2 = Color.argb(255, random.nextInt(256),random.nextInt(256),random.nextInt(256));

                text.setTextColor(color2);
                edit.putInt("color2",color2);
                edit.commit();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences pref = getSharedPreferences( "color", Context.MODE_PRIVATE);
        int color1 = pref.getInt("color1", Color.WHITE);
        int color2 = pref.getInt("color2",Color.BLACK);
        layout.setBackgroundColor(color1);
        text.setTextColor(color2);
    }
}