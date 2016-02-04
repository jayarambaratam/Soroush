package org.linphone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import org.linphone.mediastream.Log;

public class KeepAliveHandler extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Log.m11095i("Keep alive handler invoked");
        try {
            if (LinphoneManager.getLcIfManagerNotDestroyedOrNull() != null) {
                LinphoneManager.getLc().refreshRegisters();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Log.m11091e("Cannot sleep for 2s", e);
                }
            }
        } catch (Throwable e2) {
            C1104b.m6368b((Object) this, e2);
        }
    }
}
