package org.linphone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

public class NetworkManager extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        Boolean valueOf = Boolean.valueOf(intent.getBooleanExtra("noConnectivity", false));
        if (LinphoneManager.isInstanciated()) {
            LinphoneManager.getInstance().connectivityChanged(connectivityManager, valueOf.booleanValue());
        }
    }
}
