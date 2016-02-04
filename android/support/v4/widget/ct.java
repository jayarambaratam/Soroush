package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.bf;
import android.support.v4.view.bw;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

public class ct {
    private static final Interpolator f1666v;
    private int f1667a;
    private int f1668b;
    private int f1669c;
    private float[] f1670d;
    private float[] f1671e;
    private float[] f1672f;
    private float[] f1673g;
    private int[] f1674h;
    private int[] f1675i;
    private int[] f1676j;
    private int f1677k;
    private VelocityTracker f1678l;
    private float f1679m;
    private float f1680n;
    private int f1681o;
    private int f1682p;
    private bj f1683q;
    private final cw f1684r;
    private View f1685s;
    private boolean f1686t;
    private final ViewGroup f1687u;
    private final Runnable f1688w;

    static {
        f1666v = new cu();
    }

    private ct(Context context, ViewGroup viewGroup, cw cwVar) {
        this.f1669c = -1;
        this.f1688w = new cv(this);
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (cwVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f1687u = viewGroup;
            this.f1684r = cwVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f1681o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f1668b = viewConfiguration.getScaledTouchSlop();
            this.f1679m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f1680n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f1683q = bj.m3264a(context, f1666v);
        }
    }

    private float m3370a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        return abs < f2 ? 0.0f : abs > f3 ? f <= 0.0f ? -f3 : f3 : f;
    }

    private int m3371a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f1687u.getWidth();
        int i4 = width / 2;
        float b = (m3380b(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        return Math.min(i4 > 0 ? Math.round(Math.abs(b / ((float) i4)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f), 600);
    }

    private int m3372a(View view, int i, int i2, int i3, int i4) {
        int b = m3381b(i3, (int) this.f1680n, (int) this.f1679m);
        int b2 = m3381b(i4, (int) this.f1680n, (int) this.f1679m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m3371a(i2, b2, this.f1684r.m614b(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m3371a(i, b, this.f1684r.m607a(view)))));
    }

    public static ct m3373a(ViewGroup viewGroup, float f, cw cwVar) {
        ct a = m3374a(viewGroup, cwVar);
        a.f1668b = (int) (((float) a.f1668b) * (1.0f / f));
        return a;
    }

    public static ct m3374a(ViewGroup viewGroup, cw cwVar) {
        return new ct(viewGroup.getContext(), viewGroup, cwVar);
    }

    private void m3375a(float f, float f2) {
        this.f1686t = true;
        this.f1684r.m611a(this.f1685s, f, f2);
        this.f1686t = false;
        if (this.f1667a == 1) {
            m3405c(0);
        }
    }

    private void m3376a(float f, float f2, int i) {
        m3387f(i);
        float[] fArr = this.f1670d;
        this.f1672f[i] = f;
        fArr[i] = f;
        fArr = this.f1671e;
        this.f1673g[i] = f2;
        fArr[i] = f2;
        this.f1674h[i] = m3385e((int) f, (int) f2);
        this.f1677k |= 1 << i;
    }

    private boolean m3377a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f1674h[i] & i2) != i2 || (this.f1682p & i2) == 0 || (this.f1676j[i] & i2) == i2 || (this.f1675i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f1668b) && abs2 <= ((float) this.f1668b)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f1684r.m618b(i2)) {
            return (this.f1675i[i] & i2) == 0 && abs > ((float) this.f1668b);
        } else {
            int[] iArr = this.f1676j;
            iArr[i] = iArr[i] | i2;
            return false;
        }
    }

    private boolean m3378a(int i, int i2, int i3, int i4) {
        int left = this.f1685s.getLeft();
        int top = this.f1685s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f1683q.m3277h();
            m3405c(0);
            return false;
        }
        this.f1683q.m3266a(left, top, i5, i6, m3372a(this.f1685s, i5, i6, i3, i4));
        m3405c(2);
        return true;
    }

    private boolean m3379a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f1684r.m607a(view) > 0;
        boolean z2 = this.f1684r.m614b(view) > 0;
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.f1668b * this.f1668b)) : z ? Math.abs(f) > ((float) this.f1668b) : z2 ? Math.abs(f2) > ((float) this.f1668b) : false;
    }

    private float m3380b(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    private int m3381b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        return abs < i2 ? 0 : abs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    private void m3382b(float f, float f2, int i) {
        int i2 = 1;
        if (!m3377a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m3377a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m3377a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m3377a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f1675i;
            iArr[i] = iArr[i] | i2;
            this.f1684r.m616b(i2, i);
        }
    }

    private void m3383b(int i, int i2, int i3, int i4) {
        int a;
        int b;
        int left = this.f1685s.getLeft();
        int top = this.f1685s.getTop();
        if (i3 != 0) {
            a = this.f1684r.m608a(this.f1685s, i, i3);
            this.f1685s.offsetLeftAndRight(a - left);
        } else {
            a = i;
        }
        if (i4 != 0) {
            b = this.f1684r.m615b(this.f1685s, i2, i4);
            this.f1685s.offsetTopAndBottom(b - top);
        } else {
            b = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f1684r.m612a(this.f1685s, a, b, a - left, b - top);
        }
    }

    private void m3384c(MotionEvent motionEvent) {
        int c = bf.m2314c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = bf.m2312b(motionEvent, i);
            float c2 = bf.m2313c(motionEvent, i);
            float d = bf.m2315d(motionEvent, i);
            this.f1672f[b] = c2;
            this.f1673g[b] = d;
        }
    }

    private int m3385e(int i, int i2) {
        int i3 = 0;
        if (i < this.f1687u.getLeft() + this.f1681o) {
            i3 = 1;
        }
        if (i2 < this.f1687u.getTop() + this.f1681o) {
            i3 |= 4;
        }
        if (i > this.f1687u.getRight() - this.f1681o) {
            i3 |= 2;
        }
        return i2 > this.f1687u.getBottom() - this.f1681o ? i3 | 8 : i3;
    }

    private void m3386e(int i) {
        if (this.f1670d != null) {
            this.f1670d[i] = 0.0f;
            this.f1671e[i] = 0.0f;
            this.f1672f[i] = 0.0f;
            this.f1673g[i] = 0.0f;
            this.f1674h[i] = 0;
            this.f1675i[i] = 0;
            this.f1676j[i] = 0;
            this.f1677k &= (1 << i) ^ -1;
        }
    }

    private void m3387f(int i) {
        if (this.f1670d == null || this.f1670d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.f1670d != null) {
                System.arraycopy(this.f1670d, 0, obj, 0, this.f1670d.length);
                System.arraycopy(this.f1671e, 0, obj2, 0, this.f1671e.length);
                System.arraycopy(this.f1672f, 0, obj3, 0, this.f1672f.length);
                System.arraycopy(this.f1673g, 0, obj4, 0, this.f1673g.length);
                System.arraycopy(this.f1674h, 0, obj5, 0, this.f1674h.length);
                System.arraycopy(this.f1675i, 0, obj6, 0, this.f1675i.length);
                System.arraycopy(this.f1676j, 0, obj7, 0, this.f1676j.length);
            }
            this.f1670d = obj;
            this.f1671e = obj2;
            this.f1672f = obj3;
            this.f1673g = obj4;
            this.f1674h = obj5;
            this.f1675i = obj6;
            this.f1676j = obj7;
        }
    }

    private void m3388g() {
        if (this.f1670d != null) {
            Arrays.fill(this.f1670d, 0.0f);
            Arrays.fill(this.f1671e, 0.0f);
            Arrays.fill(this.f1672f, 0.0f);
            Arrays.fill(this.f1673g, 0.0f);
            Arrays.fill(this.f1674h, 0);
            Arrays.fill(this.f1675i, 0);
            Arrays.fill(this.f1676j, 0);
            this.f1677k = 0;
        }
    }

    private void m3389h() {
        this.f1678l.computeCurrentVelocity(1000, this.f1679m);
        m3375a(m3370a(bw.m2358a(this.f1678l, this.f1669c), this.f1680n, this.f1679m), m3370a(bw.m2359b(this.f1678l, this.f1669c), this.f1680n, this.f1679m));
    }

    public int m3390a() {
        return this.f1667a;
    }

    public void m3391a(float f) {
        this.f1680n = f;
    }

    public void m3392a(int i) {
        this.f1682p = i;
    }

    public void m3393a(View view, int i) {
        if (view.getParent() != this.f1687u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f1687u + ")");
        }
        this.f1685s = view;
        this.f1669c = i;
        this.f1684r.m617b(view, i);
        m3405c(1);
    }

    public boolean m3394a(int i, int i2) {
        if (this.f1686t) {
            return m3378a(i, i2, (int) bw.m2358a(this.f1678l, this.f1669c), (int) bw.m2359b(this.f1678l, this.f1669c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m3395a(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = android.support.v4.view.bf.m2309a(r14);
        r1 = android.support.v4.view.bf.m2311b(r14);
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.m3410e();
    L_0x000d:
        r2 = r13.f1678l;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.f1678l = r2;
    L_0x0017:
        r2 = r13.f1678l;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x0121;
            case 2: goto L_0x0092;
            case 3: goto L_0x0121;
            case 4: goto L_0x001f;
            case 5: goto L_0x005a;
            case 6: goto L_0x0118;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.f1667a;
        r1 = 1;
        if (r0 != r1) goto L_0x0126;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = android.support.v4.view.bf.m2312b(r14, r2);
        r13.m3376a(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.m3408d(r0, r1);
        r1 = r13.f1685s;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.f1667a;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.m3402b(r0, r2);
    L_0x0048:
        r0 = r13.f1674h;
        r0 = r0[r2];
        r1 = r13.f1682p;
        r1 = r1 & r0;
        if (r1 == 0) goto L_0x001f;
    L_0x0051:
        r1 = r13.f1684r;
        r3 = r13.f1682p;
        r0 = r0 & r3;
        r1.m610a(r0, r2);
        goto L_0x001f;
    L_0x005a:
        r0 = android.support.v4.view.bf.m2312b(r14, r1);
        r2 = android.support.v4.view.bf.m2313c(r14, r1);
        r1 = android.support.v4.view.bf.m2315d(r14, r1);
        r13.m3376a(r2, r1, r0);
        r3 = r13.f1667a;
        if (r3 != 0) goto L_0x007f;
    L_0x006d:
        r1 = r13.f1674h;
        r1 = r1[r0];
        r2 = r13.f1682p;
        r2 = r2 & r1;
        if (r2 == 0) goto L_0x001f;
    L_0x0076:
        r2 = r13.f1684r;
        r3 = r13.f1682p;
        r1 = r1 & r3;
        r2.m610a(r1, r0);
        goto L_0x001f;
    L_0x007f:
        r3 = r13.f1667a;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x0084:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.m3408d(r2, r1);
        r2 = r13.f1685s;
        if (r1 != r2) goto L_0x001f;
    L_0x008e:
        r13.m3402b(r1, r0);
        goto L_0x001f;
    L_0x0092:
        r0 = r13.f1670d;
        if (r0 == 0) goto L_0x001f;
    L_0x0096:
        r0 = r13.f1671e;
        if (r0 == 0) goto L_0x001f;
    L_0x009a:
        r2 = android.support.v4.view.bf.m2314c(r14);
        r0 = 0;
        r1 = r0;
    L_0x00a0:
        if (r1 >= r2) goto L_0x00fd;
    L_0x00a2:
        r3 = android.support.v4.view.bf.m2312b(r14, r1);
        r0 = android.support.v4.view.bf.m2313c(r14, r1);
        r4 = android.support.v4.view.bf.m2315d(r14, r1);
        r5 = r13.f1670d;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.f1671e;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.m3408d(r0, r4);
        if (r4 == 0) goto L_0x0102;
    L_0x00c2:
        r0 = r13.m3379a(r4, r5, r6);
        if (r0 == 0) goto L_0x0102;
    L_0x00c8:
        r0 = 1;
    L_0x00c9:
        if (r0 == 0) goto L_0x0104;
    L_0x00cb:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.f1684r;
        r10 = (int) r5;
        r8 = r9.m608a(r4, r8, r10);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.f1684r;
        r12 = (int) r6;
        r10 = r11.m615b(r4, r10, r12);
        r11 = r13.f1684r;
        r11 = r11.m607a(r4);
        r12 = r13.f1684r;
        r12 = r12.m614b(r4);
        if (r11 == 0) goto L_0x00f7;
    L_0x00f3:
        if (r11 <= 0) goto L_0x0104;
    L_0x00f5:
        if (r8 != r7) goto L_0x0104;
    L_0x00f7:
        if (r12 == 0) goto L_0x00fd;
    L_0x00f9:
        if (r12 <= 0) goto L_0x0104;
    L_0x00fb:
        if (r10 != r9) goto L_0x0104;
    L_0x00fd:
        r13.m3384c(r14);
        goto L_0x001f;
    L_0x0102:
        r0 = 0;
        goto L_0x00c9;
    L_0x0104:
        r13.m3382b(r5, r6, r3);
        r5 = r13.f1667a;
        r6 = 1;
        if (r5 == r6) goto L_0x00fd;
    L_0x010c:
        if (r0 == 0) goto L_0x0114;
    L_0x010e:
        r0 = r13.m3402b(r4, r3);
        if (r0 != 0) goto L_0x00fd;
    L_0x0114:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00a0;
    L_0x0118:
        r0 = android.support.v4.view.bf.m2312b(r14, r1);
        r13.m3386e(r0);
        goto L_0x001f;
    L_0x0121:
        r13.m3410e();
        goto L_0x001f;
    L_0x0126:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.ct.a(android.view.MotionEvent):boolean");
    }

    public boolean m3396a(View view, int i, int i2) {
        this.f1685s = view;
        this.f1669c = -1;
        boolean a = m3378a(i, i2, 0, 0);
        if (!(a || this.f1667a != 0 || this.f1685s == null)) {
            this.f1685s = null;
        }
        return a;
    }

    public boolean m3397a(boolean z) {
        if (this.f1667a == 2) {
            int i;
            boolean g = this.f1683q.m3276g();
            int b = this.f1683q.m3271b();
            int c = this.f1683q.m3272c();
            int left = b - this.f1685s.getLeft();
            int top = c - this.f1685s.getTop();
            if (left != 0) {
                this.f1685s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.f1685s.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.f1684r.m612a(this.f1685s, b, c, left, top);
            }
            if (g && b == this.f1683q.m3273d() && c == this.f1683q.m3274e()) {
                this.f1683q.m3277h();
                i = 0;
            } else {
                boolean z2 = g;
            }
            if (i == 0) {
                if (z) {
                    this.f1687u.post(this.f1688w);
                } else {
                    m3405c(0);
                }
            }
        }
        return this.f1667a == 2;
    }

    public int m3398b() {
        return this.f1681o;
    }

    public void m3399b(MotionEvent motionEvent) {
        int i = 0;
        int a = bf.m2309a(motionEvent);
        int b = bf.m2311b(motionEvent);
        if (a == 0) {
            m3410e();
        }
        if (this.f1678l == null) {
            this.f1678l = VelocityTracker.obtain();
        }
        this.f1678l.addMovement(motionEvent);
        float x;
        float y;
        View d;
        int i2;
        switch (a) {
            case VideoSize.QCIF /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = bf.m2312b(motionEvent, 0);
                d = m3408d((int) x, (int) y);
                m3376a(x, y, i);
                m3402b(d, i);
                i2 = this.f1674h[i];
                if ((this.f1682p & i2) != 0) {
                    this.f1684r.m610a(i2 & this.f1682p, i);
                }
            case VideoSize.CIF /*1*/:
                if (this.f1667a == 1) {
                    m3389h();
                }
                m3410e();
            case VideoSize.HVGA /*2*/:
                if (this.f1667a == 1) {
                    i = bf.m2310a(motionEvent, this.f1669c);
                    x = bf.m2313c(motionEvent, i);
                    i2 = (int) (x - this.f1672f[this.f1669c]);
                    i = (int) (bf.m2315d(motionEvent, i) - this.f1673g[this.f1669c]);
                    m3383b(this.f1685s.getLeft() + i2, this.f1685s.getTop() + i, i2, i);
                    m3384c(motionEvent);
                    return;
                }
                i2 = bf.m2314c(motionEvent);
                while (i < i2) {
                    a = bf.m2312b(motionEvent, i);
                    float c = bf.m2313c(motionEvent, i);
                    float d2 = bf.m2315d(motionEvent, i);
                    float f = c - this.f1670d[a];
                    float f2 = d2 - this.f1671e[a];
                    m3382b(f, f2, a);
                    if (this.f1667a != 1) {
                        d = m3408d((int) c, (int) d2);
                        if (!m3379a(d, f, f2) || !m3402b(d, a)) {
                            i++;
                        }
                    }
                    m3384c(motionEvent);
                }
                m3384c(motionEvent);
            case Version.API03_CUPCAKE_15 /*3*/:
                if (this.f1667a == 1) {
                    m3375a(0.0f, 0.0f);
                }
                m3410e();
            case Version.API05_ECLAIR_20 /*5*/:
                i = bf.m2312b(motionEvent, b);
                x = bf.m2313c(motionEvent, b);
                y = bf.m2315d(motionEvent, b);
                m3376a(x, y, i);
                if (this.f1667a == 0) {
                    m3402b(m3408d((int) x, (int) y), i);
                    i2 = this.f1674h[i];
                    if ((this.f1682p & i2) != 0) {
                        this.f1684r.m610a(i2 & this.f1682p, i);
                    }
                } else if (m3406c((int) x, (int) y)) {
                    m3402b(this.f1685s, i);
                }
            case Version.API06_ECLAIR_201 /*6*/:
                a = bf.m2312b(motionEvent, b);
                if (this.f1667a == 1 && a == this.f1669c) {
                    b = bf.m2314c(motionEvent);
                    while (i < b) {
                        int b2 = bf.m2312b(motionEvent, i);
                        if (b2 != this.f1669c) {
                            if (m3408d((int) bf.m2313c(motionEvent, i), (int) bf.m2315d(motionEvent, i)) == this.f1685s && m3402b(this.f1685s, b2)) {
                                i = this.f1669c;
                                if (i == -1) {
                                    m3389h();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        m3389h();
                    }
                }
                m3386e(a);
            default:
        }
    }

    public boolean m3400b(int i) {
        return (this.f1677k & (1 << i)) != 0;
    }

    public boolean m3401b(int i, int i2) {
        if (!m3400b(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.f1672f[i2] - this.f1670d[i2];
        float f2 = this.f1673g[i2] - this.f1671e[i2];
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.f1668b * this.f1668b)) : z ? Math.abs(f) > ((float) this.f1668b) : z2 ? Math.abs(f2) > ((float) this.f1668b) : false;
    }

    boolean m3402b(View view, int i) {
        if (view == this.f1685s && this.f1669c == i) {
            return true;
        }
        if (view == null || !this.f1684r.m613a(view, i)) {
            return false;
        }
        this.f1669c = i;
        m3393a(view, i);
        return true;
    }

    public boolean m3403b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public View m3404c() {
        return this.f1685s;
    }

    void m3405c(int i) {
        this.f1687u.removeCallbacks(this.f1688w);
        if (this.f1667a != i) {
            this.f1667a = i;
            this.f1684r.m609a(i);
            if (this.f1667a == 0) {
                this.f1685s = null;
            }
        }
    }

    public boolean m3406c(int i, int i2) {
        return m3403b(this.f1685s, i, i2);
    }

    public int m3407d() {
        return this.f1668b;
    }

    public View m3408d(int i, int i2) {
        for (int childCount = this.f1687u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f1687u.getChildAt(this.f1684r.m619c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public boolean m3409d(int i) {
        int length = this.f1670d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m3401b(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public void m3410e() {
        this.f1669c = -1;
        m3388g();
        if (this.f1678l != null) {
            this.f1678l.recycle();
            this.f1678l = null;
        }
    }

    public void m3411f() {
        m3410e();
        if (this.f1667a == 2) {
            int b = this.f1683q.m3271b();
            int c = this.f1683q.m3272c();
            this.f1683q.m3277h();
            int b2 = this.f1683q.m3271b();
            int c2 = this.f1683q.m3272c();
            this.f1684r.m612a(this.f1685s, b2, c2, b2 - b, c2 - c);
        }
        m3405c(0);
    }
}
