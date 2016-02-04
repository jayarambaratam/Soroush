package android.support.v4.p011a;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.a.f */
class C0119f implements C0118l {
    List<C0114b> f698a;
    List<C0116d> f699b;
    View f700c;
    private long f701d;
    private long f702e;
    private float f703f;
    private boolean f704g;
    private boolean f705h;
    private Runnable f706i;

    public C0119f() {
        this.f698a = new ArrayList();
        this.f699b = new ArrayList();
        this.f702e = 200;
        this.f703f = 0.0f;
        this.f704g = false;
        this.f705h = false;
        this.f706i = new C0120g(this);
    }

    private void m915d() {
        for (int size = this.f699b.size() - 1; size >= 0; size--) {
            ((C0116d) this.f699b.get(size)).onAnimationUpdate(this);
        }
    }

    private long m918e() {
        return this.f700c.getDrawingTime();
    }

    private void m919f() {
        for (int size = this.f698a.size() - 1; size >= 0; size--) {
            ((C0114b) this.f698a.get(size)).onAnimationStart(this);
        }
    }

    private void m922g() {
        for (int size = this.f698a.size() - 1; size >= 0; size--) {
            ((C0114b) this.f698a.get(size)).onAnimationEnd(this);
        }
    }

    private void m923h() {
        for (int size = this.f698a.size() - 1; size >= 0; size--) {
            ((C0114b) this.f698a.get(size)).onAnimationCancel(this);
        }
    }

    public void m924a() {
        if (!this.f704g) {
            this.f704g = true;
            m919f();
            this.f703f = 0.0f;
            this.f701d = m918e();
            this.f700c.postDelayed(this.f706i, 16);
        }
    }

    public void m925a(long j) {
        if (!this.f704g) {
            this.f702e = j;
        }
    }

    public void m926a(C0114b c0114b) {
        this.f698a.add(c0114b);
    }

    public void m927a(C0116d c0116d) {
        this.f699b.add(c0116d);
    }

    public void m928a(View view) {
        this.f700c = view;
    }

    public void m929b() {
        if (!this.f705h) {
            this.f705h = true;
            if (this.f704g) {
                m923h();
            }
            m922g();
        }
    }

    public float m930c() {
        return this.f703f;
    }
}
