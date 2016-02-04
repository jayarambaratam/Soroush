package com.p032a.p033a.p037d.p049d;

import com.p032a.p033a.p037d.C0676b;
import java.io.OutputStream;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: com.a.a.d.d.a */
public class C0758a<T> implements C0676b<T> {
    private static final C0758a<?> f2809a;

    static {
        f2809a = new C0758a();
    }

    public static <T> C0676b<T> m4894b() {
        return f2809a;
    }

    public String m4895a() {
        return BuildConfig.FLAVOR;
    }

    public boolean m4896a(T t, OutputStream outputStream) {
        return false;
    }
}
