package com.example.upg2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        displaySplash1();

        progressBar = findViewById(R.id.progressBar_splash);
        progressBar.setProgress(0);
    }

    public void displaySplash1(){

        Thread mythread = new Thread(){
            @Override
            public void run() {
                try {
                    int diplaytime = 4000;
                    int wittime = 0;
                    while (wittime < diplaytime){
                        sleep(100);
                        wittime = wittime + 100;
                    }
                    super.run();

                } catch (InterruptedException e){
                    e.printStackTrace();

                }finally {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();

                }
            }
        };

        mythread.start();
    }

    public void displaySplash(){
        Thread mythread = new Thread(){
            @Override
            public void run() {
                try {
                    int displaytime = 8000;
                    int waittime = 0;
                    while (waittime < displaytime) {
                        sleep(100);
                        waittime = waittime + 100;
                    }
                    super.run();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent a = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(a);
                    finish();
                }
            }
        };
        mythread.start();
    }



}