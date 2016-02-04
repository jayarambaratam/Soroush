package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.p012b.C0154t;
import android.support.v4.p016f.C0227d;
import android.support.v4.p016f.C0239r;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class ax extends av {
    static boolean f843a;
    final C0239r<ay> f844b;
    final C0239r<ay> f845c;
    final String f846d;
    boolean f847e;
    boolean f848f;
    boolean f849g;
    private C0147w f850h;

    static {
        f843a = false;
    }

    ax(String str, C0147w c0147w, boolean z) {
        this.f844b = new C0239r();
        this.f845c = new C0239r();
        this.f846d = str;
        this.f850h = c0147w;
        this.f847e = z;
    }

    private ay m1093b(int i, Bundle bundle, aw<Object> awVar) {
        ay ayVar = new ay(this, i, bundle, awVar);
        ayVar.f854d = awVar.m1089a(i, bundle);
        return ayVar;
    }

    private ay m1094c(int i, Bundle bundle, aw<Object> awVar) {
        try {
            this.f849g = true;
            ay b = m1093b(i, bundle, awVar);
            m1096a(b);
            return b;
        } finally {
            this.f849g = false;
        }
    }

    public <D> C0154t<D> m1095a(int i, Bundle bundle, aw<D> awVar) {
        if (this.f849g) {
            throw new IllegalStateException("Called while creating a loader");
        }
        ay ayVar = (ay) this.f844b.m1726a(i);
        if (f843a) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (ayVar == null) {
            ayVar = m1094c(i, bundle, awVar);
            if (f843a) {
                Log.v("LoaderManager", "  Created new loader " + ayVar);
            }
        } else {
            if (f843a) {
                Log.v("LoaderManager", "  Re-using existing loader " + ayVar);
            }
            ayVar.f853c = awVar;
        }
        if (ayVar.f855e && this.f847e) {
            ayVar.m1114b(ayVar.f854d, ayVar.f857g);
        }
        return ayVar.f854d;
    }

    void m1096a(ay ayVar) {
        this.f844b.m1730b(ayVar.f851a, ayVar);
        if (this.f847e) {
            ayVar.m1109a();
        }
    }

    void m1097a(C0147w c0147w) {
        this.f850h = c0147w;
    }

    public void m1098a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.f844b.m1728b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f844b.m1728b(); i2++) {
                ay ayVar = (ay) this.f844b.m1734e(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f844b.m1733d(i2));
                printWriter.print(": ");
                printWriter.println(ayVar.toString());
                ayVar.m1112a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f845c.m1728b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.f845c.m1728b()) {
                ayVar = (ay) this.f845c.m1734e(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f845c.m1733d(i));
                printWriter.print(": ");
                printWriter.println(ayVar.toString());
                ayVar.m1112a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean m1099a() {
        int b = this.f844b.m1728b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            ay ayVar = (ay) this.f844b.m1734e(i);
            int i2 = (!ayVar.f858h || ayVar.f856f) ? 0 : 1;
            z |= i2;
        }
        return z;
    }

    void m1100b() {
        if (f843a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f847e) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f847e = true;
        for (int b = this.f844b.m1728b() - 1; b >= 0; b--) {
            ((ay) this.f844b.m1734e(b)).m1109a();
        }
    }

    void m1101c() {
        if (f843a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f847e) {
            for (int b = this.f844b.m1728b() - 1; b >= 0; b--) {
                ((ay) this.f844b.m1734e(b)).m1117e();
            }
            this.f847e = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    void m1102d() {
        if (f843a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f847e) {
            this.f848f = true;
            this.f847e = false;
            for (int b = this.f844b.m1728b() - 1; b >= 0; b--) {
                ((ay) this.f844b.m1734e(b)).m1113b();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    void m1103e() {
        if (this.f848f) {
            if (f843a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f848f = false;
            for (int b = this.f844b.m1728b() - 1; b >= 0; b--) {
                ((ay) this.f844b.m1734e(b)).m1115c();
            }
        }
    }

    void m1104f() {
        for (int b = this.f844b.m1728b() - 1; b >= 0; b--) {
            ((ay) this.f844b.m1734e(b)).f861k = true;
        }
    }

    void m1105g() {
        for (int b = this.f844b.m1728b() - 1; b >= 0; b--) {
            ((ay) this.f844b.m1734e(b)).m1116d();
        }
    }

    void m1106h() {
        int b;
        if (!this.f848f) {
            if (f843a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (b = this.f844b.m1728b() - 1; b >= 0; b--) {
                ((ay) this.f844b.m1734e(b)).m1118f();
            }
            this.f844b.m1731c();
        }
        if (f843a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (b = this.f845c.m1728b() - 1; b >= 0; b--) {
            ((ay) this.f845c.m1734e(b)).m1118f();
        }
        this.f845c.m1731c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        C0227d.m1705a(this.f850h, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
