package android.support.v7.p009c.p010a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.p013c.p014a.C0177a;
import android.support.v7.p019a.C0359b;
import android.support.v7.p019a.C0368k;
import android.support.v7.p019a.C0369l;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: android.support.v7.c.a.c */
public class C0382c extends Drawable {
    private static final float f1880b;
    private final Paint f1881a;
    private float f1882c;
    private float f1883d;
    private float f1884e;
    private float f1885f;
    private boolean f1886g;
    private final Path f1887h;
    private final int f1888i;
    private boolean f1889j;
    private float f1890k;
    private float f1891l;
    private int f1892m;

    static {
        f1880b = (float) Math.toRadians(45.0d);
    }

    public C0382c(Context context) {
        this.f1881a = new Paint();
        this.f1887h = new Path();
        this.f1889j = false;
        this.f1892m = 2;
        this.f1881a.setStyle(Style.STROKE);
        this.f1881a.setStrokeJoin(Join.MITER);
        this.f1881a.setStrokeCap(Cap.BUTT);
        this.f1881a.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, C0369l.DrawerArrowToggle, C0359b.drawerArrowStyle, C0368k.Base_Widget_AppCompat_DrawerArrowToggle);
        m3813a(obtainStyledAttributes.getColor(C0369l.DrawerArrowToggle_color, 0));
        m3815b(obtainStyledAttributes.getDimension(C0369l.DrawerArrowToggle_thickness, 0.0f));
        m3814a(obtainStyledAttributes.getBoolean(C0369l.DrawerArrowToggle_spinBars, true));
        m3817c((float) Math.round(obtainStyledAttributes.getDimension(C0369l.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.f1888i = obtainStyledAttributes.getDimensionPixelSize(C0369l.DrawerArrowToggle_drawableSize, 0);
        this.f1883d = (float) Math.round(obtainStyledAttributes.getDimension(C0369l.DrawerArrowToggle_barLength, 0.0f));
        this.f1882c = (float) Math.round(obtainStyledAttributes.getDimension(C0369l.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.f1884e = obtainStyledAttributes.getDimension(C0369l.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private static float m3812a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    public void m3813a(int i) {
        if (i != this.f1881a.getColor()) {
            this.f1881a.setColor(i);
            invalidateSelf();
        }
    }

    public void m3814a(boolean z) {
        if (this.f1886g != z) {
            this.f1886g = z;
            invalidateSelf();
        }
    }

    public void m3815b(float f) {
        if (this.f1881a.getStrokeWidth() != f) {
            this.f1881a.setStrokeWidth(f);
            this.f1891l = (float) (((double) (f / 2.0f)) * Math.cos((double) f1880b));
            invalidateSelf();
        }
    }

    public void m3816b(boolean z) {
        if (this.f1889j != z) {
            this.f1889j = z;
            invalidateSelf();
        }
    }

    public void m3817c(float f) {
        if (f != this.f1885f) {
            this.f1885f = f;
            invalidateSelf();
        }
    }

    public void m3818d(float f) {
        if (this.f1890k != f) {
            this.f1890k = f;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        int i;
        Rect bounds = getBounds();
        switch (this.f1892m) {
            case VideoSize.QCIF /*0*/:
                i = 0;
                break;
            case VideoSize.CIF /*1*/:
                i = 1;
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                if (C0177a.m1551e(this) != 0) {
                    i = 0;
                    break;
                } else {
                    i = 1;
                    break;
                }
            default:
                if (C0177a.m1551e(this) != 1) {
                    i = 0;
                    break;
                } else {
                    i = 1;
                    break;
                }
        }
        float a = C0382c.m3812a(this.f1883d, (float) Math.sqrt((double) ((this.f1882c * this.f1882c) * 2.0f)), this.f1890k);
        float a2 = C0382c.m3812a(this.f1883d, this.f1884e, this.f1890k);
        float round = (float) Math.round(C0382c.m3812a(0.0f, this.f1891l, this.f1890k));
        float a3 = C0382c.m3812a(0.0f, f1880b, this.f1890k);
        float a4 = C0382c.m3812a(i != 0 ? 0.0f : -180.0f, i != 0 ? 180.0f : 0.0f, this.f1890k);
        float round2 = (float) Math.round(((double) a) * Math.cos((double) a3));
        a = (float) Math.round(((double) a) * Math.sin((double) a3));
        this.f1887h.rewind();
        a3 = C0382c.m3812a(this.f1885f + this.f1881a.getStrokeWidth(), -this.f1891l, this.f1890k);
        float f = (-a2) / 2.0f;
        this.f1887h.moveTo(f + round, 0.0f);
        this.f1887h.rLineTo(a2 - (round * 2.0f), 0.0f);
        this.f1887h.moveTo(f, a3);
        this.f1887h.rLineTo(round2, a);
        this.f1887h.moveTo(f, -a3);
        this.f1887h.rLineTo(round2, -a);
        this.f1887h.close();
        canvas.save();
        round2 = this.f1881a.getStrokeWidth();
        canvas.translate((float) bounds.centerX(), (float) (((double) ((float) ((((int) ((((float) bounds.height()) - (3.0f * round2)) - (this.f1885f * 2.0f))) / 4) * 2))) + ((((double) round2) * 1.5d) + ((double) this.f1885f))));
        if (this.f1886g) {
            canvas.rotate(((float) ((i ^ this.f1889j) != 0 ? -1 : 1)) * a4);
        } else if (i != 0) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f1887h, this.f1881a);
        canvas.restore();
    }

    public int getIntrinsicHeight() {
        return this.f1888i;
    }

    public int getIntrinsicWidth() {
        return this.f1888i;
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
        if (i != this.f1881a.getAlpha()) {
            this.f1881a.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1881a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
