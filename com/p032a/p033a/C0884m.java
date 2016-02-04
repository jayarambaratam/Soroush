package com.p032a.p033a;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.p032a.p033a.p037d.p046c.C0677s;
import com.p032a.p033a.p042j.C0879h;
import com.p032a.p033a.p055e.C0777j;
import com.p032a.p033a.p055e.C0809i;
import com.p032a.p033a.p055e.C0814e;
import com.p032a.p033a.p055e.C0817p;
import com.p032a.p033a.p055e.C0824q;
import com.p032a.p033a.p061i.C0869a;

/* renamed from: com.a.a.m */
public class C0884m implements C0777j {
    private final Context f3084a;
    private final C0809i f3085b;
    private final C0817p f3086c;
    private final C0824q f3087d;
    private final C0872i f3088e;
    private final C0889r f3089f;
    private C0886o f3090g;

    public C0884m(Context context, C0809i c0809i, C0817p c0817p) {
        this(context, c0809i, c0817p, new C0824q(), new C0814e());
    }

    C0884m(Context context, C0809i c0809i, C0817p c0817p, C0824q c0824q, C0814e c0814e) {
        this.f3084a = context.getApplicationContext();
        this.f3085b = c0809i;
        this.f3086c = c0817p;
        this.f3087d = c0824q;
        this.f3088e = C0872i.m5264a(context);
        this.f3089f = new C0889r(this);
        C0777j a = c0814e.m5055a(context, new C0890s(c0824q));
        if (C0879h.m5312d()) {
            new Handler(Looper.getMainLooper()).post(new C0885n(this, c0809i));
        } else {
            c0809i.m5048a(this);
        }
        c0809i.m5048a(a);
    }

    private <T> C0808d<T> m5319a(Class<T> cls) {
        C0677s a = C0872i.m5262a((Class) cls, this.f3084a);
        C0677s b = C0872i.m5269b((Class) cls, this.f3084a);
        if (cls != null && a == null && b == null) {
            throw new IllegalArgumentException("Unknown type " + cls + ". You must provide a Model of a type for" + " which there is a registered ModelLoader, if you are using a custom model, you must first call" + " Glide#register with a ModelLoaderFactory for your custom model class");
        }
        return (C0808d) this.f3089f.m5346a(new C0808d(cls, a, b, this.f3084a, this.f3088e, this.f3087d, this.f3085b, this.f3089f));
    }

    private static <T> Class<T> m5322b(T t) {
        return t != null ? t.getClass() : null;
    }

    public C0808d<Uri> m5327a(Uri uri) {
        return (C0808d) m5339h().m4414a((Object) uri);
    }

    public C0808d<Integer> m5328a(Integer num) {
        return (C0808d) m5340i().m4414a((Object) num);
    }

    public C0808d<String> m5329a(String str) {
        return (C0808d) m5338g().m4414a((Object) str);
    }

    public <A, T> C0887p<A, T> m5330a(C0677s<A, T> c0677s, Class<T> cls) {
        return new C0887p(this, c0677s, cls);
    }

    public void m5331a() {
        this.f3088e.m5285i();
    }

    public void m5332a(int i) {
        this.f3088e.m5275a(i);
    }

    public void m5333b() {
        C0879h.m5307a();
        this.f3087d.m5085a();
    }

    public void m5334c() {
        C0879h.m5307a();
        this.f3087d.m5087b();
    }

    public void m5335d() {
        m5334c();
    }

    public void m5336e() {
        m5333b();
    }

    public void m5337f() {
        this.f3087d.m5089c();
    }

    public C0808d<String> m5338g() {
        return m5319a(String.class);
    }

    public C0808d<Uri> m5339h() {
        return m5319a(Uri.class);
    }

    public C0808d<Integer> m5340i() {
        return (C0808d) m5319a(Integer.class).m4411a(C0869a.m5257a(this.f3084a));
    }
}
