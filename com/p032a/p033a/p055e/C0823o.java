package com.p032a.p033a.p055e;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.C0145q;
import android.support.v4.app.C0151x;
import android.util.Log;
import com.p032a.p033a.C0884m;
import com.p032a.p033a.p042j.C0879h;
import java.util.HashMap;
import java.util.Map;
import org.linphone.core.VideoSize;

/* renamed from: com.a.a.e.o */
public class C0823o implements Callback {
    private static final C0823o f2926c;
    final Map<FragmentManager, C0820l> f2927a;
    final Map<C0151x, C0825r> f2928b;
    private volatile C0884m f2929d;
    private final Handler f2930e;

    static {
        f2926c = new C0823o();
    }

    C0823o() {
        this.f2927a = new HashMap();
        this.f2928b = new HashMap();
        this.f2930e = new Handler(Looper.getMainLooper(), this);
    }

    public static C0823o m5075a() {
        return f2926c;
    }

    private C0884m m5076b(Context context) {
        if (this.f2929d == null) {
            synchronized (this) {
                if (this.f2929d == null) {
                    this.f2929d = new C0884m(context.getApplicationContext(), new C0811b(), new C0818h());
                }
            }
        }
        return this.f2929d;
    }

    @TargetApi(17)
    private static void m5077b(Activity activity) {
        if (VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @TargetApi(17)
    C0820l m5078a(FragmentManager fragmentManager) {
        C0820l c0820l = (C0820l) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (c0820l != null) {
            return c0820l;
        }
        c0820l = (C0820l) this.f2927a.get(fragmentManager);
        if (c0820l != null) {
            return c0820l;
        }
        Fragment c0820l2 = new C0820l();
        this.f2927a.put(fragmentManager, c0820l2);
        fragmentManager.beginTransaction().add(c0820l2, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.f2930e.obtainMessage(1, fragmentManager).sendToTarget();
        return c0820l2;
    }

    C0825r m5079a(C0151x c0151x) {
        C0825r c0825r = (C0825r) c0151x.m1382a("com.bumptech.glide.manager");
        if (c0825r != null) {
            return c0825r;
        }
        c0825r = (C0825r) this.f2928b.get(c0151x);
        if (c0825r != null) {
            return c0825r;
        }
        android.support.v4.app.Fragment c0825r2 = new C0825r();
        this.f2928b.put(c0151x, c0825r2);
        c0151x.m1383a().m1059a(c0825r2, "com.bumptech.glide.manager").m1060b();
        this.f2930e.obtainMessage(2, c0151x).sendToTarget();
        return c0825r2;
    }

    @TargetApi(11)
    public C0884m m5080a(Activity activity) {
        if (C0879h.m5312d() || VERSION.SDK_INT < 11) {
            return m5081a(activity.getApplicationContext());
        }
        C0823o.m5077b(activity);
        return m5082a((Context) activity, activity.getFragmentManager());
    }

    public C0884m m5081a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (C0879h.m5311c() && !(context instanceof Application)) {
            if (context instanceof C0145q) {
                return m5084a((C0145q) context);
            }
            if (context instanceof Activity) {
                return m5080a((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                return m5081a(((ContextWrapper) context).getBaseContext());
            }
        }
        return m5076b(context);
    }

    @TargetApi(11)
    C0884m m5082a(Context context, FragmentManager fragmentManager) {
        C0820l a = m5078a(fragmentManager);
        C0884m b = a.m5073b();
        if (b != null) {
            return b;
        }
        b = new C0884m(context, a.m5071a(), a.m5074c());
        a.m5072a(b);
        return b;
    }

    C0884m m5083a(Context context, C0151x c0151x) {
        C0825r a = m5079a(c0151x);
        C0884m K = a.m5094K();
        if (K != null) {
            return K;
        }
        K = new C0884m(context, a.m5093J(), a.m5095L());
        a.m5097a(K);
        return K;
    }

    public C0884m m5084a(C0145q c0145q) {
        if (C0879h.m5312d()) {
            return m5081a(c0145q.getApplicationContext());
        }
        C0823o.m5077b((Activity) c0145q);
        return m5083a((Context) c0145q, c0145q.m1311f());
    }

    public boolean handleMessage(Message message) {
        Object obj = null;
        boolean z = true;
        Object remove;
        switch (message.what) {
            case VideoSize.CIF /*1*/:
                FragmentManager fragmentManager = (FragmentManager) message.obj;
                remove = this.f2927a.remove(fragmentManager);
                break;
            case VideoSize.HVGA /*2*/:
                C0151x c0151x = (C0151x) message.obj;
                remove = this.f2928b.remove(c0151x);
                break;
            default:
                z = false;
                remove = null;
                break;
        }
        if (z && r1 == null && Log.isLoggable("RMRetriever", 5)) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        }
        return z;
    }
}
