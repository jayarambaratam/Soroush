package mobi.mmdt.ott.view.p178a;

import android.content.Context;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.componentsutils.p079a.p080a.C1105c;
import mobi.mmdt.ott.logic.p164k.C1548c;
import mobi.mmdt.ott.p095c.p096a.C1254c;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.a.ad */
public class ad {
    private static ad f5493a;
    private Context f5494b;
    private boolean f5495c;
    private long f5496d;

    private ad(Context context) {
        this.f5495c = false;
        this.f5496d = 0;
        this.f5494b = context;
        if (C1104b.f4138b) {
            m8464a();
        }
    }

    public static ad m8463a(Context context) {
        if (f5493a == null) {
            f5493a = new ad(context);
        }
        return f5493a;
    }

    private void m8464a() {
        Thread.setDefaultUncaughtExceptionHandler(new ae(this));
    }

    public void m8468a(String str, C1105c c1105c, String str2, String str3) {
        C1254c c1254c = null;
        switch (ag.f5501a[c1105c.ordinal()]) {
            case VideoSize.CIF /*1*/:
                c1254c = C1254c.bug;
                break;
            case VideoSize.HVGA /*2*/:
                c1254c = C1254c.error;
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                c1254c = C1254c.info;
                break;
        }
        C1548c.m7822a(this.f5494b).m7827a(str, c1254c, str2, str3);
    }
}
