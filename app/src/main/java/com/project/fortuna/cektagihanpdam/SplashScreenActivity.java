package com.project.fortuna.cektagihanpdam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {

    private ImageView imageSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageSplash = (ImageView)findViewById(R.id.imageSplash);
        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    Animation myAnim = AnimationUtils.loadAnimation(SplashScreenActivity.this,R.anim.my_transition);
                    imageSplash.startAnimation(myAnim);
                    sleep(3000);
                    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}
