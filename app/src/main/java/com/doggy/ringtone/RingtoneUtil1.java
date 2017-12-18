package com.doggy.ringtone;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;

import java.io.IOException;

/**
 * Created by hy on 2017/12/14.
 * 播放手机系统铃声工具类（MediaPlayer播放）
 */

public class RingtoneUtil1 {

    private static MediaPlayer mMediaPlayer;

    //开始播放铃声
    public static void startPlay(Context context) {
        try {
            Uri defaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.TYPE_RINGTONE);
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setAudioStreamType(RingtoneManager.TYPE_RINGTONE);
            mMediaPlayer.setDataSource(context, defaultRingtoneUri);
            mMediaPlayer.setLooping(true);
            mMediaPlayer.prepare();
            mMediaPlayer.start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //停止播放铃声
    public static void stopPlay() {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

}
