package com.example.serviceswithnotifications;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.util.Log;

/*
 * This class is loaded when the application is loaded, before the main activity.
 * This is done by adding it's name as the "android:name" property of the application
 * in the AndroidManifest.xml file.
 * Any initialization that applies to the whole application can be done in here.
 */
public class ServicesWithNotificationsApp extends Application {
    public static final String TAG = "Services...App";
    public static final String CHANNEL_1_ID = "Channel1";
    public static final String CHANNEL_2_ID = "Channel2";
    public static final Integer SERVICE_NOTIFICATION_ID = 1;

    @Override
    public void onCreate(){
        super.onCreate();
        Log.w(TAG,"Initializing App!!");
        createNotificationChannels();
    }

    /*
     * Creating the notification channels in here allows them to be created only once
     * and then to be used anywhere in the whole application.
     */
    private void createNotificationChannels() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel Channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel1Name",
                    NotificationManager.IMPORTANCE_HIGH);
            Channel1.setDescription("Description of Channel1");


            NotificationChannel Channel2 = new NotificationChannel(
                    CHANNEL_2_ID,
                    "Channel2Name",
                    NotificationManager.IMPORTANCE_LOW);
            Channel2.setDescription("Description of Channel2");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(Channel1);
            manager.createNotificationChannel(Channel2);
        }
    }
}
