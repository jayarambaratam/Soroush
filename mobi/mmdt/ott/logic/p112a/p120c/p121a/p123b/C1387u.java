package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import android.content.Context;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p169c.C1588h;
import mobi.mmdt.ott.provider.p169c.C1592l;
import mobi.mmdt.ott.provider.p169c.C1594n;
import mobi.mmdt.ott.provider.p169c.C1595o;
import mobi.mmdt.ott.provider.p170d.C1597b;
import mobi.mmdt.ott.provider.p170d.C1598c;
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.provider.p171e.C1611e;
import mobi.mmdt.ott.provider.p174h.C1628a;
import mobi.mmdt.ott.provider.p174h.C1629b;
import mobi.mmdt.ott.view.p178a.ah;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.u */
public class C1387u {
    private static String m7217a(Context context, C1595o c1595o, String str) {
        C1611e a = C1607a.m8152a(context, str);
        return c1595o == C1595o.SINGLE ? a.m8209k() ? ah.m8469a(a.m8205g(), a.m8204f()) : ah.m8470b(a.m8202d(), a.m8201c()) : ah.m8470b(a.m8202d(), a.m8201c());
    }

    public static void m7218a(Context context, String str, C1588h c1588h, C1595o c1595o) {
        if (c1588h != null) {
            String uri;
            String str2;
            String str3;
            String f = c1588h.m8045f();
            if (c1588h.m8050k().equals(C1594n.IMAGE) || c1588h.m8050k().equals(C1594n.VIDEO) || c1588h.m8050k().equals(C1594n.PUSH_TO_TALK) || c1588h.m8050k().equals(C1594n.FILE)) {
                String uri2;
                C1597b a = C1598c.m8102a(context, c1588h.m8048i().longValue());
                if (a != null) {
                    uri2 = a.m8088f() != null ? a.m8088f().toString() : null;
                    if (a.m8089g() != null) {
                        uri = a.m8089g().toString();
                        str2 = uri2;
                    } else {
                        uri = null;
                        str2 = uri2;
                    }
                } else {
                    uri = null;
                    str2 = null;
                }
                if (f == null || f.isEmpty()) {
                    switch (C1388v.f4768a[c1588h.m8050k().ordinal()]) {
                        case VideoSize.CIF /*1*/:
                            uri2 = context.getString(2131230930);
                            break;
                        case VideoSize.HVGA /*2*/:
                            uri2 = context.getString(2131230934);
                            break;
                        case Version.API03_CUPCAKE_15 /*3*/:
                            uri2 = context.getString(2131230932);
                            break;
                        case Version.API04_DONUT_16 /*4*/:
                            uri2 = context.getString(2131230929);
                            break;
                    }
                }
                uri2 = f;
                str3 = uri2;
            } else if (c1588h.m8050k().equals(C1594n.STICKER)) {
                C1628a a2 = C1629b.m8296a(context, c1588h.m8041b());
                str2 = a2.m8286a();
                uri = a2.m8287b();
                str3 = context.getString(2131230933);
            } else {
                str3 = f;
                uri = null;
                str2 = null;
            }
            String a3 = c1588h.m8049j().equals(C1595o.SINGLE) ? c1588h.m8040a().equals(C1592l.IN) ? C1387u.m7217a(context, c1595o, c1588h.m8042c()) : C1387u.m7217a(context, c1595o, C1309a.m6934a(context).m6942b()) : C1387u.m7217a(context, c1595o, c1588h.m8042c());
            C1583c.m7964a(context, str, c1588h.m8043d(), a3, c1588h.m8050k(), str3, str2, uri, c1588h.m8041b());
        }
    }
}
