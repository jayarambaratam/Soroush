package com.p063b.p064a;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Picture;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: com.b.a.n */
public class C0929n {
    private static final List<bi> f3569a;
    private ba f3570b;
    private String f3571c;
    private String f3572d;
    private cm f3573e;
    private float f3574f;
    private C0923h f3575g;

    static {
        f3569a = new ArrayList(0);
    }

    protected C0929n() {
        this.f3570b = null;
        this.f3571c = BuildConfig.FLAVOR;
        this.f3572d = BuildConfig.FLAVOR;
        this.f3573e = null;
        this.f3574f = 96.0f;
        this.f3575g = new C0923h();
    }

    private bg m5788a(be beVar, String str) {
        bg bgVar = (bg) beVar;
        if (str.equals(bgVar.f3196p)) {
            return bgVar;
        }
        for (bi biVar : beVar.m5444a()) {
            if (biVar instanceof bg) {
                bg bgVar2 = (bg) biVar;
                if (str.equals(bgVar2.f3196p)) {
                    return bgVar2;
                }
                if (biVar instanceof be) {
                    bgVar = m5788a((be) biVar, str);
                    if (bgVar != null) {
                        return bgVar;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public static C0929n m5789a(Context context, int i) {
        return new cp().m5741a(context.getResources().openRawResource(i));
    }

    public static C0929n m5790a(AssetManager assetManager, String str) {
        cp cpVar = new cp();
        InputStream open = assetManager.open(str);
        C0929n a = cpVar.m5741a(open);
        open.close();
        return a;
    }

    public static C0929n m5791a(InputStream inputStream) {
        return new cp().m5741a(inputStream);
    }

    public Picture m5793a() {
        ac acVar = this.f3570b.f3337c;
        if (acVar == null) {
            return m5794a(512, 512);
        }
        float f;
        float a = acVar.m5461a(this.f3574f);
        C0930o c0930o = this.f3570b.x;
        if (c0930o != null) {
            f = (c0930o.f3579d * a) / c0930o.f3578c;
        } else {
            acVar = this.f3570b.f3338d;
            f = acVar != null ? acVar.m5461a(this.f3574f) : a;
        }
        return m5794a((int) Math.ceil((double) a), (int) Math.ceil((double) f));
    }

    public Picture m5794a(int i, int i2) {
        Picture picture = new Picture();
        new cb(picture.beginRecording(i, i2), new C0930o(0.0f, 0.0f, (float) i, (float) i2), this.f3574f).m5615a(this, null, null, false);
        picture.endRecording();
        return picture;
    }

    protected bi m5795a(String str) {
        return (str != null && str.length() > 1 && str.startsWith("#")) ? m5802d(str.substring(1)) : null;
    }

    protected void m5796a(ba baVar) {
        this.f3570b = baVar;
    }

    protected void m5797a(C0923h c0923h) {
        this.f3575g.m5774a(c0923h);
    }

    protected ba m5798b() {
        return this.f3570b;
    }

    protected void m5799b(String str) {
        this.f3571c = str;
    }

    protected List<C0922g> m5800c() {
        return this.f3575g.m5772a();
    }

    protected void m5801c(String str) {
        this.f3572d = str;
    }

    protected bi m5802d(String str) {
        return str.equals(this.f3570b.p) ? this.f3570b : m5788a(this.f3570b, str);
    }

    protected boolean m5803d() {
        return !this.f3575g.m5775b();
    }

    protected cm m5804e() {
        return this.f3573e;
    }
}
