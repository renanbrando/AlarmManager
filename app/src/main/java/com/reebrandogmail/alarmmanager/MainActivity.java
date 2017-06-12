package com.reebrandogmail.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etTime)
    EditText etTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void startAlarm(View view){
        int i = Integer.parseInt(etTime.getText().toString());

        Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i + 1000), pendingIntent);

        Snackbar.make(view, getString(R.string.alarm_msg_one) + i + getString(R.string.alarm_msg_two), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}
