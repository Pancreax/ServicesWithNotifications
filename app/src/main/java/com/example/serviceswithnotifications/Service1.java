package com.example.serviceswithnotifications;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import static com.example.serviceswithnotifications.ServicesWithNotificationsApp.CHANNEL_1_ID;
import static com.example.serviceswithnotifications.ServicesWithNotificationsApp.CHANNEL_2_ID;

public class Service1 extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

        String input = intent.getStringExtra("extra");

        Intent notificationIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, notificationIntent, 0);

        Notification notification = new NotificationCompat.Builder(this,input.equals("extra1Val") ? CHANNEL_1_ID : CHANNEL_2_ID)
                .setSmallIcon(input.equals("extra1Val") ? R.drawable.ic_1 : R.drawable.ic_2)
                .setContentTitle(input)
                .setContentText(input)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1,notification);

        //notificationManager.notify(1, notification);

        //return super.onStartCommand(intent,flags,startId);

        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent){
        return null;
    }
}
