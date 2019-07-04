package com.example.serviceswithnotifications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button gotoActivity1Button;
    private Button gotoActivity2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.w("MainActivity","Starting Main Activity");

        gotoActivity1Button = findViewById(R.id.gotoActivity1Button);
        gotoActivity2Button = findViewById(R.id.gotoActivity2Button);


    }

    public void gotoActivity1(View v){
        Log.w("MainActivity","gotoActivity1 onClick");

        Intent intent = new Intent(this,Activity1.class);
        startActivity(intent);
    }

    public void gotoActivity2(View v){
        Log.w("MainActivity","gotoActivity2 onClick");

        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
    }
}
