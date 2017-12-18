package com.doggy.ringtone;

import android.content.Context;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.view.View;

/**
 * Created by w on 2017/12/18.
 * 播放手机系统铃声工具类（Ringtone播放）
 */

public class RingtoneUtil2 {
    /**
     * 在Ringtone中，对DRM提供了默认的支持，利用setStreamType()方法可以设置流类型，利用isPlaying()方法可以判断流的播放状态。
     * DRM:Digital Rights Management，译为数字版权管理。是目前业界使用非常广泛的一种数字内容版权保护技术
     * If the current default ringtone is in the DRM provider and the caller
     * does not have permission, the exception will be a FileNotFoundException.
     * 如果当前的默认铃声在DRM供应商中没有调用权限，将发生FileNotFoundException异常。
     */
    private static Ringtone ringtone;

    public static void startPlay(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        Uri mDefaultUri = RingtoneManager.getActualDefaultRingtoneUri(context,
                RingtoneManager.TYPE_RINGTONE);                               //获取默认铃声
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_RING);
        audioManager.setStreamVolume(AudioManager.STREAM_RING, maxVolume / 2,
                AudioManager.FLAG_ALLOW_RINGER_MODES);
        ringtone = RingtoneManager.getRingtone(context, mDefaultUri); //获得铃声句柄
        ringtone.setStreamType(RingtoneManager.TYPE_RINGTONE);//设置铃声类型
        ringtone.play();
    }

    public static void stopPlay() {
        if (ringtone != null && ringtone.isPlaying())
            ringtone.stop();
    }
}
