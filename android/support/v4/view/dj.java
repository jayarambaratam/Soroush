package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public class dj {
    static final dm f1354a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f1354a = new C0311do();
        } else if (i >= 18) {
            f1354a = new dn();
        } else if (i >= 14) {
            f1354a = new dl();
        } else if (i >= 11) {
            f1354a = new dk();
        } else {
            f1354a = new dp();
        }
    }

    public static void m2741a(ViewGroup viewGroup, boolean z) {
        f1354a.m2742a(viewGroup, z);
    }
}
