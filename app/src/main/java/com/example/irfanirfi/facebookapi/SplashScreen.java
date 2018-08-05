package com.example.irfanirfi.facebookapi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.net.NetworkInterface;

public class SplashScreen extends AppCompatActivity {

    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        preferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
            int id = preferences.getInt("user_id", 0);
            if (id != 0) {



                Thread t = new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(10000);
                            Intent i = new Intent(SplashScreen.this, Diary.class);
                            startActivity(i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                t.start();
            }
     else {
//        Intent ii = new Intent(SplashScreen.this, Main2Activity.class);
//        startActivity(ii);
                d();
    }
    }

    private void d()
    {
        Toast.makeText(SplashScreen.this, "Please Login to continue", Toast.LENGTH_LONG).show();
    }
}
