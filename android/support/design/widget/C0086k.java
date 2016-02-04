package android.support.design.widget;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.design.C0070k;
import android.support.v4.p015e.C0209i;
import android.support.v4.view.C0327v;
import android.support.v4.view.cb;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;
import mobi.mmdt.ott.C1317h;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: android.support.design.widget.k */
final class C0086k {
    private static final boolean f613a;
    private static final Paint f614b;
    private boolean f615A;
    private Bitmap f616B;
    private Paint f617C;
    private float f618D;
    private float f619E;
    private float f620F;
    private float f621G;
    private boolean f622H;
    private final TextPaint f623I;
    private Interpolator f624J;
    private Interpolator f625K;
    private float f626L;
    private float f627M;
    private float f628N;
    private int f629O;
    private float f630P;
    private float f631Q;
    private float f632R;
    private int f633S;
    private final View f634c;
    private boolean f635d;
    private float f636e;
    private final Rect f637f;
    private final Rect f638g;
    private final RectF f639h;
    private int f640i;
    private int f641j;
    private float f642k;
    private float f643l;
    private int f644m;
    private int f645n;
    private float f646o;
    private float f647p;
    private float f648q;
    private float f649r;
    private float f650s;
    private float f651t;
    private Typeface f652u;
    private Typeface f653v;
    private Typeface f654w;
    private CharSequence f655x;
    private CharSequence f656y;
    private boolean f657z;

    static {
        f613a = VERSION.SDK_INT < 18;
        f614b = null;
        if (f614b != null) {
            f614b.setAntiAlias(true);
            f614b.setColor(-65281);
        }
    }

    public C0086k(View view) {
        this.f640i = 16;
        this.f641j = 16;
        this.f642k = 15.0f;
        this.f643l = 15.0f;
        this.f634c = view;
        this.f623I = new TextPaint();
        this.f623I.setAntiAlias(true);
        this.f638g = new Rect();
        this.f637f = new Rect();
        this.f639h = new RectF();
    }

    private static float m775a(float f, float f2, float f3, Interpolator interpolator) {
        if (interpolator != null) {
            f3 = interpolator.getInterpolation(f3);
        }
        return C0072a.m476a(f, f2, f3);
    }

    private static int m776a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((f2 * ((float) Color.blue(i))) + (((float) Color.blue(i2)) * f)));
    }

    private static boolean m777a(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    private static boolean m778a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }

    private boolean m779b(CharSequence charSequence) {
        int i = 1;
        if (cb.m2428h(this.f634c) != 1) {
            i = 0;
        }
        return (i != 0 ? C0209i.f1111d : C0209i.f1110c).m1639a(charSequence, 0, charSequence.length());
    }

    private void m780c(float f) {
        m781d(f);
        this.f650s = C0086k.m775a(this.f648q, this.f649r, f, this.f624J);
        this.f651t = C0086k.m775a(this.f646o, this.f647p, f, this.f624J);
        m782e(C0086k.m775a(this.f642k, this.f643l, f, this.f625K));
        if (this.f645n != this.f644m) {
            this.f623I.setColor(C0086k.m776a(this.f644m, this.f645n, f));
        } else {
            this.f623I.setColor(this.f645n);
        }
        this.f623I.setShadowLayer(C0086k.m775a(this.f630P, this.f626L, f, null), C0086k.m775a(this.f631Q, this.f627M, f, null), C0086k.m775a(this.f632R, this.f628N, f, null), C0086k.m776a(this.f633S, this.f629O, f));
        cb.m2417d(this.f634c);
    }

    private void m781d(float f) {
        this.f639h.left = C0086k.m775a((float) this.f637f.left, (float) this.f638g.left, f, this.f624J);
        this.f639h.top = C0086k.m775a(this.f646o, this.f647p, f, this.f624J);
        this.f639h.right = C0086k.m775a((float) this.f637f.right, (float) this.f638g.right, f, this.f624J);
        this.f639h.bottom = C0086k.m775a((float) this.f637f.bottom, (float) this.f638g.bottom, f, this.f624J);
    }

    private void m782e(float f) {
        m783f(f);
        boolean z = f613a && this.f620F != 1.0f;
        this.f615A = z;
        if (this.f615A) {
            m787m();
        }
        cb.m2417d(this.f634c);
    }

    private void m783f(float f) {
        boolean z = true;
        if (this.f655x != null) {
            float width;
            float f2;
            boolean z2;
            if (C0086k.m777a(f, this.f643l)) {
                width = (float) this.f638g.width();
                float f3 = this.f643l;
                this.f620F = 1.0f;
                if (this.f654w != this.f652u) {
                    this.f654w = this.f652u;
                    f2 = width;
                    width = f3;
                    z2 = true;
                } else {
                    f2 = width;
                    width = f3;
                    z2 = false;
                }
            } else {
                f2 = (float) this.f637f.width();
                width = this.f642k;
                if (this.f654w != this.f653v) {
                    this.f654w = this.f653v;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (C0086k.m777a(f, this.f642k)) {
                    this.f620F = 1.0f;
                } else {
                    this.f620F = f / this.f642k;
                }
            }
            if (f2 > 0.0f) {
                if (!(this.f621G != width || this.f622H || z2)) {
                    z = false;
                }
                this.f621G = width;
                this.f622H = false;
            } else {
                z = z2;
            }
            if (this.f656y == null || r1) {
                this.f623I.setTextSize(this.f621G);
                this.f623I.setTypeface(this.f654w);
                CharSequence ellipsize = TextUtils.ellipsize(this.f655x, this.f623I, f2, TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.f656y)) {
                    this.f656y = ellipsize;
                    this.f657z = m779b(this.f656y);
                }
            }
        }
    }

    private Typeface m784g(int i) {
        TypedArray obtainStyledAttributes = this.f634c.getContext().obtainStyledAttributes(i, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                Typeface create = Typeface.create(string, 0);
                return create;
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m785k() {
        m780c(this.f636e);
    }

    private void m786l() {
        int i = 1;
        float f = 0.0f;
        float f2 = this.f621G;
        m783f(this.f643l);
        float measureText = this.f656y != null ? this.f623I.measureText(this.f656y, 0, this.f656y.length()) : 0.0f;
        int a = C0327v.m2941a(this.f641j, this.f657z ? 1 : 0);
        switch (a & 112) {
            case C1317h.Theme_homeAsUpIndicator /*48*/:
                this.f647p = ((float) this.f638g.top) - this.f623I.ascent();
                break;
            case C1317h.Theme_panelMenuListTheme /*80*/:
                this.f647p = (float) this.f638g.bottom;
                break;
            default:
                this.f647p = (((this.f623I.descent() - this.f623I.ascent()) / 2.0f) - this.f623I.descent()) + ((float) this.f638g.centerY());
                break;
        }
        switch (a & 7) {
            case VideoSize.CIF /*1*/:
                this.f649r = ((float) this.f638g.centerX()) - (measureText / 2.0f);
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                this.f649r = ((float) this.f638g.right) - measureText;
                break;
            default:
                this.f649r = (float) this.f638g.left;
                break;
        }
        m783f(this.f642k);
        if (this.f656y != null) {
            f = this.f623I.measureText(this.f656y, 0, this.f656y.length());
        }
        int i2 = this.f640i;
        if (!this.f657z) {
            i = 0;
        }
        i2 = C0327v.m2941a(i2, i);
        switch (i2 & 112) {
            case C1317h.Theme_homeAsUpIndicator /*48*/:
                this.f646o = ((float) this.f637f.top) - this.f623I.ascent();
                break;
            case C1317h.Theme_panelMenuListTheme /*80*/:
                this.f646o = (float) this.f637f.bottom;
                break;
            default:
                this.f646o = (((this.f623I.descent() - this.f623I.ascent()) / 2.0f) - this.f623I.descent()) + ((float) this.f637f.centerY());
                break;
        }
        switch (i2 & 7) {
            case VideoSize.CIF /*1*/:
                this.f648q = ((float) this.f637f.centerX()) - (f / 2.0f);
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                this.f648q = ((float) this.f637f.right) - f;
                break;
            default:
                this.f648q = (float) this.f637f.left;
                break;
        }
        m788n();
        m782e(f2);
    }

    private void m787m() {
        if (this.f616B == null && !this.f637f.isEmpty() && !TextUtils.isEmpty(this.f656y)) {
            m780c(0.0f);
            this.f618D = this.f623I.ascent();
            this.f619E = this.f623I.descent();
            int round = Math.round(this.f623I.measureText(this.f656y, 0, this.f656y.length()));
            int round2 = Math.round(this.f619E - this.f618D);
            if (round > 0 && round2 > 0) {
                this.f616B = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
                new Canvas(this.f616B).drawText(this.f656y, 0, this.f656y.length(), 0.0f, ((float) round2) - this.f623I.descent(), this.f623I);
                if (this.f617C == null) {
                    this.f617C = new Paint(3);
                }
            }
        }
    }

    private void m788n() {
        if (this.f616B != null) {
            this.f616B.recycle();
            this.f616B = null;
        }
    }

    void m789a() {
        boolean z = this.f638g.width() > 0 && this.f638g.height() > 0 && this.f637f.width() > 0 && this.f637f.height() > 0;
        this.f635d = z;
    }

    void m790a(float f) {
        if (this.f642k != f) {
            this.f642k = f;
            m813h();
        }
    }

    void m791a(int i) {
        if (this.f645n != i) {
            this.f645n = i;
            m813h();
        }
    }

    void m792a(int i, int i2, int i3, int i4) {
        if (!C0086k.m778a(this.f637f, i, i2, i3, i4)) {
            this.f637f.set(i, i2, i3, i4);
            this.f622H = true;
            m789a();
        }
    }

    public void m793a(Canvas canvas) {
        int save = canvas.save();
        if (this.f656y != null && this.f635d) {
            float f;
            float f2 = this.f650s;
            float f3 = this.f651t;
            int i = (!this.f615A || this.f616B == null) ? 0 : 1;
            this.f623I.setTextSize(this.f621G);
            float f4;
            if (i != 0) {
                f = this.f618D * this.f620F;
                f4 = this.f619E * this.f620F;
            } else {
                f = this.f623I.ascent() * this.f620F;
                f4 = this.f623I.descent() * this.f620F;
            }
            if (i != 0) {
                f3 += f;
            }
            if (this.f620F != 1.0f) {
                canvas.scale(this.f620F, this.f620F, f2, f3);
            }
            if (i != 0) {
                canvas.drawBitmap(this.f616B, f2, f3, this.f617C);
            } else {
                canvas.drawText(this.f656y, 0, this.f656y.length(), f2, f3, this.f623I);
            }
        }
        canvas.restoreToCount(save);
    }

    void m794a(Typeface typeface) {
        if (this.f652u != typeface) {
            this.f652u = typeface;
            m813h();
        }
    }

    void m795a(Interpolator interpolator) {
        this.f625K = interpolator;
        m813h();
    }

    void m796a(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.f655x)) {
            this.f655x = charSequence;
            this.f656y = null;
            m788n();
            m813h();
        }
    }

    int m797b() {
        return this.f640i;
    }

    void m798b(float f) {
        float a = as.m540a(f, 0.0f, 1.0f);
        if (a != this.f636e) {
            this.f636e = a;
            m785k();
        }
    }

    void m799b(int i) {
        if (this.f644m != i) {
            this.f644m = i;
            m813h();
        }
    }

    void m800b(int i, int i2, int i3, int i4) {
        if (!C0086k.m778a(this.f638g, i, i2, i3, i4)) {
            this.f638g.set(i, i2, i3, i4);
            this.f622H = true;
            m789a();
        }
    }

    void m801b(Typeface typeface) {
        if (this.f653v != typeface) {
            this.f653v = typeface;
            m813h();
        }
    }

    void m802b(Interpolator interpolator) {
        this.f624J = interpolator;
        m813h();
    }

    int m803c() {
        return this.f641j;
    }

    void m804c(int i) {
        if (this.f640i != i) {
            this.f640i = i;
            m813h();
        }
    }

    void m805c(Typeface typeface) {
        this.f653v = typeface;
        this.f652u = typeface;
        m813h();
    }

    Typeface m806d() {
        return this.f652u != null ? this.f652u : Typeface.DEFAULT;
    }

    void m807d(int i) {
        if (this.f641j != i) {
            this.f641j = i;
            m813h();
        }
    }

    Typeface m808e() {
        return this.f653v != null ? this.f653v : Typeface.DEFAULT;
    }

    void m809e(int i) {
        TypedArray obtainStyledAttributes = this.f634c.getContext().obtainStyledAttributes(i, C0070k.TextAppearance);
        if (obtainStyledAttributes.hasValue(C0070k.TextAppearance_android_textColor)) {
            this.f645n = obtainStyledAttributes.getColor(C0070k.TextAppearance_android_textColor, this.f645n);
        }
        if (obtainStyledAttributes.hasValue(C0070k.TextAppearance_android_textSize)) {
            this.f643l = (float) obtainStyledAttributes.getDimensionPixelSize(C0070k.TextAppearance_android_textSize, (int) this.f643l);
        }
        this.f629O = obtainStyledAttributes.getInt(C0070k.TextAppearance_android_shadowColor, 0);
        this.f627M = obtainStyledAttributes.getFloat(C0070k.TextAppearance_android_shadowDx, 0.0f);
        this.f628N = obtainStyledAttributes.getFloat(C0070k.TextAppearance_android_shadowDy, 0.0f);
        this.f626L = obtainStyledAttributes.getFloat(C0070k.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.f652u = m784g(i);
        }
        m813h();
    }

    float m810f() {
        return this.f636e;
    }

    void m811f(int i) {
        TypedArray obtainStyledAttributes = this.f634c.getContext().obtainStyledAttributes(i, C0070k.TextAppearance);
        if (obtainStyledAttributes.hasValue(C0070k.TextAppearance_android_textColor)) {
            this.f644m = obtainStyledAttributes.getColor(C0070k.TextAppearance_android_textColor, this.f644m);
        }
        if (obtainStyledAttributes.hasValue(C0070k.TextAppearance_android_textSize)) {
            this.f642k = (float) obtainStyledAttributes.getDimensionPixelSize(C0070k.TextAppearance_android_textSize, (int) this.f642k);
        }
        this.f633S = obtainStyledAttributes.getInt(C0070k.TextAppearance_android_shadowColor, 0);
        this.f631Q = obtainStyledAttributes.getFloat(C0070k.TextAppearance_android_shadowDx, 0.0f);
        this.f632R = obtainStyledAttributes.getFloat(C0070k.TextAppearance_android_shadowDy, 0.0f);
        this.f630P = obtainStyledAttributes.getFloat(C0070k.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.f653v = m784g(i);
        }
        m813h();
    }

    float m812g() {
        return this.f643l;
    }

    public void m813h() {
        if (this.f634c.getHeight() > 0 && this.f634c.getWidth() > 0) {
            m786l();
            m785k();
        }
    }

    CharSequence m814i() {
        return this.f655x;
    }

    int m815j() {
        return this.f645n;
    }
}
