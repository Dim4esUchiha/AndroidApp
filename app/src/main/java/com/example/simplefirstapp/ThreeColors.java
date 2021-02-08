package com.example.simplefirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ThreeColors extends AppCompatActivity {

    private Button generateRandomColorButton, backButton;
    private LinearLayout Color1, Color2, Color3;
    private TextView textViewWoW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_colors);
        generateRandomColorButton = findViewById(R.id.generateButton);
        backButton = findViewById(R.id.backButton);
        Color1 = findViewById(R.id.Color1);
        Color2 = findViewById(R.id.Color2);
        Color3 = findViewById(R.id.Color3);
        textViewWoW = findViewById(R.id.textWOW);



        ArrayList<Integer> listOfColors = new ArrayList<Integer>();
        listOfColors.add(R.color.colorPurple);
        //listOfColors.add(R.color.white);
        listOfColors.add(R.color.colorRed);
        listOfColors.add(R.color.colorGreen);
        //listOfColors.add(R.color.colorYellow);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThreeColors.this, MainActivity.class);
                startActivity(intent);
            }
        });

        generateRandomColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewWoW.clearComposingText();
                int random;
                for(int i = 0;i < 3; ++i ){
                    random = (int)(Math.random() * listOfColors.size());
                    Color1.setBackgroundResource(listOfColors.get(random));
                    random = (int)(Math.random() * listOfColors.size());
                    Color2.setBackgroundResource(listOfColors.get(random));
                    random = (int)(Math.random() * listOfColors.size());
                    Color3.setBackgroundResource(listOfColors.get(random));
                }

                int color1 = ((ColorDrawable)Color1.getBackground()).getColor();
                int color2 = ((ColorDrawable)Color2.getBackground()).getColor();
                int color3 = ((ColorDrawable)Color3.getBackground()).getColor();

                if(color1 == color2 && color2 == color3){
                    textViewWoW.setText("WOW!!!");
                }

            }
        });
    }
}