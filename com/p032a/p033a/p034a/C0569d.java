package com.p032a.p033a.p034a;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.a.a.a.d */
final class C0569d {
    File[] f2360a;
    File[] f2361b;
    final /* synthetic */ C0566a f2362c;
    private final String f2363d;
    private final long[] f2364e;
    private boolean f2365f;
    private C0568c f2366g;
    private long f2367h;

    private C0569d(C0566a c0566a, String str) {
        this.f2362c = c0566a;
        this.f2363d = str;
        this.f2364e = new long[c0566a.f2348h];
        this.f2360a = new File[c0566a.f2348h];
        this.f2361b = new File[c0566a.f2348h];
        StringBuilder append = new StringBuilder(str).append('.');
        int length = append.length();
        for (int i = 0; i < c0566a.f2348h; i++) {
            append.append(i);
            this.f2360a[i] = new File(c0566a.f2342b, append.toString());
            append.append(".tmp");
            this.f2361b[i] = new File(c0566a.f2342b, append.toString());
            append.setLength(length);
        }
    }

    private void m4262a(String[] strArr) {
        if (strArr.length != this.f2362c.f2348h) {
            throw m4264b(strArr);
        }
        int i = 0;
        while (i < strArr.length) {
            try {
                this.f2364e[i] = Long.parseLong(strArr[i]);
                i++;
            } catch (NumberFormatException e) {
                throw m4264b(strArr);
            }
        }
    }

    private IOException m4264b(String[] strArr) {
        throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
    }

    public File m4269a(int i) {
        return this.f2360a[i];
    }

    public String m4270a() {
        StringBuilder stringBuilder = new StringBuilder();
        for (long append : this.f2364e) {
            stringBuilder.append(' ').append(append);
        }
        return stringBuilder.toString();
    }

    public File m4271b(int i) {
        return this.f2361b[i];
    }
}
