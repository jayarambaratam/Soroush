package android.support.v4.view.p017a;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.List;

/* renamed from: android.support.v4.view.a.z */
public class C0303z {
    private static final aa f1321a;
    private final Object f1322b;

    static {
        if (VERSION.SDK_INT >= 19) {
            f1321a = new ad();
        } else if (VERSION.SDK_INT >= 16) {
            f1321a = new ab();
        } else {
            f1321a = new af();
        }
    }

    public C0303z() {
        this.f1322b = f1321a.m1868a(this);
    }

    public C0303z(Object obj) {
        this.f1322b = obj;
    }

    public C0284g m2200a(int i) {
        return null;
    }

    public Object m2201a() {
        return this.f1322b;
    }

    public List<C0284g> m2202a(String str, int i) {
        return null;
    }

    public boolean m2203a(int i, int i2, Bundle bundle) {
        return false;
    }

    public C0284g m2204b(int i) {
        return null;
    }
}
