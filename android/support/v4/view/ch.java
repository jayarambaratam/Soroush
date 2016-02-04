package android.support.v4.view;

import android.view.View;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

class ch extends cf {
    static Field f1345b;
    static boolean f1346c;

    static {
        f1346c = false;
    }

    ch() {
    }

    public void m2613a(View view, C0077a c0077a) {
        ct.m2689a(view, c0077a == null ? null : c0077a.getBridge());
    }

    public void m2614a(View view, boolean z) {
        ct.m2690a(view, z);
    }

    public boolean m2615a(View view, int i) {
        return ct.m2691a(view, i);
    }

    public boolean m2616b(View view) {
        boolean z = true;
        if (f1346c) {
            return false;
        }
        if (f1345b == null) {
            try {
                f1345b = View.class.getDeclaredField("mAccessibilityDelegate");
                f1345b.setAccessible(true);
            } catch (Throwable th) {
                f1346c = true;
                return false;
            }
        }
        try {
            if (f1345b.get(view) == null) {
                z = false;
            }
            return z;
        } catch (Throwable th2) {
            f1346c = true;
            return false;
        }
    }

    public boolean m2617b(View view, int i) {
        return ct.m2692b(view, i);
    }

    public el m2618u(View view) {
        if (this.a == null) {
            this.a = new WeakHashMap();
        }
        el elVar = (el) this.a.get(view);
        if (elVar != null) {
            return elVar;
        }
        elVar = new el(view);
        this.a.put(view, elVar);
        return elVar;
    }
}
