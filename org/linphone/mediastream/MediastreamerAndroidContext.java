package org.linphone.mediastream;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;

@TargetApi(18)
public class MediastreamerAndroidContext {
    private MediastreamerAndroidContext() {
    }

    private static int parseInt(String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            Log.m11091e("Can't parse " + str + " to integer ; using default value " + i);
        }
        return i;
    }

    public static void setContext(Object obj) {
        if (obj != null) {
            Context context = (Context) obj;
            MediastreamerAndroidContext mediastreamerAndroidContext = new MediastreamerAndroidContext();
            if (VERSION.SDK_INT >= 19) {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                int parseInt = parseInt(audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER"), 64);
                Log.m11095i("Setting buffer size to " + parseInt + " and sample rate to " + parseInt(audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE"), 44100) + " for OpenSLES MS sound card.");
                mediastreamerAndroidContext.setDeviceFavoriteSampleRate(r0);
                mediastreamerAndroidContext.setDeviceFavoriteBufferSize(parseInt);
                return;
            }
            Log.m11095i("Android < 4.4 detected, android context not used.");
        }
    }

    private native void setDeviceFavoriteBufferSize(int i);

    private native void setDeviceFavoriteSampleRate(int i);
}
