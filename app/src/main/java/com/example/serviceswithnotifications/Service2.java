package com.example.serviceswithnotifications;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import static com.example.serviceswithnotifications.ServicesWithNotificationsApp.CHANNEL_1_ID;
import static com.example.serviceswithnotifications.ServicesWithNotificationsApp.CHANNEL_2_ID;
import static com.example.serviceswithnotifications.ServicesWithNotificationsApp.SERVICE_NOTIFICATION_ID;

public class Service2 extends Service {
    private final String TAG = "Service2";
    private Handler myHandler;
    private Boolean isRunning = false;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w(TAG,"Stopping!");
        isRunning = false;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.w(TAG,"Starting!");
        isRunning = true;
        myHandler = new Handler();

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

        startForeground(SERVICE_NOTIFICATION_ID,notification);

        doSomething();

        return START_NOT_STICKY;
    }

    private void doSomething(){

        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.w(TAG,"Doing something");
                if(isRunning)doSomething();
            }
        },1000);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent){
        return null;
    }
}
