package mobi.mmdt.ott.p095c.p106b;

import android.content.Context;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import mobi.mmdt.ott.p095c.C1272b;
import org.jivesoftware.smack.util.TLSUtils;

/* renamed from: mobi.mmdt.ott.c.b.a */
public class C1265a {
    public static HttpURLConnection m6853a(Context context, URL url, boolean z) {
        System.setProperty("http.keepAlive", "false");
        if (url.toString().startsWith("https")) {
            HttpsURLConnection.setDefaultSSLSocketFactory(new C1267c());
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setSSLSocketFactory(C1265a.m6855a(context));
            httpsURLConnection.setHostnameVerifier(C1265a.m6854a());
            if (z) {
                httpsURLConnection.setConnectTimeout(60000);
                httpsURLConnection.setReadTimeout(60000);
            }
            httpsURLConnection.setUseCaches(false);
            return httpsURLConnection;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setUseCaches(false);
        return httpURLConnection;
    }

    private static HostnameVerifier m6854a() {
        return new C1266b();
    }

    private static SSLSocketFactory m6855a(Context context) {
        KeyStore instance = KeyStore.getInstance("BKS");
        InputStream openRawResource = context.getResources().openRawResource(C1272b.soroush_servers_certificate);
        try {
            instance.load(openRawResource, "mysecret".toCharArray());
            TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance2.init(instance);
            SSLContext instance3 = SSLContext.getInstance(TLSUtils.TLS);
            instance3.init(null, instance2.getTrustManagers(), new SecureRandom());
            return instance3.getSocketFactory();
        } finally {
            openRawResource.close();
        }
    }
}
