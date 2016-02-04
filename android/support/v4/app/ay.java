package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.p012b.C0127v;
import android.support.v4.p012b.C0128w;
import android.support.v4.p012b.C0154t;
import android.support.v4.p016f.C0227d;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class ay implements C0127v<Object>, C0128w<Object> {
    final int f851a;
    final Bundle f852b;
    aw<Object> f853c;
    C0154t<Object> f854d;
    boolean f855e;
    boolean f856f;
    Object f857g;
    boolean f858h;
    boolean f859i;
    boolean f860j;
    boolean f861k;
    boolean f862l;
    boolean f863m;
    ay f864n;
    final /* synthetic */ ax f865o;

    public ay(ax axVar, int i, Bundle bundle, aw<Object> awVar) {
        this.f865o = axVar;
        this.f851a = i;
        this.f852b = bundle;
        this.f853c = awVar;
    }

    void m1109a() {
        if (this.f859i && this.f860j) {
            this.f858h = true;
        } else if (!this.f858h) {
            this.f858h = true;
            if (ax.f843a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            if (this.f854d == null && this.f853c != null) {
                this.f854d = this.f853c.m1089a(this.f851a, this.f852b);
            }
            if (this.f854d == null) {
                return;
            }
            if (!this.f854d.getClass().isMemberClass() || Modifier.isStatic(this.f854d.getClass().getModifiers())) {
                if (!this.f863m) {
                    this.f854d.m1457a(this.f851a, this);
                    this.f854d.m1458a((C0127v) this);
                    this.f863m = true;
                }
                this.f854d.m1473q();
                return;
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f854d);
        }
    }

    public void m1110a(C0154t<Object> c0154t) {
        if (ax.f843a) {
            Log.v("LoaderManager", "onLoadCanceled: " + this);
        }
        if (this.f862l) {
            if (ax.f843a) {
                Log.v("LoaderManager", "  Ignoring load canceled -- destroyed");
            }
        } else if (this.f865o.f844b.m1726a(this.f851a) == this) {
            ay ayVar = this.f864n;
            if (ayVar != null) {
                if (ax.f843a) {
                    Log.v("LoaderManager", "  Switching to pending loader: " + ayVar);
                }
                this.f864n = null;
                this.f865o.f844b.m1730b(this.f851a, null);
                m1118f();
                this.f865o.m1096a(ayVar);
            }
        } else if (ax.f843a) {
            Log.v("LoaderManager", "  Ignoring load canceled -- not active");
        }
    }

    public void m1111a(C0154t<Object> c0154t, Object obj) {
        if (ax.f843a) {
            Log.v("LoaderManager", "onLoadComplete: " + this);
        }
        if (this.f862l) {
            if (ax.f843a) {
                Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
            }
        } else if (this.f865o.f844b.m1726a(this.f851a) == this) {
            ay ayVar = this.f864n;
            if (ayVar != null) {
                if (ax.f843a) {
                    Log.v("LoaderManager", "  Switching to pending loader: " + ayVar);
                }
                this.f864n = null;
                this.f865o.f844b.m1730b(this.f851a, null);
                m1118f();
                this.f865o.m1096a(ayVar);
                return;
            }
            if (!(this.f857g == obj && this.f855e)) {
                this.f857g = obj;
                this.f855e = true;
                if (this.f858h) {
                    m1114b(c0154t, obj);
                }
            }
            ayVar = (ay) this.f865o.f845c.m1726a(this.f851a);
            if (!(ayVar == null || ayVar == this)) {
                ayVar.f856f = false;
                ayVar.m1118f();
                this.f865o.f845c.m1732c(this.f851a);
            }
            if (this.f865o.f850h != null && !this.f865o.m1099a()) {
                this.f865o.f850h.f1001d.m1433d();
            }
        } else if (ax.f843a) {
            Log.v("LoaderManager", "  Ignoring load complete -- not active");
        }
    }

    public void m1112a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f851a);
        printWriter.print(" mArgs=");
        printWriter.println(this.f852b);
        printWriter.print(str);
        printWriter.print("mCallbacks=");
        printWriter.println(this.f853c);
        printWriter.print(str);
        printWriter.print("mLoader=");
        printWriter.println(this.f854d);
        if (this.f854d != null) {
            this.f854d.m1460a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f855e || this.f856f) {
            printWriter.print(str);
            printWriter.print("mHaveData=");
            printWriter.print(this.f855e);
            printWriter.print("  mDeliveredData=");
            printWriter.println(this.f856f);
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(this.f857g);
        }
        printWriter.print(str);
        printWriter.print("mStarted=");
        printWriter.print(this.f858h);
        printWriter.print(" mReportNextStart=");
        printWriter.print(this.f861k);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f862l);
        printWriter.print(str);
        printWriter.print("mRetaining=");
        printWriter.print(this.f859i);
        printWriter.print(" mRetainingStarted=");
        printWriter.print(this.f860j);
        printWriter.print(" mListenerRegistered=");
        printWriter.println(this.f863m);
        if (this.f864n != null) {
            printWriter.print(str);
            printWriter.println("Pending Loader ");
            printWriter.print(this.f864n);
            printWriter.println(":");
            this.f864n.m1112a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    void m1113b() {
        if (ax.f843a) {
            Log.v("LoaderManager", "  Retaining: " + this);
        }
        this.f859i = true;
        this.f860j = this.f858h;
        this.f858h = false;
        this.f853c = null;
    }

    void m1114b(C0154t<Object> c0154t, Object obj) {
        String str;
        if (this.f853c != null) {
            if (this.f865o.f850h != null) {
                String str2 = this.f865o.f850h.f1001d.f1038v;
                this.f865o.f850h.f1001d.f1038v = "onLoadFinished";
                str = str2;
            } else {
                str = null;
            }
            try {
                if (ax.f843a) {
                    Log.v("LoaderManager", "  onLoadFinished in " + c0154t + ": " + c0154t.m1464c(obj));
                }
                this.f853c.m1091a((C0154t) c0154t, obj);
                this.f856f = true;
            } finally {
                if (this.f865o.f850h != null) {
                    this.f865o.f850h.f1001d.f1038v = str;
                }
            }
        }
    }

    void m1115c() {
        if (this.f859i) {
            if (ax.f843a) {
                Log.v("LoaderManager", "  Finished Retaining: " + this);
            }
            this.f859i = false;
            if (!(this.f858h == this.f860j || this.f858h)) {
                m1117e();
            }
        }
        if (this.f858h && this.f855e && !this.f861k) {
            m1114b(this.f854d, this.f857g);
        }
    }

    void m1116d() {
        if (this.f858h && this.f861k) {
            this.f861k = false;
            if (this.f855e) {
                m1114b(this.f854d, this.f857g);
            }
        }
    }

    void m1117e() {
        if (ax.f843a) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        this.f858h = false;
        if (!this.f859i && this.f854d != null && this.f863m) {
            this.f863m = false;
            this.f854d.m1459a((C0128w) this);
            this.f854d.m1461b((C0127v) this);
            this.f854d.m1476t();
        }
    }

    void m1118f() {
        String str;
        aw awVar = null;
        if (ax.f843a) {
            Log.v("LoaderManager", "  Destroying: " + this);
        }
        this.f862l = true;
        boolean z = this.f856f;
        this.f856f = false;
        if (this.f853c != null && this.f854d != null && this.f855e && z) {
            if (ax.f843a) {
                Log.v("LoaderManager", "  Reseting: " + this);
            }
            if (this.f865o.f850h != null) {
                String str2 = this.f865o.f850h.f1001d.f1038v;
                this.f865o.f850h.f1001d.f1038v = "onLoaderReset";
                str = str2;
            } else {
                str = null;
            }
            try {
                this.f853c.m1090a(this.f854d);
            } finally {
                awVar = this.f865o.f850h;
                if (awVar != null) {
                    awVar = this.f865o.f850h.f1001d;
                    awVar.f1038v = str;
                }
            }
        }
        this.f853c = awVar;
        this.f857g = awVar;
        this.f855e = false;
        if (this.f854d != null) {
            if (this.f863m) {
                this.f863m = false;
                this.f854d.m1459a((C0128w) this);
                this.f854d.m1461b((C0127v) this);
            }
            this.f854d.m1477u();
        }
        if (this.f864n != null) {
            this.f864n.m1118f();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("LoaderInfo{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" #");
        stringBuilder.append(this.f851a);
        stringBuilder.append(" : ");
        C0227d.m1705a(this.f854d, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
