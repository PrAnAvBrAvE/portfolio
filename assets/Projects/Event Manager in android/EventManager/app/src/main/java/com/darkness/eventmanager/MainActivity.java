package com.darkness.eventmanager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    ////////////////////////////////////////
    //                                    //
    //      Created By Vinayak Patil      //
    //           Date 18/06/2020          //
    //                                    //
    ////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startTimerForSplashScreen();


    }

    private void startTimerForSplashScreen() {
        new CountDownTimer(2000,1000){
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(MainActivity.this,EventDisplayerActivity.class));
                MainActivity.this.finish();
            }
        }.start();
    }
}
