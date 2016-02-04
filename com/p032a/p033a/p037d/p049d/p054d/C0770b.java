package com.p032a.p033a.p037d.p049d.p054d;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.view.Gravity;
import com.p032a.p033a.p035b.C0576a;
import com.p032a.p033a.p035b.C0577b;
import com.p032a.p033a.p035b.C0579d;
import com.p032a.p033a.p037d.C0730g;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;
import com.p032a.p033a.p037d.p049d.p052b.C0742b;

/* renamed from: com.a.a.d.d.d.b */
public class C0770b extends C0742b implements C0769j {
    private final Paint f2819a;
    private final Rect f2820b;
    private final C0771c f2821c;
    private final C0576a f2822d;
    private final C0775g f2823e;
    private boolean f2824f;
    private boolean f2825g;
    private boolean f2826h;
    private boolean f2827i;
    private int f2828j;
    private int f2829k;
    private boolean f2830l;

    public C0770b(Context context, C0577b c0577b, C0605e c0605e, C0730g<Bitmap> c0730g, int i, int i2, C0579d c0579d, byte[] bArr, Bitmap bitmap) {
        this(new C0771c(c0579d, bArr, context, c0730g, i, i2, c0577b, c0605e, bitmap));
    }

    public C0770b(C0770b c0770b, Bitmap bitmap, C0730g<Bitmap> c0730g) {
        this(new C0771c(c0770b.f2821c.f2831a, c0770b.f2821c.f2832b, c0770b.f2821c.f2833c, c0730g, c0770b.f2821c.f2835e, c0770b.f2821c.f2836f, c0770b.f2821c.f2837g, c0770b.f2821c.f2838h, bitmap));
    }

    C0770b(C0771c c0771c) {
        this.f2820b = new Rect();
        this.f2827i = true;
        this.f2829k = -1;
        if (c0771c == null) {
            throw new NullPointerException("GifState must not be null");
        }
        this.f2821c = c0771c;
        this.f2822d = new C0576a(c0771c.f2837g);
        this.f2819a = new Paint();
        this.f2822d.m4342a(c0771c.f2831a, c0771c.f2832b);
        this.f2823e = new C0775g(c0771c.f2833c, this, this.f2822d, c0771c.f2835e, c0771c.f2836f);
        this.f2823e.m4945a(c0771c.f2834d);
    }

    private void m4921g() {
        this.f2828j = 0;
    }

    private void m4922h() {
        this.f2823e.m4947c();
        invalidateSelf();
    }

    private void m4923i() {
        if (this.f2822d.m4344c() == 1) {
            invalidateSelf();
        } else if (!this.f2824f) {
            this.f2824f = true;
            this.f2823e.m4943a();
            invalidateSelf();
        }
    }

    private void m4924j() {
        this.f2824f = false;
        this.f2823e.m4946b();
    }

    public void m4925a(int i) {
        if (i <= 0 && i != -1 && i != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        } else if (i == 0) {
            this.f2829k = this.f2822d.m4346e();
        } else {
            this.f2829k = i;
        }
    }

    public boolean m4926a() {
        return true;
    }

    public Bitmap m4927b() {
        return this.f2821c.f2839i;
    }

    @TargetApi(11)
    public void m4928b(int i) {
        if (VERSION.SDK_INT < 11 || getCallback() != null) {
            invalidateSelf();
            if (i == this.f2822d.m4344c() - 1) {
                this.f2828j++;
            }
            if (this.f2829k != -1 && this.f2828j >= this.f2829k) {
                stop();
                return;
            }
            return;
        }
        stop();
        m4922h();
    }

    public C0730g<Bitmap> m4929c() {
        return this.f2821c.f2834d;
    }

    public byte[] m4930d() {
        return this.f2821c.f2832b;
    }

    public void draw(Canvas canvas) {
        if (!this.f2826h) {
            if (this.f2830l) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.f2820b);
                this.f2830l = false;
            }
            Bitmap d = this.f2823e.m4948d();
            if (d == null) {
                d = this.f2821c.f2839i;
            }
            canvas.drawBitmap(d, null, this.f2820b, this.f2819a);
        }
    }

    public int m4931e() {
        return this.f2822d.m4344c();
    }

    public void m4932f() {
        this.f2826h = true;
        this.f2821c.f2838h.m4511a(this.f2821c.f2839i);
        this.f2823e.m4947c();
        this.f2823e.m4946b();
    }

    public ConstantState getConstantState() {
        return this.f2821c;
    }

    public int getIntrinsicHeight() {
        return this.f2821c.f2839i.getHeight();
    }

    public int getIntrinsicWidth() {
        return this.f2821c.f2839i.getWidth();
    }

    public int getOpacity() {
        return -2;
    }

    public boolean isRunning() {
        return this.f2824f;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f2830l = true;
    }

    public void setAlpha(int i) {
        this.f2819a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2819a.setColorFilter(colorFilter);
    }

    public boolean setVisible(boolean z, boolean z2) {
        this.f2827i = z;
        if (!z) {
            m4924j();
        } else if (this.f2825g) {
            m4923i();
        }
        return super.setVisible(z, z2);
    }

    public void start() {
        this.f2825g = true;
        m4921g();
        if (this.f2827i) {
            m4923i();
        }
    }

    public void stop() {
        this.f2825g = false;
        m4924j();
        if (VERSION.SDK_INT < 11) {
            m4922h();
        }
    }
}
