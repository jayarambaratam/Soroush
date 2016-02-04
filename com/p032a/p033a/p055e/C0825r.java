package com.p032a.p033a.p055e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import com.p032a.p033a.C0884m;
import java.util.HashSet;

/* renamed from: com.a.a.e.r */
public class C0825r extends Fragment {
    private C0884m aa;
    private final C0810a ab;
    private final C0817p ac;
    private final HashSet<C0825r> ad;
    private C0825r ae;

    public C0825r() {
        this(new C0810a());
    }

    @SuppressLint({"ValidFragment"})
    public C0825r(C0810a c0810a) {
        this.ac = new C0827t();
        this.ad = new HashSet();
        this.ab = c0810a;
    }

    private void m5091a(C0825r c0825r) {
        this.ad.add(c0825r);
    }

    private void m5092b(C0825r c0825r) {
        this.ad.remove(c0825r);
    }

    C0810a m5093J() {
        return this.ab;
    }

    public C0884m m5094K() {
        return this.aa;
    }

    public C0817p m5095L() {
        return this.ac;
    }

    public void m5096a(Activity activity) {
        super.m958a(activity);
        this.ae = C0823o.m5075a().m5079a(m979c().m1311f());
        if (this.ae != this) {
            this.ae.m5091a(this);
        }
    }

    public void m5097a(C0884m c0884m) {
        this.aa = c0884m;
    }

    public void m5098j() {
        super.m998j();
        this.ab.m5049a();
    }

    public void m5099m() {
        super.m1002m();
        this.ab.m5051b();
    }

    public void m5100o() {
        super.m1004o();
        this.ab.m5052c();
    }

    public void onLowMemory() {
        super.onLowMemory();
        if (this.aa != null) {
            this.aa.m5331a();
        }
    }

    public void m5101q() {
        super.m1006q();
        if (this.ae != null) {
            this.ae.m5092b(this);
            this.ae = null;
        }
    }
}
