package com.example.simpletodo;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class LaunchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Send user to MainActivity as soon as this activity loads
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        // remove this activity from the stack
        finish();
    }
}


