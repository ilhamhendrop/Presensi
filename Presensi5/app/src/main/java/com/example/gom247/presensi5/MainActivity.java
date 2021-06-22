package com.example.gom247.presensi5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv = (TextView)findViewById(R.id.tv);
        iv = (ImageView)findViewById(R.id.iv);

        Animation nyanim = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        tv.startAnimation(nyanim);
        iv.startAnimation(nyanim);

        final Intent i = new Intent(getApplicationContext(), Login.class);

        Thread timer = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();

    }
}
