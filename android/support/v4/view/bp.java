package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

public class bp {
    private final View f1334a;
    private ViewParent f1335b;
    private boolean f1336c;
    private int[] f1337d;

    public bp(View view) {
        this.f1334a = view;
    }

    public void m2346a(boolean z) {
        if (this.f1336c) {
            cb.m2384C(this.f1334a);
        }
        this.f1336c = z;
    }

    public boolean m2347a() {
        return this.f1336c;
    }

    public boolean m2348a(float f, float f2) {
        return (!m2347a() || this.f1335b == null) ? false : ee.m2761a(this.f1335b, this.f1334a, f, f2);
    }

    public boolean m2349a(float f, float f2, boolean z) {
        return (!m2347a() || this.f1335b == null) ? false : ee.m2762a(this.f1335b, this.f1334a, f, f2, z);
    }

    public boolean m2350a(int i) {
        if (m2353b()) {
            return true;
        }
        if (m2347a()) {
            View view = this.f1334a;
            for (ViewParent parent = this.f1334a.getParent(); parent != null; parent = parent.getParent()) {
                if (ee.m2763a(parent, view, this.f1334a, i)) {
                    this.f1335b = parent;
                    ee.m2764b(parent, view, this.f1334a, i);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public boolean m2351a(int i, int i2, int i3, int i4, int[] iArr) {
        if (!m2347a() || this.f1335b == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            int i5;
            int i6;
            if (iArr != null) {
                this.f1334a.getLocationInWindow(iArr);
                int i7 = iArr[0];
                i5 = iArr[1];
                i6 = i7;
            } else {
                i5 = 0;
                i6 = 0;
            }
            ee.m2759a(this.f1335b, this.f1334a, i, i2, i3, i4);
            if (iArr != null) {
                this.f1334a.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i6;
                iArr[1] = iArr[1] - i5;
            }
            return true;
        } else if (iArr == null) {
            return false;
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
    }

    public boolean m2352a(int i, int i2, int[] iArr, int[] iArr2) {
        if (!m2347a() || this.f1335b == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            int i3;
            int i4;
            if (iArr2 != null) {
                this.f1334a.getLocationInWindow(iArr2);
                i3 = iArr2[0];
                i4 = iArr2[1];
            } else {
                i4 = 0;
                i3 = 0;
            }
            if (iArr == null) {
                if (this.f1337d == null) {
                    this.f1337d = new int[2];
                }
                iArr = this.f1337d;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            ee.m2760a(this.f1335b, this.f1334a, i, i2, iArr);
            if (iArr2 != null) {
                this.f1334a.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i3;
                iArr2[1] = iArr2[1] - i4;
            }
            return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public boolean m2353b() {
        return this.f1335b != null;
    }

    public void m2354c() {
        if (this.f1335b != null) {
            ee.m2758a(this.f1335b, this.f1334a);
            this.f1335b = null;
        }
    }
}
