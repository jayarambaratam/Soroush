package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class bm {
    Notification f882A;
    public Notification f883B;
    public ArrayList<String> f884C;
    public Context f885a;
    public CharSequence f886b;
    public CharSequence f887c;
    PendingIntent f888d;
    PendingIntent f889e;
    RemoteViews f890f;
    public Bitmap f891g;
    public CharSequence f892h;
    public int f893i;
    int f894j;
    boolean f895k;
    public boolean f896l;
    public by f897m;
    public CharSequence f898n;
    int f899o;
    int f900p;
    boolean f901q;
    String f902r;
    boolean f903s;
    String f904t;
    public ArrayList<bi> f905u;
    boolean f906v;
    String f907w;
    Bundle f908x;
    int f909y;
    int f910z;

    public bm(Context context) {
        this.f895k = true;
        this.f905u = new ArrayList();
        this.f906v = false;
        this.f909y = 0;
        this.f910z = 0;
        this.f883B = new Notification();
        this.f885a = context;
        this.f883B.when = System.currentTimeMillis();
        this.f883B.audioStreamType = -1;
        this.f894j = 0;
        this.f884C = new ArrayList();
    }

    private void m1167a(int i, boolean z) {
        if (z) {
            Notification notification = this.f883B;
            notification.flags |= i;
            return;
        }
        notification = this.f883B;
        notification.flags &= i ^ -1;
    }

    protected static CharSequence m1168d(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public Notification m1169a() {
        return bh.f867a.m1192a(this, m1184b());
    }

    public bm m1170a(int i) {
        this.f883B.icon = i;
        return this;
    }

    public bm m1171a(int i, int i2) {
        this.f883B.icon = i;
        this.f883B.iconLevel = i2;
        return this;
    }

    public bm m1172a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        this.f905u.add(new bi(i, charSequence, pendingIntent));
        return this;
    }

    public bm m1173a(PendingIntent pendingIntent) {
        this.f888d = pendingIntent;
        return this;
    }

    public bm m1174a(Bitmap bitmap) {
        this.f891g = bitmap;
        return this;
    }

    public bm m1175a(Uri uri) {
        this.f883B.sound = uri;
        this.f883B.audioStreamType = -1;
        return this;
    }

    public bm m1176a(by byVar) {
        if (this.f897m != byVar) {
            this.f897m = byVar;
            if (this.f897m != null) {
                this.f897m.m1163a(this);
            }
        }
        return this;
    }

    public bm m1177a(CharSequence charSequence) {
        this.f886b = m1168d(charSequence);
        return this;
    }

    public bm m1178a(String str) {
        this.f907w = str;
        return this;
    }

    public bm m1179a(boolean z) {
        m1167a(2, z);
        return this;
    }

    public bm m1180a(long[] jArr) {
        this.f883B.vibrate = jArr;
        return this;
    }

    public bm m1181b(int i) {
        this.f893i = i;
        return this;
    }

    public bm m1182b(CharSequence charSequence) {
        this.f887c = m1168d(charSequence);
        return this;
    }

    public bm m1183b(boolean z) {
        m1167a(16, z);
        return this;
    }

    protected bn m1184b() {
        return new bn();
    }

    public bm m1185c(int i) {
        this.f883B.defaults = i;
        if ((i & 4) != 0) {
            Notification notification = this.f883B;
            notification.flags |= 1;
        }
        return this;
    }

    public bm m1186c(CharSequence charSequence) {
        this.f883B.tickerText = m1168d(charSequence);
        return this;
    }

    public bm m1187d(int i) {
        this.f894j = i;
        return this;
    }
}
