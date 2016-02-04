package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;

public class co extends cw {
    public static final cx f926a;
    private static final cq f927g;
    private final String f928b;
    private final CharSequence f929c;
    private final CharSequence[] f930d;
    private final boolean f931e;
    private final Bundle f932f;

    static {
        if (VERSION.SDK_INT >= 20) {
            f927g = new cr();
        } else if (VERSION.SDK_INT >= 16) {
            f927g = new ct();
        } else {
            f927g = new cs();
        }
        f926a = new cp();
    }

    public String m1230a() {
        return this.f928b;
    }

    public CharSequence m1231b() {
        return this.f929c;
    }

    public CharSequence[] m1232c() {
        return this.f930d;
    }

    public boolean m1233d() {
        return this.f931e;
    }

    public Bundle m1234e() {
        return this.f932f;
    }
}
