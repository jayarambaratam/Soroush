package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;

class at {
    private final RectF f1601a;
    private final Paint f1602b;
    private final Paint f1603c;
    private final Callback f1604d;
    private float f1605e;
    private float f1606f;
    private float f1607g;
    private float f1608h;
    private float f1609i;
    private int[] f1610j;
    private int f1611k;
    private float f1612l;
    private float f1613m;
    private float f1614n;
    private boolean f1615o;
    private Path f1616p;
    private float f1617q;
    private double f1618r;
    private int f1619s;
    private int f1620t;
    private int f1621u;
    private final Paint f1622v;
    private int f1623w;
    private int f1624x;

    public at(Callback callback) {
        this.f1601a = new RectF();
        this.f1602b = new Paint();
        this.f1603c = new Paint();
        this.f1605e = 0.0f;
        this.f1606f = 0.0f;
        this.f1607g = 0.0f;
        this.f1608h = 5.0f;
        this.f1609i = 2.5f;
        this.f1622v = new Paint(1);
        this.f1604d = callback;
        this.f1602b.setStrokeCap(Cap.SQUARE);
        this.f1602b.setAntiAlias(true);
        this.f1602b.setStyle(Style.STROKE);
        this.f1603c.setStyle(Style.FILL);
        this.f1603c.setAntiAlias(true);
    }

    private void m3202a(Canvas canvas, float f, float f2, Rect rect) {
        if (this.f1615o) {
            if (this.f1616p == null) {
                this.f1616p = new Path();
                this.f1616p.setFillType(FillType.EVEN_ODD);
            } else {
                this.f1616p.reset();
            }
            float f3 = ((float) (((int) this.f1609i) / 2)) * this.f1617q;
            float cos = (float) ((this.f1618r * Math.cos(0.0d)) + ((double) rect.exactCenterX()));
            float sin = (float) ((this.f1618r * Math.sin(0.0d)) + ((double) rect.exactCenterY()));
            this.f1616p.moveTo(0.0f, 0.0f);
            this.f1616p.lineTo(((float) this.f1619s) * this.f1617q, 0.0f);
            this.f1616p.lineTo((((float) this.f1619s) * this.f1617q) / 2.0f, ((float) this.f1620t) * this.f1617q);
            this.f1616p.offset(cos - f3, sin);
            this.f1616p.close();
            this.f1603c.setColor(this.f1624x);
            canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
            canvas.drawPath(this.f1616p, this.f1603c);
        }
    }

    private int m3203n() {
        return (this.f1611k + 1) % this.f1610j.length;
    }

    private void m3204o() {
        this.f1604d.invalidateDrawable(null);
    }

    public int m3205a() {
        return this.f1610j[m3203n()];
    }

    public void m3206a(double d) {
        this.f1618r = d;
    }

    public void m3207a(float f) {
        this.f1608h = f;
        this.f1602b.setStrokeWidth(f);
        m3204o();
    }

    public void m3208a(float f, float f2) {
        this.f1619s = (int) f;
        this.f1620t = (int) f2;
    }

    public void m3209a(int i) {
        this.f1623w = i;
    }

    public void m3210a(int i, int i2) {
        float min = (float) Math.min(i, i2);
        min = (this.f1618r <= 0.0d || min < 0.0f) ? (float) Math.ceil((double) (this.f1608h / 2.0f)) : (float) (((double) (min / 2.0f)) - this.f1618r);
        this.f1609i = min;
    }

    public void m3211a(Canvas canvas, Rect rect) {
        RectF rectF = this.f1601a;
        rectF.set(rect);
        rectF.inset(this.f1609i, this.f1609i);
        float f = (this.f1605e + this.f1607g) * 360.0f;
        float f2 = ((this.f1606f + this.f1607g) * 360.0f) - f;
        this.f1602b.setColor(this.f1624x);
        canvas.drawArc(rectF, f, f2, false, this.f1602b);
        m3202a(canvas, f, f2, rect);
        if (this.f1621u < 255) {
            this.f1622v.setColor(this.f1623w);
            this.f1622v.setAlpha(255 - this.f1621u);
            canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float) (rect.width() / 2), this.f1622v);
        }
    }

    public void m3212a(ColorFilter colorFilter) {
        this.f1602b.setColorFilter(colorFilter);
        m3204o();
    }

    public void m3213a(boolean z) {
        if (this.f1615o != z) {
            this.f1615o = z;
            m3204o();
        }
    }

    public void m3214a(int[] iArr) {
        this.f1610j = iArr;
        m3220c(0);
    }

    public void m3215b() {
        m3220c(m3203n());
    }

    public void m3216b(float f) {
        this.f1605e = f;
        m3204o();
    }

    public void m3217b(int i) {
        this.f1624x = i;
    }

    public int m3218c() {
        return this.f1621u;
    }

    public void m3219c(float f) {
        this.f1606f = f;
        m3204o();
    }

    public void m3220c(int i) {
        this.f1611k = i;
        this.f1624x = this.f1610j[this.f1611k];
    }

    public float m3221d() {
        return this.f1608h;
    }

    public void m3222d(float f) {
        this.f1607g = f;
        m3204o();
    }

    public void m3223d(int i) {
        this.f1621u = i;
    }

    public float m3224e() {
        return this.f1605e;
    }

    public void m3225e(float f) {
        if (f != this.f1617q) {
            this.f1617q = f;
            m3204o();
        }
    }

    public float m3226f() {
        return this.f1612l;
    }

    public float m3227g() {
        return this.f1613m;
    }

    public int m3228h() {
        return this.f1610j[this.f1611k];
    }

    public float m3229i() {
        return this.f1606f;
    }

    public double m3230j() {
        return this.f1618r;
    }

    public float m3231k() {
        return this.f1614n;
    }

    public void m3232l() {
        this.f1612l = this.f1605e;
        this.f1613m = this.f1606f;
        this.f1614n = this.f1607g;
    }

    public void m3233m() {
        this.f1612l = 0.0f;
        this.f1613m = 0.0f;
        this.f1614n = 0.0f;
        m3216b(0.0f);
        m3219c(0.0f);
        m3222d(0.0f);
    }
}
