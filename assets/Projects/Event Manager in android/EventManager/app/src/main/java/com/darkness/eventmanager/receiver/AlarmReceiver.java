package com.darkness.eventmanager.receiver;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.darkness.eventmanager.DisplayEventNowActivity;
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        //Android Oreo and above requires Notification Channel to create Notification.
        //Following code will create notification channel.

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel("EVENTID","EVENTMANAGER",NotificationManager.IMPORTANCE_HIGH);
                assert notificationManager != null;
                notificationManager.createNotificationChannel(channel);
            }

        Intent intent1 = new Intent(context, DisplayEventNowActivity.class);
        intent1.putExtra("title",intent.getStringExtra("title"));
        intent1.putExtra("date",intent.getStringExtra("date"));
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        PendingIntent pendingIntent = PendingIntent.getActivity(context.getApplicationContext(), 23,intent1,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"EVENTID")
                .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setContentTitle(intent.getStringExtra("title"))
                .setFullScreenIntent(pendingIntent,true)//To show our event display activity from lock screen this line will do it.
                .setContentText("Your event is going to live in few minutes be Ready !");
        assert notificationManager != null;
        notificationManager.notify(34,builder.build());

    }
}
