package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import org.apache.http.myHttp.HttpStatus;

class cx extends cu {
    private static final Handler f568a;
    private long f569b;
    private boolean f570c;
    private final int[] f571d;
    private final float[] f572e;
    private int f573f;
    private Interpolator f574g;
    private cv f575h;
    private cw f576i;
    private float f577j;
    private final Runnable f578k;

    static {
        f568a = new Handler(Looper.getMainLooper());
    }

    cx() {
        this.f571d = new int[2];
        this.f572e = new float[2];
        this.f573f = HttpStatus.SC_OK;
        this.f578k = new cy(this);
    }

    private void m714h() {
        if (this.f570c) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f569b)) / ((float) this.f573f);
            if (this.f574g != null) {
                uptimeMillis = this.f574g.getInterpolation(uptimeMillis);
            }
            this.f577j = uptimeMillis;
            if (this.f576i != null) {
                this.f576i.m691a();
            }
            if (SystemClock.uptimeMillis() >= this.f569b + ((long) this.f573f)) {
                this.f570c = false;
                if (this.f575h != null) {
                    this.f575h.m694b();
                }
            }
        }
        if (this.f570c) {
            f568a.postDelayed(this.f578k, 10);
        }
    }

    public void m715a() {
        if (!this.f570c) {
            if (this.f574g == null) {
                this.f574g = new AccelerateDecelerateInterpolator();
            }
            this.f569b = SystemClock.uptimeMillis();
            this.f570c = true;
            if (this.f575h != null) {
                this.f575h.m693a();
            }
            f568a.postDelayed(this.f578k, 10);
        }
    }

    public void m716a(float f, float f2) {
        this.f572e[0] = f;
        this.f572e[1] = f2;
    }

    public void m717a(int i) {
        this.f573f = i;
    }

    public void m718a(int i, int i2) {
        this.f571d[0] = i;
        this.f571d[1] = i2;
    }

    public void m719a(cv cvVar) {
        this.f575h = cvVar;
    }

    public void m720a(cw cwVar) {
        this.f576i = cwVar;
    }

    public void m721a(Interpolator interpolator) {
        this.f574g = interpolator;
    }

    public boolean m722b() {
        return this.f570c;
    }

    public int m723c() {
        return C0072a.m477a(this.f571d[0], this.f571d[1], m726f());
    }

    public float m724d() {
        return C0072a.m476a(this.f572e[0], this.f572e[1], m726f());
    }

    public void m725e() {
        this.f570c = false;
        f568a.removeCallbacks(this.f578k);
        if (this.f575h != null) {
            this.f575h.m695c();
        }
    }

    public float m726f() {
        return this.f577j;
    }

    public long m727g() {
        return (long) this.f573f;
    }
}
