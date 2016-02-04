package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

public class cl implements bf, bg {
    private Builder f920a;
    private final Bundle f921b;
    private List<Bundle> f922c;

    public cl(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2) {
        this.f922c = new ArrayList();
        this.f920a = new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
        this.f921b = new Bundle();
        if (bundle != null) {
            this.f921b.putAll(bundle);
        }
        if (z3) {
            this.f921b.putBoolean("android.support.localOnly", true);
        }
        if (str != null) {
            this.f921b.putString("android.support.groupKey", str);
            if (z4) {
                this.f921b.putBoolean("android.support.isGroupSummary", true);
            } else {
                this.f921b.putBoolean("android.support.useSideChannel", true);
            }
        }
        if (str2 != null) {
            this.f921b.putString("android.support.sortKey", str2);
        }
    }

    public Builder m1219a() {
        return this.f920a;
    }

    public void m1220a(ce ceVar) {
        this.f922c.add(ck.m1213a(this.f920a, ceVar));
    }

    public Notification m1221b() {
        Notification build = this.f920a.build();
        Bundle a = ck.m1214a(build);
        Bundle bundle = new Bundle(this.f921b);
        for (String str : this.f921b.keySet()) {
            if (a.containsKey(str)) {
                bundle.remove(str);
            }
        }
        a.putAll(bundle);
        SparseArray a2 = ck.m1215a(this.f922c);
        if (a2 != null) {
            ck.m1214a(build).putSparseParcelableArray("android.support.actionExtras", a2);
        }
        return build;
    }
}
