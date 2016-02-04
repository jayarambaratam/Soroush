package mobi.mmdt.ott.logic.p164k;

import android.content.Context;
import java.io.IOException;
import java.security.GeneralSecurityException;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.componentsutils.p079a.p080a.C1105c;
import mobi.mmdt.componentsutils.p079a.p080a.C1106d;
import mobi.mmdt.ott.p095c.C1299c;
import mobi.mmdt.ott.p095c.p096a.C1247b;
import mobi.mmdt.ott.p095c.p096a.C1254c;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1196a;
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
import mobi.mmdt.ott.p095c.p107c.C1273q;
import mobi.mmdt.ott.p095c.p107c.C1274a;
import mobi.mmdt.ott.p095c.p107c.C1276c;
import mobi.mmdt.ott.p095c.p107c.C1277d;
import mobi.mmdt.ott.p095c.p107c.C1278e;
import mobi.mmdt.ott.p095c.p107c.C1279f;
import mobi.mmdt.ott.p095c.p107c.C1281h;
import mobi.mmdt.ott.p095c.p107c.C1282i;
import mobi.mmdt.ott.p095c.p107c.C1283j;
import mobi.mmdt.ott.p095c.p107c.C1290r;
import mobi.mmdt.ott.p095c.p107c.C1292t;
import mobi.mmdt.ott.p095c.p107c.C1293u;
import mobi.mmdt.ott.p095c.p107c.aa;
import mobi.mmdt.ott.p095c.p107c.ab;
import mobi.mmdt.ott.p095c.p107c.ac;
import mobi.mmdt.ott.p095c.p107c.ae;
import mobi.mmdt.ott.p095c.p107c.af;
import mobi.mmdt.ott.p095c.p107c.ag;
import mobi.mmdt.ott.p095c.p107c.aj;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import org.json.JSONException;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.k.c */
public class C1548c {
    private static C1548c f5210a;
    private Context f5211b;
    private String f5212c;
    private String f5213d;

    private C1548c(Context context) {
        this.f5211b = context;
        this.f5212c = C1309a.m6934a(this.f5211b).m6963i();
        this.f5213d = C1309a.m6934a(this.f5211b).m6961h();
    }

    public static C1548c m7822a(Context context) {
        if (f5210a == null) {
            f5210a = new C1548c(context);
        }
        return f5210a;
    }

    public static void m7823a(Exception exception) {
        if (exception instanceof C1273q) {
            C1273q c1273q = (C1273q) exception;
            if (C1104b.f4137a) {
                C0002c.m2a().m17c(new C1106d("Webservice exception", C1105c.info, c1273q.m6861c(), c1273q.m6860b().toString()));
            }
        }
    }

    public C1196a m7824a(String str, String str2) {
        Exception e;
        try {
            return C1299c.m6862a(this.f5211b).m6588a(this.f5212c, str, str2);
        } catch (GeneralSecurityException e2) {
            e = e2;
            C1548c.m7823a(e);
            throw e;
        } catch (aj e3) {
            e = e3;
            C1548c.m7823a(e);
            throw e;
        } catch (IOException e4) {
            e = e4;
            C1548c.m7823a(e);
            throw e;
        } catch (JSONException e5) {
            e = e5;
            C1548c.m7823a(e);
            throw e;
        } catch (C1293u e6) {
            e = e6;
            C1548c.m7823a(e);
            throw e;
        } catch (C1279f e7) {
            e = e7;
            C1548c.m7823a(e);
            throw e;
        } catch (ab e8) {
            e = e8;
            C1548c.m7823a(e);
            throw e;
        } catch (C1292t e9) {
            e = e9;
            C1548c.m7823a(e);
            throw e;
        } catch (C1276c e10) {
            e = e10;
            C1548c.m7823a(e);
            throw e;
        } catch (af e11) {
            e = e11;
            C1548c.m7823a(e);
            throw e;
        } catch (C1281h e12) {
            e = e12;
            C1548c.m7823a(e);
            throw e;
        } catch (C1290r e13) {
            e = e13;
            C1548c.m7823a(e);
            throw e;
        } catch (C1278e e14) {
            e = e14;
            C1548c.m7823a(e);
            throw e;
        } catch (ae e15) {
            e = e15;
            C1548c.m7823a(e);
            throw e;
        } catch (C1283j e16) {
            e = e16;
            C1548c.m7823a(e);
            throw e;
        } catch (ag e17) {
            e = e17;
            C1548c.m7823a(e);
            throw e;
        } catch (Throwable e18) {
            C1548c.m7823a((Exception) e18);
            C1104b.m6368b((Object) this, e18);
            return null;
        } catch (Throwable e182) {
            C1548c.m7823a((Exception) e182);
            C1104b.m6368b((Object) this, e182);
            return null;
        } catch (Throwable e1822) {
            C1548c.m7823a((Exception) e1822);
            C1104b.m6368b((Object) this, e1822);
            return null;
        }
    }

    public ad m7825a(String[] strArr) {
        Exception e;
        try {
            return C1299c.m6862a(this.f5211b).m6589a(this.f5212c, C1309a.m6934a(this.f5211b).m6942b(), strArr);
        } catch (GeneralSecurityException e2) {
            e = e2;
            C1548c.m7823a(e);
            throw e;
        } catch (aj e3) {
            e = e3;
            C1548c.m7823a(e);
            throw e;
        } catch (IOException e4) {
            e = e4;
            C1548c.m7823a(e);
            throw e;
        } catch (JSONException e5) {
            e = e5;
            C1548c.m7823a(e);
            throw e;
        } catch (C1293u e6) {
            e = e6;
            C1548c.m7823a(e);
            throw e;
        } catch (C1279f e7) {
            e = e7;
            C1548c.m7823a(e);
            throw e;
        } catch (ag e8) {
            e = e8;
            C1548c.m7823a(e);
            throw e;
        } catch (ab e9) {
            e = e9;
            C1548c.m7823a(e);
            throw e;
        } catch (C1292t e10) {
            e = e10;
            C1548c.m7823a(e);
            throw e;
        } catch (C1276c e11) {
            e = e11;
            C1548c.m7823a(e);
            throw e;
        } catch (af e12) {
            e = e12;
            C1548c.m7823a(e);
            throw e;
        } catch (C1281h e13) {
            e = e13;
            C1548c.m7823a(e);
            throw e;
        } catch (C1290r e14) {
            e = e14;
            C1548c.m7823a(e);
            throw e;
        } catch (C1278e e15) {
            e = e15;
            C1548c.m7823a(e);
            throw e;
        } catch (ae e16) {
            e = e16;
            C1548c.m7823a(e);
            throw e;
        } catch (C1283j e17) {
            e = e17;
            C1548c.m7823a(e);
            throw e;
        } catch (Throwable e18) {
            C1548c.m7823a((Exception) e18);
            C1104b.m6368b((Object) this, e18);
            return null;
        }
    }

    public am m7826a(String str, C1247b c1247b) {
        Exception e;
        try {
            return C1299c.m6862a(this.f5211b).m6590a(this.f5212c, str, c1247b);
        } catch (GeneralSecurityException e2) {
            e = e2;
            C1548c.m7823a(e);
            throw e;
        } catch (aj e3) {
            e = e3;
            C1548c.m7823a(e);
            throw e;
        } catch (IOException e4) {
            e = e4;
            C1548c.m7823a(e);
            throw e;
        } catch (JSONException e5) {
            e = e5;
            C1548c.m7823a(e);
            throw e;
        } catch (C1293u e6) {
            e = e6;
            C1548c.m7823a(e);
            throw e;
        } catch (C1279f e7) {
            e = e7;
            C1548c.m7823a(e);
            throw e;
        } catch (ab e8) {
            e = e8;
            C1548c.m7823a(e);
            throw e;
        } catch (C1278e e9) {
            e = e9;
            C1548c.m7823a(e);
            throw e;
        } catch (ag e10) {
            e = e10;
            C1548c.m7823a(e);
            throw e;
        } catch (ac e11) {
            e = e11;
            C1548c.m7823a(e);
            throw e;
        } catch (C1292t e12) {
            e = e12;
            C1548c.m7823a(e);
            throw e;
        } catch (C1282i e13) {
            e = e13;
            C1548c.m7823a(e);
            throw e;
        } catch (C1274a e14) {
            e = e14;
            C1548c.m7823a(e);
            throw e;
        } catch (C1281h e15) {
            e = e15;
            C1548c.m7823a(e);
            throw e;
        } catch (C1290r e16) {
            e = e16;
            C1548c.m7823a(e);
            throw e;
        } catch (C1283j e17) {
            e = e17;
            C1548c.m7823a(e);
            throw e;
        } catch (C1276c e18) {
            e = e18;
            C1548c.m7823a(e);
            throw e;
        } catch (ae e19) {
            e = e19;
            C1548c.m7823a(e);
            throw e;
        } catch (af e20) {
            e = e20;
            C1548c.m7823a(e);
            throw e;
        } catch (Exception e21) {
            C1548c.m7823a(e21);
            C1104b.m6362a((Object) this, e21.getMessage());
            return null;
        }
    }

    public ap m7827a(String str, C1254c c1254c, String str2, String str3) {
        C1292t e;
        try {
            return C1299c.m6862a(this.f5211b).m6591a(this.f5212c, C1309a.m6934a(this.f5211b).m6942b(), str, c1254c, str2, str3);
        } catch (GeneralSecurityException e2) {
            e = e2;
            throw e;
        } catch (aj e3) {
            e = e3;
            throw e;
        } catch (IOException e4) {
            e = e4;
            throw e;
        } catch (JSONException e5) {
            e = e5;
            throw e;
        } catch (C1293u e6) {
            e = e6;
            throw e;
        } catch (C1279f e7) {
            e = e7;
            throw e;
        } catch (ag e8) {
            e = e8;
            throw e;
        } catch (ab e9) {
            e = e9;
            throw e;
        } catch (C1292t e10) {
            e = e10;
            throw e;
        } catch (C1276c e11) {
            e = e11;
            throw e;
        } catch (af e12) {
            e = e12;
            throw e;
        } catch (C1281h e13) {
            e = e13;
            throw e;
        } catch (C1290r e14) {
            e = e14;
            throw e;
        } catch (C1278e e15) {
            e = e15;
            throw e;
        } catch (ae e16) {
            e = e16;
            throw e;
        } catch (C1283j e17) {
            e = e17;
            throw e;
        } catch (Throwable e18) {
            C1104b.m6368b((Object) this, e18);
            return null;
        }
    }

    public aw m7828a(String str, String str2, String str3, String str4) {
        Exception e;
        try {
            return C1299c.m6862a(this.f5211b).m6592a(this.f5212c, C1309a.m6934a(this.f5211b).m6942b(), str, str2, str3, str4);
        } catch (GeneralSecurityException e2) {
            e = e2;
            C1548c.m7823a(e);
            throw e;
        } catch (aj e3) {
            e = e3;
            C1548c.m7823a(e);
            throw e;
        } catch (IOException e4) {
            e = e4;
            C1548c.m7823a(e);
            throw e;
        } catch (JSONException e5) {
            e = e5;
            C1548c.m7823a(e);
            throw e;
        } catch (C1293u e6) {
            e = e6;
            C1548c.m7823a(e);
            throw e;
        } catch (C1279f e7) {
            e = e7;
            C1548c.m7823a(e);
            throw e;
        } catch (ag e8) {
            e = e8;
            C1548c.m7823a(e);
            throw e;
        } catch (ab e9) {
            e = e9;
            C1548c.m7823a(e);
            throw e;
        } catch (C1292t e10) {
            e = e10;
            C1548c.m7823a(e);
            throw e;
        } catch (C1276c e11) {
            e = e11;
            C1548c.m7823a(e);
            throw e;
        } catch (af e12) {
            e = e12;
            C1548c.m7823a(e);
            throw e;
        } catch (C1281h e13) {
            e = e13;
            C1548c.m7823a(e);
            throw e;
        } catch (C1290r e14) {
            e = e14;
            C1548c.m7823a(e);
            throw e;
        } catch (C1278e e15) {
            e = e15;
            C1548c.m7823a(e);
            throw e;
        } catch (ae e16) {
            e = e16;
            C1548c.m7823a(e);
            throw e;
        } catch (C1283j e17) {
            e = e17;
            C1548c.m7823a(e);
            throw e;
        } catch (Throwable e18) {
            C1548c.m7823a((Exception) e18);
            C1104b.m6368b((Object) this, e18);
            return null;
        }
    }

    public bj m7829a(bi[] biVarArr) {
        Exception e;
        try {
            return C1299c.m6862a(this.f5211b).m6593a(this.f5212c, C1309a.m6934a(this.f5211b).m6942b(), biVarArr);
        } catch (GeneralSecurityException e2) {
            e = e2;
            C1548c.m7823a(e);
            throw e;
        } catch (aj e3) {
            e = e3;
            C1548c.m7823a(e);
            throw e;
        } catch (IOException e4) {
            e = e4;
            C1548c.m7823a(e);
            throw e;
        } catch (JSONException e5) {
            e = e5;
            C1548c.m7823a(e);
            throw e;
        } catch (C1293u e6) {
            e = e6;
            C1548c.m7823a(e);
            throw e;
        } catch (C1279f e7) {
            e = e7;
            C1548c.m7823a(e);
            throw e;
        } catch (ag e8) {
            e = e8;
            C1548c.m7823a(e);
            throw e;
        } catch (ab e9) {
            e = e9;
            C1548c.m7823a(e);
            throw e;
        } catch (C1292t e10) {
            e = e10;
            C1548c.m7823a(e);
            throw e;
        } catch (C1276c e11) {
            e = e11;
            C1548c.m7823a(e);
            throw e;
        } catch (af e12) {
            e = e12;
            C1548c.m7823a(e);
            throw e;
        } catch (C1281h e13) {
            e = e13;
            C1548c.m7823a(e);
            throw e;
        } catch (C1290r e14) {
            e = e14;
            C1548c.m7823a(e);
            throw e;
        } catch (C1278e e15) {
            e = e15;
            C1548c.m7823a(e);
            throw e;
        } catch (ae e16) {
            e = e16;
            C1548c.m7823a(e);
            throw e;
        } catch (C1283j e17) {
            e = e17;
            C1548c.m7823a(e);
            throw e;
        } catch (Throwable e18) {
            C1548c.m7823a((Exception) e18);
            C1104b.m6368b((Object) this, e18);
            return null;
        }
    }

    public bm m7830a(bk[] bkVarArr) {
        Exception e;
        try {
            return C1299c.m6862a(this.f5211b).m6594a(this.f5212c, C1309a.m6934a(this.f5211b).m6942b(), bkVarArr);
        } catch (JSONException e2) {
            e = e2;
            C1548c.m7823a(e);
            throw e;
        } catch (GeneralSecurityException e3) {
            e = e3;
            C1548c.m7823a(e);
            throw e;
        } catch (IOException e4) {
            e = e4;
            C1548c.m7823a(e);
            throw e;
        } catch (aj e5) {
            e = e5;
            C1548c.m7823a(e);
            throw e;
        } catch (NumberFormatException e6) {
            e = e6;
            C1548c.m7823a(e);
            throw e;
        } catch (C1293u e7) {
            e = e7;
            C1548c.m7823a(e);
            throw e;
        } catch (C1279f e8) {
            e = e8;
            C1548c.m7823a(e);
            throw e;
        } catch (ag e9) {
            e = e9;
            C1548c.m7823a(e);
            throw e;
        } catch (ab e10) {
            e = e10;
            C1548c.m7823a(e);
            throw e;
        } catch (C1292t e11) {
            e = e11;
            C1548c.m7823a(e);
            throw e;
        } catch (C1276c e12) {
            e = e12;
            C1548c.m7823a(e);
            throw e;
        } catch (af e13) {
            e = e13;
            C1548c.m7823a(e);
            throw e;
        } catch (C1281h e14) {
            e = e14;
            C1548c.m7823a(e);
            throw e;
        } catch (C1290r e15) {
            e = e15;
            C1548c.m7823a(e);
            throw e;
        } catch (C1278e e16) {
            e = e16;
            C1548c.m7823a(e);
            throw e;
        } catch (ae e17) {
            e = e17;
            C1548c.m7823a(e);
            throw e;
        } catch (C1283j e18) {
            e = e18;
            C1548c.m7823a(e);
            throw e;
        } catch (Throwable e19) {
            C1548c.m7823a((Exception) e19);
            C1104b.m6368b((Object) this, e19);
            return null;
        }
    }

    public C1205h m7831a() {
        Exception e;
        try {
            return C1299c.m6862a(this.f5211b).m6595a(this.f5213d);
        } catch (GeneralSecurityException e2) {
            e = e2;
            C1548c.m7823a(e);
            throw e;
        } catch (aj e3) {
            e = e3;
            C1548c.m7823a(e);
            throw e;
        } catch (IOException e4) {
            e = e4;
            C1548c.m7823a(e);
            throw e;
        } catch (JSONException e5) {
            e = e5;
            C1548c.m7823a(e);
            throw e;
        } catch (C1293u e6) {
            e = e6;
            C1548c.m7823a(e);
            throw e;
        } catch (C1279f e7) {
            e = e7;
            C1548c.m7823a(e);
            throw e;
        } catch (ag e8) {
            e = e8;
            C1548c.m7823a(e);
            throw e;
        } catch (ab e9) {
            e = e9;
            C1548c.m7823a(e);
            throw e;
        } catch (C1292t e10) {
            e = e10;
            C1548c.m7823a(e);
            throw e;
        } catch (C1276c e11) {
            e = e11;
            C1548c.m7823a(e);
            throw e;
        } catch (af e12) {
            e = e12;
            C1548c.m7823a(e);
            throw e;
        } catch (C1281h e13) {
            e = e13;
            C1548c.m7823a(e);
            throw e;
        } catch (C1290r e14) {
            e = e14;
            C1548c.m7823a(e);
            throw e;
        } catch (C1278e e15) {
            e = e15;
            C1548c.m7823a(e);
            throw e;
        } catch (ae e16) {
            e = e16;
            C1548c.m7823a(e);
            throw e;
        } catch (C1283j e17) {
            e = e17;
            C1548c.m7823a(e);
            throw e;
        } catch (Throwable e18) {
            C1548c.m7823a((Exception) e18);
            C1104b.m6368b((Object) this, e18);
            return null;
        }
    }

    public C1217w m7832a(String str) {
        Exception e;
        try {
            return C1299c.m6862a(this.f5211b).m6596a(this.f5212c, str);
        } catch (GeneralSecurityException e2) {
            e = e2;
            C1548c.m7823a(e);
            throw e;
        } catch (aj e3) {
            e = e3;
            C1548c.m7823a(e);
            throw e;
        } catch (IOException e4) {
            e = e4;
            C1548c.m7823a(e);
            throw e;
        } catch (JSONException e5) {
            e = e5;
            C1548c.m7823a(e);
            throw e;
        } catch (C1293u e6) {
            e = e6;
            C1548c.m7823a(e);
            throw e;
        } catch (C1279f e7) {
            e = e7;
            C1548c.m7823a(e);
            throw e;
        } catch (aa e8) {
            e = e8;
            C1548c.m7823a(e);
            throw e;
        } catch (ag e9) {
            e = e9;
            C1548c.m7823a(e);
            throw e;
        } catch (ab e10) {
            e = e10;
            C1548c.m7823a(e);
            throw e;
        } catch (C1292t e11) {
            e = e11;
            C1548c.m7823a(e);
            throw e;
        } catch (C1276c e12) {
            e = e12;
            C1548c.m7823a(e);
            throw e;
        } catch (C1277d e13) {
            e = e13;
            C1548c.m7823a(e);
            throw e;
        } catch (C1281h e14) {
            e = e14;
            C1548c.m7823a(e);
            throw e;
        } catch (C1290r e15) {
            e = e15;
            C1548c.m7823a(e);
            throw e;
        } catch (C1283j e16) {
            e = e16;
            C1548c.m7823a(e);
            throw e;
        } catch (C1278e e17) {
            e = e17;
            C1548c.m7823a(e);
            throw e;
        } catch (ae e18) {
            e = e18;
            C1548c.m7823a(e);
            throw e;
        } catch (af e19) {
            e = e19;
            C1548c.m7823a(e);
            throw e;
        } catch (Throwable e20) {
            C1548c.m7823a((Exception) e20);
            C1104b.m6368b((Object) this, e20);
            return null;
        }
    }

    public C1207j m7833b() {
        Exception e;
        try {
            return C1299c.m6862a(this.f5211b).m6597b(this.f5213d, C1309a.m6934a(this.f5211b).m6942b());
        } catch (GeneralSecurityException e2) {
            e = e2;
            C1548c.m7823a(e);
            throw e;
        } catch (aj e3) {
            e = e3;
            C1548c.m7823a(e);
            throw e;
        } catch (IOException e4) {
            e = e4;
            C1548c.m7823a(e);
            throw e;
        } catch (JSONException e5) {
            e = e5;
            C1548c.m7823a(e);
            throw e;
        } catch (C1293u e6) {
            e = e6;
            C1548c.m7823a(e);
            throw e;
        } catch (C1279f e7) {
            e = e7;
            C1548c.m7823a(e);
            throw e;
        } catch (ag e8) {
            e = e8;
            C1548c.m7823a(e);
            throw e;
        } catch (ab e9) {
            e = e9;
            C1548c.m7823a(e);
            throw e;
        } catch (C1292t e10) {
            e = e10;
            C1548c.m7823a(e);
            throw e;
        } catch (C1276c e11) {
            e = e11;
            C1548c.m7823a(e);
            throw e;
        } catch (af e12) {
            e = e12;
            C1548c.m7823a(e);
            throw e;
        } catch (C1281h e13) {
            e = e13;
            C1548c.m7823a(e);
            throw e;
        } catch (C1290r e14) {
            e = e14;
            C1548c.m7823a(e);
            throw e;
        } catch (C1278e e15) {
            e = e15;
            C1548c.m7823a(e);
            throw e;
        } catch (ae e16) {
            e = e16;
            C1548c.m7823a(e);
            throw e;
        } catch (C1283j e17) {
            e = e17;
            C1548c.m7823a(e);
            throw e;
        } catch (Throwable e18) {
            C1548c.m7823a((Exception) e18);
            C1104b.m6368b((Object) this, e18);
            return null;
        }
    }

    public au m7834c() {
        Exception e;
        try {
            return C1299c.m6862a(this.f5211b).m6598c(this.f5212c, C1309a.m6934a(this.f5211b).m6942b());
        } catch (GeneralSecurityException e2) {
            e = e2;
            C1548c.m7823a(e);
            throw e;
        } catch (aj e3) {
            e = e3;
            C1548c.m7823a(e);
            throw e;
        } catch (IOException e4) {
            e = e4;
            C1548c.m7823a(e);
            throw e;
        } catch (JSONException e5) {
            e = e5;
            C1548c.m7823a(e);
            throw e;
        } catch (C1293u e6) {
            e = e6;
            C1548c.m7823a(e);
            throw e;
        } catch (C1279f e7) {
            e = e7;
            C1548c.m7823a(e);
            throw e;
        } catch (ag e8) {
            e = e8;
            C1548c.m7823a(e);
            throw e;
        } catch (ab e9) {
            e = e9;
            C1548c.m7823a(e);
            throw e;
        } catch (C1292t e10) {
            e = e10;
            C1548c.m7823a(e);
            throw e;
        } catch (C1276c e11) {
            e = e11;
            C1548c.m7823a(e);
            throw e;
        } catch (af e12) {
            e = e12;
            C1548c.m7823a(e);
            throw e;
        } catch (C1281h e13) {
            e = e13;
            C1548c.m7823a(e);
            throw e;
        } catch (C1290r e14) {
            e = e14;
            C1548c.m7823a(e);
            throw e;
        } catch (C1278e e15) {
            e = e15;
            C1548c.m7823a(e);
            throw e;
        } catch (ae e16) {
            e = e16;
            C1548c.m7823a(e);
            throw e;
        } catch (C1283j e17) {
            e = e17;
            C1548c.m7823a(e);
            throw e;
        } catch (Throwable e18) {
            C1548c.m7823a((Exception) e18);
            C1104b.m6368b((Object) this, e18);
            return null;
        }
    }

    public C1219y m7835d() {
        Exception e;
        try {
            return C1299c.m6862a(this.f5211b).m6599d(this.f5213d, C1309a.m6934a(this.f5211b).m6942b());
        } catch (GeneralSecurityException e2) {
            e = e2;
            C1548c.m7823a(e);
            throw e;
        } catch (aj e3) {
            e = e3;
            C1548c.m7823a(e);
            throw e;
        } catch (IOException e4) {
            e = e4;
            C1548c.m7823a(e);
            throw e;
        } catch (JSONException e5) {
            e = e5;
            C1548c.m7823a(e);
            throw e;
        } catch (C1293u e6) {
            e = e6;
            C1548c.m7823a(e);
            throw e;
        } catch (C1279f e7) {
            e = e7;
            C1548c.m7823a(e);
            throw e;
        } catch (ag e8) {
            e = e8;
            C1548c.m7823a(e);
            throw e;
        } catch (ab e9) {
            e = e9;
            C1548c.m7823a(e);
            throw e;
        } catch (C1292t e10) {
            e = e10;
            C1548c.m7823a(e);
            throw e;
        } catch (C1276c e11) {
            e = e11;
            C1548c.m7823a(e);
            throw e;
        } catch (af e12) {
            e = e12;
            C1548c.m7823a(e);
            throw e;
        } catch (C1281h e13) {
            e = e13;
            C1548c.m7823a(e);
            throw e;
        } catch (C1290r e14) {
            e = e14;
            C1548c.m7823a(e);
            throw e;
        } catch (C1278e e15) {
            e = e15;
            C1548c.m7823a(e);
            throw e;
        } catch (ae e16) {
            e = e16;
            C1548c.m7823a(e);
            throw e;
        } catch (C1283j e17) {
            e = e17;
            C1548c.m7823a(e);
            throw e;
        } catch (Throwable e18) {
            C1548c.m7823a((Exception) e18);
            C1104b.m6368b((Object) this, e18);
            return null;
        }
    }
}
