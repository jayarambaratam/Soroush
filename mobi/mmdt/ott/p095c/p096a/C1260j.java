package mobi.mmdt.ott.p095c.p096a;

import android.content.Context;
import android.provider.Settings.Secure;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.p095c.C1303d;
import mobi.mmdt.ott.p095c.p096a.p097a.C1173f;
import mobi.mmdt.ott.p095c.p096a.p097a.C1184q;
import mobi.mmdt.ott.p095c.p096a.p097a.C1185r;
import mobi.mmdt.ott.p095c.p096a.p097a.C1186s;
import mobi.mmdt.ott.p095c.p096a.p097a.C1187t;
import mobi.mmdt.ott.p095c.p096a.p097a.C1188u;
import mobi.mmdt.ott.p095c.p096a.p097a.C1189v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.av;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.az;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ba;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bd;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.be;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bf;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bg;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.C1228g;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.C1239r;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.C1240s;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.C1241t;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.C1242u;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.C1243v;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.C1244w;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.ar;
import mobi.mmdt.ott.p095c.p106b.C1271g;
import mobi.mmdt.ott.p095c.p107c.C1284k;
import mobi.mmdt.ott.p095c.p107c.C1286m;
import mobi.mmdt.ott.p095c.p107c.C1289p;
import mobi.mmdt.ott.p095c.p107c.ad;
import mobi.mmdt.ott.p095c.p107c.aj;
import mobi.mmdt.ott.p095c.p108d.C1301b;
import org.apache.http.myHttp.HttpStatus;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.j */
public class C1260j implements C1259i {
    private static C1260j f4485f;
    private Context f4486a;
    private C1263m f4487b;
    private String f4488c;
    private String f4489d;
    private C1247b f4490e;

    private C1260j(Context context, String str, C1247b c1247b) {
        this.f4486a = context;
        this.f4487b = new C1263m(context);
        this.f4489d = str;
        this.f4490e = c1247b;
    }

    public static C1260j m6830a(Context context, String str, C1247b c1247b) {
        if (f4485f == null) {
            f4485f = new C1260j(context, str, c1247b);
        }
        return f4485f;
    }

    public ba m6831a(String str) {
        C1303d.m6881a(this.f4486a);
        if (this.f4488c == null) {
            this.f4488c = m6838c(str).m6659a();
        }
        System.currentTimeMillis();
        JSONObject c1186s = new C1186s(this.f4489d, this.f4488c);
        try {
            ba baVar = (ba) ar.m6742a(c1186s, C1271g.m6858a(this.f4486a, str + "browse/" + "index/", c1186s, null), new C1241t(this.f4487b));
            System.currentTimeMillis();
            return baVar;
        } catch (Throwable e) {
            C1104b.m6367b(this, e.m6861c(), e);
            if (C1194a.m6600a(this.f4486a).m6608a(str, C1262l.f4496a, C1262l.f4497b, this.f4489d).m6697a()) {
                return m6831a(str);
            }
            throw e;
        } catch (Throwable e2) {
            C1104b.m6367b(this, e2.m6861c(), e2);
            this.f4488c = m6838c(str).m6659a();
            return m6831a(str);
        }
    }

    public bd m6832a(String str, String str2, String str3, String str4, String str5) {
        C1303d.m6881a(this.f4486a);
        if (this.f4488c == null) {
            this.f4488c = m6838c(str).m6659a();
        }
        System.currentTimeMillis();
        String a = C1301b.m6870a(this.f4486a);
        String string = Secure.getString(this.f4486a.getContentResolver(), "android_id");
        JSONObject c1184q = new C1184q(this.f4489d, str2, str3, str4, str5, a, string, this.f4487b.m6847e(), this.f4487b.m6851g());
        try {
            bd bdVar = (bd) ar.m6742a(c1184q, C1271g.m6858a(this.f4486a, str + "stickers/" + "download/", c1184q, null), new C1239r(this.f4487b));
            System.currentTimeMillis();
            return bdVar;
        } catch (Throwable e) {
            C1104b.m6367b(this, e.m6861c(), e);
            if (C1194a.m6600a(this.f4486a).m6608a(str, C1262l.f4496a, C1262l.f4497b, this.f4489d).m6697a()) {
                return m6832a(str, str2, str3, str4, str5);
            }
            throw e;
        } catch (Throwable e2) {
            C1104b.m6367b(this, e2.m6861c(), e2);
            this.f4488c = m6838c(str).m6659a();
            return m6832a(str, str2, str3, str4, str5);
        } catch (Throwable e3) {
            C1104b.m6367b(this, e3.m6861c(), e3);
            switch (e3.m6859a()) {
                case HttpStatus.SC_NOT_FOUND /*404*/:
                    throw new C1289p(e3.m6859a(), e3.m6861c(), c1184q);
                case 421:
                    throw new C1284k(e3.m6859a(), e3.m6861c(), c1184q);
                case HttpStatus.SC_UNPROCESSABLE_ENTITY /*422*/:
                    throw new ad(e3.m6859a(), e3.m6861c(), c1184q);
                case HttpStatus.SC_LOCKED /*423*/:
                    throw new C1286m(e3.m6859a(), e3.m6861c(), c1184q);
                default:
                    throw new aj(e3.m6859a(), e3.m6861c(), c1184q);
            }
        }
    }

    public bf m6833a(String str, String str2) {
        C1303d.m6881a(this.f4486a);
        if (this.f4488c == null) {
            this.f4488c = m6838c(str).m6659a();
        }
        System.currentTimeMillis();
        JSONObject c1189v = new C1189v(this.f4489d, this.f4488c);
        try {
            bf bfVar = (bf) ar.m6742a(c1189v, C1271g.m6858a(this.f4486a, str + "packages/" + "view/" + str2, c1189v, null), new C1244w(this.f4487b));
            System.currentTimeMillis();
            return bfVar;
        } catch (Throwable e) {
            C1104b.m6367b(this, e.m6861c(), e);
            if (C1194a.m6600a(this.f4486a).m6608a(str, C1262l.f4496a, C1262l.f4497b, this.f4489d).m6697a()) {
                return m6833a(str, str2);
            }
            throw e;
        } catch (Throwable e2) {
            C1104b.m6367b(this, e2.m6861c(), e2);
            this.f4488c = m6838c(str).m6659a();
            return m6833a(str, str2);
        } catch (Throwable e22) {
            C1104b.m6367b(this, e22.m6861c(), e22);
            switch (e22.m6859a()) {
                case HttpStatus.SC_NOT_FOUND /*404*/:
                    throw new C1289p(e22.m6859a(), e22.m6861c(), c1189v);
                default:
                    throw new aj(e22.m6859a(), e22.m6861c(), c1189v);
            }
        }
    }

    public bg m6834a(String str, String str2, String str3, String str4) {
        C1303d.m6881a(this.f4486a);
        if (this.f4488c == null) {
            this.f4488c = m6838c(str).m6659a();
        }
        System.currentTimeMillis();
        JSONObject c1187t = new C1187t(this.f4489d, this.f4488c, str2, str3);
        try {
            bg bgVar = (bg) ar.m6742a(c1187t, C1271g.m6858a(this.f4486a, str + "browse/" + "index/" + str4, c1187t, null), new C1242u(this.f4487b));
            System.currentTimeMillis();
            return bgVar;
        } catch (Throwable e) {
            C1104b.m6367b(this, e.m6861c(), e);
            if (C1194a.m6600a(this.f4486a).m6608a(str, C1262l.f4496a, C1262l.f4497b, this.f4489d).m6697a()) {
                return m6834a(str, str2, str3, str4);
            }
            throw e;
        } catch (Throwable e2) {
            C1104b.m6367b(this, e2.m6861c(), e2);
            this.f4488c = m6838c(str).m6659a();
            return m6834a(str, str2, str3, str4);
        } catch (Throwable e22) {
            C1104b.m6367b(this, e22.m6861c(), e22);
            switch (e22.m6859a()) {
                case HttpStatus.SC_NOT_FOUND /*404*/:
                    throw new C1289p(e22.m6859a(), e22.m6861c(), c1187t);
                default:
                    throw new aj(e22.m6859a(), e22.m6861c(), c1187t);
            }
        }
    }

    public bg m6835a(String str, String str2, String str3, C1261k c1261k) {
        C1303d.m6881a(this.f4486a);
        if (this.f4488c == null) {
            this.f4488c = m6838c(str).m6659a();
        }
        System.currentTimeMillis();
        JSONObject c1187t = new C1187t(this.f4489d, this.f4488c, str2, str3);
        try {
            bg bgVar = (bg) ar.m6742a(c1187t, C1271g.m6858a(this.f4486a, str + "browse/" + c1261k.toString(), c1187t, null), new C1242u(this.f4487b));
            System.currentTimeMillis();
            return bgVar;
        } catch (Throwable e) {
            C1104b.m6367b(this, e.m6861c(), e);
            if (C1194a.m6600a(this.f4486a).m6608a(str, C1262l.f4496a, C1262l.f4497b, this.f4489d).m6697a()) {
                return m6835a(str, str2, str3, c1261k);
            }
            throw e;
        } catch (Throwable e2) {
            C1104b.m6367b(this, e2.m6861c(), e2);
            this.f4488c = m6838c(str).m6659a();
            return m6835a(str, str2, str3, c1261k);
        }
    }

    public az m6836b(String str) {
        C1303d.m6881a(this.f4486a);
        if (this.f4488c == null) {
            this.f4488c = m6838c(str).m6659a();
        }
        System.currentTimeMillis();
        JSONObject c1185r = new C1185r(this.f4489d, this.f4488c);
        try {
            az azVar = (az) ar.m6742a(c1185r, C1271g.m6858a(this.f4486a, str + "banner/", c1185r, null), new C1240s(this.f4487b));
            System.currentTimeMillis();
            return azVar;
        } catch (Throwable e) {
            C1104b.m6367b(this, e.m6861c(), e);
            if (C1194a.m6600a(this.f4486a).m6608a(str, C1262l.f4496a, C1262l.f4497b, this.f4489d).m6697a()) {
                return m6836b(str);
            }
            throw e;
        } catch (Throwable e2) {
            C1104b.m6367b(this, e2.m6861c(), e2);
            this.f4488c = m6838c(str).m6659a();
            return m6836b(str);
        }
    }

    public be m6837b(String str, String str2) {
        C1303d.m6881a(this.f4486a);
        if (this.f4488c == null) {
            this.f4488c = m6838c(str).m6659a();
        }
        System.currentTimeMillis();
        JSONObject c1188u = new C1188u(this.f4489d, this.f4488c);
        try {
            be beVar = (be) ar.m6742a(c1188u, C1271g.m6858a(this.f4486a, str + "packages/" + "download/" + str2, c1188u, null), new C1243v(this.f4487b));
            System.currentTimeMillis();
            return beVar;
        } catch (Throwable e) {
            C1104b.m6367b(this, e.m6861c(), e);
            if (C1194a.m6600a(this.f4486a).m6608a(str, C1262l.f4496a, C1262l.f4497b, this.f4489d).m6697a()) {
                return m6837b(str, str2);
            }
            throw e;
        } catch (Throwable e2) {
            C1104b.m6367b(this, e2.m6861c(), e2);
            this.f4488c = m6838c(str).m6659a();
            return m6837b(str, str2);
        } catch (Throwable e22) {
            C1104b.m6367b(this, e22.m6861c(), e22);
            switch (e22.m6859a()) {
                case HttpStatus.SC_NOT_FOUND /*404*/:
                    throw new C1289p(e22.m6859a(), e22.m6861c(), c1188u);
                default:
                    throw new aj(e22.m6859a(), e22.m6861c(), c1188u);
            }
        }
    }

    public av m6838c(String str) {
        C1303d.m6881a(this.f4486a);
        System.currentTimeMillis();
        String[] strArr = new String[]{C1301b.m6870a(this.f4486a)};
        JSONObject c1173f = new C1173f(this.f4489d, this.f4487b.m6847e(), this.f4490e.toString(), Secure.getString(this.f4486a.getContentResolver(), "android_id"), strArr, this.f4487b.m6851g());
        try {
            av avVar = (av) ar.m6742a(c1173f, C1271g.m6858a(this.f4486a, str + "authentication/", c1173f, C1301b.m6871b(this.f4486a)), new C1228g(this.f4487b));
            System.currentTimeMillis();
            return avVar;
        } catch (Throwable e) {
            C1104b.m6367b(this, e.m6861c(), e);
            if (C1194a.m6600a(this.f4486a).m6608a(str, C1262l.f4496a, C1262l.f4497b, this.f4489d).m6697a()) {
                return m6838c(str);
            }
            throw e;
        } catch (Throwable e2) {
            C1104b.m6367b(this, e2.m6861c(), e2);
            return null;
        }
    }
}
