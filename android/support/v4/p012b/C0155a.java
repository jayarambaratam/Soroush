package android.support.v4.p012b;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.b.a$android.support.v4.b.b;
import android.support.v4.p016f.C0240s;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.Executor;

/* renamed from: android.support.v4.b.a */
public abstract class C0155a<D> extends C0154t<D> {
    volatile b f1052a;
    volatile b f1053b;
    long f1054c;
    long f1055d;
    Handler f1056e;
    private final Executor f1057f;

    public C0155a(Context context) {
        this(context, C0156x.f1069c);
    }

    private C0155a(Context context, Executor executor) {
        super(context);
        this.f1055d = -10000;
        this.f1057f = executor;
    }

    protected void m1482a() {
        super.m1456a();
        m1474r();
        this.f1052a = new C0157b(this);
        m1488c();
    }

    void m1483a(b bVar, D d) {
        m1484a(d);
        if (this.f1053b == bVar) {
            m1480x();
            this.f1055d = SystemClock.uptimeMillis();
            this.f1053b = null;
            m1468l();
            m1488c();
        }
    }

    public void m1484a(D d) {
    }

    public void m1485a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.m1460a(str, fileDescriptor, printWriter, strArr);
        if (this.f1052a != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f1052a);
            printWriter.print(" waiting=");
            printWriter.println(this.f1052a.f1076a);
        }
        if (this.f1053b != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f1053b);
            printWriter.print(" waiting=");
            printWriter.println(this.f1053b.f1076a);
        }
        if (this.f1054c != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            C0240s.m1739a(this.f1054c, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            C0240s.m1738a(this.f1055d, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    void m1486b(b bVar, D d) {
        if (this.f1052a != bVar) {
            m1483a(bVar, d);
        } else if (m1471o()) {
            m1484a(d);
        } else {
            m1479w();
            this.f1055d = SystemClock.uptimeMillis();
            this.f1052a = null;
            m1462b((Object) d);
        }
    }

    protected boolean m1487b() {
        boolean z = false;
        if (this.f1052a != null) {
            if (this.f1053b != null) {
                if (this.f1052a.f1076a) {
                    this.f1052a.f1076a = false;
                    this.f1056e.removeCallbacks(this.f1052a);
                }
                this.f1052a = null;
            } else if (this.f1052a.f1076a) {
                this.f1052a.f1076a = false;
                this.f1056e.removeCallbacks(this.f1052a);
                this.f1052a = null;
            } else {
                z = this.f1052a.m1505a(false);
                if (z) {
                    this.f1053b = this.f1052a;
                    m1491f();
                }
                this.f1052a = null;
            }
        }
        return z;
    }

    void m1488c() {
        if (this.f1053b == null && this.f1052a != null) {
            if (this.f1052a.f1076a) {
                this.f1052a.f1076a = false;
                this.f1056e.removeCallbacks(this.f1052a);
            }
            if (this.f1054c <= 0 || SystemClock.uptimeMillis() >= this.f1055d + this.f1054c) {
                this.f1052a.m1501a(this.f1057f, (Object[]) (Void[]) null);
                return;
            }
            this.f1052a.f1076a = true;
            this.f1056e.postAtTime(this.f1052a, this.f1055d + this.f1054c);
        }
    }

    public abstract D m1489d();

    protected D m1490e() {
        return m1489d();
    }

    public void m1491f() {
    }

    public boolean m1492g() {
        return this.f1053b != null;
    }
}
