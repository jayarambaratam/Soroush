package org.linphone;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.linphone.mediastream.Log;

@TargetApi(11)
public class BluetoothManager extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (LinphoneManager.isInstanciated()) {
            String action = intent.getAction();
            LinphoneManager instance = LinphoneManager.getInstance();
            if ("android.bluetooth.device.action.ACL_DISCONNECTED".equals(action)) {
                Log.m11091e("Bluetooth Received Event ACTION_ACL_DISCONNECTED");
                if (instance != null) {
                    instance.scoDisconnected();
                    instance.routeAudioToReceiver();
                }
            } else if ("android.bluetooth.device.action.ACL_CONNECTED".equals(action)) {
                Log.m11091e("Bluetooth Received Event ACTION_ACL_CONNECTED");
                if (instance != null) {
                    instance.scoConnected();
                }
            } else if ("android.media.SCO_AUDIO_STATE_CHANGED".equals(action)) {
                int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", 0);
                Log.m11091e("Bluetooth sco state changed : " + intExtra);
                if (intExtra == 1) {
                    if (instance != null) {
                        instance.scoConnected();
                    }
                } else if (intExtra == 0 && instance != null) {
                    instance.scoDisconnected();
                    instance.routeAudioToReceiver();
                }
            } else if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(action)) {
                Log.m11091e("Bluetooth state changed: " + intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", 0));
                if (instance != null && r0 == 2) {
                    instance.startBluetooth();
                }
            }
        }
    }
}
