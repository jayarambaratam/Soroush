package com.p032a.p033a.p037d.p039b;

import com.p032a.p033a.p037d.C0667c;
import com.p032a.p033a.p037d.C0676b;
import com.p032a.p033a.p037d.C0727f;
import com.p032a.p033a.p037d.C0730g;
import com.p032a.p033a.p037d.C0739e;
import com.p032a.p033a.p037d.p049d.p058f.C0802c;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smack.util.StringUtils;

/* renamed from: com.a.a.d.b.q */
class C0668q implements C0667c {
    private final String f2669a;
    private final int f2670b;
    private final int f2671c;
    private final C0739e f2672d;
    private final C0739e f2673e;
    private final C0730g f2674f;
    private final C0727f f2675g;
    private final C0802c f2676h;
    private final C0676b f2677i;
    private final C0667c f2678j;
    private String f2679k;
    private int f2680l;
    private C0667c f2681m;

    public C0668q(String str, C0667c c0667c, int i, int i2, C0739e c0739e, C0739e c0739e2, C0730g c0730g, C0727f c0727f, C0802c c0802c, C0676b c0676b) {
        this.f2669a = str;
        this.f2678j = c0667c;
        this.f2670b = i;
        this.f2671c = i2;
        this.f2672d = c0739e;
        this.f2673e = c0739e2;
        this.f2674f = c0730g;
        this.f2675g = c0727f;
        this.f2676h = c0802c;
        this.f2677i = c0676b;
    }

    public C0667c m4675a() {
        if (this.f2681m == null) {
            this.f2681m = new C0674x(this.f2669a, this.f2678j);
        }
        return this.f2681m;
    }

    public void m4676a(MessageDigest messageDigest) {
        byte[] array = ByteBuffer.allocate(8).putInt(this.f2670b).putInt(this.f2671c).array();
        this.f2678j.m4674a(messageDigest);
        messageDigest.update(this.f2669a.getBytes(StringUtils.UTF8));
        messageDigest.update(array);
        messageDigest.update((this.f2672d != null ? this.f2672d.m4835a() : BuildConfig.FLAVOR).getBytes(StringUtils.UTF8));
        messageDigest.update((this.f2673e != null ? this.f2673e.m4835a() : BuildConfig.FLAVOR).getBytes(StringUtils.UTF8));
        messageDigest.update((this.f2674f != null ? this.f2674f.m4803a() : BuildConfig.FLAVOR).getBytes(StringUtils.UTF8));
        messageDigest.update((this.f2675g != null ? this.f2675g.m4698a() : BuildConfig.FLAVOR).getBytes(StringUtils.UTF8));
        messageDigest.update((this.f2677i != null ? this.f2677i.m4698a() : BuildConfig.FLAVOR).getBytes(StringUtils.UTF8));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0668q c0668q = (C0668q) obj;
        if (!this.f2669a.equals(c0668q.f2669a) || !this.f2678j.equals(c0668q.f2678j) || this.f2671c != c0668q.f2671c || this.f2670b != c0668q.f2670b) {
            return false;
        }
        if (((this.f2674f == null ? 1 : 0) ^ (c0668q.f2674f == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.f2674f != null && !this.f2674f.m4803a().equals(c0668q.f2674f.m4803a())) {
            return false;
        }
        if (((this.f2673e == null ? 1 : 0) ^ (c0668q.f2673e == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.f2673e != null && !this.f2673e.m4835a().equals(c0668q.f2673e.m4835a())) {
            return false;
        }
        if (((this.f2672d == null ? 1 : 0) ^ (c0668q.f2672d == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.f2672d != null && !this.f2672d.m4835a().equals(c0668q.f2672d.m4835a())) {
            return false;
        }
        if (((this.f2675g == null ? 1 : 0) ^ (c0668q.f2675g == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.f2675g != null && !this.f2675g.m4698a().equals(c0668q.f2675g.m4698a())) {
            return false;
        }
        if (((this.f2676h == null ? 1 : 0) ^ (c0668q.f2676h == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.f2676h != null && !this.f2676h.m5034a().equals(c0668q.f2676h.m5034a())) {
            return false;
        }
        return ((this.f2677i == null ? 1 : 0) ^ (c0668q.f2677i == null ? 1 : 0)) == 0 ? this.f2677i == null || this.f2677i.m4698a().equals(c0668q.f2677i.m4698a()) : false;
    }

    public int hashCode() {
        int i = 0;
        if (this.f2680l == 0) {
            this.f2680l = this.f2669a.hashCode();
            this.f2680l = (this.f2680l * 31) + this.f2678j.hashCode();
            this.f2680l = (this.f2680l * 31) + this.f2670b;
            this.f2680l = (this.f2680l * 31) + this.f2671c;
            this.f2680l = (this.f2672d != null ? this.f2672d.m4835a().hashCode() : 0) + (this.f2680l * 31);
            this.f2680l = (this.f2673e != null ? this.f2673e.m4835a().hashCode() : 0) + (this.f2680l * 31);
            this.f2680l = (this.f2674f != null ? this.f2674f.m4803a().hashCode() : 0) + (this.f2680l * 31);
            this.f2680l = (this.f2675g != null ? this.f2675g.m4698a().hashCode() : 0) + (this.f2680l * 31);
            this.f2680l = (this.f2676h != null ? this.f2676h.m5034a().hashCode() : 0) + (this.f2680l * 31);
            int i2 = this.f2680l * 31;
            if (this.f2677i != null) {
                i = this.f2677i.m4698a().hashCode();
            }
            this.f2680l = i2 + i;
        }
        return this.f2680l;
    }

    public String toString() {
        if (this.f2679k == null) {
            this.f2679k = "EngineKey{" + this.f2669a + '+' + this.f2678j + "+[" + this.f2670b + 'x' + this.f2671c + "]+" + '\'' + (this.f2672d != null ? this.f2672d.m4835a() : BuildConfig.FLAVOR) + '\'' + '+' + '\'' + (this.f2673e != null ? this.f2673e.m4835a() : BuildConfig.FLAVOR) + '\'' + '+' + '\'' + (this.f2674f != null ? this.f2674f.m4803a() : BuildConfig.FLAVOR) + '\'' + '+' + '\'' + (this.f2675g != null ? this.f2675g.m4698a() : BuildConfig.FLAVOR) + '\'' + '+' + '\'' + (this.f2676h != null ? this.f2676h.m5034a() : BuildConfig.FLAVOR) + '\'' + '+' + '\'' + (this.f2677i != null ? this.f2677i.m4698a() : BuildConfig.FLAVOR) + '\'' + '}';
        }
        return this.f2679k;
    }
}
