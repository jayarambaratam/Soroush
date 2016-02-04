package com.p032a.p033a.p037d.p046c;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.myHttp.HttpHeaders;
import org.apache.http.myHttp.protocol.HTTP;

/* renamed from: com.a.a.d.c.n */
public final class C0720n {
    private static final String f2733a;
    private static final Map<String, List<C0718l>> f2734b;
    private boolean f2735c;
    private boolean f2736d;
    private Map<String, List<C0718l>> f2737e;
    private boolean f2738f;

    static {
        f2733a = System.getProperty("http.agent");
        Map hashMap = new HashMap(2);
        if (!TextUtils.isEmpty(f2733a)) {
            hashMap.put(HTTP.USER_AGENT, Collections.singletonList(new C0721o(f2733a)));
        }
        hashMap.put(HttpHeaders.ACCEPT_ENCODING, Collections.singletonList(new C0721o(HTTP.IDENTITY_CODING)));
        f2734b = Collections.unmodifiableMap(hashMap);
    }

    public C0720n() {
        this.f2735c = true;
        this.f2736d = true;
        this.f2737e = f2734b;
        this.f2738f = this.f2737e.containsKey(f2733a);
    }

    public C0719m m4777a() {
        this.f2735c = true;
        return new C0719m(this.f2737e);
    }
}
