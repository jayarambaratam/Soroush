package com.pnikosis.materialishprogress;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;

public class ProgressWheel extends View {
    private static final String f4111a;
    private final int f4112b;
    private final int f4113c;
    private final long f4114d;
    private int f4115e;
    private int f4116f;
    private int f4117g;
    private boolean f4118h;
    private double f4119i;
    private double f4120j;
    private float f4121k;
    private boolean f4122l;
    private long f4123m;
    private int f4124n;
    private int f4125o;
    private Paint f4126p;
    private Paint f4127q;
    private RectF f4128r;
    private float f4129s;
    private long f4130t;
    private boolean f4131u;
    private float f4132v;
    private float f4133w;
    private boolean f4134x;
    private C1093b f4135y;
    private boolean f4136z;

    class WheelSavedState extends BaseSavedState {
        public static final Creator<WheelSavedState> CREATOR;
        float f4100a;
        float f4101b;
        boolean f4102c;
        float f4103d;
        int f4104e;
        int f4105f;
        int f4106g;
        int f4107h;
        int f4108i;
        boolean f4109j;
        boolean f4110k;

        static {
            CREATOR = new C1094c();
        }

        private WheelSavedState(Parcel parcel) {
            boolean z = true;
            super(parcel);
            this.f4100a = parcel.readFloat();
            this.f4101b = parcel.readFloat();
            this.f4102c = parcel.readByte() != null;
            this.f4103d = parcel.readFloat();
            this.f4104e = parcel.readInt();
            this.f4105f = parcel.readInt();
            this.f4106g = parcel.readInt();
            this.f4107h = parcel.readInt();
            this.f4108i = parcel.readInt();
            this.f4109j = parcel.readByte() != null;
            if (parcel.readByte() == null) {
                z = false;
            }
            this.f4110k = z;
        }

        WheelSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 1;
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.f4100a);
            parcel.writeFloat(this.f4101b);
            parcel.writeByte((byte) (this.f4102c ? 1 : 0));
            parcel.writeFloat(this.f4103d);
            parcel.writeInt(this.f4104e);
            parcel.writeInt(this.f4105f);
            parcel.writeInt(this.f4106g);
            parcel.writeInt(this.f4107h);
            parcel.writeInt(this.f4108i);
            parcel.writeByte((byte) (this.f4109j ? 1 : 0));
            if (!this.f4110k) {
                i2 = 0;
            }
            parcel.writeByte((byte) i2);
        }
    }

    static {
        f4111a = ProgressWheel.class.getSimpleName();
    }

    public ProgressWheel(Context context) {
        super(context);
        this.f4112b = 16;
        this.f4113c = 270;
        this.f4114d = 200;
        this.f4115e = 28;
        this.f4116f = 4;
        this.f4117g = 4;
        this.f4118h = false;
        this.f4119i = 0.0d;
        this.f4120j = 460.0d;
        this.f4121k = 0.0f;
        this.f4122l = true;
        this.f4123m = 0;
        this.f4124n = -1442840576;
        this.f4125o = 16777215;
        this.f4126p = new Paint();
        this.f4127q = new Paint();
        this.f4128r = new RectF();
        this.f4129s = 230.0f;
        this.f4130t = 0;
        this.f4132v = 0.0f;
        this.f4133w = 0.0f;
        this.f4134x = false;
        m6349d();
    }

    public ProgressWheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4112b = 16;
        this.f4113c = 270;
        this.f4114d = 200;
        this.f4115e = 28;
        this.f4116f = 4;
        this.f4117g = 4;
        this.f4118h = false;
        this.f4119i = 0.0d;
        this.f4120j = 460.0d;
        this.f4121k = 0.0f;
        this.f4122l = true;
        this.f4123m = 0;
        this.f4124n = -1442840576;
        this.f4125o = 16777215;
        this.f4126p = new Paint();
        this.f4127q = new Paint();
        this.f4128r = new RectF();
        this.f4129s = 230.0f;
        this.f4130t = 0;
        this.f4132v = 0.0f;
        this.f4133w = 0.0f;
        this.f4134x = false;
        m6348a(context.obtainStyledAttributes(attributeSet, C1096e.ProgressWheel));
        m6349d();
    }

    private void m6345a(float f) {
        if (this.f4135y != null) {
            this.f4135y.m6355a(f);
        }
    }

    private void m6346a(int i, int i2) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (this.f4118h) {
            this.f4128r = new RectF((float) (paddingLeft + this.f4116f), (float) (paddingTop + this.f4116f), (float) ((i - paddingRight) - this.f4116f), (float) ((i2 - paddingBottom) - this.f4116f));
            return;
        }
        int min = Math.min(Math.min((i - paddingLeft) - paddingRight, (i2 - paddingBottom) - paddingTop), (this.f4115e * 2) - (this.f4116f * 2));
        paddingLeft += (((i - paddingLeft) - paddingRight) - min) / 2;
        paddingTop += (((i2 - paddingTop) - paddingBottom) - min) / 2;
        this.f4128r = new RectF((float) (this.f4116f + paddingLeft), (float) (this.f4116f + paddingTop), (float) ((paddingLeft + min) - this.f4116f), (float) ((paddingTop + min) - this.f4116f));
    }

    private void m6347a(long j) {
        if (this.f4123m >= 200) {
            this.f4119i += (double) j;
            if (this.f4119i > this.f4120j) {
                this.f4119i -= this.f4120j;
                this.f4123m = 0;
                this.f4122l = !this.f4122l;
            }
            float cos = (((float) Math.cos(((this.f4119i / this.f4120j) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
            if (this.f4122l) {
                this.f4121k = cos * 254.0f;
                return;
            }
            cos = (1.0f - cos) * 254.0f;
            this.f4132v += this.f4121k - cos;
            this.f4121k = cos;
            return;
        }
        this.f4123m += j;
    }

    private void m6348a(TypedArray typedArray) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.f4116f = (int) TypedValue.applyDimension(1, (float) this.f4116f, displayMetrics);
        this.f4117g = (int) TypedValue.applyDimension(1, (float) this.f4117g, displayMetrics);
        this.f4115e = (int) TypedValue.applyDimension(1, (float) this.f4115e, displayMetrics);
        this.f4115e = (int) typedArray.getDimension(C1096e.ProgressWheel_matProg_circleRadius, (float) this.f4115e);
        this.f4118h = typedArray.getBoolean(C1096e.ProgressWheel_matProg_fillRadius, false);
        this.f4116f = (int) typedArray.getDimension(C1096e.ProgressWheel_matProg_barWidth, (float) this.f4116f);
        this.f4117g = (int) typedArray.getDimension(C1096e.ProgressWheel_matProg_rimWidth, (float) this.f4117g);
        this.f4129s = typedArray.getFloat(C1096e.ProgressWheel_matProg_spinSpeed, this.f4129s / 360.0f) * 360.0f;
        this.f4120j = (double) typedArray.getInt(C1096e.ProgressWheel_matProg_barSpinCycleTime, (int) this.f4120j);
        this.f4124n = typedArray.getColor(C1096e.ProgressWheel_matProg_barColor, this.f4124n);
        this.f4125o = typedArray.getColor(C1096e.ProgressWheel_matProg_rimColor, this.f4125o);
        this.f4131u = typedArray.getBoolean(C1096e.ProgressWheel_matProg_linearProgress, false);
        if (typedArray.getBoolean(C1096e.ProgressWheel_matProg_progressIndeterminate, false)) {
            m6354c();
        }
        typedArray.recycle();
    }

    @TargetApi(17)
    private void m6349d() {
        this.f4136z = (VERSION.SDK_INT >= 17 ? Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f) : System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f)) != 0.0f;
    }

    private void m6350e() {
        this.f4126p.setColor(this.f4124n);
        this.f4126p.setAntiAlias(true);
        this.f4126p.setStyle(Style.STROKE);
        this.f4126p.setStrokeWidth((float) this.f4116f);
        this.f4127q.setColor(this.f4125o);
        this.f4127q.setAntiAlias(true);
        this.f4127q.setStyle(Style.STROKE);
        this.f4127q.setStrokeWidth((float) this.f4117g);
    }

    private void m6351f() {
        if (this.f4135y != null) {
            this.f4135y.m6355a(((float) Math.round((this.f4132v * 100.0f) / 360.0f)) / 100.0f);
        }
    }

    public boolean m6352a() {
        return this.f4134x;
    }

    public void m6353b() {
        this.f4134x = false;
        this.f4132v = 0.0f;
        this.f4133w = 0.0f;
        invalidate();
    }

    public void m6354c() {
        this.f4130t = SystemClock.uptimeMillis();
        this.f4134x = true;
        invalidate();
    }

    public int getBarColor() {
        return this.f4124n;
    }

    public int getBarWidth() {
        return this.f4116f;
    }

    public int getCircleRadius() {
        return this.f4115e;
    }

    public float getProgress() {
        return this.f4134x ? -1.0f : this.f4132v / 360.0f;
    }

    public int getRimColor() {
        return this.f4125o;
    }

    public int getRimWidth() {
        return this.f4117g;
    }

    public float getSpinSpeed() {
        return this.f4129s / 360.0f;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.f4128r, 360.0f, 360.0f, false, this.f4127q);
        Object obj = null;
        if (this.f4136z) {
            Object obj2;
            float f;
            if (this.f4134x) {
                obj2 = 1;
                long uptimeMillis = SystemClock.uptimeMillis() - this.f4130t;
                f = (((float) uptimeMillis) * this.f4129s) / 1000.0f;
                m6347a(uptimeMillis);
                this.f4132v += f;
                if (this.f4132v > 360.0f) {
                    this.f4132v -= 360.0f;
                    m6345a(-1.0f);
                }
                this.f4130t = SystemClock.uptimeMillis();
                f = this.f4132v - 90.0f;
                float f2 = 16.0f + this.f4121k;
                if (isInEditMode()) {
                    f = 0.0f;
                    f2 = 135.0f;
                }
                canvas.drawArc(this.f4128r, f, f2, false, this.f4126p);
            } else {
                float f3 = this.f4132v;
                if (this.f4132v != this.f4133w) {
                    obj = 1;
                    this.f4132v = Math.min(((((float) (SystemClock.uptimeMillis() - this.f4130t)) / 1000.0f) * this.f4129s) + this.f4132v, this.f4133w);
                    this.f4130t = SystemClock.uptimeMillis();
                }
                obj2 = obj;
                if (f3 != this.f4132v) {
                    m6351f();
                }
                float f4 = this.f4132v;
                if (this.f4131u) {
                    f = 0.0f;
                } else {
                    f4 = ((float) (1.0d - Math.pow((double) (1.0f - (this.f4132v / 360.0f)), (double) 1073741824))) * 360.0f;
                    f = ((float) (1.0d - Math.pow((double) (1.0f - (this.f4132v / 360.0f)), (double) (2.0f * 2.0f)))) * 360.0f;
                }
                canvas.drawArc(this.f4128r, f - 90.0f, isInEditMode() ? 360.0f : f4, false, this.f4126p);
            }
            if (obj2 != null) {
                invalidate();
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int paddingLeft = (this.f4115e + getPaddingLeft()) + getPaddingRight();
        int paddingTop = (this.f4115e + getPaddingTop()) + getPaddingBottom();
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = mode == RtlSpacingHelper.UNDEFINED ? Math.min(paddingLeft, size) : paddingLeft;
        }
        if (mode2 == 1073741824 || mode == 1073741824) {
            paddingTop = size2;
        } else if (mode2 == RtlSpacingHelper.UNDEFINED) {
            paddingTop = Math.min(paddingTop, size2);
        }
        setMeasuredDimension(size, paddingTop);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof WheelSavedState) {
            WheelSavedState wheelSavedState = (WheelSavedState) parcelable;
            super.onRestoreInstanceState(wheelSavedState.getSuperState());
            this.f4132v = wheelSavedState.f4100a;
            this.f4133w = wheelSavedState.f4101b;
            this.f4134x = wheelSavedState.f4102c;
            this.f4129s = wheelSavedState.f4103d;
            this.f4116f = wheelSavedState.f4104e;
            this.f4124n = wheelSavedState.f4105f;
            this.f4117g = wheelSavedState.f4106g;
            this.f4125o = wheelSavedState.f4107h;
            this.f4115e = wheelSavedState.f4108i;
            this.f4131u = wheelSavedState.f4109j;
            this.f4118h = wheelSavedState.f4110k;
            this.f4130t = SystemClock.uptimeMillis();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
        wheelSavedState.f4100a = this.f4132v;
        wheelSavedState.f4101b = this.f4133w;
        wheelSavedState.f4102c = this.f4134x;
        wheelSavedState.f4103d = this.f4129s;
        wheelSavedState.f4104e = this.f4116f;
        wheelSavedState.f4105f = this.f4124n;
        wheelSavedState.f4106g = this.f4117g;
        wheelSavedState.f4107h = this.f4125o;
        wheelSavedState.f4108i = this.f4115e;
        wheelSavedState.f4109j = this.f4131u;
        wheelSavedState.f4110k = this.f4118h;
        return wheelSavedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m6346a(i, i2);
        m6350e();
        invalidate();
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.f4130t = SystemClock.uptimeMillis();
        }
    }

    public void setBarColor(int i) {
        this.f4124n = i;
        m6350e();
        if (!this.f4134x) {
            invalidate();
        }
    }

    public void setBarWidth(int i) {
        this.f4116f = i;
        if (!this.f4134x) {
            invalidate();
        }
    }

    public void setCallback(C1093b c1093b) {
        this.f4135y = c1093b;
        if (!this.f4134x) {
            m6351f();
        }
    }

    public void setCircleRadius(int i) {
        this.f4115e = i;
        if (!this.f4134x) {
            invalidate();
        }
    }

    public void setInstantProgress(float f) {
        if (this.f4134x) {
            this.f4132v = 0.0f;
            this.f4134x = false;
        }
        if (f > 1.0f) {
            f -= 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (f != this.f4133w) {
            this.f4133w = Math.min(f * 360.0f, 360.0f);
            this.f4132v = this.f4133w;
            this.f4130t = SystemClock.uptimeMillis();
            invalidate();
        }
    }

    public void setLinearProgress(boolean z) {
        this.f4131u = z;
        if (!this.f4134x) {
            invalidate();
        }
    }

    public void setProgress(float f) {
        if (this.f4134x) {
            this.f4132v = 0.0f;
            this.f4134x = false;
            m6351f();
        }
        if (f > 1.0f) {
            f -= 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (f != this.f4133w) {
            if (this.f4132v == this.f4133w) {
                this.f4130t = SystemClock.uptimeMillis();
            }
            this.f4133w = Math.min(f * 360.0f, 360.0f);
            invalidate();
        }
    }

    public void setRimColor(int i) {
        this.f4125o = i;
        m6350e();
        if (!this.f4134x) {
            invalidate();
        }
    }

    public void setRimWidth(int i) {
        this.f4117g = i;
        if (!this.f4134x) {
            invalidate();
        }
    }

    public void setSpinSpeed(float f) {
        this.f4129s = 360.0f * f;
    }
}
