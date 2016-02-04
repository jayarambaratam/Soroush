package android.support.v4.p012b;

import android.content.Context;
import android.support.v4.p016f.C0227d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.b.t */
public class C0154t<D> {
    int f1043n;
    C0128w<D> f1044o;
    C0127v<D> f1045p;
    Context f1046q;
    boolean f1047r;
    boolean f1048s;
    boolean f1049t;
    boolean f1050u;
    boolean f1051v;

    public C0154t(Context context) {
        this.f1047r = false;
        this.f1048s = false;
        this.f1049t = true;
        this.f1050u = false;
        this.f1051v = false;
        this.f1046q = context.getApplicationContext();
    }

    protected void m1456a() {
    }

    public void m1457a(int i, C0128w<D> c0128w) {
        if (this.f1044o != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f1044o = c0128w;
        this.f1043n = i;
    }

    public void m1458a(C0127v<D> c0127v) {
        if (this.f1045p != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f1045p = c0127v;
    }

    public void m1459a(C0128w<D> c0128w) {
        if (this.f1044o == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f1044o != c0128w) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f1044o = null;
        }
    }

    public void m1460a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f1043n);
        printWriter.print(" mListener=");
        printWriter.println(this.f1044o);
        if (this.f1047r || this.f1050u || this.f1051v) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f1047r);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f1050u);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f1051v);
        }
        if (this.f1048s || this.f1049t) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f1048s);
            printWriter.print(" mReset=");
            printWriter.println(this.f1049t);
        }
    }

    public void m1461b(C0127v<D> c0127v) {
        if (this.f1045p == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f1045p != c0127v) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f1045p = null;
        }
    }

    public void m1462b(D d) {
        if (this.f1044o != null) {
            this.f1044o.m1108a(this, d);
        }
    }

    protected boolean m1463b() {
        return false;
    }

    public String m1464c(D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0227d.m1705a(d, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    protected void m1465i() {
    }

    protected void m1466j() {
    }

    protected void m1467k() {
    }

    public void m1468l() {
        if (this.f1045p != null) {
            this.f1045p.m1107a(this);
        }
    }

    public Context m1469m() {
        return this.f1046q;
    }

    public boolean m1470n() {
        return this.f1047r;
    }

    public boolean m1471o() {
        return this.f1048s;
    }

    public boolean m1472p() {
        return this.f1049t;
    }

    public final void m1473q() {
        this.f1047r = true;
        this.f1049t = false;
        this.f1048s = false;
        m1465i();
    }

    public boolean m1474r() {
        return m1463b();
    }

    public void m1475s() {
        m1456a();
    }

    public void m1476t() {
        this.f1047r = false;
        m1466j();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0227d.m1705a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f1043n);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void m1477u() {
        m1467k();
        this.f1049t = true;
        this.f1047r = false;
        this.f1048s = false;
        this.f1050u = false;
        this.f1051v = false;
    }

    public boolean m1478v() {
        boolean z = this.f1050u;
        this.f1050u = false;
        this.f1051v |= z;
        return z;
    }

    public void m1479w() {
        this.f1051v = false;
    }

    public void m1480x() {
        if (this.f1051v) {
            this.f1050u = true;
        }
    }

    public void m1481y() {
        if (this.f1047r) {
            m1475s();
        } else {
            this.f1050u = true;
        }
    }
}
