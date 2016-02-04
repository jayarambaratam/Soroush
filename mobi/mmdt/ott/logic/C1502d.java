package mobi.mmdt.ott.logic;

import android.content.Context;
import java.util.Timer;
import mobi.mmdt.ott.logic.p112a.p147h.C1452c;
import mobi.mmdt.ott.p109d.p111b.C1309a;

/* renamed from: mobi.mmdt.ott.logic.d */
public class C1502d {
    public static void m7573a(Context context) {
        C1309a a = C1309a.m6934a(context);
        if (!a.m6973p()) {
            return;
        }
        if (a.m6974q()) {
            new Timer().schedule(new C1520e(context), 5000);
        } else {
            C1494c.m7541c(new C1452c(context));
        }
    }
}
