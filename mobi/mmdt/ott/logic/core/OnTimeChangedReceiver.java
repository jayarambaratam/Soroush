package mobi.mmdt.ott.logic.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import mobi.mmdt.componentsutils.p079a.p084e.C1113a;
import mobi.mmdt.ott.p109d.p111b.C1309a;

public class OnTimeChangedReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (!C1113a.m6422a(context)) {
            C1309a.m6934a(context).m6953d(false);
        }
    }
}
