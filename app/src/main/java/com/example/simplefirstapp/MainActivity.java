package com.example.simplefirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonClick, secondPage;
    private LinearLayout linearLayoutIndicator;
    private TextView textViewCounter;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonClick = findViewById(R.id.buttonClick);
        secondPage = findViewById(R.id.SecondPage);
        linearLayoutIndicator = findViewById(R.id.indicator);
        textViewCounter = findViewById(R.id.textCounter);




        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++count;
                switch (count){
                    case 5:
                        linearLayoutIndicator.setBackgroundResource(R.color.colorRed);
                        break;
                    case 10:
                        linearLayoutIndicator.setBackgroundResource(R.color.purple_500);
                        break;
                    case 15:
                        linearLayoutIndicator.setBackgroundResource(R.color.colorPurple);
                        count = 0;
                        break;
                }
                textViewCounter.setText(String.valueOf(count));
            }
        });

        secondPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThreeColors.class);
                startActivity(intent);
            }
        });
    }
}