package p025b.p026a.p027a.p028a.p029a;

import android.content.Context;
import android.os.Build.VERSION;

/* renamed from: b.a.a.a.a.g */
public final class C0546g {
    public static C0540e m4153a(Context context, C0545f c0545f) {
        int i = VERSION.SDK_INT;
        C0540e c0541a = i < 5 ? new C0541a(context) : i < 8 ? new C0542b(context) : new C0543c(context);
        c0541a.m4135a(c0545f);
        return c0541a;
    }
}
