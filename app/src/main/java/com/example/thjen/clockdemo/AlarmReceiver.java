package com.example.thjen.clockdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Hi", "Hi Q.ThjeN");
        String stop = intent.getExtras().getString("extra");
        Intent intent1 = new Intent(context, MusicService.class);
        intent1.putExtra("extra", stop);

        context.startService(intent1);
    }
}
