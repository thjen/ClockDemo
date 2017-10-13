package com.example.thjen.clockdemo;

import android.app.Service;
import android.content.Context;
import android.content.Intent;

import android.media.AudioAttributes;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;

public class MusicService extends Service {

    MediaPlayer mediaPlayer;
    int id;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String Stop = intent.getExtras().getString("extra");

        if ( Stop.equals("on") ) {
            id = 1;
        } else {
            id = 2;
        }

        if ( id == 1 ) {

            try {
                mediaPlayer = MediaPlayer.create(this, R.raw.anhmo);
                mediaPlayer.start();
            } catch (Exception e ) {}
            Log.d("Musical", "Play now");
            id = 2;
        } else {
            mediaPlayer.stop();
            mediaPlayer.reset();
        }

        return START_NOT_STICKY;
    }

}
