package com.example.gom247.presensi5;

import android.app.Application;

import com.firebase.client.Firebase;



/**
 * Created by Gom247 on 01/12/2017.
 */

public class DataBaseFireBase extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);

    }
}
