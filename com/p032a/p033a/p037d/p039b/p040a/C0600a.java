package com.p032a.p033a.p037d.p039b.p040a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.p032a.p033a.p042j.C0879h;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* renamed from: com.a.a.d.b.a.a */
class C0600a implements C0599m {
    private final C0604c f2536a;
    private final C0607g<C0602b, Bitmap> f2537b;

    C0600a() {
        this.f2536a = new C0604c();
        this.f2537b = new C0607g();
    }

    private static String m4491d(int i, int i2, Config config) {
        return "[" + i + DataForm.ELEMENT + i2 + "], " + config;
    }

    private static String m4492d(Bitmap bitmap) {
        return C0600a.m4491d(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public Bitmap m4493a() {
        return (Bitmap) this.f2537b.m4522a();
    }

    public Bitmap m4494a(int i, int i2, Config config) {
        return (Bitmap) this.f2537b.m4523a(this.f2536a.m4506a(i, i2, config));
    }

    public void m4495a(Bitmap bitmap) {
        this.f2537b.m4524a(this.f2536a.m4506a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public String m4496b(int i, int i2, Config config) {
        return C0600a.m4491d(i, i2, config);
    }

    public String m4497b(Bitmap bitmap) {
        return C0600a.m4492d(bitmap);
    }

    public int m4498c(Bitmap bitmap) {
        return C0879h.m5302a(bitmap);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f2537b;
    }
}
