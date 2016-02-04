package com.akexorcist.roundcornerprogressbar.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.akexorcist.roundcornerprogressbar.C0898e;
import com.akexorcist.roundcornerprogressbar.C0899f;
import com.akexorcist.roundcornerprogressbar.C0902i;

public abstract class BaseRoundCornerProgressBar extends LinearLayout {
    private LinearLayout f3112a;
    private LinearLayout f3113b;
    private LinearLayout f3114c;
    private int f3115d;
    private int f3116e;
    private int f3117f;
    private float f3118g;
    private float f3119h;
    private float f3120i;
    private int f3121j;
    private int f3122k;
    private int f3123l;
    private boolean f3124m;
    private C0895b f3125n;

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        float f3147a;
        float f3148b;
        float f3149c;
        int f3150d;
        int f3151e;
        int f3152f;
        int f3153g;
        int f3154h;
        boolean f3155i;

        static {
            CREATOR = new C0896c();
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f3147a = parcel.readFloat();
            this.f3148b = parcel.readFloat();
            this.f3149c = parcel.readFloat();
            this.f3150d = parcel.readInt();
            this.f3151e = parcel.readInt();
            this.f3152f = parcel.readInt();
            this.f3153g = parcel.readInt();
            this.f3154h = parcel.readInt();
            this.f3155i = parcel.readByte() != null;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.f3147a);
            parcel.writeFloat(this.f3148b);
            parcel.writeFloat(this.f3149c);
            parcel.writeInt(this.f3150d);
            parcel.writeInt(this.f3151e);
            parcel.writeInt(this.f3152f);
            parcel.writeInt(this.f3153g);
            parcel.writeInt(this.f3154h);
            parcel.writeByte((byte) (this.f3155i ? 1 : 0));
        }
    }

    public BaseRoundCornerProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (isInEditMode()) {
            m5348a(context);
        } else {
            m5363b(context, attributeSet);
        }
    }

    @TargetApi(11)
    public BaseRoundCornerProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (isInEditMode()) {
            m5348a(context);
        } else {
            m5363b(context, attributeSet);
        }
    }

    private void m5348a(Context context) {
        setGravity(17);
        View textView = new TextView(context);
        textView.setLayoutParams(new LayoutParams(-1, -1));
        textView.setGravity(17);
        textView.setText(getClass().getSimpleName());
        textView.setTextColor(-1);
        textView.setBackgroundColor(-7829368);
        addView(textView);
    }

    private void m5349a(RelativeLayout.LayoutParams layoutParams) {
        if (VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(11);
            layoutParams.removeRule(21);
            layoutParams.removeRule(9);
            layoutParams.removeRule(20);
            return;
        }
        layoutParams.addRule(11, 0);
        layoutParams.addRule(9, 0);
    }

    private void m5352f() {
        Drawable a = m5359a(this.f3121j);
        int i = this.f3115d - (this.f3116e / 2);
        a.setCornerRadii(new float[]{(float) i, (float) i, (float) i, (float) i, (float) i, (float) i, (float) i, (float) i});
        if (VERSION.SDK_INT >= 16) {
            this.f3112a.setBackground(a);
        } else {
            this.f3112a.setBackgroundDrawable(a);
        }
    }

    private void m5353g() {
        m5361a(this.f3113b, this.f3118g, this.f3119h, (float) this.f3117f, this.f3115d, this.f3116e, this.f3122k, this.f3124m);
    }

    private void m5354h() {
        m5361a(this.f3114c, this.f3118g, this.f3120i, (float) this.f3117f, this.f3115d, this.f3116e, this.f3123l, this.f3124m);
    }

    private void m5355i() {
        setupReverse(this.f3113b);
        setupReverse(this.f3114c);
    }

    private void m5356j() {
        this.f3112a.setPadding(this.f3116e, this.f3116e, this.f3116e, this.f3116e);
    }

    private void setupReverse(LinearLayout linearLayout) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        m5349a(layoutParams);
        if (this.f3124m) {
            layoutParams.addRule(11);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.addRule(21);
            }
        } else {
            layoutParams.addRule(9);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.addRule(20);
            }
        }
        linearLayout.setLayoutParams(layoutParams);
    }

    @SuppressLint({"NewApi"})
    protected float m5357a(float f) {
        return (float) Math.round(((float) (getContext().getResources().getDisplayMetrics().densityDpi / 160)) * f);
    }

    protected abstract int m5358a();

    protected GradientDrawable m5359a(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    protected abstract void m5360a(Context context, AttributeSet attributeSet);

    protected abstract void m5361a(LinearLayout linearLayout, float f, float f2, float f3, int i, int i2, int i3, boolean z);

    protected abstract void m5362b();

    public void m5363b(Context context, AttributeSet attributeSet) {
        m5365c(context, attributeSet);
        removeAllViews();
        LayoutInflater.from(context).inflate(m5358a(), this);
        this.f3112a = (LinearLayout) findViewById(C0899f.layout_background);
        this.f3113b = (LinearLayout) findViewById(C0899f.layout_progress);
        this.f3114c = (LinearLayout) findViewById(C0899f.layout_secondary_progress);
        m5362b();
    }

    protected abstract void m5364c();

    public void m5365c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0902i.RoundCornerProgress);
        this.f3115d = (int) obtainStyledAttributes.getDimension(C0902i.RoundCornerProgress_rcRadius, m5357a(30.0f));
        this.f3116e = (int) obtainStyledAttributes.getDimension(C0902i.RoundCornerProgress_rcBackgroundPadding, m5357a(0.0f));
        this.f3124m = obtainStyledAttributes.getBoolean(C0902i.RoundCornerProgress_rcReverse, false);
        this.f3118g = obtainStyledAttributes.getFloat(C0902i.RoundCornerProgress_rcMax, 100.0f);
        this.f3119h = obtainStyledAttributes.getFloat(C0902i.RoundCornerProgress_rcProgress, 0.0f);
        this.f3120i = obtainStyledAttributes.getFloat(C0902i.RoundCornerProgress_rcSecondaryProgress, 0.0f);
        this.f3121j = obtainStyledAttributes.getColor(C0902i.RoundCornerProgress_rcBackgroundColor, context.getResources().getColor(C0898e.round_corner_progress_bar_background_default));
        this.f3122k = obtainStyledAttributes.getColor(C0902i.RoundCornerProgress_rcProgressColor, context.getResources().getColor(C0898e.round_corner_progress_bar_progress_default));
        this.f3123l = obtainStyledAttributes.getColor(C0902i.RoundCornerProgress_rcSecondaryProgressColor, context.getResources().getColor(C0898e.round_corner_progress_bar_secondary_progress_default));
        obtainStyledAttributes.recycle();
        m5360a(context, attributeSet);
    }

    protected void m5366d() {
        m5352f();
        m5356j();
        m5355i();
        m5353g();
        m5354h();
        m5364c();
    }

    public boolean m5367e() {
        return this.f3124m;
    }

    public float getLayoutWidth() {
        return (float) this.f3117f;
    }

    public float getMax() {
        return this.f3118g;
    }

    public int getPadding() {
        return this.f3116e;
    }

    public float getProgress() {
        return this.f3119h;
    }

    public int getProgressBackgroundColor() {
        return this.f3121j;
    }

    public int getProgressColor() {
        return this.f3122k;
    }

    public int getRadius() {
        return this.f3115d;
    }

    public float getSecondaryProgress() {
        return this.f3120i;
    }

    public int getSecondaryProgressColor() {
        return this.f3123l;
    }

    public float getSecondaryProgressWidth() {
        return this.f3114c != null ? (float) this.f3114c.getWidth() : 0.0f;
    }

    public void invalidate() {
        super.invalidate();
        m5366d();
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f3115d = savedState.f3150d;
            this.f3116e = savedState.f3151e;
            this.f3121j = savedState.f3152f;
            this.f3122k = savedState.f3153g;
            this.f3123l = savedState.f3154h;
            this.f3118g = savedState.f3147a;
            this.f3119h = savedState.f3148b;
            this.f3120i = savedState.f3149c;
            this.f3124m = savedState.f3155i;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3150d = this.f3115d;
        savedState.f3151e = this.f3116e;
        savedState.f3152f = this.f3121j;
        savedState.f3153g = this.f3122k;
        savedState.f3154h = this.f3123l;
        savedState.f3147a = this.f3118g;
        savedState.f3148b = this.f3119h;
        savedState.f3149c = this.f3120i;
        savedState.f3155i = this.f3124m;
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (!isInEditMode()) {
            this.f3117f = i;
            m5366d();
            postDelayed(new C0894a(this), 5);
        }
    }

    public void setMax(float f) {
        if (f >= 0.0f) {
            this.f3118g = f;
        }
        if (this.f3119h > f) {
            this.f3119h = f;
        }
        m5353g();
        m5354h();
    }

    public void setOnProgressChangedListener(C0895b c0895b) {
        this.f3125n = c0895b;
    }

    public void setPadding(int i) {
        if (i >= 0) {
            this.f3116e = i;
        }
        m5356j();
        m5353g();
        m5354h();
    }

    public void setProgress(float f) {
        if (f < 0.0f) {
            this.f3119h = 0.0f;
        } else if (f > this.f3118g) {
            this.f3119h = this.f3118g;
        } else {
            this.f3119h = f;
        }
        m5353g();
        if (this.f3125n != null) {
            this.f3125n.m5393a(getId(), this.f3119h, true, false);
        }
    }

    public void setProgressBackgroundColor(int i) {
        this.f3121j = i;
        m5352f();
    }

    public void setProgressColor(int i) {
        this.f3122k = i;
        m5353g();
    }

    public void setRadius(int i) {
        if (i >= 0) {
            this.f3115d = i;
        }
        m5352f();
        m5353g();
        m5354h();
    }

    public void setReverse(boolean z) {
        this.f3124m = z;
        m5355i();
        m5353g();
        m5354h();
    }

    public void setSecondaryProgress(float f) {
        if (f < 0.0f) {
            this.f3120i = 0.0f;
        } else if (f > this.f3118g) {
            this.f3120i = this.f3118g;
        } else {
            this.f3120i = f;
        }
        m5354h();
        if (this.f3125n != null) {
            this.f3125n.m5393a(getId(), this.f3120i, false, true);
        }
    }

    public void setSecondaryProgressColor(int i) {
        this.f3123l = i;
        m5354h();
    }
}
