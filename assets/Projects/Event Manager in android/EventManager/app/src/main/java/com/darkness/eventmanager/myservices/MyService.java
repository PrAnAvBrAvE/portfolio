package com.darkness.eventmanager.myservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.darkness.eventmanager.DisplayEventNowActivity;

public class MyService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent intent1 = new Intent(getApplicationContext(),DisplayEventNowActivity.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_FROM_BACKGROUND);
        intent1.setAction(Intent.ACTION_SCREEN_ON);
        getBaseContext().startActivity(new Intent(getApplicationContext(),DisplayEventNowActivity.class));
        return START_NOT_STICKY;
    }
}
