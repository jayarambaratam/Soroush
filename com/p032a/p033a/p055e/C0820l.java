package com.p032a.p033a.p055e;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import com.p032a.p033a.C0884m;
import java.util.HashSet;

@TargetApi(11)
/* renamed from: com.a.a.e.l */
public class C0820l extends Fragment {
    private final C0810a f2920a;
    private final C0817p f2921b;
    private C0884m f2922c;
    private final HashSet<C0820l> f2923d;
    private C0820l f2924e;

    public C0820l() {
        this(new C0810a());
    }

    @SuppressLint({"ValidFragment"})
    C0820l(C0810a c0810a) {
        this.f2921b = new C0822n();
        this.f2923d = new HashSet();
        this.f2920a = c0810a;
    }

    private void m5069a(C0820l c0820l) {
        this.f2923d.add(c0820l);
    }

    private void m5070b(C0820l c0820l) {
        this.f2923d.remove(c0820l);
    }

    C0810a m5071a() {
        return this.f2920a;
    }

    public void m5072a(C0884m c0884m) {
        this.f2922c = c0884m;
    }

    public C0884m m5073b() {
        return this.f2922c;
    }

    public C0817p m5074c() {
        return this.f2921b;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f2924e = C0823o.m5075a().m5078a(getActivity().getFragmentManager());
        if (this.f2924e != this) {
            this.f2924e.m5069a(this);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f2920a.m5052c();
    }

    public void onDetach() {
        super.onDetach();
        if (this.f2924e != null) {
            this.f2924e.m5070b(this);
            this.f2924e = null;
        }
    }

    public void onLowMemory() {
        if (this.f2922c != null) {
            this.f2922c.m5331a();
        }
    }

    public void onStart() {
        super.onStart();
        this.f2920a.m5049a();
    }

    public void onStop() {
        super.onStop();
        this.f2920a.m5051b();
    }

    public void onTrimMemory(int i) {
        if (this.f2922c != null) {
            this.f2922c.m5332a(i);
        }
    }
}
