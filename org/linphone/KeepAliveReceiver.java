package org.linphone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.linphone.mediastream.Log;

public class KeepAliveReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (!SipLibService.isReady()) {
            Log.m11095i("Keep alive broadcast received while Linphone service not ready");
        } else if (intent.getAction().equalsIgnoreCase("android.intent.action.SCREEN_ON")) {
            LinphoneManager.getLc().enableKeepAlive(true);
        } else if (!intent.getAction().equalsIgnoreCase("android.intent.action.SCREEN_OFF")) {
        }
    }
}
