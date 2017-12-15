package com.example.overrideondraw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.overrideondraw.R;

public class Demo1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1);
    }
}
