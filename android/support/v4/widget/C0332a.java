package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.bf;
import android.support.v4.view.cb;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import org.jivesoftware.smack.tcp.XMPPTCPConnection.PacketWriter;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: android.support.v4.widget.a */
public abstract class C0332a implements OnTouchListener {
    private static final int f1551r;
    private final C0336c f1552a;
    private final Interpolator f1553b;
    private final View f1554c;
    private Runnable f1555d;
    private float[] f1556e;
    private float[] f1557f;
    private int f1558g;
    private int f1559h;
    private float[] f1560i;
    private float[] f1561j;
    private float[] f1562k;
    private boolean f1563l;
    private boolean f1564m;
    private boolean f1565n;
    private boolean f1566o;
    private boolean f1567p;
    private boolean f1568q;

    static {
        f1551r = ViewConfiguration.getTapTimeout();
    }

    public C0332a(View view) {
        this.f1552a = new C0336c();
        this.f1553b = new AccelerateInterpolator();
        this.f1556e = new float[]{0.0f, 0.0f};
        this.f1557f = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f1560i = new float[]{0.0f, 0.0f};
        this.f1561j = new float[]{0.0f, 0.0f};
        this.f1562k = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f1554c = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        m3098a((float) i, (float) i);
        m3102b((float) i2, (float) i2);
        m3099a(1);
        m3108e(Float.MAX_VALUE, Float.MAX_VALUE);
        m3106d(0.2f, 0.2f);
        m3104c(1.0f, 1.0f);
        m3103b(f1551r);
        m3105c((int) PacketWriter.QUEUE_SIZE);
        m3107d((int) PacketWriter.QUEUE_SIZE);
    }

    private float m3078a(float f, float f2, float f3, float f4) {
        float f5;
        float b = C0332a.m3084b(f * f2, 0.0f, f3);
        b = m3095f(f2 - f4, b) - m3095f(f4, b);
        if (b < 0.0f) {
            f5 = -this.f1553b.getInterpolation(-b);
        } else if (b <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.f1553b.getInterpolation(b);
        }
        return C0332a.m3084b(f5, -1.0f, 1.0f);
    }

    private float m3079a(int i, float f, float f2, float f3) {
        float a = m3078a(this.f1556e[i], f2, this.f1557f[i], f);
        if (a == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f1560i[i];
        float f5 = this.f1561j[i];
        float f6 = this.f1562k[i];
        f4 *= f3;
        return a > 0.0f ? C0332a.m3084b(a * f4, f5, f6) : -C0332a.m3084b((-a) * f4, f5, f6);
    }

    private boolean m3081a() {
        C0336c c0336c = this.f1552a;
        int f = c0336c.m3351f();
        int e = c0336c.m3350e();
        return (f != 0 && m3110f(f)) || (e != 0 && m3109e(e));
    }

    private static float m3084b(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    private static int m3085b(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    private void m3086b() {
        if (this.f1555d == null) {
            this.f1555d = new C0337d();
        }
        this.f1566o = true;
        this.f1564m = true;
        if (this.f1563l || this.f1559h <= 0) {
            this.f1555d.run();
        } else {
            cb.m2403a(this.f1554c, this.f1555d, (long) this.f1559h);
        }
        this.f1563l = true;
    }

    private void m3090c() {
        if (this.f1564m) {
            this.f1566o = false;
        } else {
            this.f1552a.m3346b();
        }
    }

    private void m3092d() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1554c.onTouchEvent(obtain);
        obtain.recycle();
    }

    private float m3095f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.f1558g) {
            case VideoSize.QCIF /*0*/:
            case VideoSize.CIF /*1*/:
                return f < f2 ? f >= 0.0f ? 1.0f - (f / f2) : (this.f1566o && this.f1558g == 1) ? 1.0f : 0.0f : 0.0f;
            case VideoSize.HVGA /*2*/:
                return f < 0.0f ? f / (-f2) : 0.0f;
            default:
                return 0.0f;
        }
    }

    public C0332a m3098a(float f, float f2) {
        this.f1562k[0] = f / 1000.0f;
        this.f1562k[1] = f2 / 1000.0f;
        return this;
    }

    public C0332a m3099a(int i) {
        this.f1558g = i;
        return this;
    }

    public C0332a m3100a(boolean z) {
        if (this.f1567p && !z) {
            m3090c();
        }
        this.f1567p = z;
        return this;
    }

    public abstract void m3101a(int i, int i2);

    public C0332a m3102b(float f, float f2) {
        this.f1561j[0] = f / 1000.0f;
        this.f1561j[1] = f2 / 1000.0f;
        return this;
    }

    public C0332a m3103b(int i) {
        this.f1559h = i;
        return this;
    }

    public C0332a m3104c(float f, float f2) {
        this.f1560i[0] = f / 1000.0f;
        this.f1560i[1] = f2 / 1000.0f;
        return this;
    }

    public C0332a m3105c(int i) {
        this.f1552a.m3345a(i);
        return this;
    }

    public C0332a m3106d(float f, float f2) {
        this.f1556e[0] = f;
        this.f1556e[1] = f2;
        return this;
    }

    public C0332a m3107d(int i) {
        this.f1552a.m3347b(i);
        return this;
    }

    public C0332a m3108e(float f, float f2) {
        this.f1557f[0] = f;
        this.f1557f[1] = f2;
        return this;
    }

    public abstract boolean m3109e(int i);

    public abstract boolean m3110f(int i);

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        if (!this.f1567p) {
            return false;
        }
        switch (bf.m2309a(motionEvent)) {
            case VideoSize.QCIF /*0*/:
                this.f1565n = true;
                this.f1563l = false;
                break;
            case VideoSize.CIF /*1*/:
            case Version.API03_CUPCAKE_15 /*3*/:
                m3090c();
                break;
            case VideoSize.HVGA /*2*/:
                break;
        }
        this.f1552a.m3344a(m3079a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f1554c.getWidth()), m3079a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f1554c.getHeight()));
        if (!this.f1566o && m3081a()) {
            m3086b();
        }
        if (!(this.f1568q && this.f1566o)) {
            z = false;
        }
        return z;
    }
}
