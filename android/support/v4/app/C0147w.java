package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v4.p016f.C0222q;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.app.w */
public abstract class C0147w<E> extends C0141u {
    private final Activity f998a;
    final Context f999b;
    final int f1000c;
    final C0153z f1001d;
    private final Handler f1002e;
    private C0222q<String, av> f1003f;
    private boolean f1004g;
    private ax f1005h;
    private boolean f1006i;
    private boolean f1007j;

    C0147w(Activity activity, Context context, Handler handler, int i) {
        this.f1001d = new C0153z();
        this.f998a = activity;
        this.f999b = context;
        this.f1002e = handler;
        this.f1000c = i;
    }

    C0147w(C0145q c0145q) {
        this(c0145q, c0145q, c0145q.f989a, 0);
    }

    ax m1313a(String str, boolean z, boolean z2) {
        if (this.f1003f == null) {
            this.f1003f = new C0222q();
        }
        ax axVar = (ax) this.f1003f.get(str);
        if (axVar != null) {
            axVar.m1097a(this);
            return axVar;
        } else if (!z2) {
            return axVar;
        } else {
            axVar = new ax(str, this, z);
            this.f1003f.put(str, axVar);
            return axVar;
        }
    }

    public View m1314a(int i) {
        return null;
    }

    void m1315a(C0222q<String, av> c0222q) {
        this.f1003f = c0222q;
    }

    void m1316a(String str) {
        if (this.f1003f != null) {
            ax axVar = (ax) this.f1003f.get(str);
            if (axVar != null && !axVar.f848f) {
                axVar.m1106h();
                this.f1003f.remove(str);
            }
        }
    }

    public void m1317a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    void m1318a(boolean z) {
        this.f1004g = z;
        if (this.f1005h != null && this.f1007j) {
            this.f1007j = false;
            if (z) {
                this.f1005h.m1102d();
            } else {
                this.f1005h.m1101c();
            }
        }
    }

    public boolean m1319a() {
        return true;
    }

    public boolean m1320a(Fragment fragment) {
        return true;
    }

    public LayoutInflater m1321b() {
        return (LayoutInflater) this.f999b.getSystemService("layout_inflater");
    }

    void m1322b(Fragment fragment) {
    }

    void m1323b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.f1007j);
        if (this.f1005h != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f1005h)));
            printWriter.println(":");
            this.f1005h.m1098a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public void m1324c() {
    }

    public boolean m1325d() {
        return true;
    }

    public int m1326e() {
        return this.f1000c;
    }

    Activity m1327f() {
        return this.f998a;
    }

    Context m1328g() {
        return this.f999b;
    }

    Handler m1329h() {
        return this.f1002e;
    }

    C0153z m1330i() {
        return this.f1001d;
    }

    ax m1331j() {
        if (this.f1005h != null) {
            return this.f1005h;
        }
        this.f1006i = true;
        this.f1005h = m1313a("(root)", this.f1007j, true);
        return this.f1005h;
    }

    boolean m1332k() {
        return this.f1004g;
    }

    void m1333l() {
        if (!this.f1007j) {
            this.f1007j = true;
            if (this.f1005h != null) {
                this.f1005h.m1100b();
            } else if (!this.f1006i) {
                this.f1005h = m1313a("(root)", this.f1007j, false);
                if (!(this.f1005h == null || this.f1005h.f847e)) {
                    this.f1005h.m1100b();
                }
            }
            this.f1006i = true;
        }
    }

    void m1334m() {
        if (this.f1005h != null) {
            this.f1005h.m1106h();
        }
    }

    void m1335n() {
        if (this.f1003f != null) {
            int size = this.f1003f.size();
            ax[] axVarArr = new ax[size];
            for (int i = size - 1; i >= 0; i--) {
                axVarArr[i] = (ax) this.f1003f.m1668c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                ax axVar = axVarArr[i2];
                axVar.m1103e();
                axVar.m1105g();
            }
        }
    }

    C0222q<String, av> m1336o() {
        int i;
        int i2 = 0;
        if (this.f1003f != null) {
            int size = this.f1003f.size();
            ax[] axVarArr = new ax[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                axVarArr[i3] = (ax) this.f1003f.m1668c(i3);
            }
            i = 0;
            while (i2 < size) {
                ax axVar = axVarArr[i2];
                if (axVar.f848f) {
                    i = 1;
                } else {
                    axVar.m1106h();
                    this.f1003f.remove(axVar.f846d);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        return i != 0 ? this.f1003f : null;
    }
}
