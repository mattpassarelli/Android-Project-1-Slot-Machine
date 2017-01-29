package com.example.matt.project1slotmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Button reset = (Button) findViewById(R.id.reset);
        //reset.setVisibility(View.VISIBLE);
        setContentView(R.layout.activity_main);

    }
}
