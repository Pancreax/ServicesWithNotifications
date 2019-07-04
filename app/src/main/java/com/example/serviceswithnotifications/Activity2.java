package com.example.serviceswithnotifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static com.example.serviceswithnotifications.ServicesWithNotificationsApp.CHANNEL_1_ID;
import static com.example.serviceswithnotifications.ServicesWithNotificationsApp.CHANNEL_2_ID;

public class Activity2 extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        notificationManager = NotificationManagerCompat.from(this);
    }

    public void startService(View view) {

        Intent serviceIntent = new Intent(this,Service1.class);
        serviceIntent.putExtra("extra","extra2Val");

        startService(serviceIntent);

        /*Notification notification = new NotificationCompat.Builder(this,CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_2)
                .setContentTitle("Title2")
                .setContentText("Text2")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1, notification);*/
    }
}
