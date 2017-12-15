package com.example.overrideondraw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn1:
                intent = new Intent(MainActivity.this, Demo1Activity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
