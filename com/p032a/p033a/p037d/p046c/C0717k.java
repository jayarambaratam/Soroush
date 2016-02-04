package com.p032a.p033a.p037d.p046c;

import android.os.ParcelFileDescriptor;
import com.p032a.p033a.p037d.C0676b;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.a.a.d.c.k */
public class C0717k implements C0676b<C0716j> {
    private final C0676b<InputStream> f2728a;
    private final C0676b<ParcelFileDescriptor> f2729b;
    private String f2730c;

    public C0717k(C0676b<InputStream> c0676b, C0676b<ParcelFileDescriptor> c0676b2) {
        this.f2728a = c0676b;
        this.f2729b = c0676b2;
    }

    public String m4771a() {
        if (this.f2730c == null) {
            this.f2730c = this.f2728a.m4698a() + this.f2729b.m4698a();
        }
        return this.f2730c;
    }

    public boolean m4772a(C0716j c0716j, OutputStream outputStream) {
        return c0716j.m4769a() != null ? this.f2728a.m4699a(c0716j.m4769a(), outputStream) : this.f2729b.m4699a(c0716j.m4770b(), outputStream);
    }
}
