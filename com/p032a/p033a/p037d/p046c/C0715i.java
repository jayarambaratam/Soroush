package com.p032a.p033a.p037d.p046c;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.p032a.p033a.C0883l;
import com.p032a.p033a.p037d.p038a.C0586c;
import java.io.InputStream;

/* renamed from: com.a.a.d.c.i */
class C0715i implements C0586c<C0716j> {
    private final C0586c<InputStream> f2724a;
    private final C0586c<ParcelFileDescriptor> f2725b;

    public C0715i(C0586c<InputStream> c0586c, C0586c<ParcelFileDescriptor> c0586c2) {
        this.f2724a = c0586c;
        this.f2725b = c0586c2;
    }

    public /* synthetic */ Object m4764a(C0883l c0883l) {
        return m4766b(c0883l);
    }

    public void m4765a() {
        if (this.f2724a != null) {
            this.f2724a.m4439a();
        }
        if (this.f2725b != null) {
            this.f2725b.m4439a();
        }
    }

    public C0716j m4766b(C0883l c0883l) {
        InputStream inputStream;
        ParcelFileDescriptor parcelFileDescriptor = null;
        if (this.f2724a != null) {
            try {
                inputStream = (InputStream) this.f2724a.m4438a(c0883l);
            } catch (Throwable e) {
                if (Log.isLoggable("IVML", 2)) {
                    Log.v("IVML", "Exception fetching input stream, trying ParcelFileDescriptor", e);
                }
                if (this.f2725b == null) {
                    throw e;
                }
            }
            if (this.f2725b != null) {
                try {
                    parcelFileDescriptor = (ParcelFileDescriptor) this.f2725b.m4438a(c0883l);
                } catch (Throwable e2) {
                    if (Log.isLoggable("IVML", 2)) {
                        Log.v("IVML", "Exception fetching ParcelFileDescriptor", e2);
                    }
                    if (inputStream == null) {
                        throw e2;
                    }
                }
            }
            return new C0716j(inputStream, parcelFileDescriptor);
        }
        inputStream = null;
        if (this.f2725b != null) {
            parcelFileDescriptor = (ParcelFileDescriptor) this.f2725b.m4438a(c0883l);
        }
        return new C0716j(inputStream, parcelFileDescriptor);
    }

    public String m4767b() {
        return this.f2724a != null ? this.f2724a.m4440b() : this.f2725b.m4440b();
    }

    public void m4768c() {
        if (this.f2724a != null) {
            this.f2724a.m4441c();
        }
        if (this.f2725b != null) {
            this.f2725b.m4441c();
        }
    }
}
