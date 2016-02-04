package android.support.design.widget;

import android.os.Build.VERSION;
import android.view.View;

class dk {
    static final ct f597a;
    private static final dm f598b;

    static {
        f597a = new dl();
        if (VERSION.SDK_INT >= 21) {
            f598b = new C0079do();
        } else {
            f598b = new dn();
        }
    }

    static cn m755a() {
        return f597a.m699a();
    }

    static void m756a(View view) {
        f598b.m758a(view);
    }
}
