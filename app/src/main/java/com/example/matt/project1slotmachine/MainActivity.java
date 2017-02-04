package com.example.matt.project1slotmachine;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Vibrator;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    private ImageView reset;
    private ImageView go;
    private ImageView flower1;
    private ImageView flower2;
    private ImageView flower3;
    private TextView money;
    private Animation rotate;
    int amount;
    Vibrator vibrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        reset = (ImageView) findViewById(R.id.reset);
        go = (ImageView) findViewById(R.id.go);
        flower1 = (ImageView) findViewById(R.id.flower1);
        flower2 = (ImageView) findViewById(R.id.flower2);
        flower3 = (ImageView) findViewById(R.id.flower3);
        money = (TextView) findViewById(R.id.moneyCount);
        rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        amount = 5;
        vibrate = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        setMoney(amount);
        rotate.setAnimationListener(this);
    }

    public void go(View view) {

        flower1.setBackgroundResource(R.drawable.tmp);
        flower2.setBackgroundResource(R.drawable.tmp);
        flower3.setBackgroundResource(R.drawable.tmp);
        flower1.startAnimation(rotate);
        flower2.startAnimation(rotate);
        flower3.startAnimation(rotate);
        reset.setVisibility(View.VISIBLE);

        vibrate.vibrate(100);

        amount -= 1;
        setMoney(amount);

        go.setClickable(false);
    }


    private void setMoney(int amount) {
        money.setText("$" + amount);
    }

    public void reset(View view) {
        Toast.makeText(this, "Game has been reset", Toast.LENGTH_SHORT).show();

        vibrate.vibrate(100);

        amount = 5;
        setMoney(amount);


        flower1.setBackgroundResource(R.drawable.f1);
        flower2.setBackgroundResource(R.drawable.f1);
        flower3.setBackgroundResource(R.drawable.f1);

        go.setVisibility(View.VISIBLE);
        reset.setVisibility(View.GONE);
    }

    @Override
    public void onAnimationStart(Animation animation) {
        go.setClickable(false);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        go.setClickable(true);
        changeFlowers();
    }

    private void changeFlowers() {
        Random random = new Random();
        int num1 = random.nextInt(3);
        int num2 = random.nextInt(3);
        int num3 = random.nextInt(3);

        //Toast.makeText(this, "" + num1 + " " + num2 + " " + num3, Toast.LENGTH_SHORT).show();

        int count = 0;

        switch (num1) {
            case 0:
                flower1.setBackgroundResource(R.drawable.f1);
                break;
            case 1:
                flower1.setBackgroundResource(R.drawable.f2);
                break;
            case 2:
                flower1.setBackgroundResource(R.drawable.f3);
                break;
        }
        switch (num2) {
            case 0:
                flower2.setBackgroundResource(R.drawable.f1);
                break;
            case 1:
                flower2.setBackgroundResource(R.drawable.f2);
                break;
            case 2:
                flower2.setBackgroundResource(R.drawable.f3);
                break;
        }
        switch (num3) {
            case 0:
                flower3.setBackgroundResource(R.drawable.f1);
                break;
            case 1:
                flower3.setBackgroundResource(R.drawable.f2);
                break;
            case 2:
                flower3.setBackgroundResource(R.drawable.f3);
                break;
        }

        if (num1 == num2) {
            count = 2;
            if (num2 == num3) {
                count = 3;
            }
        } else if (num2 == num3) {
            count = 2;
        } else if (num1 == num3) {
            count = 2;
        }

        // Toast.makeText(this, ""+ count, Toast.LENGTH_LONG).show();
        amount += count;
        if (amount <= 0) {
            go.setVisibility(View.GONE);
        }
        setMoney(amount);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}

