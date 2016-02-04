package com.p032a.p033a.p034a;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: com.a.a.a.g */
class C0572g extends ByteArrayOutputStream {
    final /* synthetic */ C0571f f2378a;

    C0572g(C0571f c0571f, int i) {
        this.f2378a = c0571f;
        super(i);
    }

    public String toString() {
        int i = (this.count <= 0 || this.buf[this.count - 1] != 13) ? this.count : this.count - 1;
        try {
            return new String(this.buf, 0, i, this.f2378a.f2374b.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
