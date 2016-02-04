package mobi.mmdt.ott.logic.p124j;

import android.content.Context;
import mobi.mmdt.componentsutils.p079a.C1107a;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p170d.C1605j;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.logic.j.a */
public class C1543a {
    public static boolean m7782a(Context context, C1605j c1605j) {
        boolean c = C1107a.m6378c(context);
        boolean d = C1107a.m6379d(context);
        if (c) {
            switch (C1544b.f5196a[c1605j.ordinal()]) {
                case VideoSize.CIF /*1*/:
                    return C1309a.m6934a(context).m6975r();
                case VideoSize.HVGA /*2*/:
                    return C1309a.m6934a(context).m6977t();
                case Version.API03_CUPCAKE_15 /*3*/:
                    return C1309a.m6934a(context).m6979v();
                default:
                    return false;
            }
        } else if (!d) {
            return false;
        } else {
            switch (C1544b.f5196a[c1605j.ordinal()]) {
                case VideoSize.CIF /*1*/:
                    return C1309a.m6934a(context).m6976s();
                case VideoSize.HVGA /*2*/:
                    return C1309a.m6934a(context).m6978u();
                case Version.API03_CUPCAKE_15 /*3*/:
                    return C1309a.m6934a(context).m6980w();
                default:
                    return false;
            }
        }
    }
}
