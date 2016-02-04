package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.bt;
import android.view.View;
import android.view.ViewGroup;

public abstract class ah extends bt {
    private final C0151x f809a;
    private an f810b;
    private Fragment f811c;

    public ah(C0151x c0151x) {
        this.f810b = null;
        this.f811c = null;
        this.f809a = c0151x;
    }

    private static String m1026a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public Parcelable m1027a() {
        return null;
    }

    public abstract Fragment m1028a(int i);

    public Object m1029a(ViewGroup viewGroup, int i) {
        if (this.f810b == null) {
            this.f810b = this.f809a.m1383a();
        }
        long b = m1034b(i);
        Fragment a = this.f809a.m1382a(m1026a(viewGroup.getId(), b));
        if (a != null) {
            this.f810b.m1062c(a);
        } else {
            a = m1028a(i);
            this.f810b.m1057a(viewGroup.getId(), a, m1026a(viewGroup.getId(), b));
        }
        if (a != this.f811c) {
            a.m976b(false);
            a.m981c(false);
        }
        return a;
    }

    public void m1030a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public void m1031a(ViewGroup viewGroup) {
    }

    public void m1032a(ViewGroup viewGroup, int i, Object obj) {
        if (this.f810b == null) {
            this.f810b = this.f809a.m1383a();
        }
        this.f810b.m1061b((Fragment) obj);
    }

    public boolean m1033a(View view, Object obj) {
        return ((Fragment) obj).m996i() == view;
    }

    public long m1034b(int i) {
        return (long) i;
    }

    public void m1035b(ViewGroup viewGroup) {
        if (this.f810b != null) {
            this.f810b.m1060b();
            this.f810b = null;
            this.f809a.m1386b();
        }
    }

    public void m1036b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f811c) {
            if (this.f811c != null) {
                this.f811c.m976b(false);
                this.f811c.m981c(false);
            }
            if (fragment != null) {
                fragment.m976b(true);
                fragment.m981c(true);
            }
            this.f811c = fragment;
        }
    }
}
