package com.example.serviceswithnotifications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity"; // To be shown on Logs
    private Button gotoActivity1Button;
    private Button gotoActivity2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.w(TAG,"Starting!");

        /*
         * Here we instantiate the buttons, just in case we wanted to
         * change something in them.
         */
        gotoActivity1Button = findViewById(R.id.gotoActivity1Button);
        gotoActivity2Button = findViewById(R.id.gotoActivity2Button);
    }


    /*
     * Callback for the onClick event of button1.
     * This is set in the .xml layout file of the activity.
     */
    public void gotoActivity1(View v){
        Log.w(TAG,"gotoActivity1 onClick");

        Intent intent = new Intent(this,Activity1.class);
        startActivity(intent);
    }

    /*
     * Callback for the onClick event of button2.
     * This is set in the .xml layout file of the activity.
     */
    public void gotoActivity2(View v){
        Log.w(TAG,"gotoActivity2 onClick");

        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
    }
}
