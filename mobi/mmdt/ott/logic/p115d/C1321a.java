package mobi.mmdt.ott.logic.p115d;

import java.security.GeneralSecurityException;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.logic.C1486a;
import mobi.mmdt.ott.logic.p112a.p154k.C1485b;
import mobi.mmdt.ott.p095c.p107c.C1275b;
import mobi.mmdt.ott.p095c.p107c.C1276c;
import mobi.mmdt.ott.p095c.p107c.C1279f;
import mobi.mmdt.ott.p095c.p107c.C1283j;
import mobi.mmdt.ott.p095c.p107c.C1290r;
import mobi.mmdt.ott.p095c.p107c.C1293u;
import mobi.mmdt.ott.p095c.p107c.ae;
import mobi.mmdt.ott.p095c.p107c.af;
import mobi.mmdt.ott.p095c.p107c.ah;
import mobi.mmdt.ott.p095c.p107c.aj;
import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smack.SmackException.ConnectionException;
import org.json.JSONException;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.d.a */
public abstract class C1321a {
    private C1486a f4596a;

    public C1321a(Throwable th) {
        this.f4596a = m6996a(th);
    }

    public C1486a m6996a(Throwable th) {
        C1486a c1486a = null;
        if (!(th instanceof GeneralSecurityException)) {
            if (th instanceof aj) {
                int a = ((aj) th).m6859a();
                c1486a = a == 355 ? C1486a.INVALID_VOTE_DATA : a == 353 ? C1486a.YOU_ALREADY_VOTED : C1486a.WEB_SERVICE_ERROR;
            } else if (th instanceof C1290r) {
                c1486a = C1486a.NOT_AUTHORIZED;
            } else if (th instanceof ae) {
                c1486a = C1486a.UNKNOWN_SECURITY_ERROR;
            } else if (th instanceof C1276c) {
                c1486a = C1486a.IP_BLOCKED;
            } else if (th instanceof C1283j) {
                c1486a = C1486a.INVALID_REQUEST_ID;
            } else if (th instanceof ConnectionException) {
                c1486a = C1486a.CONNECTION_ERROR;
            } else if (!(th instanceof JSONException)) {
                if (th instanceof af) {
                    c1486a = C1486a.UNKNOWN_SERVER_ERROR;
                } else if (th instanceof C1293u) {
                    c1486a = C1486a.OLD_VERSION_ERROR;
                    C0002c.m2a().m17c(new C1485b());
                } else if (th instanceof ah) {
                    c1486a = C1486a.USER_NOT_HAVE_PERMISSION;
                } else if (th instanceof C1275b) {
                    c1486a = C1486a.FILE_TOO_LARGE;
                } else if (!(th instanceof C1279f)) {
                    c1486a = C1486a.UNEXPECTED_ERROR;
                    C1104b.m6363a(C1321a.class, "Un handled error", th);
                }
            }
        }
        C1104b.m6362a((Object) C1321a.class, "*********  error : " + c1486a);
        C1104b.m6367b(C1321a.class, BuildConfig.FLAVOR, th);
        return c1486a;
    }

    public C1486a m6997d() {
        return this.f4596a;
    }
}
