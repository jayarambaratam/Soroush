package com.p032a.p033a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.C0145q;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.p032a.p033a.p037d.C0598a;
import com.p032a.p033a.p037d.p039b.C0655f;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;
import com.p032a.p033a.p037d.p039b.p041b.C0632o;
import com.p032a.p033a.p037d.p039b.p044d.C0650a;
import com.p032a.p033a.p037d.p046c.C0677s;
import com.p032a.p033a.p037d.p046c.C0681t;
import com.p032a.p033a.p037d.p046c.C0709c;
import com.p032a.p033a.p037d.p046c.C0711e;
import com.p032a.p033a.p037d.p046c.C0716j;
import com.p032a.p033a.p037d.p046c.p047a.C0682b;
import com.p032a.p033a.p037d.p046c.p047a.C0685e;
import com.p032a.p033a.p037d.p046c.p047a.C0688g;
import com.p032a.p033a.p037d.p046c.p047a.C0691i;
import com.p032a.p033a.p037d.p046c.p048b.C0694b;
import com.p032a.p033a.p037d.p046c.p048b.C0697d;
import com.p032a.p033a.p037d.p046c.p048b.C0699f;
import com.p032a.p033a.p037d.p046c.p048b.C0701i;
import com.p032a.p033a.p037d.p046c.p048b.C0703k;
import com.p032a.p033a.p037d.p046c.p048b.C0705m;
import com.p032a.p033a.p037d.p046c.p048b.C0708o;
import com.p032a.p033a.p037d.p049d.p050a.C0732e;
import com.p032a.p033a.p037d.p049d.p050a.C0738j;
import com.p032a.p033a.p037d.p049d.p050a.C0741l;
import com.p032a.p033a.p037d.p049d.p050a.C0743m;
import com.p032a.p033a.p037d.p049d.p050a.C0752u;
import com.p032a.p033a.p037d.p049d.p050a.C0755x;
import com.p032a.p033a.p037d.p049d.p052b.C0742b;
import com.p032a.p033a.p037d.p049d.p053c.C0765e;
import com.p032a.p033a.p037d.p049d.p054d.C0770b;
import com.p032a.p033a.p037d.p049d.p054d.C0772d;
import com.p032a.p033a.p037d.p049d.p057e.C0793a;
import com.p032a.p033a.p037d.p049d.p057e.C0800h;
import com.p032a.p033a.p037d.p049d.p057e.C0801i;
import com.p032a.p033a.p037d.p049d.p058f.C0802c;
import com.p032a.p033a.p037d.p049d.p058f.C0803a;
import com.p032a.p033a.p037d.p049d.p058f.C0804b;
import com.p032a.p033a.p037d.p049d.p058f.C0805d;
import com.p032a.p033a.p042j.C0879h;
import com.p032a.p033a.p045h.C0860d;
import com.p032a.p033a.p045h.p056b.C0778k;
import com.p032a.p033a.p045h.p056b.C0854f;
import com.p032a.p033a.p051g.C0737b;
import com.p032a.p033a.p051g.C0833c;
import com.p032a.p033a.p055e.C0823o;
import com.p032a.p033a.p059f.C0828a;
import com.p032a.p033a.p059f.C0829b;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/* renamed from: com.a.a.i */
public class C0872i {
    private static volatile C0872i f3040a;
    private final C0709c f3041b;
    private final C0655f f3042c;
    private final C0605e f3043d;
    private final C0632o f3044e;
    private final C0598a f3045f;
    private final C0854f f3046g;
    private final C0805d f3047h;
    private final C0833c f3048i;
    private final C0732e f3049j;
    private final C0800h f3050k;
    private final C0741l f3051l;
    private final C0800h f3052m;
    private final Handler f3053n;
    private final C0650a f3054o;

    C0872i(C0655f c0655f, C0632o c0632o, C0605e c0605e, Context context, C0598a c0598a) {
        this.f3046g = new C0854f();
        this.f3047h = new C0805d();
        this.f3042c = c0655f;
        this.f3043d = c0605e;
        this.f3044e = c0632o;
        this.f3045f = c0598a;
        this.f3041b = new C0709c(context);
        this.f3053n = new Handler(Looper.getMainLooper());
        this.f3054o = new C0650a(c0632o, c0605e, c0598a);
        this.f3048i = new C0833c();
        C0737b c0755x = new C0755x(c0605e, c0598a);
        this.f3048i.m5118a(InputStream.class, Bitmap.class, c0755x);
        C0737b c0738j = new C0738j(c0605e, c0598a);
        this.f3048i.m5118a(ParcelFileDescriptor.class, Bitmap.class, c0738j);
        C0737b c0752u = new C0752u(c0755x, c0738j);
        this.f3048i.m5118a(C0716j.class, Bitmap.class, c0752u);
        c0755x = new C0772d(context, c0605e);
        this.f3048i.m5118a(InputStream.class, C0770b.class, c0755x);
        this.f3048i.m5118a(C0716j.class, C0793a.class, new C0801i(c0752u, c0755x, c0605e));
        this.f3048i.m5118a(InputStream.class, File.class, new C0765e());
        m5276a(File.class, ParcelFileDescriptor.class, new C0682b());
        m5276a(File.class, InputStream.class, new C0699f());
        m5276a(Integer.TYPE, ParcelFileDescriptor.class, new C0685e());
        m5276a(Integer.TYPE, InputStream.class, new C0701i());
        m5276a(Integer.class, ParcelFileDescriptor.class, new C0685e());
        m5276a(Integer.class, InputStream.class, new C0701i());
        m5276a(String.class, ParcelFileDescriptor.class, new C0688g());
        m5276a(String.class, InputStream.class, new C0703k());
        m5276a(Uri.class, ParcelFileDescriptor.class, new C0691i());
        m5276a(Uri.class, InputStream.class, new C0705m());
        m5276a(URL.class, InputStream.class, new C0708o());
        m5276a(C0711e.class, InputStream.class, new C0694b());
        m5276a(byte[].class, InputStream.class, new C0697d());
        this.f3047h.m5040a(Bitmap.class, C0743m.class, new C0804b(context.getResources(), c0605e));
        this.f3047h.m5040a(C0793a.class, C0742b.class, new C0803a(new C0804b(context.getResources(), c0605e)));
        this.f3049j = new C0732e(c0605e);
        this.f3050k = new C0800h(c0605e, this.f3049j);
        this.f3051l = new C0741l(c0605e);
        this.f3052m = new C0800h(c0605e, this.f3051l);
    }

    public static <T> C0677s<T, InputStream> m5262a(Class<T> cls, Context context) {
        return C0872i.m5263a((Class) cls, InputStream.class, context);
    }

    public static <T, Y> C0677s<T, Y> m5263a(Class<T> cls, Class<Y> cls2, Context context) {
        if (cls != null) {
            return C0872i.m5264a(context).m5271j().m4753a(cls, cls2);
        }
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Unable to load null model, setting placeholder only");
        }
        return null;
    }

    public static C0872i m5264a(Context context) {
        if (f3040a == null) {
            synchronized (C0872i.class) {
                if (f3040a == null) {
                    Context applicationContext = context.getApplicationContext();
                    List<C0828a> a = new C0829b(applicationContext).m5105a();
                    C0882k c0882k = new C0882k(applicationContext);
                    for (C0828a a2 : a) {
                        a2.m5103a(applicationContext, c0882k);
                    }
                    f3040a = c0882k.m5317a();
                    for (C0828a a22 : a) {
                        a22.m5102a(applicationContext, f3040a);
                    }
                }
            }
        }
        return f3040a;
    }

    public static C0884m m5265a(Activity activity) {
        return C0823o.m5075a().m5080a(activity);
    }

    public static C0884m m5266a(C0145q c0145q) {
        return C0823o.m5075a().m5084a(c0145q);
    }

    public static void m5267a(View view) {
        C0872i.m5268a(new C0881j(view));
    }

    public static void m5268a(C0778k<?> c0778k) {
        C0879h.m5307a();
        C0860d a = c0778k.m4952a();
        if (a != null) {
            a.m5187d();
            c0778k.m4955a(null);
        }
    }

    public static <T> C0677s<T, ParcelFileDescriptor> m5269b(Class<T> cls, Context context) {
        return C0872i.m5263a((Class) cls, ParcelFileDescriptor.class, context);
    }

    public static C0884m m5270b(Context context) {
        return C0823o.m5075a().m5081a(context);
    }

    private C0709c m5271j() {
        return this.f3041b;
    }

    public C0605e m5272a() {
        return this.f3043d;
    }

    <Z, R> C0802c<Z, R> m5273a(Class<Z> cls, Class<R> cls2) {
        return this.f3047h.m5039a(cls, cls2);
    }

    <R> C0778k<R> m5274a(ImageView imageView, Class<R> cls) {
        return this.f3046g.m5170a(imageView, cls);
    }

    public void m5275a(int i) {
        this.f3043d.m4510a(i);
        this.f3044e.m4607a(i);
    }

    public <T, Y> void m5276a(Class<T> cls, Class<Y> cls2, C0681t<T, Y> c0681t) {
        C0681t a = this.f3041b.m4754a((Class) cls, (Class) cls2, (C0681t) c0681t);
        if (a != null) {
            a.m4704a();
        }
    }

    C0655f m5277b() {
        return this.f3042c;
    }

    <T, Z> C0737b<T, Z> m5278b(Class<T> cls, Class<Z> cls2) {
        return this.f3048i.m5117a(cls, cls2);
    }

    C0732e m5279c() {
        return this.f3049j;
    }

    C0741l m5280d() {
        return this.f3051l;
    }

    C0800h m5281e() {
        return this.f3050k;
    }

    C0800h m5282f() {
        return this.f3052m;
    }

    Handler m5283g() {
        return this.f3053n;
    }

    C0598a m5284h() {
        return this.f3045f;
    }

    public void m5285i() {
        this.f3043d.m4509a();
        this.f3044e.m4606a();
    }
}
