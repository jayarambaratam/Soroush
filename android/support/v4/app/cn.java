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

public class cn implements bf, bg {
    private Builder f923a;
    private Bundle f924b;
    private List<Bundle> f925c;

    public cn(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2) {
        this.f925c = new ArrayList();
        this.f923a = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z);
        this.f924b = new Bundle();
        if (bundle != null) {
            this.f924b.putAll(bundle);
        }
        if (!(arrayList == null || arrayList.isEmpty())) {
            this.f924b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
        }
        if (z4) {
            this.f924b.putBoolean("android.support.localOnly", true);
        }
        if (str != null) {
            this.f924b.putString("android.support.groupKey", str);
            if (z5) {
                this.f924b.putBoolean("android.support.isGroupSummary", true);
            } else {
                this.f924b.putBoolean("android.support.useSideChannel", true);
            }
        }
        if (str2 != null) {
            this.f924b.putString("android.support.sortKey", str2);
        }
    }

    public Builder m1222a() {
        return this.f923a;
    }

    public void m1223a(ce ceVar) {
        this.f925c.add(ck.m1213a(this.f923a, ceVar));
    }

    public Notification m1224b() {
        SparseArray a = ck.m1215a(this.f925c);
        if (a != null) {
            this.f924b.putSparseParcelableArray("android.support.actionExtras", a);
        }
        this.f923a.setExtras(this.f924b);
        return this.f923a.build();
    }
}
