package com.doggy.ringtone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * 播放手机铃声
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void playSystemRingtone(View view) {
        RingtoneUtil.startPlay(this);
    }

    //停止播放铃声
    public void stopSystemRingtone(View view) {
        RingtoneUtil.stopPlay();
    }
}
