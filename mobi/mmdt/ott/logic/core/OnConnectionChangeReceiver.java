package mobi.mmdt.ott.logic.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class OnConnectionChangeReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        StartUpService.m7551d(context);
    }
}
