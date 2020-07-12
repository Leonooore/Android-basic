package com.gmail.elnora.fet.nextbackapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findViewById(R.id.button_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        Intent intent = getIntent();
//        intent.getIntExtra("KEY_A", 0);
//        intent.getIntExtra("KEY_B", 0);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d("SecondActivity", "onBackPressed");
    }
}
