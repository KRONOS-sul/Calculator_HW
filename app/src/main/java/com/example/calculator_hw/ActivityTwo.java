package com.example.calculator_hw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class ActivityTwo extends AppCompatActivity {
    private MaterialButton explode;
    private TextView getting_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_two);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.status_bar)); }
        explode =  findViewById(R.id.explode);
        getting_id = findViewById(R.id.getting_id);
        explode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                onDestroy();
            }
        });
        String answer = getIntent().getStringExtra("answer");
        getting_id.setText(answer);
    }
}