package com.p032a.p033a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.p032a.p033a.p037d.C0667c;
import com.p032a.p033a.p037d.C0676b;
import com.p032a.p033a.p037d.C0730g;
import com.p032a.p033a.p037d.C0739e;
import com.p032a.p033a.p037d.p039b.C0652e;
import com.p032a.p033a.p037d.p046c.C0716j;
import com.p032a.p033a.p037d.p049d.p052b.C0742b;
import com.p032a.p033a.p037d.p049d.p057e.C0793a;
import com.p032a.p033a.p037d.p049d.p057e.C0800h;
import com.p032a.p033a.p045h.C0866h;
import com.p032a.p033a.p045h.p056b.C0778k;
import com.p032a.p033a.p045h.p060a.C0838a;
import com.p032a.p033a.p051g.C0831f;
import com.p032a.p033a.p055e.C0809i;
import com.p032a.p033a.p055e.C0824q;

/* renamed from: com.a.a.c */
public class C0585c<ModelType> extends C0574e<ModelType, C0716j, C0793a, C0742b> {
    C0585c(Context context, Class<ModelType> cls, C0831f<ModelType, C0716j, C0793a, C0742b> c0831f, C0872i c0872i, C0824q c0824q, C0809i c0809i) {
        super(context, cls, c0831f, C0742b.class, c0872i, c0824q, c0809i);
        m4430c();
    }

    public C0585c<ModelType> m4405a() {
        return m4431c(this.c.m5281e());
    }

    public C0585c<ModelType> m4406a(float f) {
        super.m4286b(f);
        return this;
    }

    public C0585c<ModelType> m4407a(int i) {
        super.m4287b(i);
        return this;
    }

    public C0585c<ModelType> m4408a(int i, int i2) {
        super.m4288b(i, i2);
        return this;
    }

    public C0585c<ModelType> m4409a(C0652e c0652e) {
        super.m4289b(c0652e);
        return this;
    }

    public C0585c<ModelType> m4410a(C0676b<C0716j> c0676b) {
        super.m4290b((C0676b) c0676b);
        return this;
    }

    public C0585c<ModelType> m4411a(C0667c c0667c) {
        super.m4291b(c0667c);
        return this;
    }

    public C0585c<ModelType> m4412a(C0739e<C0716j, C0793a> c0739e) {
        super.m4292b((C0739e) c0739e);
        return this;
    }

    public C0585c<ModelType> m4413a(C0866h<? super ModelType, C0742b> c0866h) {
        super.m4293b((C0866h) c0866h);
        return this;
    }

    public C0585c<ModelType> m4414a(ModelType modelType) {
        super.m4294b((Object) modelType);
        return this;
    }

    public C0585c<ModelType> m4415a(boolean z) {
        super.m4295b(z);
        return this;
    }

    public C0585c<ModelType> m4416a(C0730g<Bitmap>... c0730gArr) {
        C0730g[] c0730gArr2 = new C0800h[c0730gArr.length];
        for (int i = 0; i < c0730gArr.length; i++) {
            c0730gArr2[i] = new C0800h(this.c.m5272a(), c0730gArr[i]);
        }
        return m4431c(c0730gArr2);
    }

    public C0778k<C0742b> m4417a(ImageView imageView) {
        return super.m4284a(imageView);
    }

    public C0585c<ModelType> m4418b() {
        return m4431c(this.c.m5282f());
    }

    public /* synthetic */ C0574e m4419b(float f) {
        return m4406a(f);
    }

    public /* synthetic */ C0574e m4420b(int i) {
        return m4407a(i);
    }

    public /* synthetic */ C0574e m4421b(int i, int i2) {
        return m4408a(i, i2);
    }

    public /* synthetic */ C0574e m4422b(C0652e c0652e) {
        return m4409a(c0652e);
    }

    public /* synthetic */ C0574e m4423b(C0676b c0676b) {
        return m4410a(c0676b);
    }

    public /* synthetic */ C0574e m4424b(C0667c c0667c) {
        return m4411a(c0667c);
    }

    public /* synthetic */ C0574e m4425b(C0739e c0739e) {
        return m4412a(c0739e);
    }

    public /* synthetic */ C0574e m4426b(C0866h c0866h) {
        return m4413a(c0866h);
    }

    public /* synthetic */ C0574e m4427b(Object obj) {
        return m4414a(obj);
    }

    public /* synthetic */ C0574e m4428b(boolean z) {
        return m4415a(z);
    }

    public /* synthetic */ C0574e m4429b(C0730g[] c0730gArr) {
        return m4431c(c0730gArr);
    }

    public final C0585c<ModelType> m4430c() {
        super.m4283a(new C0838a());
        return this;
    }

    public C0585c<ModelType> m4431c(C0730g<C0793a>... c0730gArr) {
        super.m4296b((C0730g[]) c0730gArr);
        return this;
    }

    public /* synthetic */ Object clone() {
        return m4437i();
    }

    public C0585c<ModelType> m4432d() {
        super.m4301h();
        return this;
    }

    void m4433e() {
        m4418b();
    }

    void m4434f() {
        m4405a();
    }

    public /* synthetic */ C0574e m4435g() {
        return m4437i();
    }

    public /* synthetic */ C0574e m4436h() {
        return m4432d();
    }

    public C0585c<ModelType> m4437i() {
        return (C0585c) super.m4300g();
    }
}
