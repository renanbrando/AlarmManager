package com.reebrandogmail.alarmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver{

    public AlarmReceiver() {

    }

    private MediaPlayer mediaPlayer = null;

    @Override
    public void onReceive(Context context, Intent intent) {
        mediaPlayer = MediaPlayer.create(context, R.raw.mk_toasty);
        mediaPlayer.start();
        Toast.makeText(context, R.string.alarm, Toast.LENGTH_SHORT).show();
    }
}
