package com.p032a.p033a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.widget.ImageView;
import com.p032a.p033a.p037d.C0598a;
import com.p032a.p033a.p037d.C0667c;
import com.p032a.p033a.p037d.C0676b;
import com.p032a.p033a.p037d.C0730g;
import com.p032a.p033a.p037d.C0739e;
import com.p032a.p033a.p037d.p039b.C0652e;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;
import com.p032a.p033a.p037d.p046c.C0716j;
import com.p032a.p033a.p037d.p049d.p050a.C0731d;
import com.p032a.p033a.p037d.p049d.p050a.C0733f;
import com.p032a.p033a.p037d.p049d.p050a.C0740k;
import com.p032a.p033a.p037d.p049d.p050a.C0756y;
import com.p032a.p033a.p045h.C0866h;
import com.p032a.p033a.p045h.p056b.C0778k;
import com.p032a.p033a.p051g.C0831f;
import java.io.InputStream;

/* renamed from: com.a.a.a */
public class C0575a<ModelType, TranscodeType> extends C0574e<ModelType, C0716j, Bitmap, TranscodeType> {
    private final C0605e f2410g;
    private C0733f f2411h;
    private C0598a f2412i;
    private C0739e<InputStream, Bitmap> f2413j;
    private C0739e<ParcelFileDescriptor, Bitmap> f2414k;

    C0575a(C0831f<ModelType, C0716j, Bitmap, TranscodeType> c0831f, Class<TranscodeType> cls, C0574e<ModelType, ?, ?, ?> c0574e) {
        super(c0831f, cls, c0574e);
        this.f2411h = C0733f.f2754a;
        this.f2410g = c0574e.f2386c.m5272a();
        this.f2412i = c0574e.f2386c.m5284h();
        this.f2413j = new C0756y(this.f2410g, this.f2412i);
        this.f2414k = new C0740k(this.f2410g, this.f2412i);
    }

    public C0575a<ModelType, TranscodeType> m4302a() {
        return m4313a(this.c.m5279c());
    }

    public C0575a<ModelType, TranscodeType> m4303a(float f) {
        super.m4286b(f);
        return this;
    }

    public C0575a<ModelType, TranscodeType> m4304a(int i) {
        super.m4287b(i);
        return this;
    }

    public C0575a<ModelType, TranscodeType> m4305a(int i, int i2) {
        super.m4288b(i, i2);
        return this;
    }

    public C0575a<ModelType, TranscodeType> m4306a(C0652e c0652e) {
        super.m4289b(c0652e);
        return this;
    }

    public C0575a<ModelType, TranscodeType> m4307a(C0676b<C0716j> c0676b) {
        super.m4290b((C0676b) c0676b);
        return this;
    }

    public C0575a<ModelType, TranscodeType> m4308a(C0667c c0667c) {
        super.m4291b(c0667c);
        return this;
    }

    public C0575a<ModelType, TranscodeType> m4309a(C0739e<C0716j, Bitmap> c0739e) {
        super.m4292b((C0739e) c0739e);
        return this;
    }

    public C0575a<ModelType, TranscodeType> m4310a(C0866h<? super ModelType, TranscodeType> c0866h) {
        super.m4293b((C0866h) c0866h);
        return this;
    }

    public C0575a<ModelType, TranscodeType> m4311a(ModelType modelType) {
        super.m4294b((Object) modelType);
        return this;
    }

    public C0575a<ModelType, TranscodeType> m4312a(boolean z) {
        super.m4295b(z);
        return this;
    }

    public C0575a<ModelType, TranscodeType> m4313a(C0731d... c0731dArr) {
        super.m4296b((C0730g[]) c0731dArr);
        return this;
    }

    public C0575a<ModelType, TranscodeType> m4314a(C0730g<Bitmap>... c0730gArr) {
        super.m4296b((C0730g[]) c0730gArr);
        return this;
    }

    public C0778k<TranscodeType> m4315a(ImageView imageView) {
        return super.m4284a(imageView);
    }

    public C0575a<ModelType, TranscodeType> m4316b() {
        return m4313a(this.c.m5280d());
    }

    public /* synthetic */ C0574e m4317b(float f) {
        return m4303a(f);
    }

    public /* synthetic */ C0574e m4318b(int i) {
        return m4304a(i);
    }

    public /* synthetic */ C0574e m4319b(int i, int i2) {
        return m4305a(i, i2);
    }

    public /* synthetic */ C0574e m4320b(C0652e c0652e) {
        return m4306a(c0652e);
    }

    public /* synthetic */ C0574e m4321b(C0676b c0676b) {
        return m4307a(c0676b);
    }

    public /* synthetic */ C0574e m4322b(C0667c c0667c) {
        return m4308a(c0667c);
    }

    public /* synthetic */ C0574e m4323b(C0739e c0739e) {
        return m4309a(c0739e);
    }

    public /* synthetic */ C0574e m4324b(C0866h c0866h) {
        return m4310a(c0866h);
    }

    public /* synthetic */ C0574e m4325b(Object obj) {
        return m4311a(obj);
    }

    public /* synthetic */ C0574e m4326b(boolean z) {
        return m4312a(z);
    }

    public /* synthetic */ C0574e m4327b(C0730g[] c0730gArr) {
        return m4314a(c0730gArr);
    }

    public C0575a<ModelType, TranscodeType> m4328c() {
        super.m4301h();
        return this;
    }

    public /* synthetic */ Object clone() {
        return m4329d();
    }

    public C0575a<ModelType, TranscodeType> m4329d() {
        return (C0575a) super.m4300g();
    }

    void m4330e() {
        m4316b();
    }

    void m4331f() {
        m4302a();
    }

    public /* synthetic */ C0574e m4332g() {
        return m4329d();
    }

    public /* synthetic */ C0574e m4333h() {
        return m4328c();
    }
}
