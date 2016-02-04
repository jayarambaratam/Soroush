package mobi.mmdt.ott.p095c.p096a;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.p095c.C1303d;
import mobi.mmdt.ott.p095c.p096a.p097a.C1168a;
import mobi.mmdt.ott.p095c.p096a.p097a.C1170c;
import mobi.mmdt.ott.p095c.p096a.p097a.C1175h;
import mobi.mmdt.ott.p095c.p096a.p097a.C1190w;
import mobi.mmdt.ott.p095c.p096a.p097a.C1192z;
import mobi.mmdt.ott.p095c.p096a.p097a.ai;
import mobi.mmdt.ott.p095c.p096a.p097a.al;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1196a;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1200c;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1205h;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1207j;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1217w;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1219y;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ad;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.am;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ap;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.au;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.aw;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bi;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bj;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bk;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bm;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.C1222a;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.C1224c;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.C1227f;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.C1230i;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.C1245y;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.ae;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.ag;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.ak;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.an;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.aq;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.ar;
import mobi.mmdt.ott.p095c.p106b.C1271g;
import mobi.mmdt.ott.p095c.p107c.C1274a;
import mobi.mmdt.ott.p095c.p107c.C1277d;
import mobi.mmdt.ott.p095c.p107c.C1282i;
import mobi.mmdt.ott.p095c.p107c.aa;
import mobi.mmdt.ott.p095c.p107c.ac;
import mobi.mmdt.ott.p095c.p107c.aj;
import mobi.mmdt.ott.p095c.p108d.C1301b;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.a */
public class C1194a implements C1193g {
    private static C1194a f4263a;
    private static C1263m f4264c;
    private Context f4265b;

    private C1194a(Context context) {
        this.f4265b = context;
        f4264c = new C1263m(this.f4265b);
    }

    public static C1194a m6600a(Context context) {
        if (f4263a == null) {
            f4263a = new C1194a(context);
        }
        return f4263a;
    }

    public C1196a m6601a(String str, String str2, String str3) {
        C1303d.m6881a(this.f4265b);
        System.currentTimeMillis();
        JSONObject c1168a = new C1168a(str2, str3, f4264c.m6847e(), f4264c.m6849f(), f4264c.m6843c(), f4264c.m6845d());
        try {
            C1196a c1196a = (C1196a) ar.m6742a(c1168a, C1271g.m6858a(this.f4265b, str + "activation/", c1168a, C1301b.m6871b(this.f4265b)), new C1222a(f4264c));
            System.currentTimeMillis();
            return c1196a;
        } catch (Throwable e) {
            C1104b.m6367b(this, e.m6861c(), e);
            if (m6608a(str, C1262l.f4496a, C1262l.f4497b, str2).m6697a()) {
                return m6601a(str, str2, str3);
            }
            throw e;
        } catch (Throwable e2) {
            C1104b.m6367b(this, e2.m6861c(), e2);
            return null;
        } catch (aj e3) {
            switch (e3.m6859a()) {
                case 331:
                    throw new C1274a(e3.m6859a(), e3.m6861c(), c1168a);
                case 332:
                    throw new C1282i(e3.m6859a(), e3.m6861c(), c1168a);
                default:
                    throw new aj(e3.m6859a(), e3.m6861c(), c1168a);
            }
        }
    }

    public ad m6602a(String str, String str2, String[] strArr) {
        C1303d.m6881a(this.f4265b);
        System.currentTimeMillis();
        JSONObject adVar = new mobi.mmdt.ott.p095c.p096a.p097a.ad(str2, strArr, f4264c.m6847e(), f4264c.m6851g());
        try {
            ad adVar2 = (ad) ar.m6742a(adVar, C1271g.m6858a(this.f4265b, str + "members/", adVar, C1301b.m6871b(this.f4265b)), new ae(f4264c));
            System.currentTimeMillis();
            return adVar2;
        } catch (Throwable e) {
            C1104b.m6367b(this, e.m6861c(), e);
            if (m6608a(str, C1262l.f4496a, C1262l.f4497b, str2).m6697a()) {
                return m6602a(str, str2, strArr);
            }
            throw e;
        } catch (Throwable e2) {
            C1104b.m6367b(this, e2.m6861c(), e2);
            return null;
        }
    }

    public am m6603a(String str, String str2, C1247b c1247b) {
        C1303d.m6881a(this.f4265b);
        System.currentTimeMillis();
        JSONObject aeVar = new mobi.mmdt.ott.p095c.p096a.p097a.ae(str2, Secure.getString(this.f4265b.getContentResolver(), "android_id"), C1301b.m6869a(16), c1247b, f4264c);
        try {
            am amVar = (am) ar.m6742a(aeVar, C1271g.m6858a(this.f4265b, str + "register/", aeVar, C1301b.m6871b(this.f4265b)), new ag(f4264c));
            System.currentTimeMillis();
            return amVar;
        } catch (Throwable e) {
            C1104b.m6367b(this, e.m6861c(), e);
            if (m6608a(str, C1262l.f4496a, C1262l.f4497b, str2).m6697a()) {
                return m6603a(str, str2, c1247b);
            }
            throw e;
        } catch (Throwable e2) {
            C1104b.m6367b(this, e2.m6861c(), e2);
            return null;
        } catch (aj e3) {
            switch (e3.m6859a()) {
                case 331:
                    throw new C1274a(e3.m6859a(), e3.m6861c(), aeVar);
                case 332:
                    throw new C1282i(e3.m6859a(), e3.m6861c(), aeVar);
                case 333:
                    throw new ac(e3.m6859a(), e3.m6861c(), aeVar);
                default:
                    throw new aj(e3.m6859a(), e3.m6861c(), aeVar);
            }
        }
    }

    public ap m6604a(String str, String str2, String str3, C1254c c1254c, String str4, String str5) {
        C1303d.m6881a(this.f4265b);
        System.currentTimeMillis();
        JSONObject aiVar = new ai(str2, VERSION.RELEASE, C1301b.m6873d(this.f4265b), str3, c1254c, str4, str5, f4264c.m6847e(), f4264c.m6851g());
        try {
            ap apVar = (ap) ar.m6742a(aiVar, C1271g.m6858a(this.f4265b, str + "report/", aiVar, C1301b.m6871b(this.f4265b)), new mobi.mmdt.ott.p095c.p096a.p098b.p100b.am(f4264c));
            System.currentTimeMillis();
            return apVar;
        } catch (Throwable e) {
            C1104b.m6367b(this, e.m6861c(), e);
            if (m6608a(str, C1262l.f4496a, C1262l.f4497b, str2).m6697a()) {
                return m6604a(str, str2, str3, c1254c, str4, str5);
            }
            throw e;
        } catch (Throwable e2) {
            C1104b.m6367b(this, e2.m6861c(), e2);
            return null;
        }
    }

    public aw m6605a(String str, String str2, String str3, String str4, String str5, String str6) {
        C1303d.m6881a(this.f4265b);
        System.currentTimeMillis();
        JSONObject ajVar = new mobi.mmdt.ott.p095c.p096a.p097a.aj(str2, str3, str4, str5, str6, f4264c.m6847e(), f4264c.m6851g());
        try {
            aw awVar = (aw) ar.m6742a(ajVar, C1271g.m6858a(this.f4265b, str + "setprofile/", ajVar, C1301b.m6871b(this.f4265b)), new an(f4264c));
            System.currentTimeMillis();
            return awVar;
        } catch (Throwable e) {
            C1104b.m6367b(this, e.m6861c(), e);
            if (m6608a(str, C1262l.f4496a, C1262l.f4497b, str2).m6697a()) {
                return m6605a(str, str2, str3, str4, str5, str6);
            }
            throw e;
        } catch (Throwable e2) {
            C1104b.m6367b(this, e2.m6861c(), e2);
            return null;
        }
    }

    public bj m6606a(String str, String str2, bi[] biVarArr) {
        C1303d.m6881a(this.f4265b);
        System.currentTimeMillis();
        if (str2 == null) {
            throw new NullPointerException();
        }
        JSONObject alVar = new al(str2, biVarArr, f4264c.m6847e(), f4264c.m6851g());
        try {
            bj bjVar = (bj) ar.m6742a(alVar, C1271g.m6858a(this.f4265b, str + "contacts/syncall/", alVar, C1301b.m6871b(this.f4265b)), new mobi.mmdt.ott.p095c.p096a.p098b.p100b.ap(f4264c));
            System.currentTimeMillis();
            return bjVar;
        } catch (Throwable e) {
            C1104b.m6367b(this, e.m6861c(), e);
            if (m6608a(str, C1262l.f4496a, C1262l.f4497b, str2).m6697a()) {
                return m6606a(str, str2, biVarArr);
            }
            throw e;
        } catch (Throwable e2) {
            C1104b.m6367b(this, e2.m6861c(), e2);
            return null;
        }
    }

    public bm m6607a(String str, String str2, bk[] bkVarArr) {
        C1303d.m6881a(this.f4265b);
        System.currentTimeMillis();
        if (str2 == null) {
            throw new NullPointerException();
        }
        JSONObject amVar = new mobi.mmdt.ott.p095c.p096a.p097a.am(str2, bkVarArr, f4264c.m6847e(), f4264c.m6851g());
        try {
            bm bmVar = (bm) ar.m6742a(amVar, C1271g.m6858a(this.f4265b, str + "contacts/syncchanges/", amVar, C1301b.m6871b(this.f4265b)), new aq(f4264c));
            System.currentTimeMillis();
            return bmVar;
        } catch (Throwable e) {
            C1104b.m6367b(this, e.m6861c(), e);
            if (m6608a(str, C1262l.f4496a, C1262l.f4497b, str2).m6697a()) {
                return m6607a(str, str2, bkVarArr);
            }
            throw e;
        } catch (Throwable e2) {
            C1104b.m6367b(this, e2.m6861c(), e2);
            return null;
        }
    }

    public C1200c m6608a(String str, String[] strArr, String[] strArr2, String str2) {
        C1303d.m6881a(this.f4265b);
        System.currentTimeMillis();
        JSONObject c1170c = new C1170c(str2, strArr, strArr2);
        JSONObject a = C1271g.m6858a(this.f4265b, str + "algorithm/", c1170c, C1301b.m6871b(this.f4265b));
        try {
            System.currentTimeMillis();
            return (C1200c) ar.m6742a(c1170c, a, new C1224c(f4264c));
        } catch (Throwable e) {
            C1104b.m6367b(this, e.m6861c(), e);
            return null;
        }
    }

    public C1205h m6609a(String str) {
        C1303d.m6881a(this.f4265b);
        System.currentTimeMillis();
        try {
            C1205h c1205h = (C1205h) ar.m6742a(new JSONObject(), C1271g.m6857a(this.f4265b, str + "client_country/", C1301b.m6871b(this.f4265b)), new C1227f(f4264c));
            System.currentTimeMillis();
            return c1205h;
        } catch (Throwable e) {
            C1104b.m6367b(this, e.m6861c(), e);
            throw e;
        } catch (Throwable e2) {
            C1104b.m6367b(this, e2.m6861c(), e2);
            return null;
        }
    }

    public C1217w m6610a(String str, String str2) {
        C1303d.m6881a(this.f4265b);
        System.currentTimeMillis();
        JSONObject c1190w = new C1190w(str2);
        try {
            C1217w c1217w = (C1217w) ar.m6742a(c1190w, C1271g.m6858a(this.f4265b, str + "ivrRequest/", c1190w, C1301b.m6871b(this.f4265b)), new C1245y(f4264c));
            System.currentTimeMillis();
            return c1217w;
        } catch (Throwable e) {
            C1104b.m6367b(this, e.m6861c(), e);
            if (m6608a(str, C1262l.f4496a, C1262l.f4497b, str2).m6697a()) {
                return m6610a(str, str2);
            }
            throw e;
        } catch (Throwable e2) {
            C1104b.m6367b(this, e2.m6861c(), e2);
            return null;
        } catch (aj e3) {
            switch (e3.m6859a()) {
                case 334:
                    throw new aa(e3.m6859a(), e3.m6861c(), c1190w);
                case 336:
                    throw new C1277d(e3.m6859a(), e3.m6861c(), c1190w);
                default:
                    throw new aj(e3.m6859a(), e3.m6861c(), c1190w);
            }
        }
    }

    public C1207j m6611b(String str, String str2) {
        C1303d.m6881a(this.f4265b);
        System.currentTimeMillis();
        JSONObject c1175h = new C1175h(str2, f4264c.m6847e(), f4264c.m6851g());
        try {
            C1207j c1207j = (C1207j) ar.m6742a(c1175h, C1271g.m6858a(this.f4265b, str + "deactivation/", c1175h, C1301b.m6871b(this.f4265b)), new C1230i(f4264c));
            System.currentTimeMillis();
            return c1207j;
        } catch (Throwable e) {
            C1104b.m6367b(this, e.m6861c(), e);
            if (m6608a(str, C1262l.f4496a, C1262l.f4497b, str2).m6697a()) {
                return m6611b(str, str2);
            }
            throw e;
        } catch (Throwable e2) {
            C1104b.m6367b(this, e2.m6861c(), e2);
            return null;
        }
    }

    public au m6612c(String str, String str2) {
        C1303d.m6881a(this.f4265b);
        System.currentTimeMillis();
        JSONObject agVar = new mobi.mmdt.ott.p095c.p096a.p097a.ag(str2, C1301b.m6873d(this.f4265b), f4264c.m6847e(), f4264c.m6849f(), f4264c.m6851g());
        try {
            au auVar = (au) ar.m6742a(agVar, C1271g.m6858a(this.f4265b, str + "salam/", agVar, C1301b.m6871b(this.f4265b)), new ak(f4264c));
            System.currentTimeMillis();
            return auVar;
        } catch (Throwable e) {
            C1104b.m6367b(this, e.m6861c(), e);
            if (m6608a(str, C1262l.f4496a, C1262l.f4497b, str2).m6697a()) {
                return m6612c(str, str2);
            }
            throw e;
        } catch (Throwable e2) {
            C1104b.m6367b(this, e2.m6861c(), e2);
            return null;
        }
    }

    public C1219y m6613d(String str, String str2) {
        C1303d.m6881a(this.f4265b);
        System.currentTimeMillis();
        JSONObject c1192z = new C1192z(str2, C1255d.TimeStamp, f4264c.m6847e(), f4264c.m6851g());
        try {
            C1219y c1219y = (C1219y) ar.m6742a(c1192z, C1271g.m6858a(this.f4265b, str + "lastseen/", c1192z, C1301b.m6871b(this.f4265b)), new mobi.mmdt.ott.p095c.p096a.p098b.p100b.aa(f4264c));
            System.currentTimeMillis();
            return c1219y;
        } catch (Throwable e) {
            C1104b.m6367b(this, e.m6861c(), e);
            if (m6608a(str, C1262l.f4496a, C1262l.f4497b, str2).m6697a()) {
                return m6613d(str, str2);
            }
            throw e;
        } catch (Throwable e2) {
            C1104b.m6367b(this, e2.m6861c(), e2);
            return null;
        }
    }
}
