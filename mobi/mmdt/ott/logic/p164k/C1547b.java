package mobi.mmdt.ott.logic.p164k;

import android.content.Context;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.p095c.C1299c;
import mobi.mmdt.ott.p095c.p096a.C1247b;
import mobi.mmdt.ott.p095c.p096a.C1259i;
import mobi.mmdt.ott.p095c.p096a.C1261k;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.az;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ba;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bd;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.be;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bf;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bg;
import mobi.mmdt.ott.p095c.p107c.C1276c;
import mobi.mmdt.ott.p095c.p107c.C1278e;
import mobi.mmdt.ott.p095c.p107c.C1281h;
import mobi.mmdt.ott.p095c.p107c.C1283j;
import mobi.mmdt.ott.p095c.p107c.C1284k;
import mobi.mmdt.ott.p095c.p107c.C1286m;
import mobi.mmdt.ott.p095c.p107c.C1289p;
import mobi.mmdt.ott.p095c.p107c.C1290r;
import mobi.mmdt.ott.p095c.p107c.C1291s;
import mobi.mmdt.ott.p095c.p107c.C1292t;
import mobi.mmdt.ott.p095c.p107c.ab;
import mobi.mmdt.ott.p095c.p107c.ad;
import mobi.mmdt.ott.p095c.p107c.ae;
import mobi.mmdt.ott.p095c.p107c.af;
import mobi.mmdt.ott.p095c.p107c.ag;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import org.linphone.core.VideoSize;

/* renamed from: mobi.mmdt.ott.logic.k.b */
public class C1547b {
    private static C1547b f5206a;
    private Context f5207b;
    private C1259i f5208c;
    private String f5209d;

    private C1547b(Context context, String str, String str2, C1247b c1247b) {
        this.f5207b = context;
        this.f5208c = C1299c.m6863a(context, str2, c1247b);
        this.f5209d = str;
    }

    public static C1547b m7814a(Context context) {
        if (f5206a == null) {
            C1309a a = C1309a.m6934a(context);
            String a2 = a.m6937a();
            Object obj = -1;
            switch (a2.hashCode()) {
                case 3259:
                    if (a2.equals("fa")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 96599618:
                    if (a2.equals("en-us")) {
                        obj = null;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case VideoSize.QCIF /*0*/:
                    f5206a = new C1547b(context, a.m6965j(), a.m6942b(), C1247b.EN);
                    break;
                case VideoSize.CIF /*1*/:
                    f5206a = new C1547b(context, a.m6965j(), a.m6942b(), C1247b.FA);
                    break;
            }
        }
        return f5206a;
    }

    public ba m7815a() {
        Throwable e;
        try {
            return this.f5208c.m6823a(this.f5209d);
        } catch (C1292t e2) {
            e = e2;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ae e3) {
            e = e3;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1290r e4) {
            e = e4;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1278e e5) {
            e = e5;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (af e6) {
            e = e6;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ab e7) {
            e = e7;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ag e8) {
            e = e8;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1281h e9) {
            e = e9;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1283j e10) {
            e = e10;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1276c e11) {
            e = e11;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1291s e12) {
            e = e12;
            C1104b.m6368b((Object) this, e);
            return null;
        }
    }

    public bd m7816a(String str, String str2, String str3, String str4) {
        Throwable e;
        try {
            return this.f5208c.m6824a(this.f5209d, str, str2, str3, str4);
        } catch (C1286m e2) {
            e = e2;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1284k e3) {
            e = e3;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ad e4) {
            e = e4;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1292t e5) {
            e = e5;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ae e6) {
            e = e6;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1276c e7) {
            e = e7;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1290r e8) {
            e = e8;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1289p e9) {
            e = e9;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1278e e10) {
            e = e10;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (af e11) {
            e = e11;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ab e12) {
            e = e12;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ag e13) {
            e = e13;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1281h e14) {
            e = e14;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1283j e15) {
            e = e15;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1291s e16) {
            e = e16;
            C1104b.m6368b((Object) this, e);
            return null;
        }
    }

    public bf m7817a(String str) {
        Throwable e;
        try {
            return this.f5208c.m6825a(this.f5209d, str);
        } catch (C1292t e2) {
            e = e2;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ae e3) {
            e = e3;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1276c e4) {
            e = e4;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1290r e5) {
            e = e5;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1289p e6) {
            e = e6;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1278e e7) {
            e = e7;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (af e8) {
            e = e8;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ab e9) {
            e = e9;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ag e10) {
            e = e10;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1281h e11) {
            e = e11;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1283j e12) {
            e = e12;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1291s e13) {
            e = e13;
            C1104b.m6368b((Object) this, e);
            return null;
        }
    }

    public bg m7818a(String str, String str2, String str3) {
        Throwable e;
        try {
            return this.f5208c.m6826a(this.f5209d, str, str2, str3);
        } catch (C1292t e2) {
            e = e2;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ae e3) {
            e = e3;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1276c e4) {
            e = e4;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1290r e5) {
            e = e5;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1289p e6) {
            e = e6;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1278e e7) {
            e = e7;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (af e8) {
            e = e8;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ab e9) {
            e = e9;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ag e10) {
            e = e10;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1281h e11) {
            e = e11;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1283j e12) {
            e = e12;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1291s e13) {
            e = e13;
            C1104b.m6368b((Object) this, e);
            return null;
        }
    }

    public bg m7819a(String str, String str2, C1261k c1261k) {
        Throwable e;
        try {
            return this.f5208c.m6827a(this.f5209d, str, str2, c1261k);
        } catch (C1292t e2) {
            e = e2;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ae e3) {
            e = e3;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1276c e4) {
            e = e4;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1290r e5) {
            e = e5;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1278e e6) {
            e = e6;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (af e7) {
            e = e7;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ab e8) {
            e = e8;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ag e9) {
            e = e9;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1281h e10) {
            e = e10;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1283j e11) {
            e = e11;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1291s e12) {
            e = e12;
            C1104b.m6368b((Object) this, e);
            return null;
        }
    }

    public az m7820b() {
        Throwable e;
        try {
            return this.f5208c.m6828b(this.f5209d);
        } catch (C1292t e2) {
            e = e2;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ae e3) {
            e = e3;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1276c e4) {
            e = e4;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1290r e5) {
            e = e5;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1278e e6) {
            e = e6;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (af e7) {
            e = e7;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ab e8) {
            e = e8;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ag e9) {
            e = e9;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1281h e10) {
            e = e10;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1283j e11) {
            e = e11;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1291s e12) {
            e = e12;
            C1104b.m6368b((Object) this, e);
            return null;
        }
    }

    public be m7821b(String str) {
        Throwable e;
        try {
            return this.f5208c.m6829b(this.f5209d, str);
        } catch (C1292t e2) {
            e = e2;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ae e3) {
            e = e3;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1276c e4) {
            e = e4;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1290r e5) {
            e = e5;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1281h e6) {
            e = e6;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1278e e7) {
            e = e7;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (af e8) {
            e = e8;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1283j e9) {
            e = e9;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ag e10) {
            e = e10;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1289p e11) {
            e = e11;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (ab e12) {
            e = e12;
            C1104b.m6368b((Object) this, e);
            return null;
        } catch (C1291s e13) {
            e = e13;
            C1104b.m6368b((Object) this, e);
            return null;
        }
    }
}
