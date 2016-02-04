package com.p063b.p064a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;
import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smack.tcp.XMPPTCPConnection.PacketWriter;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: com.b.a.cb */
public class cb {
    private static /* synthetic */ int[] f3388l;
    private static /* synthetic */ int[] f3389m;
    private static /* synthetic */ int[] f3390n;
    private static /* synthetic */ int[] f3391o;
    private Canvas f3392a;
    private C0930o f3393b;
    private float f3394c;
    private boolean f3395d;
    private C0929n f3396e;
    private ci f3397f;
    private Stack<ci> f3398g;
    private Stack<be> f3399h;
    private Stack<Matrix> f3400i;
    private Stack<Canvas> f3401j;
    private Stack<Bitmap> f3402k;

    protected cb(Canvas canvas, C0930o c0930o, float f) {
        this.f3392a = canvas;
        this.f3394c = f;
        this.f3393b = c0930o;
    }

    private float m5512a(bt btVar) {
        ck clVar = new cl();
        m5550a(btVar, clVar);
        return clVar.f3445a;
    }

    private int m5513a(float f) {
        int i = (int) (256.0f * f);
        return i < 0 ? 0 : i <= 255 ? i : 255;
    }

    private Bitmap m5514a(String str) {
        if (!str.startsWith("data:") || str.length() < 14) {
            return null;
        }
        int indexOf = str.indexOf(44);
        if (indexOf == -1 || indexOf < 12 || !";base64".equals(str.substring(indexOf - 7, indexOf))) {
            return null;
        }
        byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    private Matrix m5515a(C0930o c0930o, C0930o c0930o2, C0926k c0926k) {
        Matrix matrix = new Matrix();
        if (c0926k == null || c0926k.m5786a() == null) {
            return matrix;
        }
        float f = c0930o.f3578c / c0930o2.f3578c;
        float f2 = c0930o.f3579d / c0930o2.f3579d;
        float f3 = -c0930o2.f3576a;
        float f4 = -c0930o2.f3577b;
        if (c0926k.equals(C0926k.f3545b)) {
            matrix.preTranslate(c0930o.f3576a, c0930o.f3577b);
            matrix.preScale(f, f2);
            matrix.preTranslate(f3, f4);
            return matrix;
        }
        f = c0926k.m5787b() == C0928m.Slice ? Math.max(f, f2) : Math.min(f, f2);
        f2 = c0930o.f3578c / f;
        float f5 = c0930o.f3579d / f;
        switch (cb.m5593e()[c0926k.m5786a().ordinal()]) {
            case Version.API03_CUPCAKE_15 /*3*/:
            case Version.API06_ECLAIR_201 /*6*/:
            case Version.API09_GINGERBREAD_23 /*9*/:
                f3 -= (c0930o2.f3578c - f2) / 2.0f;
                break;
            case Version.API04_DONUT_16 /*4*/:
            case Version.API07_ECLAIR_21 /*7*/:
            case Version.API10_GINGERBREAD_MR1_233 /*10*/:
                f3 -= c0930o2.f3578c - f2;
                break;
        }
        switch (cb.m5593e()[c0926k.m5786a().ordinal()]) {
            case Version.API05_ECLAIR_20 /*5*/:
            case Version.API06_ECLAIR_201 /*6*/:
            case Version.API07_ECLAIR_21 /*7*/:
                f4 -= (c0930o2.f3579d - f5) / 2.0f;
                break;
            case Version.API08_FROYO_22 /*8*/:
            case Version.API09_GINGERBREAD_23 /*9*/:
            case Version.API10_GINGERBREAD_MR1_233 /*10*/:
                f4 -= c0930o2.f3579d - f5;
                break;
        }
        matrix.preTranslate(c0930o.f3576a, c0930o.f3577b);
        matrix.preScale(f, f);
        matrix.preTranslate(f3, f4);
        return matrix;
    }

    private Typeface m5516a(String str, Integer num, at atVar) {
        int i = 1;
        int i2 = atVar == at.Italic ? 1 : 0;
        if (num.intValue() <= PacketWriter.QUEUE_SIZE) {
            i = i2 != 0 ? 2 : 0;
        } else if (i2 != 0) {
            i = 3;
        }
        return str.equals("serif") ? Typeface.create(Typeface.SERIF, i) : str.equals("sans-serif") ? Typeface.create(Typeface.SANS_SERIF, i) : str.equals("monospace") ? Typeface.create(Typeface.MONOSPACE, i) : str.equals("cursive") ? Typeface.create(Typeface.SANS_SERIF, i) : str.equals("fantasy") ? Typeface.create(Typeface.SANS_SERIF, i) : null;
    }

    private ci m5517a(bi biVar, ci ciVar) {
        List<bg> arrayList = new ArrayList();
        bi biVar2 = biVar;
        while (true) {
            if (biVar2 instanceof bg) {
                arrayList.add(0, (bg) biVar2);
            }
            if (biVar2.f3195v == null) {
                break;
            }
            biVar2 = (bi) biVar2.f3195v;
        }
        for (bg a : arrayList) {
            m5556a(ciVar, a);
        }
        ciVar.f3437g = this.f3396e.m5798b().x;
        if (ciVar.f3437g == null) {
            ciVar.f3437g = this.f3393b;
        }
        ciVar.f3436f = this.f3393b;
        ciVar.f3439i = this.f3397f.f3439i;
        return ciVar;
    }

    private String m5518a(String str, boolean z, boolean z2) {
        if (this.f3397f.f3438h) {
            return str.replaceAll("[\\n\\t]", " ");
        }
        String replaceAll = str.replaceAll("\\n", BuildConfig.FLAVOR).replaceAll("\\t", " ");
        if (z) {
            replaceAll = replaceAll.replaceAll("^\\s+", BuildConfig.FLAVOR);
        }
        if (z2) {
            replaceAll = replaceAll.replaceAll("\\s+$", BuildConfig.FLAVOR);
        }
        return replaceAll.replaceAll("\\s{2,}", " ");
    }

    private void m5519a(float f, float f2, float f3, float f4) {
        float f5 = f + f3;
        float f6 = f2 + f4;
        if (this.f3397f.f3431a.f3297w != null) {
            f += this.f3397f.f3431a.f3297w.f3583d.m5462a(this);
            f2 += this.f3397f.f3431a.f3297w.f3580a.m5464b(this);
            f5 -= this.f3397f.f3431a.f3297w.f3581b.m5462a(this);
            f6 -= this.f3397f.f3431a.f3297w.f3582c.m5464b(this);
        }
        this.f3392a.clipRect(f, f2, f5, f6);
    }

    private void m5521a(Path path) {
        if (this.f3397f.f3431a.f3274L == az.NonScalingStroke) {
            Matrix matrix = this.f3392a.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.f3392a.setMatrix(new Matrix());
            Shader shader = this.f3397f.f3435e.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.f3392a.drawPath(path2, this.f3397f.f3435e);
            this.f3392a.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.f3392a.drawPath(path, this.f3397f.f3435e);
    }

    private void m5522a(ab abVar) {
        cb.m5594f("Image render", new Object[0]);
        if (abVar.f3212d != null && !abVar.f3212d.m5465b() && abVar.f3213e != null && !abVar.f3213e.m5465b() && abVar.f3209a != null) {
            Bitmap a;
            C0926k c0926k = abVar.w != null ? abVar.w : C0926k.f3546c;
            Bitmap a2 = m5514a(abVar.f3209a);
            if (a2 == null) {
                cm e = this.f3396e.m5804e();
                if (e != null) {
                    a = e.m5644a(abVar.f3209a);
                } else {
                    return;
                }
            }
            a = a2;
            if (a == null) {
                cb.m5592e("Could not locate image '%s'", abVar.f3209a);
                return;
            }
            m5556a(this.f3397f, (bg) abVar);
            if (m5607r() && m5608s()) {
                if (abVar.f3214f != null) {
                    this.f3392a.concat(abVar.f3214f);
                }
                this.f3397f.f3436f = new C0930o(abVar.f3210b != null ? abVar.f3210b.m5462a(this) : 0.0f, abVar.f3211c != null ? abVar.f3211c.m5464b(this) : 0.0f, abVar.f3212d.m5462a(this), abVar.f3213e.m5462a(this));
                if (!this.f3397f.f3431a.f3296v.booleanValue()) {
                    m5519a(this.f3397f.f3436f.f3576a, this.f3397f.f3436f.f3577b, this.f3397f.f3436f.f3578c, this.f3397f.f3436f.f3579d);
                }
                abVar.o = new C0930o(0.0f, 0.0f, (float) a.getWidth(), (float) a.getHeight());
                this.f3392a.concat(m5515a(this.f3397f.f3436f, abVar.o, c0926k));
                m5537a((bf) abVar);
                m5590d(abVar);
                boolean m = m5602m();
                m5610u();
                this.f3392a.drawBitmap(a, 0.0f, 0.0f, this.f3397f.f3434d);
                if (m) {
                    m5580b((bf) abVar);
                }
            }
        }
    }

    private void m5523a(ad adVar) {
        cb.m5594f("Line render", new Object[0]);
        m5556a(this.f3397f, (bg) adVar);
        if (m5607r() && m5608s() && this.f3397f.f3433c) {
            if (adVar.e != null) {
                this.f3392a.concat(adVar.e);
            }
            Path c = m5585c(adVar);
            m5537a((bf) adVar);
            m5588c((bf) adVar);
            m5590d(adVar);
            boolean m = m5602m();
            m5521a(c);
            m5561a((C0914y) adVar);
            if (m) {
                m5580b((bf) adVar);
            }
        }
    }

    private void m5524a(ae aeVar, cd cdVar) {
        float floatValue;
        float a;
        Matrix matrix;
        float a2;
        C0930o c0930o;
        float f;
        float f2;
        C0926k c0926k;
        boolean m;
        float f3 = 3.0f;
        float f4 = 0.0f;
        m5599j();
        if (aeVar.f3234f != null) {
            if (!Float.isNaN(aeVar.f3234f.floatValue())) {
                floatValue = aeVar.f3234f.floatValue();
            } else if (!(cdVar.f3414c == 0.0f && cdVar.f3415d == 0.0f)) {
                floatValue = (float) Math.toDegrees(Math.atan2((double) cdVar.f3415d, (double) cdVar.f3414c));
            }
            a = aeVar.f3229a ? 1.0f : this.f3397f.f3431a.f3281g.m5461a(this.f3394c);
            this.f3397f = m5587c((bi) aeVar);
            matrix = new Matrix();
            matrix.preTranslate(cdVar.f3412a, cdVar.f3413b);
            matrix.preRotate(floatValue);
            matrix.preScale(a, a);
            floatValue = aeVar.f3230b == null ? aeVar.f3230b.m5462a(this) : 0.0f;
            a = aeVar.f3231c == null ? aeVar.f3231c.m5464b(this) : 0.0f;
            a2 = aeVar.f3232d == null ? aeVar.f3232d.m5462a(this) : 3.0f;
            if (aeVar.f3233e != null) {
                f3 = aeVar.f3233e.m5464b(this);
            }
            c0930o = aeVar.x == null ? aeVar.x : this.f3397f.f3436f;
            f = a2 / c0930o.f3578c;
            f2 = f3 / c0930o.f3579d;
            c0926k = aeVar.w == null ? aeVar.w : C0926k.f3546c;
            if (!c0926k.equals(C0926k.f3545b)) {
                f2 = c0926k.m5787b() != C0928m.Slice ? Math.max(f, f2) : Math.min(f, f2);
                f = f2;
            }
            matrix.preTranslate((-floatValue) * f, (-a) * f2);
            this.f3392a.concat(matrix);
            if (!this.f3397f.f3431a.f3296v.booleanValue()) {
                floatValue = c0930o.f3578c * f;
                a = c0930o.f3579d * f2;
                switch (cb.m5593e()[c0926k.m5786a().ordinal()]) {
                    case Version.API03_CUPCAKE_15 /*3*/:
                    case Version.API06_ECLAIR_201 /*6*/:
                    case Version.API09_GINGERBREAD_23 /*9*/:
                        floatValue = 0.0f - ((a2 - floatValue) / 2.0f);
                        break;
                    case Version.API04_DONUT_16 /*4*/:
                    case Version.API07_ECLAIR_21 /*7*/:
                    case Version.API10_GINGERBREAD_MR1_233 /*10*/:
                        floatValue = 0.0f - (a2 - floatValue);
                        break;
                    default:
                        floatValue = 0.0f;
                        break;
                }
                switch (cb.m5593e()[c0926k.m5786a().ordinal()]) {
                    case Version.API05_ECLAIR_20 /*5*/:
                    case Version.API06_ECLAIR_201 /*6*/:
                    case Version.API07_ECLAIR_21 /*7*/:
                        f4 = 0.0f - ((f3 - a) / 2.0f);
                        break;
                    case Version.API08_FROYO_22 /*8*/:
                    case Version.API09_GINGERBREAD_23 /*9*/:
                    case Version.API10_GINGERBREAD_MR1_233 /*10*/:
                        f4 = 0.0f - (f3 - a);
                        break;
                }
                m5519a(floatValue, f4, a2, f3);
            }
            matrix.reset();
            matrix.preScale(f, f2);
            this.f3392a.concat(matrix);
            m = m5602m();
            m5536a((be) aeVar, false);
            if (m) {
                m5580b((bf) aeVar);
            }
            m5600k();
        }
        floatValue = 0.0f;
        if (aeVar.f3229a) {
        }
        this.f3397f = m5587c((bi) aeVar);
        matrix = new Matrix();
        matrix.preTranslate(cdVar.f3412a, cdVar.f3413b);
        matrix.preRotate(floatValue);
        matrix.preScale(a, a);
        if (aeVar.f3230b == null) {
        }
        if (aeVar.f3231c == null) {
        }
        if (aeVar.f3232d == null) {
        }
        if (aeVar.f3233e != null) {
            f3 = aeVar.f3233e.m5464b(this);
        }
        if (aeVar.x == null) {
        }
        f = a2 / c0930o.f3578c;
        f2 = f3 / c0930o.f3579d;
        if (aeVar.w == null) {
        }
        if (c0926k.equals(C0926k.f3545b)) {
            if (c0926k.m5787b() != C0928m.Slice) {
            }
            f = f2;
        }
        matrix.preTranslate((-floatValue) * f, (-a) * f2);
        this.f3392a.concat(matrix);
        if (this.f3397f.f3431a.f3296v.booleanValue()) {
            floatValue = c0930o.f3578c * f;
            a = c0930o.f3579d * f2;
            switch (cb.m5593e()[c0926k.m5786a().ordinal()]) {
                case Version.API03_CUPCAKE_15 /*3*/:
                case Version.API06_ECLAIR_201 /*6*/:
                case Version.API09_GINGERBREAD_23 /*9*/:
                    floatValue = 0.0f - ((a2 - floatValue) / 2.0f);
                    break;
                case Version.API04_DONUT_16 /*4*/:
                case Version.API07_ECLAIR_21 /*7*/:
                case Version.API10_GINGERBREAD_MR1_233 /*10*/:
                    floatValue = 0.0f - (a2 - floatValue);
                    break;
                default:
                    floatValue = 0.0f;
                    break;
            }
            switch (cb.m5593e()[c0926k.m5786a().ordinal()]) {
                case Version.API05_ECLAIR_20 /*5*/:
                case Version.API06_ECLAIR_201 /*6*/:
                case Version.API07_ECLAIR_21 /*7*/:
                    f4 = 0.0f - ((f3 - a) / 2.0f);
                    break;
                case Version.API08_FROYO_22 /*8*/:
                case Version.API09_GINGERBREAD_23 /*9*/:
                case Version.API10_GINGERBREAD_MR1_233 /*10*/:
                    f4 = 0.0f - (f3 - a);
                    break;
            }
            m5519a(floatValue, f4, a2, f3);
        }
        matrix.reset();
        matrix.preScale(f, f2);
        this.f3392a.concat(matrix);
        m = m5602m();
        m5536a((be) aeVar, false);
        if (m) {
            m5580b((bf) aeVar);
        }
        m5600k();
    }

    private void m5525a(af afVar, bf bfVar) {
        float a;
        float f = -0.1f;
        cb.m5594f("Mask render", new Object[0]);
        boolean z = afVar.f3235a != null && afVar.f3235a.booleanValue();
        if (z) {
            float f2;
            a = afVar.f3239e != null ? afVar.f3239e.m5462a(this) : bfVar.f3201o.f3578c;
            f = afVar.f3240f != null ? afVar.f3240f.m5464b(this) : bfVar.f3201o.f3579d;
            if (afVar.f3237c != null) {
                afVar.f3237c.m5462a(this);
            } else {
                f2 = (float) (((double) bfVar.f3201o.f3576a) - (((double) bfVar.f3201o.f3578c) * 0.1d));
            }
            if (afVar.f3238d != null) {
                afVar.f3238d.m5464b(this);
            } else {
                f2 = (float) (((double) bfVar.f3201o.f3577b) - (((double) bfVar.f3201o.f3579d) * 0.1d));
            }
        } else {
            a = afVar.f3237c != null ? afVar.f3237c.m5463a(this, 1.0f) : -0.1f;
            if (afVar.f3238d != null) {
                f = afVar.f3238d.m5463a(this, 1.0f);
            }
            a = (a * bfVar.f3201o.f3578c) + bfVar.f3201o.f3576a;
            a = bfVar.f3201o.f3577b + (f * bfVar.f3201o.f3579d);
            a = bfVar.f3201o.f3578c * (afVar.f3239e != null ? afVar.f3239e.m5463a(this, 1.0f) : 1.2f);
            f = bfVar.f3201o.f3579d * (afVar.f3240f != null ? afVar.f3240f.m5463a(this, 1.0f) : 1.2f);
        }
        if (a != 0.0f && r1 != 0.0f) {
            m5599j();
            this.f3397f = m5587c((bi) afVar);
            this.f3397f.f3431a.f3287m = Float.valueOf(1.0f);
            z = afVar.f3236b == null || afVar.f3236b.booleanValue();
            if (!z) {
                this.f3392a.translate(bfVar.f3201o.f3576a, bfVar.f3201o.f3577b);
                this.f3392a.scale(bfVar.f3201o.f3578c, bfVar.f3201o.f3579d);
            }
            m5536a((be) afVar, false);
            m5600k();
        }
    }

    private void m5526a(ai aiVar) {
        cb.m5594f("Path render", new Object[0]);
        m5556a(this.f3397f, (bg) aiVar);
        if (!m5607r() || !m5608s()) {
            return;
        }
        if (this.f3397f.f3433c || this.f3397f.f3432b) {
            if (aiVar.e != null) {
                this.f3392a.concat(aiVar.e);
            }
            Path a = new ce(this, aiVar.f3243a).m5628a();
            if (aiVar.o == null) {
                aiVar.o = m5576b(a);
            }
            m5537a((bf) aiVar);
            m5588c((bf) aiVar);
            m5590d(aiVar);
            boolean m = m5602m();
            if (this.f3397f.f3432b) {
                a.setFillType(m5609t());
                m5538a((bf) aiVar, a);
            }
            if (this.f3397f.f3433c) {
                m5521a(a);
            }
            m5561a((C0914y) aiVar);
            if (m) {
                m5580b((bf) aiVar);
            }
        }
    }

    private void m5527a(ai aiVar, Path path, Matrix matrix) {
        m5556a(this.f3397f, (bg) aiVar);
        if (m5607r() && m5608s()) {
            if (aiVar.e != null) {
                matrix.preConcat(aiVar.e);
            }
            Path a = new ce(this, aiVar.f3243a).m5628a();
            if (aiVar.o == null) {
                aiVar.o = m5576b(a);
            }
            m5590d(aiVar);
            path.setFillType(m5613x());
            path.addPath(a, matrix);
        }
    }

    private void m5528a(al alVar, String str) {
        bi a = alVar.u.m5795a(str);
        if (a == null) {
            cb.m5591d("Pattern reference '%s' not found", str);
        } else if (!(a instanceof al)) {
            cb.m5592e("Pattern href attributes must point to other pattern elements", new Object[0]);
        } else if (a == alVar) {
            cb.m5592e("Circular reference in pattern href attribute '%s'", str);
        } else {
            al alVar2 = (al) a;
            if (alVar.f3247a == null) {
                alVar.f3247a = alVar2.f3247a;
            }
            if (alVar.f3248b == null) {
                alVar.f3248b = alVar2.f3248b;
            }
            if (alVar.f3249c == null) {
                alVar.f3249c = alVar2.f3249c;
            }
            if (alVar.f3250d == null) {
                alVar.f3250d = alVar2.f3250d;
            }
            if (alVar.f3251e == null) {
                alVar.f3251e = alVar2.f3251e;
            }
            if (alVar.f3252f == null) {
                alVar.f3252f = alVar2.f3252f;
            }
            if (alVar.f3253g == null) {
                alVar.f3253g = alVar2.f3253g;
            }
            if (alVar.i.isEmpty()) {
                alVar.i = alVar2.i;
            }
            if (alVar.x == null) {
                alVar.x = alVar2.x;
            }
            if (alVar.w == null) {
                alVar.w = alVar2.w;
            }
            if (alVar2.f3254h != null) {
                m5528a(alVar, alVar2.f3254h);
            }
        }
    }

    private void m5529a(am amVar) {
        cb.m5594f("PolyLine render", new Object[0]);
        m5556a(this.f3397f, (bg) amVar);
        if (!m5607r() || !m5608s()) {
            return;
        }
        if (this.f3397f.f3433c || this.f3397f.f3432b) {
            if (amVar.e != null) {
                this.f3392a.concat(amVar.e);
            }
            if (amVar.f3255a.length >= 2) {
                Path c = m5586c(amVar);
                m5537a((bf) amVar);
                m5588c((bf) amVar);
                m5590d(amVar);
                boolean m = m5602m();
                if (this.f3397f.f3432b) {
                    m5538a((bf) amVar, c);
                }
                if (this.f3397f.f3433c) {
                    m5521a(c);
                }
                m5561a((C0914y) amVar);
                if (m) {
                    m5580b((bf) amVar);
                }
            }
        }
    }

    private void m5530a(an anVar) {
        cb.m5594f("Polygon render", new Object[0]);
        m5556a(this.f3397f, (bg) anVar);
        if (!m5607r() || !m5608s()) {
            return;
        }
        if (this.f3397f.f3433c || this.f3397f.f3432b) {
            if (anVar.e != null) {
                this.f3392a.concat(anVar.e);
            }
            if (anVar.a.length >= 2) {
                Path c = m5586c((am) anVar);
                m5537a((bf) anVar);
                m5588c((bf) anVar);
                m5590d(anVar);
                boolean m = m5602m();
                if (this.f3397f.f3432b) {
                    m5538a((bf) anVar, c);
                }
                if (this.f3397f.f3433c) {
                    m5521a(c);
                }
                m5561a((C0914y) anVar);
                if (m) {
                    m5580b((bf) anVar);
                }
            }
        }
    }

    private void m5531a(ao aoVar) {
        cb.m5594f("Rect render", new Object[0]);
        if (aoVar.f3258c != null && aoVar.f3259d != null && !aoVar.f3258c.m5465b() && !aoVar.f3259d.m5465b()) {
            m5556a(this.f3397f, (bg) aoVar);
            if (m5607r() && m5608s()) {
                if (aoVar.e != null) {
                    this.f3392a.concat(aoVar.e);
                }
                Path b = m5572b(aoVar);
                m5537a((bf) aoVar);
                m5588c((bf) aoVar);
                m5590d(aoVar);
                boolean m = m5602m();
                if (this.f3397f.f3432b) {
                    m5538a((bf) aoVar, b);
                }
                if (this.f3397f.f3433c) {
                    m5521a(b);
                }
                if (m) {
                    m5580b((bf) aoVar);
                }
            }
        }
    }

    private void m5532a(ba baVar) {
        m5533a(baVar, baVar.f3337c, baVar.f3338d);
    }

    private void m5533a(ba baVar, ac acVar, ac acVar2) {
        m5534a(baVar, acVar, acVar2, baVar.x, baVar.w);
    }

    private void m5534a(ba baVar, ac acVar, ac acVar2, C0930o c0930o, C0926k c0926k) {
        float f = 0.0f;
        cb.m5594f("Svg render", new Object[0]);
        if (acVar != null && acVar.m5465b()) {
            return;
        }
        if (acVar2 == null || !acVar2.m5465b()) {
            C0926k c0926k2 = c0926k == null ? baVar.w != null ? baVar.w : C0926k.f3546c : c0926k;
            m5556a(this.f3397f, (bg) baVar);
            if (m5607r()) {
                float a;
                if (baVar.v != null) {
                    a = baVar.f3335a != null ? baVar.f3335a.m5462a(this) : 0.0f;
                    if (baVar.f3336b != null) {
                        f = baVar.f3336b.m5464b(this);
                    }
                } else {
                    a = 0.0f;
                }
                C0930o d = m5618d();
                this.f3397f.f3436f = new C0930o(a, f, acVar != null ? acVar.m5462a(this) : d.f3578c, acVar2 != null ? acVar2.m5464b(this) : d.f3579d);
                if (!this.f3397f.f3431a.f3296v.booleanValue()) {
                    m5519a(this.f3397f.f3436f.f3576a, this.f3397f.f3436f.f3577b, this.f3397f.f3436f.f3578c, this.f3397f.f3436f.f3579d);
                }
                m5540a((bf) baVar, this.f3397f.f3436f);
                if (c0930o != null) {
                    this.f3392a.concat(m5515a(this.f3397f.f3436f, c0930o, c0926k2));
                    this.f3397f.f3437g = baVar.x;
                }
                boolean m = m5602m();
                m5610u();
                m5536a((be) baVar, true);
                if (m) {
                    m5580b((bf) baVar);
                }
                m5537a((bf) baVar);
            }
        }
    }

    private void m5535a(be beVar) {
        this.f3399h.push(beVar);
        this.f3400i.push(this.f3392a.getMatrix());
    }

    private void m5536a(be beVar, boolean z) {
        if (z) {
            m5535a(beVar);
        }
        for (bi a : beVar.m5444a()) {
            m5542a(a);
        }
        if (z) {
            m5601l();
        }
    }

    private void m5537a(bf bfVar) {
        if (bfVar.v != null && bfVar.f3201o != null) {
            Matrix matrix = new Matrix();
            if (((Matrix) this.f3400i.peek()).invert(matrix)) {
                float[] fArr = new float[]{bfVar.f3201o.f3576a, bfVar.f3201o.f3577b, bfVar.f3201o.m5806a(), bfVar.f3201o.f3577b, bfVar.f3201o.m5806a(), bfVar.f3201o.m5808b(), bfVar.f3201o.f3576a, bfVar.f3201o.m5808b()};
                matrix.preConcat(this.f3392a.getMatrix());
                matrix.mapPoints(fArr);
                RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                for (int i = 2; i <= 6; i += 2) {
                    if (fArr[i] < rectF.left) {
                        rectF.left = fArr[i];
                    }
                    if (fArr[i] > rectF.right) {
                        rectF.right = fArr[i];
                    }
                    if (fArr[i + 1] < rectF.top) {
                        rectF.top = fArr[i + 1];
                    }
                    if (fArr[i + 1] > rectF.bottom) {
                        rectF.bottom = fArr[i + 1];
                    }
                }
                bf bfVar2 = (bf) this.f3399h.peek();
                if (bfVar2.f3201o == null) {
                    bfVar2.f3201o = C0930o.m5805a(rectF.left, rectF.top, rectF.right, rectF.bottom);
                } else {
                    bfVar2.f3201o.m5807a(C0930o.m5805a(rectF.left, rectF.top, rectF.right, rectF.bottom));
                }
            }
        }
    }

    private void m5538a(bf bfVar, Path path) {
        if (this.f3397f.f3431a.f3276b instanceof ah) {
            bi a = this.f3396e.m5795a(((ah) this.f3397f.f3431a.f3276b).f3241a);
            if (a instanceof al) {
                m5539a(bfVar, path, (al) a);
                return;
            }
        }
        this.f3392a.drawPath(path, this.f3397f.f3434d);
    }

    private void m5539a(bf bfVar, Path path, al alVar) {
        float b;
        float a;
        float b2;
        float a2;
        Object obj = (alVar.f3247a == null || !alVar.f3247a.booleanValue()) ? null : 1;
        if (alVar.f3254h != null) {
            m5528a(alVar, alVar.f3254h);
        }
        if (obj != null) {
            b = alVar.f3253g != null ? alVar.f3253g.m5464b(this) : 0.0f;
            a = alVar.f3252f != null ? alVar.f3252f.m5462a(this) : 0.0f;
            b2 = alVar.f3251e != null ? alVar.f3251e.m5464b(this) : 0.0f;
            a2 = alVar.f3250d != null ? alVar.f3250d.m5462a(this) : 0.0f;
        } else {
            b = (alVar.f3253g != null ? alVar.f3253g.m5463a(this, 1.0f) : 0.0f) * bfVar.f3201o.f3579d;
            a = (alVar.f3252f != null ? alVar.f3252f.m5463a(this, 1.0f) : 0.0f) * bfVar.f3201o.f3578c;
            b2 = ((alVar.f3251e != null ? alVar.f3251e.m5463a(this, 1.0f) : 0.0f) * bfVar.f3201o.f3579d) + bfVar.f3201o.f3577b;
            a2 = ((alVar.f3250d != null ? alVar.f3250d.m5463a(this, 1.0f) : 0.0f) * bfVar.f3201o.f3578c) + bfVar.f3201o.f3576a;
        }
        if (a != 0.0f && b != 0.0f) {
            C0926k c0926k = alVar.w != null ? alVar.w : C0926k.f3546c;
            m5599j();
            this.f3392a.clipPath(path);
            ci ciVar = new ci(this);
            m5555a(ciVar, ar.m5497a());
            ciVar.f3431a.f3296v = Boolean.valueOf(false);
            this.f3397f = m5517a((bi) alVar, ciVar);
            C0930o c0930o = bfVar.f3201o;
            if (alVar.f3249c != null) {
                this.f3392a.concat(alVar.f3249c);
                Matrix matrix = new Matrix();
                if (alVar.f3249c.invert(matrix)) {
                    float[] fArr = new float[]{bfVar.f3201o.f3576a, bfVar.f3201o.f3577b, bfVar.f3201o.m5806a(), bfVar.f3201o.f3577b, bfVar.f3201o.m5806a(), bfVar.f3201o.m5808b(), bfVar.f3201o.f3576a, bfVar.f3201o.m5808b()};
                    matrix.mapPoints(fArr);
                    RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                    for (int i = 2; i <= 6; i += 2) {
                        if (fArr[i] < rectF.left) {
                            rectF.left = fArr[i];
                        }
                        if (fArr[i] > rectF.right) {
                            rectF.right = fArr[i];
                        }
                        if (fArr[i + 1] < rectF.top) {
                            rectF.top = fArr[i + 1];
                        }
                        if (fArr[i + 1] > rectF.bottom) {
                            rectF.bottom = fArr[i + 1];
                        }
                    }
                    c0930o = new C0930o(rectF.left, rectF.top, rectF.right - rectF.left, rectF.bottom - rectF.top);
                }
            }
            a2 += ((float) Math.floor((double) ((c0930o.f3576a - a2) / a))) * a;
            b2 += ((float) Math.floor((double) ((c0930o.f3577b - b2) / b))) * b;
            float a3 = c0930o.m5806a();
            float b3 = c0930o.m5808b();
            C0930o c0930o2 = new C0930o(0.0f, 0.0f, a, b);
            for (float f = b2; f < b3; f += b) {
                for (b2 = a2; b2 < a3; b2 += a) {
                    c0930o2.f3576a = b2;
                    c0930o2.f3577b = f;
                    m5599j();
                    if (!this.f3397f.f3431a.f3296v.booleanValue()) {
                        m5519a(c0930o2.f3576a, c0930o2.f3577b, c0930o2.f3578c, c0930o2.f3579d);
                    }
                    if (alVar.x != null) {
                        this.f3392a.concat(m5515a(c0930o2, alVar.x, c0926k));
                    } else {
                        obj = (alVar.f3248b == null || alVar.f3248b.booleanValue()) ? 1 : null;
                        this.f3392a.translate(b2, f);
                        if (obj == null) {
                            this.f3392a.scale(bfVar.f3201o.f3578c, bfVar.f3201o.f3579d);
                        }
                    }
                    boolean m = m5602m();
                    for (bi a4 : alVar.i) {
                        m5542a(a4);
                    }
                    if (m) {
                        m5580b((bf) alVar);
                    }
                    m5600k();
                }
            }
            m5600k();
        }
    }

    private void m5540a(bf bfVar, C0930o c0930o) {
        if (this.f3397f.f3431a.f3267E != null) {
            bi a = bfVar.u.m5795a(this.f3397f.f3431a.f3267E);
            if (a == null) {
                cb.m5592e("ClipPath reference '%s' not found", this.f3397f.f3431a.f3267E);
                return;
            }
            a = (C0933r) a;
            if (a.i.isEmpty()) {
                this.f3392a.clipRect(0, 0, 0, 0);
                return;
            }
            int i;
            if (a.f3587a == null || a.f3587a.booleanValue()) {
                boolean z = true;
            } else {
                i = 0;
            }
            if ((bfVar instanceof C0917z) && i == 0) {
                cb.m5591d("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", bfVar.getClass().getSimpleName());
                return;
            }
            m5611v();
            if (i == 0) {
                Matrix matrix = new Matrix();
                matrix.preTranslate(c0930o.f3576a, c0930o.f3577b);
                matrix.preScale(c0930o.f3578c, c0930o.f3579d);
                this.f3392a.concat(matrix);
            }
            if (a.b != null) {
                this.f3392a.concat(a.b);
            }
            this.f3397f = m5587c(a);
            m5590d(a);
            Path path = new Path();
            for (bi a2 : a2.i) {
                m5544a(a2, true, path, new Matrix());
            }
            this.f3392a.clipPath(path);
            m5612w();
        }
    }

    private void m5541a(bh bhVar, bh bhVar2) {
        if (bhVar.f3345f == null) {
            bhVar.f3345f = bhVar2.f3345f;
        }
        if (bhVar.f3346g == null) {
            bhVar.f3346g = bhVar2.f3346g;
        }
        if (bhVar.f3347h == null) {
            bhVar.f3347h = bhVar2.f3347h;
        }
        if (bhVar.f3348i == null) {
            bhVar.f3348i = bhVar2.f3348i;
        }
    }

    private void m5542a(bi biVar) {
        if (!(biVar instanceof ag)) {
            m5599j();
            m5581b(biVar);
            if (biVar instanceof ba) {
                m5532a((ba) biVar);
            } else if (biVar instanceof bz) {
                m5553a((bz) biVar);
            } else if (biVar instanceof bn) {
                m5546a((bn) biVar);
            } else if (biVar instanceof C0917z) {
                m5563a((C0917z) biVar);
            } else if (biVar instanceof ab) {
                m5522a((ab) biVar);
            } else if (biVar instanceof ai) {
                m5526a((ai) biVar);
            } else if (biVar instanceof ao) {
                m5531a((ao) biVar);
            } else if (biVar instanceof C0932q) {
                m5558a((C0932q) biVar);
            } else if (biVar instanceof C0937v) {
                m5559a((C0937v) biVar);
            } else if (biVar instanceof ad) {
                m5523a((ad) biVar);
            } else if (biVar instanceof an) {
                m5530a((an) biVar);
            } else if (biVar instanceof am) {
                m5529a((am) biVar);
            } else if (biVar instanceof br) {
                m5548a((br) biVar);
            }
            m5600k();
        }
    }

    private void m5543a(bi biVar, ck ckVar) {
        float f = 0.0f;
        if (!ckVar.m5636a((bt) biVar)) {
            return;
        }
        if (biVar instanceof bu) {
            m5599j();
            m5552a((bu) biVar);
            m5600k();
        } else if (biVar instanceof bq) {
            cb.m5594f("TSpan render", new Object[0]);
            m5599j();
            bf bfVar = (bq) biVar;
            m5556a(this.f3397f, (bg) bfVar);
            if (m5607r()) {
                float a;
                float b;
                float a2;
                if (ckVar instanceof cg) {
                    a = (bfVar.b == null || bfVar.b.size() == 0) ? ((cg) ckVar).f3422b : ((ac) bfVar.b.get(0)).m5462a(this);
                    b = (bfVar.c == null || bfVar.c.size() == 0) ? ((cg) ckVar).f3423c : ((ac) bfVar.c.get(0)).m5464b(this);
                    a2 = (bfVar.d == null || bfVar.d.size() == 0) ? 0.0f : ((ac) bfVar.d.get(0)).m5462a(this);
                    if (!(bfVar.e == null || bfVar.e.size() == 0)) {
                        f = ((ac) bfVar.e.get(0)).m5464b(this);
                    }
                } else {
                    a2 = 0.0f;
                    b = 0.0f;
                    a = 0.0f;
                }
                m5588c((bf) bfVar.m5507g());
                if (ckVar instanceof cg) {
                    ((cg) ckVar).f3422b = a + a2;
                    ((cg) ckVar).f3423c = b + f;
                }
                boolean m = m5602m();
                m5550a((bt) bfVar, ckVar);
                if (m) {
                    m5580b(bfVar);
                }
            }
            m5600k();
        } else if (biVar instanceof bp) {
            m5599j();
            bg bgVar = (bp) biVar;
            m5556a(this.f3397f, bgVar);
            if (m5607r()) {
                m5588c((bf) bgVar.m5505g());
                bi a3 = biVar.f3194u.m5795a(bgVar.f3355a);
                if (a3 == null || !(a3 instanceof bt)) {
                    cb.m5592e("Tref reference '%s' not found", bgVar.f3355a);
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    m5551a((bt) a3, stringBuilder);
                    if (stringBuilder.length() > 0) {
                        ckVar.m5635a(stringBuilder.toString());
                    }
                }
            }
            m5600k();
        }
    }

    private void m5544a(bi biVar, boolean z, Path path, Matrix matrix) {
        if (m5607r()) {
            m5611v();
            if (biVar instanceof bz) {
                if (z) {
                    m5554a((bz) biVar, path, matrix);
                } else {
                    cb.m5592e("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
            } else if (biVar instanceof ai) {
                m5527a((ai) biVar, path, matrix);
            } else if (biVar instanceof br) {
                m5549a((br) biVar, path, matrix);
            } else if (biVar instanceof C0914y) {
                m5562a((C0914y) biVar, path, matrix);
            } else {
                cb.m5592e("Invalid %s element found in clipPath definition", biVar.getClass().getSimpleName());
            }
            m5612w();
        }
    }

    private void m5545a(bl blVar, bl blVar2) {
        if (blVar.f3349f == null) {
            blVar.f3349f = blVar2.f3349f;
        }
        if (blVar.f3350g == null) {
            blVar.f3350g = blVar2.f3350g;
        }
        if (blVar.f3351h == null) {
            blVar.f3351h = blVar2.f3351h;
        }
        if (blVar.f3352i == null) {
            blVar.f3352i = blVar2.f3352i;
        }
        if (blVar.f3353j == null) {
            blVar.f3353j = blVar2.f3353j;
        }
    }

    private void m5546a(bn bnVar) {
        cb.m5594f("Switch render", new Object[0]);
        m5556a(this.f3397f, (bg) bnVar);
        if (m5607r()) {
            if (bnVar.b != null) {
                this.f3392a.concat(bnVar.b);
            }
            m5590d(bnVar);
            boolean m = m5602m();
            m5582b(bnVar);
            if (m) {
                m5580b((bf) bnVar);
            }
            m5537a((bf) bnVar);
        }
    }

    private void m5547a(bo boVar, ac acVar, ac acVar2) {
        cb.m5594f("Symbol render", new Object[0]);
        if (acVar != null && acVar.m5465b()) {
            return;
        }
        if (acVar2 == null || !acVar2.m5465b()) {
            C0926k c0926k = boVar.w != null ? boVar.w : C0926k.f3546c;
            m5556a(this.f3397f, (bg) boVar);
            this.f3397f.f3436f = new C0930o(0.0f, 0.0f, acVar != null ? acVar.m5462a(this) : this.f3397f.f3436f.f3578c, acVar2 != null ? acVar2.m5462a(this) : this.f3397f.f3436f.f3579d);
            if (!this.f3397f.f3431a.f3296v.booleanValue()) {
                m5519a(this.f3397f.f3436f.f3576a, this.f3397f.f3436f.f3577b, this.f3397f.f3436f.f3578c, this.f3397f.f3436f.f3579d);
            }
            if (boVar.x != null) {
                this.f3392a.concat(m5515a(this.f3397f.f3436f, boVar.x, c0926k));
                this.f3397f.f3437g = boVar.x;
            }
            boolean m = m5602m();
            m5536a((be) boVar, true);
            if (m) {
                m5580b((bf) boVar);
            }
            m5537a((bf) boVar);
        }
    }

    private void m5548a(br brVar) {
        float f = 0.0f;
        cb.m5594f("Text render", new Object[0]);
        m5556a(this.f3397f, (bg) brVar);
        if (m5607r()) {
            if (brVar.f3362a != null) {
                this.f3392a.concat(brVar.f3362a);
            }
            float a = (brVar.b == null || brVar.b.size() == 0) ? 0.0f : ((ac) brVar.b.get(0)).m5462a(this);
            float b = (brVar.c == null || brVar.c.size() == 0) ? 0.0f : ((ac) brVar.c.get(0)).m5464b(this);
            float a2 = (brVar.d == null || brVar.d.size() == 0) ? 0.0f : ((ac) brVar.d.get(0)).m5462a(this);
            if (!(brVar.e == null || brVar.e.size() == 0)) {
                f = ((ac) brVar.e.get(0)).m5464b(this);
            }
            aw q = m5606q();
            if (q != aw.Start) {
                float a3 = m5512a((bt) brVar);
                a = q == aw.Middle ? a - (a3 / 2.0f) : a - a3;
            }
            if (brVar.o == null) {
                ck cjVar = new cj(this, a, b);
                m5550a((bt) brVar, cjVar);
                brVar.o = new C0930o(cjVar.f3443c.left, cjVar.f3443c.top, cjVar.f3443c.width(), cjVar.f3443c.height());
            }
            m5537a((bf) brVar);
            m5588c((bf) brVar);
            m5590d(brVar);
            boolean m = m5602m();
            m5550a((bt) brVar, new cg(this, a + a2, f + b));
            if (m) {
                m5580b((bf) brVar);
            }
        }
    }

    private void m5549a(br brVar, Path path, Matrix matrix) {
        float f = 0.0f;
        m5556a(this.f3397f, (bg) brVar);
        if (m5607r()) {
            if (brVar.f3362a != null) {
                matrix.preConcat(brVar.f3362a);
            }
            float a = (brVar.b == null || brVar.b.size() == 0) ? 0.0f : ((ac) brVar.b.get(0)).m5462a(this);
            float b = (brVar.c == null || brVar.c.size() == 0) ? 0.0f : ((ac) brVar.c.get(0)).m5464b(this);
            float a2 = (brVar.d == null || brVar.d.size() == 0) ? 0.0f : ((ac) brVar.d.get(0)).m5462a(this);
            if (!(brVar.e == null || brVar.e.size() == 0)) {
                f = ((ac) brVar.e.get(0)).m5464b(this);
            }
            if (this.f3397f.f3431a.f3295u != aw.Start) {
                float a3 = m5512a((bt) brVar);
                a = this.f3397f.f3431a.f3295u == aw.Middle ? a - (a3 / 2.0f) : a - a3;
            }
            if (brVar.o == null) {
                ck cjVar = new cj(this, a, b);
                m5550a((bt) brVar, cjVar);
                brVar.o = new C0930o(cjVar.f3443c.left, cjVar.f3443c.top, cjVar.f3443c.width(), cjVar.f3443c.height());
            }
            m5590d(brVar);
            Path path2 = new Path();
            m5550a((bt) brVar, new ch(this, a + a2, f + b, path2));
            path.setFillType(m5613x());
            path.addPath(path2, matrix);
        }
    }

    private void m5550a(bt btVar, ck ckVar) {
        if (m5607r()) {
            Iterator it = btVar.i.iterator();
            boolean z = true;
            while (it.hasNext()) {
                bi biVar = (bi) it.next();
                if (biVar instanceof bx) {
                    ckVar.m5635a(m5518a(((bx) biVar).f3366a, z, !it.hasNext()));
                } else {
                    m5543a(biVar, ckVar);
                }
                z = false;
            }
        }
    }

    private void m5551a(bt btVar, StringBuilder stringBuilder) {
        Iterator it = btVar.i.iterator();
        boolean z = true;
        while (it.hasNext()) {
            bi biVar = (bi) it.next();
            if (biVar instanceof bt) {
                m5551a((bt) biVar, stringBuilder);
            } else if (biVar instanceof bx) {
                stringBuilder.append(m5518a(((bx) biVar).f3366a, z, !it.hasNext()));
            }
            z = false;
        }
    }

    private void m5552a(bu buVar) {
        cb.m5594f("TextPath render", new Object[0]);
        m5556a(this.f3397f, (bg) buVar);
        if (m5607r() && m5608s()) {
            bi a = buVar.u.m5795a(buVar.f3363a);
            if (a == null) {
                cb.m5592e("TextPath reference '%s' not found", buVar.f3363a);
                return;
            }
            float f;
            ai aiVar = (ai) a;
            Path a2 = new ce(this, aiVar.f3243a).m5628a();
            if (aiVar.e != null) {
                a2.transform(aiVar.e);
            }
            float a3 = buVar.f3364b != null ? buVar.f3364b.m5463a(this, new PathMeasure(a2, false).getLength()) : 0.0f;
            aw q = m5606q();
            if (q != aw.Start) {
                float a4 = m5512a((bt) buVar);
                f = q == aw.Middle ? a3 - (a4 / 2.0f) : a3 - a4;
            } else {
                f = a3;
            }
            m5588c((bf) buVar.m5510g());
            boolean m = m5602m();
            m5550a((bt) buVar, new cf(this, a2, f, 0.0f));
            if (m) {
                m5580b((bf) buVar);
            }
        }
    }

    private void m5553a(bz bzVar) {
        float f = 0.0f;
        cb.m5594f("Use render", new Object[0]);
        if (bzVar.f3381e != null && bzVar.f3381e.m5465b()) {
            return;
        }
        if (bzVar.f3382f == null || !bzVar.f3382f.m5465b()) {
            m5556a(this.f3397f, (bg) bzVar);
            if (m5607r()) {
                bi a = bzVar.u.m5795a(bzVar.f3378a);
                if (a == null) {
                    cb.m5592e("Use reference '%s' not found", bzVar.f3378a);
                    return;
                }
                if (bzVar.b != null) {
                    this.f3392a.concat(bzVar.b);
                }
                Matrix matrix = new Matrix();
                float a2 = bzVar.f3379c != null ? bzVar.f3379c.m5462a(this) : 0.0f;
                if (bzVar.f3380d != null) {
                    f = bzVar.f3380d.m5464b(this);
                }
                matrix.preTranslate(a2, f);
                this.f3392a.concat(matrix);
                m5590d(bzVar);
                boolean m = m5602m();
                m5535a((be) bzVar);
                if (a instanceof ba) {
                    m5599j();
                    ba baVar = (ba) a;
                    m5533a(baVar, bzVar.f3381e != null ? bzVar.f3381e : baVar.f3337c, bzVar.f3382f != null ? bzVar.f3382f : baVar.f3338d);
                    m5600k();
                } else if (a instanceof bo) {
                    ac acVar = bzVar.f3381e != null ? bzVar.f3381e : new ac(100.0f, by.percent);
                    ac acVar2 = bzVar.f3382f != null ? bzVar.f3382f : new ac(100.0f, by.percent);
                    m5599j();
                    m5547a((bo) a, acVar, acVar2);
                    m5600k();
                } else {
                    m5542a(a);
                }
                m5601l();
                if (m) {
                    m5580b((bf) bzVar);
                }
                m5537a((bf) bzVar);
            }
        }
    }

    private void m5554a(bz bzVar, Path path, Matrix matrix) {
        m5556a(this.f3397f, (bg) bzVar);
        if (m5607r() && m5608s()) {
            if (bzVar.b != null) {
                matrix.preConcat(bzVar.b);
            }
            bi a = bzVar.u.m5795a(bzVar.f3378a);
            if (a == null) {
                cb.m5592e("Use reference '%s' not found", bzVar.f3378a);
                return;
            }
            m5590d(bzVar);
            m5544a(a, false, path, matrix);
        }
    }

    private void m5555a(ci ciVar, ar arVar) {
        float c;
        boolean z = true;
        if (m5569a(arVar, 4096)) {
            ciVar.f3431a.f3288n = arVar.f3288n;
        }
        if (m5569a(arVar, 2048)) {
            ciVar.f3431a.f3287m = arVar.f3287m;
        }
        if (m5569a(arVar, 1)) {
            ciVar.f3431a.f3276b = arVar.f3276b;
            ciVar.f3432b = arVar.f3276b != null;
        }
        if (m5569a(arVar, 4)) {
            ciVar.f3431a.f3278d = arVar.f3278d;
        }
        if (m5569a(arVar, 6149)) {
            m5557a(ciVar, true, ciVar.f3431a.f3276b);
        }
        if (m5569a(arVar, 2)) {
            ciVar.f3431a.f3277c = arVar.f3277c;
        }
        if (m5569a(arVar, 8)) {
            ciVar.f3431a.f3279e = arVar.f3279e;
            ciVar.f3433c = arVar.f3279e != null;
        }
        if (m5569a(arVar, 16)) {
            ciVar.f3431a.f3280f = arVar.f3280f;
        }
        if (m5569a(arVar, 6168)) {
            m5557a(ciVar, false, ciVar.f3431a.f3279e);
        }
        if (m5569a(arVar, 34359738368L)) {
            ciVar.f3431a.f3274L = arVar.f3274L;
        }
        if (m5569a(arVar, 32)) {
            ciVar.f3431a.f3281g = arVar.f3281g;
            ciVar.f3435e.setStrokeWidth(ciVar.f3431a.f3281g.m5466c(this));
        }
        if (m5569a(arVar, 64)) {
            ciVar.f3431a.f3282h = arVar.f3282h;
            switch (cb.m5595f()[arVar.f3282h.ordinal()]) {
                case VideoSize.CIF /*1*/:
                    ciVar.f3435e.setStrokeCap(Cap.BUTT);
                    break;
                case VideoSize.HVGA /*2*/:
                    ciVar.f3435e.setStrokeCap(Cap.ROUND);
                    break;
                case Version.API03_CUPCAKE_15 /*3*/:
                    ciVar.f3435e.setStrokeCap(Cap.SQUARE);
                    break;
            }
        }
        if (m5569a(arVar, 128)) {
            ciVar.f3431a.f3283i = arVar.f3283i;
            switch (cb.m5596g()[arVar.f3283i.ordinal()]) {
                case VideoSize.CIF /*1*/:
                    ciVar.f3435e.setStrokeJoin(Join.MITER);
                    break;
                case VideoSize.HVGA /*2*/:
                    ciVar.f3435e.setStrokeJoin(Join.ROUND);
                    break;
                case Version.API03_CUPCAKE_15 /*3*/:
                    ciVar.f3435e.setStrokeJoin(Join.BEVEL);
                    break;
            }
        }
        if (m5569a(arVar, 256)) {
            ciVar.f3431a.f3284j = arVar.f3284j;
            ciVar.f3435e.setStrokeMiter(arVar.f3284j.floatValue());
        }
        if (m5569a(arVar, 512)) {
            ciVar.f3431a.f3285k = arVar.f3285k;
        }
        if (m5569a(arVar, 1024)) {
            ciVar.f3431a.f3286l = arVar.f3286l;
        }
        if (m5569a(arVar, 1536)) {
            if (ciVar.f3431a.f3285k == null) {
                ciVar.f3435e.setPathEffect(null);
            } else {
                int length = ciVar.f3431a.f3285k.length;
                int i = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i];
                float f = 0.0f;
                for (int i2 = 0; i2 < i; i2++) {
                    fArr[i2] = ciVar.f3431a.f3285k[i2 % length].m5466c(this);
                    f += fArr[i2];
                }
                if (f == 0.0f) {
                    ciVar.f3435e.setPathEffect(null);
                } else {
                    c = ciVar.f3431a.f3286l.m5466c(this);
                    if (c < 0.0f) {
                        c = (c % f) + f;
                    }
                    ciVar.f3435e.setPathEffect(new DashPathEffect(fArr, c));
                }
            }
        }
        if (m5569a(arVar, 16384)) {
            c = m5616b();
            ciVar.f3431a.f3290p = arVar.f3290p;
            ciVar.f3434d.setTextSize(arVar.f3290p.m5463a(this, c));
            ciVar.f3435e.setTextSize(arVar.f3290p.m5463a(this, c));
        }
        if (m5569a(arVar, 8192)) {
            ciVar.f3431a.f3289o = arVar.f3289o;
        }
        if (m5569a(arVar, 32768)) {
            ar arVar2;
            if (arVar.f3291q.intValue() == -1 && ciVar.f3431a.f3291q.intValue() > 100) {
                arVar2 = ciVar.f3431a;
                arVar2.f3291q = Integer.valueOf(arVar2.f3291q.intValue() - 100);
            } else if (arVar.f3291q.intValue() != 1 || ciVar.f3431a.f3291q.intValue() >= 900) {
                ciVar.f3431a.f3291q = arVar.f3291q;
            } else {
                arVar2 = ciVar.f3431a;
                arVar2.f3291q = Integer.valueOf(arVar2.f3291q.intValue() + 100);
            }
        }
        if (m5569a(arVar, 65536)) {
            ciVar.f3431a.f3292r = arVar.f3292r;
        }
        if (m5569a(arVar, 106496)) {
            Typeface typeface;
            if (ciVar.f3431a.f3289o == null || this.f3396e == null) {
                typeface = null;
            } else {
                cm e = this.f3396e.m5804e();
                typeface = null;
                for (String str : ciVar.f3431a.f3289o) {
                    Typeface a = m5516a(str, ciVar.f3431a.f3291q, ciVar.f3431a.f3292r);
                    if (a != null || e == null) {
                        typeface = a;
                        continue;
                    } else {
                        typeface = e.m5645a(str, ciVar.f3431a.f3291q.intValue(), String.valueOf(ciVar.f3431a.f3292r));
                        continue;
                    }
                    if (typeface != null) {
                    }
                }
            }
            if (typeface == null) {
                typeface = m5516a("sans-serif", ciVar.f3431a.f3291q, ciVar.f3431a.f3292r);
            }
            ciVar.f3434d.setTypeface(typeface);
            ciVar.f3435e.setTypeface(typeface);
        }
        if (m5569a(arVar, 131072)) {
            ciVar.f3431a.f3293s = arVar.f3293s;
            ciVar.f3434d.setStrikeThruText(arVar.f3293s == ax.LineThrough);
            ciVar.f3434d.setUnderlineText(arVar.f3293s == ax.Underline);
            if (VERSION.SDK_INT >= 17) {
                ciVar.f3435e.setStrikeThruText(arVar.f3293s == ax.LineThrough);
                Paint paint = ciVar.f3435e;
                if (arVar.f3293s != ax.Underline) {
                    z = false;
                }
                paint.setUnderlineText(z);
            }
        }
        if (m5569a(arVar, 68719476736L)) {
            ciVar.f3431a.f3294t = arVar.f3294t;
        }
        if (m5569a(arVar, 262144)) {
            ciVar.f3431a.f3295u = arVar.f3295u;
        }
        if (m5569a(arVar, 524288)) {
            ciVar.f3431a.f3296v = arVar.f3296v;
        }
        if (m5569a(arVar, 2097152)) {
            ciVar.f3431a.f3298x = arVar.f3298x;
        }
        if (m5569a(arVar, 4194304)) {
            ciVar.f3431a.f3299y = arVar.f3299y;
        }
        if (m5569a(arVar, 8388608)) {
            ciVar.f3431a.f3300z = arVar.f3300z;
        }
        if (m5569a(arVar, 16777216)) {
            ciVar.f3431a.f3263A = arVar.f3263A;
        }
        if (m5569a(arVar, 33554432)) {
            ciVar.f3431a.f3264B = arVar.f3264B;
        }
        if (m5569a(arVar, 1048576)) {
            ciVar.f3431a.f3297w = arVar.f3297w;
        }
        if (m5569a(arVar, 268435456)) {
            ciVar.f3431a.f3267E = arVar.f3267E;
        }
        if (m5569a(arVar, 536870912)) {
            ciVar.f3431a.f3268F = arVar.f3268F;
        }
        if (m5569a(arVar, 1073741824)) {
            ciVar.f3431a.f3269G = arVar.f3269G;
        }
        if (m5569a(arVar, 67108864)) {
            ciVar.f3431a.f3265C = arVar.f3265C;
        }
        if (m5569a(arVar, 134217728)) {
            ciVar.f3431a.f3266D = arVar.f3266D;
        }
        if (m5569a(arVar, 8589934592L)) {
            ciVar.f3431a.f3272J = arVar.f3272J;
        }
        if (m5569a(arVar, 17179869184L)) {
            ciVar.f3431a.f3273K = arVar.f3273K;
        }
    }

    private void m5556a(ci ciVar, bg bgVar) {
        ciVar.f3431a.m5498a(bgVar.v == null);
        if (bgVar.f3198r != null) {
            m5555a(ciVar, bgVar.f3198r);
        }
        if (this.f3396e.m5803d()) {
            for (C0922g c0922g : this.f3396e.m5800c()) {
                if (C0913a.m5422a(c0922g.f3534a, bgVar)) {
                    m5555a(ciVar, c0922g.f3535b);
                }
            }
        }
        if (bgVar.f3199s != null) {
            m5555a(ciVar, bgVar.f3199s);
        }
    }

    private void m5557a(ci ciVar, boolean z, bj bjVar) {
        int i;
        float floatValue = (z ? ciVar.f3431a.f3278d : ciVar.f3431a.f3280f).floatValue();
        if (bjVar instanceof C0934s) {
            i = ((C0934s) bjVar).f3589a;
        } else if (bjVar instanceof C0935t) {
            i = ciVar.f3431a.f3288n.f3589a;
        } else {
            return;
        }
        i |= m5513a(floatValue) << 24;
        if (z) {
            ciVar.f3434d.setColor(i);
        } else {
            ciVar.f3435e.setColor(i);
        }
    }

    private void m5558a(C0932q c0932q) {
        cb.m5594f("Circle render", new Object[0]);
        if (c0932q.f3586c != null && !c0932q.f3586c.m5465b()) {
            m5556a(this.f3397f, (bg) c0932q);
            if (m5607r() && m5608s()) {
                if (c0932q.e != null) {
                    this.f3392a.concat(c0932q.e);
                }
                Path b = m5573b(c0932q);
                m5537a((bf) c0932q);
                m5588c((bf) c0932q);
                m5590d(c0932q);
                boolean m = m5602m();
                if (this.f3397f.f3432b) {
                    m5538a((bf) c0932q, b);
                }
                if (this.f3397f.f3433c) {
                    m5521a(b);
                }
                if (m) {
                    m5580b((bf) c0932q);
                }
            }
        }
    }

    private void m5559a(C0937v c0937v) {
        cb.m5594f("Ellipse render", new Object[0]);
        if (c0937v.f3593c != null && c0937v.f3594d != null && !c0937v.f3593c.m5465b() && !c0937v.f3594d.m5465b()) {
            m5556a(this.f3397f, (bg) c0937v);
            if (m5607r() && m5608s()) {
                if (c0937v.e != null) {
                    this.f3392a.concat(c0937v.e);
                }
                Path b = m5574b(c0937v);
                m5537a((bf) c0937v);
                m5588c((bf) c0937v);
                m5590d(c0937v);
                boolean m = m5602m();
                if (this.f3397f.f3432b) {
                    m5538a((bf) c0937v, b);
                }
                if (this.f3397f.f3433c) {
                    m5521a(b);
                }
                if (m) {
                    m5580b((bf) c0937v);
                }
            }
        }
    }

    private void m5560a(C0916w c0916w, String str) {
        bi a = c0916w.u.m5795a(str);
        if (a == null) {
            cb.m5591d("Gradient reference '%s' not found", str);
        } else if (!(a instanceof C0916w)) {
            cb.m5592e("Gradient href attributes must point to other gradient elements", new Object[0]);
        } else if (a == c0916w) {
            cb.m5592e("Circular reference in gradient href attribute '%s'", str);
        } else {
            C0916w c0916w2 = (C0916w) a;
            if (c0916w.f3341b == null) {
                c0916w.f3341b = c0916w2.f3341b;
            }
            if (c0916w.f3342c == null) {
                c0916w.f3342c = c0916w2.f3342c;
            }
            if (c0916w.f3343d == null) {
                c0916w.f3343d = c0916w2.f3343d;
            }
            if (c0916w.f3340a.isEmpty()) {
                c0916w.f3340a = c0916w2.f3340a;
            }
            try {
                if (c0916w instanceof bh) {
                    m5541a((bh) c0916w, (bh) a);
                } else {
                    m5545a((bl) c0916w, (bl) a);
                }
            } catch (ClassCastException e) {
            }
            if (c0916w2.f3344e != null) {
                m5560a(c0916w, c0916w2.f3344e);
            }
        }
    }

    private void m5561a(C0914y c0914y) {
        if (this.f3397f.f3431a.f3298x != null || this.f3397f.f3431a.f3299y != null || this.f3397f.f3431a.f3300z != null) {
            bi a;
            ae aeVar;
            ae aeVar2;
            ae aeVar3;
            List a2;
            int size;
            ar arVar;
            ar arVar2;
            int i;
            if (this.f3397f.f3431a.f3298x != null) {
                a = c0914y.u.m5795a(this.f3397f.f3431a.f3298x);
                if (a != null) {
                    aeVar = (ae) a;
                    if (this.f3397f.f3431a.f3299y != null) {
                        a = c0914y.u.m5795a(this.f3397f.f3431a.f3299y);
                        if (a == null) {
                            aeVar2 = (ae) a;
                            if (this.f3397f.f3431a.f3300z != null) {
                                a = c0914y.u.m5795a(this.f3397f.f3431a.f3300z);
                                if (a == null) {
                                    aeVar3 = (ae) a;
                                    a2 = c0914y instanceof ai ? new cc(this, ((ai) c0914y).f3243a).m5619a() : c0914y instanceof ad ? m5577b((ad) c0914y) : m5578b((am) c0914y);
                                    if (a2 == null) {
                                        size = a2.size();
                                        if (size == 0) {
                                            arVar = this.f3397f.f3431a;
                                            arVar2 = this.f3397f.f3431a;
                                            this.f3397f.f3431a.f3300z = null;
                                            arVar2.f3299y = null;
                                            arVar.f3298x = null;
                                            if (aeVar != null) {
                                                m5524a(aeVar, (cd) a2.get(0));
                                            }
                                            if (aeVar2 != null) {
                                                for (i = 1; i < size - 1; i++) {
                                                    m5524a(aeVar2, (cd) a2.get(i));
                                                }
                                            }
                                            if (aeVar3 == null) {
                                                m5524a(aeVar3, (cd) a2.get(size - 1));
                                            }
                                        }
                                    }
                                }
                                cb.m5592e("Marker reference '%s' not found", this.f3397f.f3431a.f3300z);
                            }
                            aeVar3 = null;
                            if (c0914y instanceof ai) {
                            }
                            if (a2 == null) {
                                size = a2.size();
                                if (size == 0) {
                                    arVar = this.f3397f.f3431a;
                                    arVar2 = this.f3397f.f3431a;
                                    this.f3397f.f3431a.f3300z = null;
                                    arVar2.f3299y = null;
                                    arVar.f3298x = null;
                                    if (aeVar != null) {
                                        m5524a(aeVar, (cd) a2.get(0));
                                    }
                                    if (aeVar2 != null) {
                                        for (i = 1; i < size - 1; i++) {
                                            m5524a(aeVar2, (cd) a2.get(i));
                                        }
                                    }
                                    if (aeVar3 == null) {
                                        m5524a(aeVar3, (cd) a2.get(size - 1));
                                    }
                                }
                            }
                        }
                        cb.m5592e("Marker reference '%s' not found", this.f3397f.f3431a.f3299y);
                    }
                    aeVar2 = null;
                    if (this.f3397f.f3431a.f3300z != null) {
                        a = c0914y.u.m5795a(this.f3397f.f3431a.f3300z);
                        if (a == null) {
                            cb.m5592e("Marker reference '%s' not found", this.f3397f.f3431a.f3300z);
                        } else {
                            aeVar3 = (ae) a;
                            if (c0914y instanceof ai) {
                            }
                            if (a2 == null) {
                                size = a2.size();
                                if (size == 0) {
                                    arVar = this.f3397f.f3431a;
                                    arVar2 = this.f3397f.f3431a;
                                    this.f3397f.f3431a.f3300z = null;
                                    arVar2.f3299y = null;
                                    arVar.f3298x = null;
                                    if (aeVar != null) {
                                        m5524a(aeVar, (cd) a2.get(0));
                                    }
                                    if (aeVar2 != null) {
                                        for (i = 1; i < size - 1; i++) {
                                            m5524a(aeVar2, (cd) a2.get(i));
                                        }
                                    }
                                    if (aeVar3 == null) {
                                        m5524a(aeVar3, (cd) a2.get(size - 1));
                                    }
                                }
                            }
                        }
                    }
                    aeVar3 = null;
                    if (c0914y instanceof ai) {
                        if (c0914y instanceof ad) {
                        }
                    }
                    if (a2 == null) {
                        size = a2.size();
                        if (size == 0) {
                            arVar = this.f3397f.f3431a;
                            arVar2 = this.f3397f.f3431a;
                            this.f3397f.f3431a.f3300z = null;
                            arVar2.f3299y = null;
                            arVar.f3298x = null;
                            if (aeVar != null) {
                                m5524a(aeVar, (cd) a2.get(0));
                            }
                            if (aeVar2 != null) {
                                for (i = 1; i < size - 1; i++) {
                                    m5524a(aeVar2, (cd) a2.get(i));
                                }
                            }
                            if (aeVar3 == null) {
                                m5524a(aeVar3, (cd) a2.get(size - 1));
                            }
                        }
                    }
                }
                cb.m5592e("Marker reference '%s' not found", this.f3397f.f3431a.f3298x);
            }
            aeVar = null;
            if (this.f3397f.f3431a.f3299y != null) {
                a = c0914y.u.m5795a(this.f3397f.f3431a.f3299y);
                if (a == null) {
                    cb.m5592e("Marker reference '%s' not found", this.f3397f.f3431a.f3299y);
                } else {
                    aeVar2 = (ae) a;
                    if (this.f3397f.f3431a.f3300z != null) {
                        a = c0914y.u.m5795a(this.f3397f.f3431a.f3300z);
                        if (a == null) {
                            aeVar3 = (ae) a;
                            if (c0914y instanceof ai) {
                            }
                            if (a2 == null) {
                                size = a2.size();
                                if (size == 0) {
                                    arVar = this.f3397f.f3431a;
                                    arVar2 = this.f3397f.f3431a;
                                    this.f3397f.f3431a.f3300z = null;
                                    arVar2.f3299y = null;
                                    arVar.f3298x = null;
                                    if (aeVar != null) {
                                        m5524a(aeVar, (cd) a2.get(0));
                                    }
                                    if (aeVar2 != null) {
                                        for (i = 1; i < size - 1; i++) {
                                            m5524a(aeVar2, (cd) a2.get(i));
                                        }
                                    }
                                    if (aeVar3 == null) {
                                        m5524a(aeVar3, (cd) a2.get(size - 1));
                                    }
                                }
                            }
                        }
                        cb.m5592e("Marker reference '%s' not found", this.f3397f.f3431a.f3300z);
                    }
                    aeVar3 = null;
                    if (c0914y instanceof ai) {
                        if (c0914y instanceof ad) {
                        }
                    }
                    if (a2 == null) {
                        size = a2.size();
                        if (size == 0) {
                            arVar = this.f3397f.f3431a;
                            arVar2 = this.f3397f.f3431a;
                            this.f3397f.f3431a.f3300z = null;
                            arVar2.f3299y = null;
                            arVar.f3298x = null;
                            if (aeVar != null) {
                                m5524a(aeVar, (cd) a2.get(0));
                            }
                            if (aeVar2 != null) {
                                for (i = 1; i < size - 1; i++) {
                                    m5524a(aeVar2, (cd) a2.get(i));
                                }
                            }
                            if (aeVar3 == null) {
                                m5524a(aeVar3, (cd) a2.get(size - 1));
                            }
                        }
                    }
                }
            }
            aeVar2 = null;
            if (this.f3397f.f3431a.f3300z != null) {
                a = c0914y.u.m5795a(this.f3397f.f3431a.f3300z);
                if (a == null) {
                    cb.m5592e("Marker reference '%s' not found", this.f3397f.f3431a.f3300z);
                } else {
                    aeVar3 = (ae) a;
                    if (c0914y instanceof ai) {
                    }
                    if (a2 == null) {
                        size = a2.size();
                        if (size == 0) {
                            arVar = this.f3397f.f3431a;
                            arVar2 = this.f3397f.f3431a;
                            this.f3397f.f3431a.f3300z = null;
                            arVar2.f3299y = null;
                            arVar.f3298x = null;
                            if (aeVar != null) {
                                m5524a(aeVar, (cd) a2.get(0));
                            }
                            if (aeVar2 != null) {
                                for (i = 1; i < size - 1; i++) {
                                    m5524a(aeVar2, (cd) a2.get(i));
                                }
                            }
                            if (aeVar3 == null) {
                                m5524a(aeVar3, (cd) a2.get(size - 1));
                            }
                        }
                    }
                }
            }
            aeVar3 = null;
            if (c0914y instanceof ai) {
                if (c0914y instanceof ad) {
                }
            }
            if (a2 == null) {
                size = a2.size();
                if (size == 0) {
                    arVar = this.f3397f.f3431a;
                    arVar2 = this.f3397f.f3431a;
                    this.f3397f.f3431a.f3300z = null;
                    arVar2.f3299y = null;
                    arVar.f3298x = null;
                    if (aeVar != null) {
                        m5524a(aeVar, (cd) a2.get(0));
                    }
                    if (aeVar2 != null) {
                        for (i = 1; i < size - 1; i++) {
                            m5524a(aeVar2, (cd) a2.get(i));
                        }
                    }
                    if (aeVar3 == null) {
                        m5524a(aeVar3, (cd) a2.get(size - 1));
                    }
                }
            }
        }
    }

    private void m5562a(C0914y c0914y, Path path, Matrix matrix) {
        m5556a(this.f3397f, (bg) c0914y);
        if (m5607r() && m5608s()) {
            Path b;
            if (c0914y.f3223e != null) {
                matrix.preConcat(c0914y.f3223e);
            }
            if (c0914y instanceof ao) {
                b = m5572b((ao) c0914y);
            } else if (c0914y instanceof C0932q) {
                b = m5573b((C0932q) c0914y);
            } else if (c0914y instanceof C0937v) {
                b = m5574b((C0937v) c0914y);
            } else if (c0914y instanceof am) {
                b = m5586c((am) c0914y);
            } else {
                return;
            }
            m5590d(c0914y);
            path.setFillType(b.getFillType());
            path.addPath(b, matrix);
        }
    }

    private void m5563a(C0917z c0917z) {
        cb.m5594f("Group render", new Object[0]);
        m5556a(this.f3397f, (bg) c0917z);
        if (m5607r()) {
            if (c0917z.f3354b != null) {
                this.f3392a.concat(c0917z.f3354b);
            }
            m5590d(c0917z);
            boolean m = m5602m();
            m5536a((be) c0917z, true);
            if (m) {
                m5580b((bf) c0917z);
            }
            m5537a((bf) c0917z);
        }
    }

    private void m5565a(boolean z, ap apVar) {
        boolean z2 = true;
        if (z) {
            if (m5569a(apVar.r, 2147483648L)) {
                this.f3397f.f3431a.f3276b = apVar.r.f3270H;
                ci ciVar = this.f3397f;
                if (apVar.r.f3270H == null) {
                    z2 = false;
                }
                ciVar.f3432b = z2;
            }
            if (m5569a(apVar.r, 4294967296L)) {
                this.f3397f.f3431a.f3278d = apVar.r.f3271I;
            }
            if (m5569a(apVar.r, 6442450944L)) {
                m5557a(this.f3397f, z, this.f3397f.f3431a.f3276b);
                return;
            }
            return;
        }
        if (m5569a(apVar.r, 2147483648L)) {
            this.f3397f.f3431a.f3279e = apVar.r.f3270H;
            ciVar = this.f3397f;
            if (apVar.r.f3270H == null) {
                z2 = false;
            }
            ciVar.f3433c = z2;
        }
        if (m5569a(apVar.r, 4294967296L)) {
            this.f3397f.f3431a.f3280f = apVar.r.f3271I;
        }
        if (m5569a(apVar.r, 6442450944L)) {
            m5557a(this.f3397f, z, this.f3397f.f3431a.f3279e);
        }
    }

    private void m5566a(boolean z, C0930o c0930o, ah ahVar) {
        bi a = this.f3396e.m5795a(ahVar.f3241a);
        if (a == null) {
            String str = "%s reference '%s' not found";
            Object[] objArr = new Object[2];
            objArr[0] = z ? "Fill" : "Stroke";
            objArr[1] = ahVar.f3241a;
            cb.m5592e(str, objArr);
            if (ahVar.f3242b != null) {
                m5557a(this.f3397f, z, ahVar.f3242b);
                return;
            } else if (z) {
                this.f3397f.f3432b = false;
                return;
            } else {
                this.f3397f.f3433c = false;
                return;
            }
        }
        if (a instanceof bh) {
            m5567a(z, c0930o, (bh) a);
        }
        if (a instanceof bl) {
            m5568a(z, c0930o, (bl) a);
        }
        if (a instanceof ap) {
            m5565a(z, (ap) a);
        }
    }

    private void m5567a(boolean z, C0930o c0930o, bh bhVar) {
        float b;
        float a;
        float b2;
        float a2;
        if (bhVar.e != null) {
            m5560a((C0916w) bhVar, bhVar.e);
        }
        Object obj = (bhVar.b == null || !bhVar.b.booleanValue()) ? null : 1;
        Paint paint = z ? this.f3397f.f3434d : this.f3397f.f3435e;
        if (obj != null) {
            b = bhVar.f3348i != null ? bhVar.f3348i.m5464b(this) : 0.0f;
            a = bhVar.f3347h != null ? bhVar.f3347h.m5462a(this) : m5618d().f3578c;
            b2 = bhVar.f3346g != null ? bhVar.f3346g.m5464b(this) : 0.0f;
            a2 = bhVar.f3345f != null ? bhVar.f3345f.m5462a(this) : 0.0f;
        } else {
            b = bhVar.f3348i != null ? bhVar.f3348i.m5463a(this, 1.0f) : 0.0f;
            a = bhVar.f3347h != null ? bhVar.f3347h.m5463a(this, 1.0f) : 1.0f;
            b2 = bhVar.f3346g != null ? bhVar.f3346g.m5463a(this, 1.0f) : 0.0f;
            a2 = bhVar.f3345f != null ? bhVar.f3345f.m5463a(this, 1.0f) : 0.0f;
        }
        m5599j();
        this.f3397f = m5587c((bi) bhVar);
        Matrix matrix = new Matrix();
        if (obj == null) {
            matrix.preTranslate(c0930o.f3576a, c0930o.f3577b);
            matrix.preScale(c0930o.f3578c, c0930o.f3579d);
        }
        if (bhVar.c != null) {
            matrix.preConcat(bhVar.c);
        }
        int size = bhVar.a.size();
        if (size == 0) {
            m5600k();
            if (z) {
                this.f3397f.f3432b = false;
                return;
            } else {
                this.f3397f.f3433c = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        int i = 0;
        float f = -1.0f;
        for (bi biVar : bhVar.a) {
            bg bgVar = (aq) biVar;
            if (i == 0 || bgVar.f3262a.floatValue() >= f) {
                fArr[i] = bgVar.f3262a.floatValue();
                f = bgVar.f3262a.floatValue();
            } else {
                fArr[i] = f;
            }
            m5599j();
            m5556a(this.f3397f, bgVar);
            C0934s c0934s = (C0934s) this.f3397f.f3431a.f3265C;
            if (c0934s == null) {
                c0934s = C0934s.f3588b;
            }
            iArr[i] = c0934s.f3589a | (m5513a(this.f3397f.f3431a.f3266D.floatValue()) << 24);
            int i2 = i + 1;
            m5600k();
            i = i2;
        }
        if ((a2 == a && b2 == b) || size == 1) {
            m5600k();
            paint.setColor(iArr[size - 1]);
            return;
        }
        TileMode tileMode = TileMode.CLAMP;
        if (bhVar.d != null) {
            if (bhVar.d == C0938x.reflect) {
                tileMode = TileMode.MIRROR;
            } else if (bhVar.d == C0938x.repeat) {
                tileMode = TileMode.REPEAT;
            }
        }
        m5600k();
        Shader linearGradient = new LinearGradient(a2, b2, a, b, iArr, fArr, tileMode);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
    }

    private void m5568a(boolean z, C0930o c0930o, bl blVar) {
        float c;
        float b;
        float f;
        if (blVar.e != null) {
            m5560a((C0916w) blVar, blVar.e);
        }
        Object obj = (blVar.b == null || !blVar.b.booleanValue()) ? null : 1;
        Paint paint = z ? this.f3397f.f3434d : this.f3397f.f3435e;
        if (obj != null) {
            ac acVar = new ac(50.0f, by.percent);
            float a = blVar.f3349f != null ? blVar.f3349f.m5462a(this) : acVar.m5462a(this);
            c = blVar.f3351h != null ? blVar.f3351h.m5466c(this) : acVar.m5466c(this);
            b = blVar.f3350g != null ? blVar.f3350g.m5464b(this) : acVar.m5464b(this);
            f = a;
        } else {
            c = blVar.f3351h != null ? blVar.f3351h.m5463a(this, 1.0f) : 0.5f;
            b = blVar.f3350g != null ? blVar.f3350g.m5463a(this, 1.0f) : 0.5f;
            f = blVar.f3349f != null ? blVar.f3349f.m5463a(this, 1.0f) : 0.5f;
        }
        m5599j();
        this.f3397f = m5587c((bi) blVar);
        Matrix matrix = new Matrix();
        if (obj == null) {
            matrix.preTranslate(c0930o.f3576a, c0930o.f3577b);
            matrix.preScale(c0930o.f3578c, c0930o.f3579d);
        }
        if (blVar.c != null) {
            matrix.preConcat(blVar.c);
        }
        int size = blVar.a.size();
        if (size == 0) {
            m5600k();
            if (z) {
                this.f3397f.f3432b = false;
                return;
            } else {
                this.f3397f.f3433c = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        int i = 0;
        float f2 = -1.0f;
        for (bi biVar : blVar.a) {
            bg bgVar = (aq) biVar;
            if (i == 0 || bgVar.f3262a.floatValue() >= f2) {
                fArr[i] = bgVar.f3262a.floatValue();
                f2 = bgVar.f3262a.floatValue();
            } else {
                fArr[i] = f2;
            }
            m5599j();
            m5556a(this.f3397f, bgVar);
            C0934s c0934s = (C0934s) this.f3397f.f3431a.f3265C;
            if (c0934s == null) {
                c0934s = C0934s.f3588b;
            }
            iArr[i] = c0934s.f3589a | (m5513a(this.f3397f.f3431a.f3266D.floatValue()) << 24);
            int i2 = i + 1;
            m5600k();
            i = i2;
        }
        if (c == 0.0f || size == 1) {
            m5600k();
            paint.setColor(iArr[size - 1]);
            return;
        }
        TileMode tileMode = TileMode.CLAMP;
        if (blVar.d != null) {
            if (blVar.d == C0938x.reflect) {
                tileMode = TileMode.MIRROR;
            } else if (blVar.d == C0938x.repeat) {
                tileMode = TileMode.REPEAT;
            }
        }
        m5600k();
        Shader radialGradient = new RadialGradient(f, b, c, iArr, fArr, tileMode);
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
    }

    private boolean m5569a(ar arVar, long j) {
        return (arVar.f3275a & j) != 0;
    }

    private static float[] m5571a(double d, double d2) {
        int ceil = (int) Math.ceil(Math.abs(d2) / 90.0d);
        double toRadians = Math.toRadians(d);
        float toRadians2 = (float) (Math.toRadians(d2) / ((double) ceil));
        double sin = (1.3333333333333333d * Math.sin(((double) toRadians2) / 2.0d)) / (1.0d + Math.cos(((double) toRadians2) / 2.0d));
        float[] fArr = new float[(ceil * 6)];
        int i = 0;
        for (int i2 = 0; i2 < ceil; i2++) {
            double d3 = ((double) (((float) i2) * toRadians2)) + toRadians;
            double cos = Math.cos(d3);
            double sin2 = Math.sin(d3);
            int i3 = i + 1;
            fArr[i] = (float) (cos - (sin * sin2));
            i = i3 + 1;
            fArr[i3] = (float) ((cos * sin) + sin2);
            d3 += (double) toRadians2;
            cos = Math.cos(d3);
            d3 = Math.sin(d3);
            i3 = i + 1;
            fArr[i] = (float) ((sin * d3) + cos);
            i = i3 + 1;
            fArr[i3] = (float) (d3 - (sin * cos));
            i3 = i + 1;
            fArr[i] = (float) cos;
            i = i3 + 1;
            fArr[i3] = (float) d3;
        }
        return fArr;
    }

    private Path m5572b(ao aoVar) {
        float f;
        float f2;
        if (aoVar.f3260f == null && aoVar.f3261g == null) {
            f = 0.0f;
            f2 = 0.0f;
        } else if (aoVar.f3260f == null) {
            f2 = aoVar.f3261g.m5464b(this);
            f = f2;
        } else if (aoVar.f3261g == null) {
            f2 = aoVar.f3260f.m5462a(this);
            f = f2;
        } else {
            f = aoVar.f3260f.m5462a(this);
            f2 = aoVar.f3261g.m5464b(this);
        }
        float min = Math.min(f, aoVar.f3258c.m5462a(this) / 2.0f);
        float min2 = Math.min(f2, aoVar.f3259d.m5464b(this) / 2.0f);
        f = aoVar.f3256a != null ? aoVar.f3256a.m5462a(this) : 0.0f;
        float b = aoVar.f3257b != null ? aoVar.f3257b.m5464b(this) : 0.0f;
        f2 = aoVar.f3258c.m5462a(this);
        float b2 = aoVar.f3259d.m5464b(this);
        if (aoVar.o == null) {
            aoVar.o = new C0930o(f, b, f2, b2);
        }
        float f3 = f + f2;
        float f4 = b + b2;
        Path path = new Path();
        if (min == 0.0f || min2 == 0.0f) {
            path.moveTo(f, b);
            path.lineTo(f3, b);
            path.lineTo(f3, f4);
            path.lineTo(f, f4);
            path.lineTo(f, b);
        } else {
            float f5 = min * 0.5522848f;
            float f6 = min2 * 0.5522848f;
            path.moveTo(f, b + min2);
            path.cubicTo(f, (b + min2) - f6, (f + min) - f5, b, f + min, b);
            path.lineTo(f3 - min, b);
            path.cubicTo((f3 - min) + f5, b, f3, (b + min2) - f6, f3, b + min2);
            path.lineTo(f3, f4 - min2);
            path.cubicTo(f3, (f4 - min2) + f6, (f3 - min) + f5, f4, f3 - min, f4);
            path.lineTo(f + min, f4);
            path.cubicTo((f + min) - f5, f4, f, (f4 - min2) + f6, f, f4 - min2);
            path.lineTo(f, b + min2);
        }
        path.close();
        return path;
    }

    private Path m5573b(C0932q c0932q) {
        float a = c0932q.f3584a != null ? c0932q.f3584a.m5462a(this) : 0.0f;
        float b = c0932q.f3585b != null ? c0932q.f3585b.m5464b(this) : 0.0f;
        float c = c0932q.f3586c.m5466c(this);
        float f = a - c;
        float f2 = b - c;
        float f3 = a + c;
        float f4 = b + c;
        if (c0932q.o == null) {
            c0932q.o = new C0930o(f, f2, 2.0f * c, 2.0f * c);
        }
        float f5 = c * 0.5522848f;
        Path path = new Path();
        path.moveTo(a, f2);
        path.cubicTo(a + f5, f2, f3, b - f5, f3, b);
        path.cubicTo(f3, b + f5, a + f5, f4, a, f4);
        path.cubicTo(a - f5, f4, f, b + f5, f, b);
        path.cubicTo(f, b - f5, a - f5, f2, a, f2);
        path.close();
        return path;
    }

    private Path m5574b(C0937v c0937v) {
        float a = c0937v.f3591a != null ? c0937v.f3591a.m5462a(this) : 0.0f;
        float b = c0937v.f3592b != null ? c0937v.f3592b.m5464b(this) : 0.0f;
        float a2 = c0937v.f3593c.m5462a(this);
        float b2 = c0937v.f3594d.m5464b(this);
        float f = a - a2;
        float f2 = b - b2;
        float f3 = a + a2;
        float f4 = b + b2;
        if (c0937v.o == null) {
            c0937v.o = new C0930o(f, f2, 2.0f * a2, 2.0f * b2);
        }
        float f5 = a2 * 0.5522848f;
        float f6 = b2 * 0.5522848f;
        Path path = new Path();
        path.moveTo(a, f2);
        path.cubicTo(a + f5, f2, f3, b - f6, f3, b);
        path.cubicTo(f3, b + f6, a + f5, f4, a, f4);
        path.cubicTo(a - f5, f4, f, b + f6, f, b);
        path.cubicTo(f, b - f6, a - f5, f2, a, f2);
        path.close();
        return path;
    }

    private C0930o m5576b(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new C0930o(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    private List<cd> m5577b(ad adVar) {
        float a = adVar.f3224a != null ? adVar.f3224a.m5462a(this) : 0.0f;
        float b = adVar.f3225b != null ? adVar.f3225b.m5464b(this) : 0.0f;
        float a2 = adVar.f3226c != null ? adVar.f3226c.m5462a(this) : 0.0f;
        float b2 = adVar.f3227d != null ? adVar.f3227d.m5464b(this) : 0.0f;
        List<cd> arrayList = new ArrayList(2);
        arrayList.add(new cd(this, a, b, a2 - a, b2 - b));
        arrayList.add(new cd(this, a2, b2, a2 - a, b2 - b));
        return arrayList;
    }

    private List<cd> m5578b(am amVar) {
        int i = 2;
        float f = 0.0f;
        int length = amVar.f3255a.length;
        if (length < 2) {
            return null;
        }
        List<cd> arrayList = new ArrayList();
        cd cdVar = new cd(this, amVar.f3255a[0], amVar.f3255a[1], 0.0f, 0.0f);
        float f2 = 0.0f;
        cd cdVar2 = cdVar;
        while (i < length) {
            f2 = amVar.f3255a[i];
            float f3 = amVar.f3255a[i + 1];
            cdVar2.m5626a(f2, f3);
            arrayList.add(cdVar2);
            cdVar = new cd(this, f2, f3, f2 - cdVar2.f3412a, f3 - cdVar2.f3413b);
            i += 2;
            f = f3;
            cdVar2 = cdVar;
        }
        if (!(amVar instanceof an)) {
            arrayList.add(cdVar2);
        } else if (!(f2 == amVar.f3255a[0] || r4 == amVar.f3255a[1])) {
            f2 = amVar.f3255a[0];
            f3 = amVar.f3255a[1];
            cdVar2.m5626a(f2, f3);
            arrayList.add(cdVar2);
            cdVar = new cd(this, f2, f3, f2 - cdVar2.f3412a, f3 - cdVar2.f3413b);
            cdVar.m5627a((cd) arrayList.get(0));
            arrayList.add(cdVar);
            arrayList.set(0, cdVar);
        }
        return arrayList;
    }

    private static void m5579b(float f, float f2, float f3, float f4, float f5, boolean z, boolean z2, float f6, float f7, ak akVar) {
        if (f != f6 || f2 != f7) {
            if (f3 == 0.0f || f4 == 0.0f) {
                akVar.m5484b(f6, f7);
                return;
            }
            float f8;
            float f9;
            double d;
            float abs = Math.abs(f3);
            float abs2 = Math.abs(f4);
            float toRadians = (float) Math.toRadians(((double) f5) % 360.0d);
            double cos = Math.cos((double) toRadians);
            double sin = Math.sin((double) toRadians);
            double d2 = ((double) (f - f6)) / 2.0d;
            double d3 = ((double) (f2 - f7)) / 2.0d;
            double d4 = (sin * d3) + (cos * d2);
            double d5 = (d2 * (-sin)) + (d3 * cos);
            d3 = (double) (abs * abs);
            d2 = (double) (abs2 * abs2);
            double d6 = d4 * d4;
            double d7 = d5 * d5;
            double d8 = (d6 / d3) + (d7 / d2);
            if (d8 > 1.0d) {
                abs *= (float) Math.sqrt(d8);
                abs2 *= (float) Math.sqrt(d8);
                f8 = abs2;
                f9 = abs;
                d = (double) (abs * abs);
                d3 = (double) (abs2 * abs2);
            } else {
                f8 = abs2;
                f9 = abs;
                d = d3;
                d3 = d2;
            }
            double d9 = (double) (z == z2 ? -1 : 1);
            d2 = (((d * d3) - (d * d7)) - (d3 * d6)) / ((d3 * d6) + (d * d7));
            if (d2 < 0.0d) {
                d2 = 0.0d;
            }
            d2 = Math.sqrt(d2) * d9;
            d3 = ((((double) f9) * d5) / ((double) f8)) * d2;
            d2 *= -((((double) f8) * d4) / ((double) f9));
            d = (((double) (f + f6)) / 2.0d) + ((cos * d3) - (sin * d2));
            cos = ((cos * d2) + (sin * d3)) + (((double) (f2 + f7)) / 2.0d);
            sin = (d4 - d3) / ((double) f9);
            d6 = (d5 - d2) / ((double) f8);
            d3 = ((-d4) - d3) / ((double) f9);
            d4 = ((-d5) - d2) / ((double) f8);
            d5 = Math.toDegrees((d6 < 0.0d ? -1.0d : 1.0d) * Math.acos(sin / Math.sqrt((sin * sin) + (d6 * d6))));
            d2 = Math.toDegrees(((sin * d4) - (d3 * d6) < 0.0d ? -1.0d : 1.0d) * Math.acos(((d6 * d4) + (sin * d3)) / Math.sqrt(((sin * sin) + (d6 * d6)) * ((d3 * d3) + (d4 * d4)))));
            if (!z2 && d2 > 0.0d) {
                d2 -= 360.0d;
            } else if (z2 && d2 < 0.0d) {
                d2 += 360.0d;
            }
            float[] a = cb.m5571a(d5 % 360.0d, d2 % 360.0d);
            Matrix matrix = new Matrix();
            matrix.postScale(f9, f8);
            matrix.postRotate(f5);
            matrix.postTranslate((float) d, (float) cos);
            matrix.mapPoints(a);
            a[a.length - 2] = f6;
            a[a.length - 1] = f7;
            for (int i = 0; i < a.length; i += 6) {
                akVar.m5481a(a[i], a[i + 1], a[i + 2], a[i + 3], a[i + 4], a[i + 5]);
            }
        }
    }

    private void m5580b(bf bfVar) {
        if (this.f3397f.f3431a.f3269G != null && this.f3397f.f3439i) {
            bi a = this.f3396e.m5795a(this.f3397f.f3431a.f3269G);
            m5604o();
            m5525a((af) a, bfVar);
            Bitmap p = m5605p();
            this.f3392a = (Canvas) this.f3401j.pop();
            this.f3392a.save();
            this.f3392a.setMatrix(new Matrix());
            this.f3392a.drawBitmap(p, 0.0f, 0.0f, this.f3397f.f3434d);
            p.recycle();
            this.f3392a.restore();
        }
        m5600k();
    }

    private void m5581b(bi biVar) {
        if (biVar instanceof bg) {
            bg bgVar = (bg) biVar;
            if (bgVar.f3197q != null) {
                this.f3397f.f3438h = bgVar.f3197q.booleanValue();
            }
        }
    }

    private void m5582b(bn bnVar) {
        String language = Locale.getDefault().getLanguage();
        cm e = this.f3396e.m5804e();
        for (bi biVar : bnVar.m5446a()) {
            if (biVar instanceof bb) {
                bb bbVar = (bb) biVar;
                if (bbVar.m5438c() == null) {
                    Set d = bbVar.m5440d();
                    if (d == null || (!d.isEmpty() && d.contains(language))) {
                        Collection b = bbVar.m5436b();
                        if (b == null || (!b.isEmpty() && cp.f3448a.containsAll(b))) {
                            Set<String> e2 = bbVar.m5442e();
                            if (e2 != null) {
                                if (!(e2.isEmpty() || e == null)) {
                                    for (String b2 : e2) {
                                        if (!e.m5646b(b2)) {
                                            break;
                                        }
                                    }
                                }
                            }
                            Set<String> f = bbVar.m5443f();
                            if (f != null) {
                                if (!(f.isEmpty() || e == null)) {
                                    for (String a : f) {
                                        if (e.m5645a(a, this.f3397f.f3431a.f3291q.intValue(), String.valueOf(this.f3397f.f3431a.f3292r)) == null) {
                                        }
                                    }
                                }
                            }
                            m5542a(biVar);
                            return;
                        }
                    }
                }
                continue;
            }
        }
    }

    private Path m5585c(ad adVar) {
        float f = 0.0f;
        float c = adVar.f3224a == null ? 0.0f : adVar.f3224a.m5466c(this);
        float c2 = adVar.f3225b == null ? 0.0f : adVar.f3225b.m5466c(this);
        float c3 = adVar.f3226c == null ? 0.0f : adVar.f3226c.m5466c(this);
        if (adVar.f3227d != null) {
            f = adVar.f3227d.m5466c(this);
        }
        if (adVar.o == null) {
            adVar.o = new C0930o(Math.min(c, c2), Math.min(c2, f), Math.abs(c3 - c), Math.abs(f - c2));
        }
        Path path = new Path();
        path.moveTo(c, c2);
        path.lineTo(c3, f);
        return path;
    }

    private Path m5586c(am amVar) {
        Path path = new Path();
        path.moveTo(amVar.f3255a[0], amVar.f3255a[1]);
        for (int i = 2; i < amVar.f3255a.length; i += 2) {
            path.lineTo(amVar.f3255a[i], amVar.f3255a[i + 1]);
        }
        if (amVar instanceof an) {
            path.close();
        }
        if (amVar.o == null) {
            amVar.o = m5576b(path);
        }
        path.setFillType(m5613x());
        return path;
    }

    private ci m5587c(bi biVar) {
        ci ciVar = new ci(this);
        m5555a(ciVar, ar.m5497a());
        return m5517a(biVar, ciVar);
    }

    private void m5588c(bf bfVar) {
        if (this.f3397f.f3431a.f3276b instanceof ah) {
            m5566a(true, bfVar.f3201o, (ah) this.f3397f.f3431a.f3276b);
        }
        if (this.f3397f.f3431a.f3279e instanceof ah) {
            m5566a(false, bfVar.f3201o, (ah) this.f3397f.f3431a.f3279e);
        }
    }

    private void m5590d(bf bfVar) {
        m5540a(bfVar, bfVar.f3201o);
    }

    private static void m5591d(String str, Object... objArr) {
        Log.w("SVGAndroidRenderer", String.format(str, objArr));
    }

    private static void m5592e(String str, Object... objArr) {
        Log.e("SVGAndroidRenderer", String.format(str, objArr));
    }

    static /* synthetic */ int[] m5593e() {
        int[] iArr = f3388l;
        if (iArr == null) {
            iArr = new int[C0927l.values().length];
            try {
                iArr[C0927l.None.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C0927l.XMaxYMax.ordinal()] = 10;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C0927l.XMaxYMid.ordinal()] = 7;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[C0927l.XMaxYMin.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[C0927l.XMidYMax.ordinal()] = 9;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[C0927l.XMidYMid.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[C0927l.XMidYMin.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[C0927l.XMinYMax.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[C0927l.XMinYMid.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[C0927l.XMinYMin.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            f3388l = iArr;
        }
        return iArr;
    }

    private static void m5594f(String str, Object... objArr) {
    }

    static /* synthetic */ int[] m5595f() {
        int[] iArr = f3389m;
        if (iArr == null) {
            iArr = new int[au.values().length];
            try {
                iArr[au.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[au.Round.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[au.Square.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            f3389m = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] m5596g() {
        int[] iArr = f3390n;
        if (iArr == null) {
            iArr = new int[av.values().length];
            try {
                iArr[av.Bevel.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[av.Miter.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[av.Round.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            f3390n = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] m5597h() {
        int[] iArr = f3391o;
        if (iArr == null) {
            iArr = new int[as.values().length];
            try {
                iArr[as.EvenOdd.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[as.NonZero.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            f3391o = iArr;
        }
        return iArr;
    }

    private void m5598i() {
        this.f3397f = new ci(this);
        this.f3398g = new Stack();
        m5555a(this.f3397f, ar.m5497a());
        this.f3397f.f3436f = this.f3393b;
        this.f3397f.f3438h = false;
        this.f3397f.f3439i = this.f3395d;
        this.f3398g.push((ci) this.f3397f.clone());
        this.f3401j = new Stack();
        this.f3402k = new Stack();
        this.f3400i = new Stack();
        this.f3399h = new Stack();
    }

    private void m5599j() {
        this.f3392a.save();
        this.f3398g.push(this.f3397f);
        this.f3397f = (ci) this.f3397f.clone();
    }

    private void m5600k() {
        this.f3392a.restore();
        this.f3397f = (ci) this.f3398g.pop();
    }

    private void m5601l() {
        this.f3399h.pop();
        this.f3400i.pop();
    }

    private boolean m5602m() {
        if (!m5603n()) {
            return false;
        }
        this.f3392a.saveLayerAlpha(null, m5513a(this.f3397f.f3431a.f3287m.floatValue()), 4);
        this.f3398g.push(this.f3397f);
        this.f3397f = (ci) this.f3397f.clone();
        if (this.f3397f.f3431a.f3269G != null && this.f3397f.f3439i) {
            bi a = this.f3396e.m5795a(this.f3397f.f3431a.f3269G);
            if (a == null || !(a instanceof af)) {
                cb.m5592e("Mask reference '%s' not found", this.f3397f.f3431a.f3269G);
                this.f3397f.f3431a.f3269G = null;
                return true;
            }
            this.f3401j.push(this.f3392a);
            m5604o();
        }
        return true;
    }

    private boolean m5603n() {
        if (!(this.f3397f.f3431a.f3269G == null || this.f3397f.f3439i)) {
            cb.m5591d("Masks are not supported when using getPicture()", new Object[0]);
        }
        return this.f3397f.f3431a.f3287m.floatValue() < 1.0f || (this.f3397f.f3431a.f3269G != null && this.f3397f.f3439i);
    }

    private void m5604o() {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.f3392a.getWidth(), this.f3392a.getHeight(), Config.ARGB_8888);
            this.f3402k.push(createBitmap);
            Canvas canvas = new Canvas(createBitmap);
            canvas.setMatrix(this.f3392a.getMatrix());
            this.f3392a = canvas;
        } catch (OutOfMemoryError e) {
            cb.m5592e("Not enough memory to create temporary bitmaps for mask processing", new Object[0]);
            throw e;
        }
    }

    private Bitmap m5605p() {
        Bitmap bitmap = (Bitmap) this.f3402k.pop();
        Bitmap bitmap2 = (Bitmap) this.f3402k.pop();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width];
        int[] iArr2 = new int[width];
        for (int i = 0; i < height; i++) {
            bitmap.getPixels(iArr, 0, width, 0, i, width, 1);
            bitmap2.getPixels(iArr2, 0, width, 0, i, width, 1);
            for (int i2 = 0; i2 < width; i2++) {
                int i3 = iArr[i2];
                int i4 = i3 & 255;
                int i5 = (i3 >> 8) & 255;
                int i6 = (i3 >> 16) & 255;
                i3 = (i3 >> 24) & 255;
                if (i3 == 0) {
                    iArr2[i2] = 0;
                } else {
                    i4 *= 2362;
                    i3 = (i3 * (i4 + ((i5 * 23442) + (i6 * 6963)))) / 8355840;
                    i4 = iArr2[i2];
                    iArr2[i2] = (((i3 * ((i4 >> 24) & 255)) / 255) << 24) | (i4 & 16777215);
                }
            }
            bitmap2.setPixels(iArr2, 0, width, 0, i, width, 1);
        }
        bitmap.recycle();
        return bitmap2;
    }

    private aw m5606q() {
        return (this.f3397f.f3431a.f3294t == ay.LTR || this.f3397f.f3431a.f3295u == aw.Middle) ? this.f3397f.f3431a.f3295u : this.f3397f.f3431a.f3295u == aw.Start ? aw.End : aw.Start;
    }

    private boolean m5607r() {
        return this.f3397f.f3431a.f3263A != null ? this.f3397f.f3431a.f3263A.booleanValue() : true;
    }

    private boolean m5608s() {
        return this.f3397f.f3431a.f3264B != null ? this.f3397f.f3431a.f3264B.booleanValue() : true;
    }

    private FillType m5609t() {
        if (this.f3397f.f3431a.f3277c == null) {
            return FillType.WINDING;
        }
        switch (cb.m5597h()[this.f3397f.f3431a.f3277c.ordinal()]) {
            case VideoSize.HVGA /*2*/:
                return FillType.EVEN_ODD;
            default:
                return FillType.WINDING;
        }
    }

    private void m5610u() {
        int i;
        if (this.f3397f.f3431a.f3272J instanceof C0934s) {
            i = ((C0934s) this.f3397f.f3431a.f3272J).f3589a;
        } else if (this.f3397f.f3431a.f3272J instanceof C0935t) {
            i = this.f3397f.f3431a.f3288n.f3589a;
        } else {
            return;
        }
        if (this.f3397f.f3431a.f3273K != null) {
            i |= m5513a(this.f3397f.f3431a.f3273K.floatValue()) << 24;
        }
        this.f3392a.drawColor(i);
    }

    private void m5611v() {
        this.f3392a.save(1);
        this.f3398g.push(this.f3397f);
        this.f3397f = (ci) this.f3397f.clone();
    }

    private void m5612w() {
        this.f3392a.restore();
        this.f3397f = (ci) this.f3398g.pop();
    }

    private FillType m5613x() {
        if (this.f3397f.f3431a.f3268F == null) {
            return FillType.WINDING;
        }
        switch (cb.m5597h()[this.f3397f.f3431a.f3268F.ordinal()]) {
            case VideoSize.HVGA /*2*/:
                return FillType.EVEN_ODD;
            default:
                return FillType.WINDING;
        }
    }

    protected float m5614a() {
        return this.f3394c;
    }

    protected void m5615a(C0929n c0929n, C0930o c0930o, C0926k c0926k, boolean z) {
        this.f3396e = c0929n;
        this.f3395d = z;
        bi b = c0929n.m5798b();
        if (b == null) {
            cb.m5591d("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        m5598i();
        m5581b(b);
        m5534a(b, b.f3337c, b.f3338d, c0930o != null ? c0930o : b.x, c0926k != null ? c0926k : b.w);
    }

    protected float m5616b() {
        return this.f3397f.f3434d.getTextSize();
    }

    protected float m5617c() {
        return this.f3397f.f3434d.getTextSize() / 2.0f;
    }

    protected C0930o m5618d() {
        return this.f3397f.f3437g != null ? this.f3397f.f3437g : this.f3397f.f3436f;
    }
}
