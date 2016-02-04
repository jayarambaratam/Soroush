package android.support.v4.p011a;

import android.os.Build.VERSION;
import android.view.View;

/* renamed from: android.support.v4.a.a */
public abstract class C0113a {
    static C0115c f697a;

    static {
        if (VERSION.SDK_INT >= 12) {
            f697a = new C0121h();
        } else {
            f697a = new C0117e();
        }
    }

    public static C0118l m898a() {
        return f697a.m900a();
    }

    public static void m899a(View view) {
        f697a.m901a(view);
    }
}
