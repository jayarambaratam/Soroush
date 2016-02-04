package mobi.mmdt.ott.p095c.p106b;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* renamed from: mobi.mmdt.ott.c.b.b */
final class C1266b implements HostnameVerifier {
    C1266b() {
    }

    public boolean verify(String str, SSLSession sSLSession) {
        return sSLSession.isValid() && str.equals(sSLSession.getPeerHost());
    }
}
