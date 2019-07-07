package com.example.serviceswithnotifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.ActivityManager;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static com.example.serviceswithnotifications.ServicesWithNotificationsApp.CHANNEL_1_ID;
import static com.example.serviceswithnotifications.ServicesWithNotificationsApp.CHANNEL_2_ID;

public class Activity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    public void startService(View view) {

        if(isMyServiceRunning(Service2.class)) return;

        Intent serviceIntent = new Intent(this,Service2.class);
        serviceIntent.putExtra("extra","extra2Val");
        startService(serviceIntent);
    }

    public void stopService(View view) {
        if(!isMyServiceRunning(Service2.class)) return;

        Intent serviceIntent = new Intent(this,Service2.class);
        stopService(serviceIntent);
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
