package com.p032a.p033a.p037d.p038a;

import android.text.TextUtils;
import android.util.Log;
import com.p032a.p033a.C0883l;
import com.p032a.p033a.p037d.p046c.C0711e;
import com.p032a.p033a.p042j.C0874b;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.myHttp.HttpHeaders;

/* renamed from: com.a.a.d.a.f */
public class C0592f implements C0586c<InputStream> {
    private static final C0594i f2525a;
    private final C0711e f2526b;
    private final C0594i f2527c;
    private HttpURLConnection f2528d;
    private InputStream f2529e;
    private volatile boolean f2530f;

    static {
        f2525a = new C0595h();
    }

    public C0592f(C0711e c0711e) {
        this(c0711e, f2525a);
    }

    C0592f(C0711e c0711e, C0594i c0594i) {
        this.f2526b = c0711e;
        this.f2527c = c0594i;
    }

    private InputStream m4467a(HttpURLConnection httpURLConnection) {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f2529e = C0874b.m5290a(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f2529e = httpURLConnection.getInputStream();
        }
        return this.f2529e;
    }

    private InputStream m4468a(URL url, int i, URL url2, Map<String, String> map) {
        if (i >= 5) {
            throw new IOException("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new IOException("In re-direct loop");
                }
            } catch (URISyntaxException e) {
            }
        }
        this.f2528d = this.f2527c.m4474a(url);
        for (Entry entry : map.entrySet()) {
            this.f2528d.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        this.f2528d.setConnectTimeout(2500);
        this.f2528d.setReadTimeout(2500);
        this.f2528d.setUseCaches(false);
        this.f2528d.setDoInput(true);
        this.f2528d.connect();
        if (this.f2530f) {
            return null;
        }
        int responseCode = this.f2528d.getResponseCode();
        if (responseCode / 100 == 2) {
            return m4467a(this.f2528d);
        }
        if (responseCode / 100 == 3) {
            Object headerField = this.f2528d.getHeaderField(HttpHeaders.LOCATION);
            if (!TextUtils.isEmpty(headerField)) {
                return m4468a(new URL(url, headerField), i + 1, url, map);
            }
            throw new IOException("Received empty or null redirect url");
        } else if (responseCode == -1) {
            throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
        } else {
            throw new IOException("Request failed " + responseCode + ": " + this.f2528d.getResponseMessage());
        }
    }

    public /* synthetic */ Object m4469a(C0883l c0883l) {
        return m4471b(c0883l);
    }

    public void m4470a() {
        if (this.f2529e != null) {
            try {
                this.f2529e.close();
            } catch (IOException e) {
            }
        }
        if (this.f2528d != null) {
            this.f2528d.disconnect();
        }
    }

    public InputStream m4471b(C0883l c0883l) {
        return m4468a(this.f2526b.m4758a(), 0, null, this.f2526b.m4759b());
    }

    public String m4472b() {
        return this.f2526b.m4760c();
    }

    public void m4473c() {
        this.f2530f = true;
    }
}
