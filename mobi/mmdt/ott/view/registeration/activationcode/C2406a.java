package mobi.mmdt.ott.view.registeration.activationcode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.SmsMessage;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.registeration.activationcode.a */
class C2406a extends BroadcastReceiver {
    final /* synthetic */ ActivationCodeActivity f7897a;

    C2406a(ActivationCodeActivity activationCodeActivity) {
        this.f7897a = activationCodeActivity;
    }

    public void onReceive(Context context, Intent intent) {
        try {
            if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    for (Object obj : (Object[]) extras.get("pdus")) {
                        SmsMessage createFromPdu = VERSION.SDK_INT >= 23 ? SmsMessage.createFromPdu((byte[]) obj, extras.getString("format")) : SmsMessage.createFromPdu((byte[]) obj);
                        createFromPdu.getOriginatingAddress();
                        String replaceAll = createFromPdu.getMessageBody().replaceAll("[^0-9]", BuildConfig.FLAVOR);
                        if (replaceAll.length() == 5 || replaceAll.length() == 6) {
                            this.f7897a.runOnUiThread(new C2407b(this, replaceAll));
                            abortBroadcast();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
    }
}
