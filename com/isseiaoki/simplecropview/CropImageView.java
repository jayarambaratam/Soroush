package com.isseiaoki.simplecropview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.ImageView;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

public class CropImageView extends ImageView {
    private float f4026A;
    private int f4027B;
    private int f4028C;
    private boolean f4029D;
    private boolean f4030E;
    private boolean f4031F;
    private boolean f4032G;
    private PointF f4033H;
    private float f4034I;
    private float f4035J;
    private int f4036K;
    private int f4037L;
    private int f4038M;
    private int f4039N;
    private int f4040O;
    private float f4041P;
    private final int f4042a;
    private final int f4043b;
    private final int f4044c;
    private final int f4045d;
    private int f4046e;
    private int f4047f;
    private Bitmap f4048g;
    private float f4049h;
    private float f4050i;
    private float f4051j;
    private float f4052k;
    private boolean f4053l;
    private Matrix f4054m;
    private Paint f4055n;
    private Paint f4056o;
    private Paint f4057p;
    private RectF f4058q;
    private RectF f4059r;
    private PointF f4060s;
    private float f4061t;
    private float f4062u;
    private PointF f4063v;
    private C1070d f4064w;
    private C1068b f4065x;
    private C1069c f4066y;
    private C1069c f4067z;

    public class SavedState extends BaseSavedState {
        Bitmap f4006a;
        C1068b f4007b;
        int f4008c;
        int f4009d;
        int f4010e;
        C1069c f4011f;
        C1069c f4012g;
        boolean f4013h;
        boolean f4014i;
        int f4015j;
        int f4016k;
        float f4017l;
        float f4018m;
        float f4019n;
        float f4020o;
        float f4021p;
        boolean f4022q;
        int f4023r;
        int f4024s;
        float f4025t;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 1;
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f4006a, i);
            parcel.writeSerializable(this.f4007b);
            parcel.writeInt(this.f4008c);
            parcel.writeInt(this.f4009d);
            parcel.writeInt(this.f4010e);
            parcel.writeSerializable(this.f4011f);
            parcel.writeSerializable(this.f4012g);
            parcel.writeInt(this.f4013h ? 1 : 0);
            parcel.writeInt(this.f4014i ? 1 : 0);
            parcel.writeInt(this.f4015j);
            parcel.writeInt(this.f4016k);
            parcel.writeFloat(this.f4017l);
            parcel.writeFloat(this.f4018m);
            parcel.writeFloat(this.f4019n);
            parcel.writeFloat(this.f4020o);
            parcel.writeFloat(this.f4021p);
            if (!this.f4022q) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeInt(this.f4023r);
            parcel.writeInt(this.f4024s);
            parcel.writeFloat(this.f4025t);
        }
    }

    public CropImageView(Context context) {
        this(context, null);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4043b = -1140850689;
        this.f4044c = -1;
        this.f4045d = -1157627904;
        this.f4046e = 0;
        this.f4047f = 0;
        this.f4048g = null;
        this.f4049h = 1.0f;
        this.f4050i = 0.0f;
        this.f4051j = 0.0f;
        this.f4052k = 0.0f;
        this.f4053l = false;
        this.f4054m = null;
        this.f4060s = new PointF();
        this.f4063v = new PointF();
        this.f4064w = C1070d.OUT_OF_BOUNDS;
        this.f4065x = C1068b.RATIO_1_1;
        this.f4066y = C1069c.SHOW_ALWAYS;
        this.f4067z = C1069c.SHOW_ALWAYS;
        this.f4028C = 0;
        this.f4029D = true;
        this.f4030E = true;
        this.f4031F = true;
        this.f4032G = true;
        this.f4033H = new PointF(1.0f, 1.0f);
        this.f4034I = 3.0f;
        this.f4035J = 3.0f;
        this.f4042a = getResources().getColor(17170445);
        float density = getDensity();
        this.f4027B = (int) (16.0f * density);
        this.f4026A = 50.0f * density;
        this.f4034I = density * 1.0f;
        this.f4035J = density * 1.0f;
        this.f4056o = new Paint();
        this.f4055n = new Paint();
        this.f4057p = new Paint();
        this.f4057p.setFilterBitmap(true);
        this.f4054m = new Matrix();
        this.f4049h = 1.0f;
        this.f4036K = this.f4042a;
        this.f4038M = -1;
        this.f4037L = -1157627904;
        this.f4039N = -1;
        this.f4040O = -1140850689;
        m6305a(context, attributeSet, i, density);
    }

    private float m6302a(float f, float f2, float f3, float f4) {
        return (f < f2 || f > f3) ? f4 : f;
    }

    private void m6303a() {
        this.f4054m.reset();
        this.f4054m.setTranslate(this.f4060s.x - (this.f4051j * 0.5f), this.f4060s.y - (this.f4052k * 0.5f));
        this.f4054m.postScale(this.f4049h, this.f4049h, this.f4060s.x, this.f4060s.y);
        this.f4054m.postRotate(this.f4050i, this.f4060s.x, this.f4060s.y);
    }

    private void m6304a(float f, float f2) {
        if (m6317c(f, f2)) {
            this.f4064w = C1070d.LEFT_TOP;
            if (this.f4067z == C1069c.SHOW_ON_TOUCH) {
                this.f4030E = true;
            }
            if (this.f4066y == C1069c.SHOW_ON_TOUCH) {
                this.f4029D = true;
            }
        } else if (m6320d(f, f2)) {
            this.f4064w = C1070d.RIGHT_TOP;
            if (this.f4067z == C1069c.SHOW_ON_TOUCH) {
                this.f4030E = true;
            }
            if (this.f4066y == C1069c.SHOW_ON_TOUCH) {
                this.f4029D = true;
            }
        } else if (m6323e(f, f2)) {
            this.f4064w = C1070d.LEFT_BOTTOM;
            if (this.f4067z == C1069c.SHOW_ON_TOUCH) {
                this.f4030E = true;
            }
            if (this.f4066y == C1069c.SHOW_ON_TOUCH) {
                this.f4029D = true;
            }
        } else if (m6325f(f, f2)) {
            this.f4064w = C1070d.RIGHT_BOTTOM;
            if (this.f4067z == C1069c.SHOW_ON_TOUCH) {
                this.f4030E = true;
            }
            if (this.f4066y == C1069c.SHOW_ON_TOUCH) {
                this.f4029D = true;
            }
        } else if (m6313b(f, f2)) {
            if (this.f4066y == C1069c.SHOW_ON_TOUCH) {
                this.f4029D = true;
            }
            this.f4064w = C1070d.CENTER;
        } else {
            this.f4064w = C1070d.OUT_OF_BOUNDS;
        }
    }

    private void m6305a(Context context, AttributeSet attributeSet, int i, float f) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1072f.CropImageView, i, 0);
        this.f4065x = C1068b.RATIO_1_1;
        try {
            Drawable drawable = obtainStyledAttributes.getDrawable(C1072f.CropImageView_imgSrc);
            if (drawable != null) {
                setImageBitmap(((BitmapDrawable) drawable).getBitmap());
            }
            for (C1068b c1068b : C1068b.values()) {
                if (obtainStyledAttributes.getInt(C1072f.CropImageView_cropMode, 3) == c1068b.m6335a()) {
                    this.f4065x = c1068b;
                    break;
                }
            }
            this.f4036K = obtainStyledAttributes.getColor(C1072f.CropImageView_backgroundColor, this.f4042a);
            super.setBackgroundColor(this.f4036K);
            this.f4037L = obtainStyledAttributes.getColor(C1072f.CropImageView_overlayColor, -1157627904);
            this.f4038M = obtainStyledAttributes.getColor(C1072f.CropImageView_frameColor, -1);
            this.f4039N = obtainStyledAttributes.getColor(C1072f.CropImageView_handleColor, -1);
            this.f4040O = obtainStyledAttributes.getColor(C1072f.CropImageView_guideColor, -1140850689);
            for (C1069c c1069c : C1069c.values()) {
                if (obtainStyledAttributes.getInt(C1072f.CropImageView_guideShowMode, 1) == c1069c.m6336a()) {
                    this.f4066y = c1069c;
                    break;
                }
            }
            for (C1069c c1069c2 : C1069c.values()) {
                if (obtainStyledAttributes.getInt(C1072f.CropImageView_handleShowMode, 1) == c1069c2.m6336a()) {
                    this.f4067z = c1069c2;
                    break;
                }
            }
            setGuideShowMode(this.f4066y);
            setHandleShowMode(this.f4067z);
            this.f4027B = obtainStyledAttributes.getDimensionPixelSize(C1072f.CropImageView_handleSize, (int) (16.0f * f));
            this.f4028C = obtainStyledAttributes.getDimensionPixelSize(C1072f.CropImageView_touchPadding, 0);
            this.f4026A = (float) obtainStyledAttributes.getDimensionPixelSize(C1072f.CropImageView_minFrameSize, (int) (50.0f * f));
            this.f4034I = (float) obtainStyledAttributes.getDimensionPixelSize(C1072f.CropImageView_frameStrokeWeight, (int) (1.0f * f));
            this.f4035J = (float) obtainStyledAttributes.getDimensionPixelSize(C1072f.CropImageView_guideStrokeWeight, (int) (1.0f * f));
            this.f4031F = obtainStyledAttributes.getBoolean(C1072f.CropImageView_cropEnabled, true);
            this.f4041P = m6302a(obtainStyledAttributes.getFloat(C1072f.CropImageView_initialFrameScale, 0.75f), 0.01f, 1.0f, 0.75f);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m6306a(Canvas canvas) {
        if (this.f4031F) {
            if (this.f4065x == C1068b.CIRCLE) {
                this.f4055n.setFilterBitmap(true);
                this.f4055n.setColor(this.f4037L);
                this.f4055n.setStyle(Style.FILL);
                Path path = new Path();
                path.addRect(this.f4059r.left, this.f4059r.top, this.f4059r.right, this.f4059r.bottom, Direction.CW);
                path.addCircle((this.f4058q.left + this.f4058q.right) / 2.0f, (this.f4058q.top + this.f4058q.bottom) / 2.0f, (this.f4058q.right - this.f4058q.left) / 2.0f, Direction.CCW);
                canvas.drawPath(path, this.f4055n);
            } else {
                this.f4055n.setFilterBitmap(true);
                this.f4055n.setColor(this.f4037L);
                this.f4055n.setStyle(Style.FILL);
                canvas.drawRect(this.f4059r.left, this.f4059r.top, this.f4059r.right, this.f4058q.top, this.f4055n);
                canvas.drawRect(this.f4059r.left, this.f4058q.bottom, this.f4059r.right, this.f4059r.bottom, this.f4055n);
                canvas.drawRect(this.f4059r.left, this.f4058q.top, this.f4058q.left, this.f4058q.bottom, this.f4055n);
                canvas.drawRect(this.f4058q.right, this.f4058q.top, this.f4059r.right, this.f4058q.bottom, this.f4055n);
            }
            this.f4056o.setAntiAlias(true);
            this.f4056o.setFilterBitmap(true);
            this.f4056o.setStyle(Style.STROKE);
            this.f4056o.setColor(this.f4038M);
            this.f4056o.setStrokeWidth(this.f4034I);
            canvas.drawRect(this.f4058q.left, this.f4058q.top, this.f4058q.right, this.f4058q.bottom, this.f4056o);
            if (this.f4029D) {
                this.f4056o.setColor(this.f4040O);
                this.f4056o.setStrokeWidth(this.f4035J);
                float f = ((this.f4058q.right - this.f4058q.left) / 3.0f) + this.f4058q.left;
                float f2 = this.f4058q.right - ((this.f4058q.right - this.f4058q.left) / 3.0f);
                float f3 = this.f4058q.top + ((this.f4058q.bottom - this.f4058q.top) / 3.0f);
                float f4 = this.f4058q.bottom - ((this.f4058q.bottom - this.f4058q.top) / 3.0f);
                canvas.drawLine(f, this.f4058q.top, f, this.f4058q.bottom, this.f4056o);
                canvas.drawLine(f2, this.f4058q.top, f2, this.f4058q.bottom, this.f4056o);
                canvas.drawLine(this.f4058q.left, f3, this.f4058q.right, f3, this.f4056o);
                canvas.drawLine(this.f4058q.left, f4, this.f4058q.right, f4, this.f4056o);
            }
            if (this.f4030E) {
                this.f4056o.setStyle(Style.FILL);
                this.f4056o.setColor(this.f4039N);
                canvas.drawCircle(this.f4058q.left, this.f4058q.top, (float) this.f4027B, this.f4056o);
                canvas.drawCircle(this.f4058q.right, this.f4058q.top, (float) this.f4027B, this.f4056o);
                canvas.drawCircle(this.f4058q.left, this.f4058q.bottom, (float) this.f4027B, this.f4056o);
                canvas.drawCircle(this.f4058q.right, this.f4058q.bottom, (float) this.f4027B, this.f4056o);
            }
        }
    }

    private void m6307a(MotionEvent motionEvent) {
        invalidate();
        this.f4061t = motionEvent.getX();
        this.f4062u = motionEvent.getY();
        m6304a(motionEvent.getX(), motionEvent.getY());
    }

    private boolean m6308a(float f) {
        return this.f4059r.left <= f && this.f4059r.right >= f;
    }

    private void m6309b() {
        m6303a();
        float[] fArr = new float[]{0.0f, 0.0f, 0.0f, this.f4052k, this.f4051j, 0.0f, this.f4051j, this.f4052k};
        this.f4054m.mapPoints(fArr);
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[6];
        float f4 = fArr[7];
        this.f4058q = new RectF(f, f2, f3, f4);
        this.f4059r = new RectF(f, f2, f3, f4);
    }

    private void m6310b(int i, int i2) {
        float width = (float) this.f4048g.getWidth();
        float height = (float) this.f4048g.getHeight();
        this.f4051j = width;
        this.f4052k = height;
        float f = (float) i;
        float f2 = (float) i2;
        float f3 = f / f2;
        float f4 = width / height;
        float f5 = 1.0f;
        if (f4 >= f3) {
            f5 = f / width;
        } else if (f4 < f3) {
            f5 = f2 / height;
        }
        setCenter(new PointF(((float) getPaddingLeft()) + (f * 0.5f), ((float) getPaddingTop()) + (f2 * 0.5f)));
        setScale(f5);
        m6309b();
        m6328h();
        this.f4053l = true;
    }

    private void m6311b(MotionEvent motionEvent) {
        float x = motionEvent.getX() - this.f4061t;
        float y = motionEvent.getY() - this.f4062u;
        switch (C1067a.f4068a[this.f4064w.ordinal()]) {
            case VideoSize.CIF /*1*/:
                m6326g(x, y);
                break;
            case VideoSize.HVGA /*2*/:
                m6329h(x, y);
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                m6330i(x, y);
                break;
            case Version.API04_DONUT_16 /*4*/:
                m6331j(x, y);
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                m6332k(x, y);
                break;
        }
        invalidate();
        this.f4061t = motionEvent.getX();
        this.f4062u = motionEvent.getY();
    }

    private boolean m6312b(float f) {
        return this.f4059r.top <= f && this.f4059r.bottom >= f;
    }

    private boolean m6313b(float f, float f2) {
        if (this.f4058q.left > f || this.f4058q.right < f || this.f4058q.top > f2 || this.f4058q.bottom < f2) {
            return false;
        }
        this.f4064w = C1070d.CENTER;
        return true;
    }

    private float m6314c(float f) {
        switch (C1067a.f4069b[this.f4065x.ordinal()]) {
            case VideoSize.CIF /*1*/:
                return this.f4051j;
            case Version.API03_CUPCAKE_15 /*3*/:
                return 4.0f;
            case Version.API04_DONUT_16 /*4*/:
                return 3.0f;
            case Version.API05_ECLAIR_20 /*5*/:
                return 16.0f;
            case Version.API06_ECLAIR_201 /*6*/:
                return 9.0f;
            case Version.API07_ECLAIR_21 /*7*/:
            case Version.API08_FROYO_22 /*8*/:
                return 1.0f;
            case Version.API09_GINGERBREAD_23 /*9*/:
                return this.f4033H.x;
            default:
                return f;
        }
    }

    private void m6315c() {
        this.f4064w = C1070d.OUT_OF_BOUNDS;
        invalidate();
    }

    private void m6316c(MotionEvent motionEvent) {
        if (this.f4066y == C1069c.SHOW_ON_TOUCH) {
            this.f4029D = false;
        }
        if (this.f4067z == C1069c.SHOW_ON_TOUCH) {
            this.f4030E = false;
        }
        this.f4064w = C1070d.OUT_OF_BOUNDS;
        invalidate();
    }

    private boolean m6317c(float f, float f2) {
        float f3 = f - this.f4058q.left;
        float f4 = f2 - this.f4058q.top;
        return m6321e((float) (this.f4027B + this.f4028C)) >= (f3 * f3) + (f4 * f4);
    }

    private float m6318d(float f) {
        switch (C1067a.f4069b[this.f4065x.ordinal()]) {
            case VideoSize.CIF /*1*/:
                return this.f4052k;
            case Version.API03_CUPCAKE_15 /*3*/:
                return 3.0f;
            case Version.API04_DONUT_16 /*4*/:
                return 4.0f;
            case Version.API05_ECLAIR_20 /*5*/:
                return 9.0f;
            case Version.API06_ECLAIR_201 /*6*/:
                return 16.0f;
            case Version.API07_ECLAIR_21 /*7*/:
            case Version.API08_FROYO_22 /*8*/:
                return 1.0f;
            case Version.API09_GINGERBREAD_23 /*9*/:
                return this.f4033H.y;
            default:
                return f;
        }
    }

    private void m6319d() {
        float f = this.f4058q.left - this.f4059r.left;
        float f2 = this.f4058q.right - this.f4059r.right;
        float f3 = this.f4058q.top - this.f4059r.top;
        float f4 = this.f4058q.bottom - this.f4059r.bottom;
        if (f < 0.0f) {
            RectF rectF = this.f4058q;
            rectF.left -= f;
        }
        if (f2 > 0.0f) {
            RectF rectF2 = this.f4058q;
            rectF2.right -= f2;
        }
        if (f3 < 0.0f) {
            rectF2 = this.f4058q;
            rectF2.top -= f3;
        }
        if (f4 > 0.0f) {
            rectF2 = this.f4058q;
            rectF2.bottom -= f4;
        }
    }

    private boolean m6320d(float f, float f2) {
        float f3 = f - this.f4058q.right;
        float f4 = f2 - this.f4058q.top;
        return m6321e((float) (this.f4027B + this.f4028C)) >= (f3 * f3) + (f4 * f4);
    }

    private float m6321e(float f) {
        return f * f;
    }

    private void m6322e() {
        float f = this.f4058q.left - this.f4059r.left;
        if (f < 0.0f) {
            RectF rectF = this.f4058q;
            rectF.left -= f;
            rectF = this.f4058q;
            rectF.right -= f;
        }
        f = this.f4058q.right - this.f4059r.right;
        if (f > 0.0f) {
            rectF = this.f4058q;
            rectF.left -= f;
            rectF = this.f4058q;
            rectF.right -= f;
        }
        f = this.f4058q.top - this.f4059r.top;
        if (f < 0.0f) {
            rectF = this.f4058q;
            rectF.top -= f;
            rectF = this.f4058q;
            rectF.bottom -= f;
        }
        f = this.f4058q.bottom - this.f4059r.bottom;
        if (f > 0.0f) {
            rectF = this.f4058q;
            rectF.top -= f;
            rectF = this.f4058q;
            rectF.bottom -= f;
        }
    }

    private boolean m6323e(float f, float f2) {
        float f3 = f - this.f4058q.left;
        float f4 = f2 - this.f4058q.bottom;
        return m6321e((float) (this.f4027B + this.f4028C)) >= (f3 * f3) + (f4 * f4);
    }

    private boolean m6324f() {
        return getFrameW() < this.f4026A;
    }

    private boolean m6325f(float f, float f2) {
        float f3 = f - this.f4058q.right;
        float f4 = f2 - this.f4058q.bottom;
        return m6321e((float) (this.f4027B + this.f4028C)) >= (f3 * f3) + (f4 * f4);
    }

    private void m6326g(float f, float f2) {
        RectF rectF = this.f4058q;
        rectF.left += f;
        rectF = this.f4058q;
        rectF.right += f;
        rectF = this.f4058q;
        rectF.top += f2;
        rectF = this.f4058q;
        rectF.bottom += f2;
        m6322e();
    }

    private boolean m6327g() {
        return getFrameH() < this.f4026A;
    }

    private float getDensity() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    private float getFrameH() {
        return this.f4058q.bottom - this.f4058q.top;
    }

    private float getFrameW() {
        return this.f4058q.right - this.f4058q.left;
    }

    private float getRatioX() {
        switch (C1067a.f4069b[this.f4065x.ordinal()]) {
            case VideoSize.CIF /*1*/:
                return this.f4051j;
            case Version.API03_CUPCAKE_15 /*3*/:
                return 4.0f;
            case Version.API04_DONUT_16 /*4*/:
                return 3.0f;
            case Version.API05_ECLAIR_20 /*5*/:
                return 16.0f;
            case Version.API06_ECLAIR_201 /*6*/:
                return 9.0f;
            case Version.API09_GINGERBREAD_23 /*9*/:
                return this.f4033H.x;
            default:
                return 1.0f;
        }
    }

    private float getRatioY() {
        switch (C1067a.f4069b[this.f4065x.ordinal()]) {
            case VideoSize.CIF /*1*/:
                return this.f4052k;
            case Version.API03_CUPCAKE_15 /*3*/:
                return 3.0f;
            case Version.API04_DONUT_16 /*4*/:
                return 4.0f;
            case Version.API05_ECLAIR_20 /*5*/:
                return 9.0f;
            case Version.API06_ECLAIR_201 /*6*/:
                return 16.0f;
            case Version.API09_GINGERBREAD_23 /*9*/:
                return this.f4033H.y;
            default:
                return 1.0f;
        }
    }

    private void m6328h() {
        if (this.f4059r != null) {
            float f = this.f4059r.right - this.f4059r.left;
            float f2 = this.f4059r.bottom - this.f4059r.top;
            float f3 = f / f2;
            float c = m6314c(f) / m6318d(f2);
            float f4 = this.f4059r.left;
            float f5 = this.f4059r.top;
            float f6 = this.f4059r.right;
            float f7 = this.f4059r.bottom;
            if (c >= f3) {
                f4 = this.f4059r.left;
                f6 = this.f4059r.right;
                f7 = (this.f4059r.top + this.f4059r.bottom) * 0.5f;
                f = (f / c) * 0.5f;
                f5 = f7 - f;
                f7 += f;
            } else if (c < f3) {
                f5 = this.f4059r.top;
                f7 = this.f4059r.bottom;
                f6 = (this.f4059r.left + this.f4059r.right) * 0.5f;
                f = (f2 * c) * 0.5f;
                f4 = f6 - f;
                f6 += f;
            }
            f6 -= f4;
            f7 -= f5;
            f4 += f6 / 2.0f;
            f5 += f7 / 2.0f;
            f6 *= this.f4041P;
            f7 *= this.f4041P;
            this.f4058q = new RectF(f4 - (f6 / 2.0f), f5 - (f7 / 2.0f), (f6 / 2.0f) + f4, (f7 / 2.0f) + f5);
            invalidate();
        }
    }

    private void m6329h(float f, float f2) {
        float frameW;
        RectF rectF;
        if (this.f4065x == C1068b.RATIO_FREE) {
            RectF rectF2 = this.f4058q;
            rectF2.left += f;
            rectF2 = this.f4058q;
            rectF2.top += f2;
            if (m6324f()) {
                frameW = this.f4026A - getFrameW();
                rectF = this.f4058q;
                rectF.left -= frameW;
            }
            if (m6327g()) {
                frameW = this.f4026A - getFrameH();
                rectF = this.f4058q;
                rectF.top -= frameW;
            }
            m6319d();
            return;
        }
        frameW = (getRatioY() * f) / getRatioX();
        rectF = this.f4058q;
        rectF.left += f;
        rectF = this.f4058q;
        rectF.top = frameW + rectF.top;
        if (m6324f()) {
            frameW = this.f4026A - getFrameW();
            rectF = this.f4058q;
            rectF.left -= frameW;
            frameW = (frameW * getRatioY()) / getRatioX();
            rectF = this.f4058q;
            rectF.top -= frameW;
        }
        if (m6327g()) {
            frameW = this.f4026A - getFrameH();
            rectF = this.f4058q;
            rectF.top -= frameW;
            frameW = (frameW * getRatioX()) / getRatioY();
            rectF = this.f4058q;
            rectF.left -= frameW;
        }
        if (!m6308a(this.f4058q.left)) {
            frameW = this.f4059r.left - this.f4058q.left;
            rectF = this.f4058q;
            rectF.left += frameW;
            frameW = (frameW * getRatioY()) / getRatioX();
            rectF = this.f4058q;
            rectF.top = frameW + rectF.top;
        }
        if (!m6312b(this.f4058q.top)) {
            frameW = this.f4059r.top - this.f4058q.top;
            rectF = this.f4058q;
            rectF.top += frameW;
            frameW = (frameW * getRatioX()) / getRatioY();
            rectF = this.f4058q;
            rectF.left = frameW + rectF.left;
        }
    }

    private void m6330i(float f, float f2) {
        float frameW;
        RectF rectF;
        if (this.f4065x == C1068b.RATIO_FREE) {
            RectF rectF2 = this.f4058q;
            rectF2.right += f;
            rectF2 = this.f4058q;
            rectF2.top += f2;
            if (m6324f()) {
                frameW = this.f4026A - getFrameW();
                rectF = this.f4058q;
                rectF.right = frameW + rectF.right;
            }
            if (m6327g()) {
                frameW = this.f4026A - getFrameH();
                rectF = this.f4058q;
                rectF.top -= frameW;
            }
            m6319d();
            return;
        }
        frameW = (getRatioY() * f) / getRatioX();
        rectF = this.f4058q;
        rectF.right += f;
        rectF = this.f4058q;
        rectF.top -= frameW;
        if (m6324f()) {
            frameW = this.f4026A - getFrameW();
            rectF = this.f4058q;
            rectF.right += frameW;
            frameW = (frameW * getRatioY()) / getRatioX();
            rectF = this.f4058q;
            rectF.top -= frameW;
        }
        if (m6327g()) {
            frameW = this.f4026A - getFrameH();
            rectF = this.f4058q;
            rectF.top -= frameW;
            frameW = (frameW * getRatioX()) / getRatioY();
            rectF = this.f4058q;
            rectF.right = frameW + rectF.right;
        }
        if (!m6308a(this.f4058q.right)) {
            frameW = this.f4058q.right - this.f4059r.right;
            rectF = this.f4058q;
            rectF.right -= frameW;
            frameW = (frameW * getRatioY()) / getRatioX();
            rectF = this.f4058q;
            rectF.top = frameW + rectF.top;
        }
        if (!m6312b(this.f4058q.top)) {
            frameW = this.f4059r.top - this.f4058q.top;
            rectF = this.f4058q;
            rectF.top += frameW;
            frameW = (frameW * getRatioX()) / getRatioY();
            rectF = this.f4058q;
            rectF.right -= frameW;
        }
    }

    private void m6331j(float f, float f2) {
        float frameW;
        RectF rectF;
        if (this.f4065x == C1068b.RATIO_FREE) {
            RectF rectF2 = this.f4058q;
            rectF2.left += f;
            rectF2 = this.f4058q;
            rectF2.bottom += f2;
            if (m6324f()) {
                frameW = this.f4026A - getFrameW();
                rectF = this.f4058q;
                rectF.left -= frameW;
            }
            if (m6327g()) {
                frameW = this.f4026A - getFrameH();
                rectF = this.f4058q;
                rectF.bottom = frameW + rectF.bottom;
            }
            m6319d();
            return;
        }
        frameW = (getRatioY() * f) / getRatioX();
        rectF = this.f4058q;
        rectF.left += f;
        rectF = this.f4058q;
        rectF.bottom -= frameW;
        if (m6324f()) {
            frameW = this.f4026A - getFrameW();
            rectF = this.f4058q;
            rectF.left -= frameW;
            frameW = (frameW * getRatioY()) / getRatioX();
            rectF = this.f4058q;
            rectF.bottom = frameW + rectF.bottom;
        }
        if (m6327g()) {
            frameW = this.f4026A - getFrameH();
            rectF = this.f4058q;
            rectF.bottom += frameW;
            frameW = (frameW * getRatioX()) / getRatioY();
            rectF = this.f4058q;
            rectF.left -= frameW;
        }
        if (!m6308a(this.f4058q.left)) {
            frameW = this.f4059r.left - this.f4058q.left;
            rectF = this.f4058q;
            rectF.left += frameW;
            frameW = (frameW * getRatioY()) / getRatioX();
            rectF = this.f4058q;
            rectF.bottom -= frameW;
        }
        if (!m6312b(this.f4058q.bottom)) {
            frameW = this.f4058q.bottom - this.f4059r.bottom;
            rectF = this.f4058q;
            rectF.bottom -= frameW;
            frameW = (frameW * getRatioX()) / getRatioY();
            rectF = this.f4058q;
            rectF.left = frameW + rectF.left;
        }
    }

    private void m6332k(float f, float f2) {
        float frameW;
        RectF rectF;
        if (this.f4065x == C1068b.RATIO_FREE) {
            RectF rectF2 = this.f4058q;
            rectF2.right += f;
            rectF2 = this.f4058q;
            rectF2.bottom += f2;
            if (m6324f()) {
                frameW = this.f4026A - getFrameW();
                rectF = this.f4058q;
                rectF.right = frameW + rectF.right;
            }
            if (m6327g()) {
                frameW = this.f4026A - getFrameH();
                rectF = this.f4058q;
                rectF.bottom = frameW + rectF.bottom;
            }
            m6319d();
            return;
        }
        frameW = (getRatioY() * f) / getRatioX();
        rectF = this.f4058q;
        rectF.right += f;
        rectF = this.f4058q;
        rectF.bottom = frameW + rectF.bottom;
        if (m6324f()) {
            frameW = this.f4026A - getFrameW();
            rectF = this.f4058q;
            rectF.right += frameW;
            frameW = (frameW * getRatioY()) / getRatioX();
            rectF = this.f4058q;
            rectF.bottom = frameW + rectF.bottom;
        }
        if (m6327g()) {
            frameW = this.f4026A - getFrameH();
            rectF = this.f4058q;
            rectF.bottom += frameW;
            frameW = (frameW * getRatioX()) / getRatioY();
            rectF = this.f4058q;
            rectF.right = frameW + rectF.right;
        }
        if (!m6308a(this.f4058q.right)) {
            frameW = this.f4058q.right - this.f4059r.right;
            rectF = this.f4058q;
            rectF.right -= frameW;
            frameW = (frameW * getRatioY()) / getRatioX();
            rectF = this.f4058q;
            rectF.bottom -= frameW;
        }
        if (!m6312b(this.f4058q.bottom)) {
            frameW = this.f4058q.bottom - this.f4059r.bottom;
            rectF = this.f4058q;
            rectF.bottom -= frameW;
            frameW = (frameW * getRatioX()) / getRatioY();
            rectF = this.f4058q;
            rectF.right -= frameW;
        }
    }

    private void setCenter(PointF pointF) {
        this.f4060s = pointF;
    }

    private void setScale(float f) {
        this.f4049h = f;
    }

    public Bitmap m6333a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Canvas canvas = new Canvas(createBitmap);
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.drawCircle((float) width, (float) height, (float) Math.min(width, height), paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public void m6334a(int i, int i2) {
        if (i != 0 && i2 != 0) {
            this.f4065x = C1068b.RATIO_CUSTOM;
            this.f4033H = new PointF((float) i, (float) i2);
            m6328h();
        }
    }

    public Bitmap getCroppedBitmap() {
        int i;
        int i2;
        int i3;
        int i4;
        if (this.f4048g != null) {
            int i5 = (int) (this.f4058q.left / this.f4049h);
            i = (int) (this.f4058q.top / this.f4049h);
            i2 = i5 - ((int) (this.f4059r.left / this.f4049h));
            i3 = i - ((int) (this.f4059r.top / this.f4049h));
            i4 = ((int) (this.f4058q.right / this.f4049h)) - i5;
            i = ((int) (this.f4058q.bottom / this.f4049h)) - i;
        } else {
            i = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.f4048g, i2, i3, i4, i, null, false);
        return this.f4065x != C1068b.CIRCLE ? createBitmap : m6333a(createBitmap);
    }

    public Bitmap getImageBitmap() {
        return this.f4048g;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f4053l) {
            m6303a();
            Matrix matrix = new Matrix();
            matrix.postConcat(this.f4054m);
            canvas.drawBitmap(this.f4048g, matrix, this.f4057p);
            m6306a(canvas);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f4046e = ((i3 - i) - getPaddingLeft()) - getPaddingRight();
        this.f4047f = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f4048g != null) {
            m6310b(this.f4046e, this.f4047f);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f4065x = savedState.f4007b;
        this.f4036K = savedState.f4008c;
        this.f4037L = savedState.f4009d;
        this.f4038M = savedState.f4010e;
        this.f4066y = savedState.f4011f;
        this.f4067z = savedState.f4012g;
        this.f4029D = savedState.f4013h;
        this.f4030E = savedState.f4014i;
        this.f4027B = savedState.f4015j;
        this.f4028C = savedState.f4016k;
        this.f4026A = savedState.f4017l;
        this.f4033H = new PointF(savedState.f4018m, savedState.f4019n);
        this.f4034I = savedState.f4020o;
        this.f4035J = savedState.f4021p;
        this.f4031F = savedState.f4022q;
        this.f4039N = savedState.f4023r;
        this.f4040O = savedState.f4024s;
        this.f4041P = savedState.f4025t;
        setImageBitmap(savedState.f4006a);
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4006a = this.f4048g;
        savedState.f4007b = this.f4065x;
        savedState.f4008c = this.f4036K;
        savedState.f4009d = this.f4037L;
        savedState.f4010e = this.f4038M;
        savedState.f4011f = this.f4066y;
        savedState.f4012g = this.f4067z;
        savedState.f4013h = this.f4029D;
        savedState.f4014i = this.f4030E;
        savedState.f4015j = this.f4027B;
        savedState.f4016k = this.f4028C;
        savedState.f4017l = this.f4026A;
        savedState.f4018m = this.f4033H.x;
        savedState.f4019n = this.f4033H.y;
        savedState.f4020o = this.f4034I;
        savedState.f4021p = this.f4035J;
        savedState.f4022q = this.f4031F;
        savedState.f4023r = this.f4039N;
        savedState.f4024s = this.f4040O;
        savedState.f4025t = this.f4041P;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f4053l || !this.f4031F || !this.f4032G) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case VideoSize.QCIF /*0*/:
                m6307a(motionEvent);
                return true;
            case VideoSize.CIF /*1*/:
                getParent().requestDisallowInterceptTouchEvent(false);
                m6316c(motionEvent);
                return true;
            case VideoSize.HVGA /*2*/:
                m6311b(motionEvent);
                if (this.f4064w != C1070d.OUT_OF_BOUNDS) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case Version.API03_CUPCAKE_15 /*3*/:
                getParent().requestDisallowInterceptTouchEvent(false);
                m6315c();
                return true;
            default:
                return false;
        }
    }

    public void setBackgroundColor(int i) {
        this.f4036K = i;
        super.setBackgroundColor(this.f4036K);
        invalidate();
    }

    public void setCropEnabled(boolean z) {
        this.f4031F = z;
        invalidate();
    }

    public void setCropMode(C1068b c1068b) {
        if (c1068b == C1068b.RATIO_CUSTOM) {
            m6334a(1, 1);
            return;
        }
        this.f4065x = c1068b;
        m6328h();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f4032G = z;
    }

    public void setFrameColor(int i) {
        this.f4038M = i;
        invalidate();
    }

    public void setFrameStrokeWeightInDp(int i) {
        this.f4034I = ((float) i) * getDensity();
        invalidate();
    }

    public void setGuideColor(int i) {
        this.f4040O = i;
        invalidate();
    }

    public void setGuideShowMode(C1069c c1069c) {
        this.f4066y = c1069c;
        switch (C1067a.f4070c[c1069c.ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f4029D = true;
                break;
            case VideoSize.HVGA /*2*/:
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f4029D = false;
                break;
        }
        invalidate();
    }

    public void setGuideStrokeWeightInDp(int i) {
        this.f4035J = ((float) i) * getDensity();
        invalidate();
    }

    public void setHandleColor(int i) {
        this.f4039N = i;
        invalidate();
    }

    public void setHandleShowMode(C1069c c1069c) {
        this.f4067z = c1069c;
        switch (C1067a.f4070c[c1069c.ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f4030E = true;
                break;
            case VideoSize.HVGA /*2*/:
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f4030E = false;
                break;
        }
        invalidate();
    }

    public void setHandleSizeInDp(int i) {
        this.f4027B = (int) (((float) i) * getDensity());
    }

    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.f4053l = false;
            if (!(this.f4048g == null || this.f4048g == bitmap)) {
                this.f4048g = null;
            }
            this.f4048g = bitmap;
            if (this.f4048g != null) {
                this.f4051j = (float) this.f4048g.getWidth();
                this.f4052k = (float) this.f4048g.getHeight();
                m6310b(this.f4046e, this.f4047f);
            }
        }
    }

    public void setImageResource(int i) {
        if (i != 0) {
            setImageBitmap(BitmapFactory.decodeResource(getResources(), i));
        }
    }

    public void setInitialFrameScale(float f) {
        this.f4041P = m6302a(f, 0.01f, 1.0f, 0.75f);
    }

    public void setMinFrameSizeInDp(int i) {
        this.f4026A = ((float) i) * getDensity();
    }

    public void setOverlayColor(int i) {
        this.f4037L = i;
        invalidate();
    }

    public void setTouchPaddingInDp(int i) {
        this.f4028C = (int) (((float) i) * getDensity());
    }
}
