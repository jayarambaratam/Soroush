package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;

public class bi extends ce {
    public static final cf f868d;
    public int f869a;
    public CharSequence f870b;
    public PendingIntent f871c;
    private final Bundle f872e;
    private final co[] f873f;

    static {
        f868d = new bj();
    }

    public bi(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        this(i, charSequence, pendingIntent, new Bundle(), null);
    }

    private bi(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, co[] coVarArr) {
        this.f869a = i;
        this.f870b = bm.m1168d(charSequence);
        this.f871c = pendingIntent;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f872e = bundle;
        this.f873f = coVarArr;
    }

    public int m1157a() {
        return this.f869a;
    }

    public CharSequence m1158b() {
        return this.f870b;
    }

    public PendingIntent m1159c() {
        return this.f871c;
    }

    public Bundle m1160d() {
        return this.f872e;
    }

    public co[] m1161e() {
        return this.f873f;
    }

    public /* synthetic */ cw[] m1162f() {
        return m1161e();
    }
}
