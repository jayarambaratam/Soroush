package android.support.v4.app;

import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.RemoteInput;

class bz {
    public static void m1201a(Builder builder, ce ceVar) {
        Action.Builder builder2 = new Action.Builder(ceVar.m1152a(), ceVar.m1153b(), ceVar.m1154c());
        if (ceVar.m1156f() != null) {
            for (RemoteInput addRemoteInput : cu.m1235a(ceVar.m1156f())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        if (ceVar.m1155d() != null) {
            builder2.addExtras(ceVar.m1155d());
        }
        builder.addAction(builder2.build());
    }
}
