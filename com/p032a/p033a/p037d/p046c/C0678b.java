package com.p032a.p033a.p037d.p046c;

import android.net.Uri;
import com.p032a.p033a.p037d.p038a.C0586c;
import java.io.File;

/* renamed from: com.a.a.d.c.b */
public class C0678b<T> implements C0677s<File, T> {
    private final C0677s<Uri, T> f2700a;

    public C0678b(C0677s<Uri, T> c0677s) {
        this.f2700a = c0677s;
    }

    public C0586c<T> m4701a(File file, int i, int i2) {
        return this.f2700a.m4700a(Uri.fromFile(file), i, i2);
    }
}
